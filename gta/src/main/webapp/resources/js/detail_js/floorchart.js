let selectedFloorText = '1'; // 선택된 층의 텍스트 초기값
let currentDataset = 'now'; // 현재 데이터셋 초기값
let chart;
let chart2;
const floorItems = document.querySelectorAll('.Fbuild .floor-item');
const floorInfoElement = document.getElementById('Floor-info');
const plugValueElement = document.getElementById('plugValue');
const airconValueElement = document.getElementById('airconValue');
const lightValueElement = document.getElementById('lightValue');

// 스크립트 실행과 동시에 바닥 차트를 추가하는 함수 호출
addFloorChart({
  beFloor: selectedFloorText,
  label: '',
  currentDataset: currentDataset
});

floorItems.forEach(floorItem => {
  floorItem.addEventListener('click', function (event) {
    event.preventDefault();

    resetFloorEffects(); // 층 선택 효과 초기화

    this.classList.add('selected'); // 현재 클릭한 층에 선택 효과 추가

    selectedFloorText = this.textContent.trim().replace('F', '');
    floorInfoElement.textContent = `${selectedFloorText}Floor_Energy`;

    
    // 선택한 층과 데이터셋을 사용하여 바닥 차트 추가
    addFloorChart({
      beFloor: selectedFloorText,
      label: '',    
      currentDataset: currentDataset
    });
  });
});

function resetFloorEffects() {
  floorItems.forEach(floorItem => {
    floorItem.classList.remove('selected');
  });
}

function clearCanvas() {
  const cnvs = document.getElementById('myCanvas');
  const ctx = cnvs.getContext('2d');
  ctx.clearRect(0, 0, cnvs.width, cnvs.height);
  ctx.beginPath();
}

// 바닥 차트를 추가하는 함수
function addFloorChart(detailChartVO) {
  $.ajax({
    type: 'POST',
    url:  curl+ '/detail/chart.do',
    contentType: 'application/json',
    data: JSON.stringify(detailChartVO),
    success: function (data) {
     
      drawChart(data);
    },
    error: function (error) {
      console.error('데이터를 가져오는 중 에러 발생:', error);
    }
  });
}

function drawChart(data) {
  const labels = data.map(item => item.label);
  const plugValues = data.map(item => item.bePlugEnergy);
  const airconValues = data.map(item => item.beAcEnergy);
  const lightValues = data.map(item => item.beLightEnergy);
//각 기기별 에너지 총합을 저장할 변수
  let totalPlugEnergy = data.reduce((total, item) => total + item.bePlugEnergy, 0);
  let totalAirconEnergy = data.reduce((total, item) => total + item.beAcEnergy, 0);
  let totalLightEnergy = data.reduce((total, item) => total + item.beLightEnergy, 0);
  
  const ctx = document.getElementById('myChart').getContext('2d');
  if (chart) {
    chart.destroy();
  }
  chart = new Chart(ctx, {
    type: 'line',
    data: {
      labels,
      datasets: [
        {
          label: '플러그 에너지',
          data: plugValues,
          backgroundColor: 'rgba(255, 99, 132, 0.2)',
          borderColor: 'rgba(255, 99, 132, 1)',
          borderWidth: 1
        },
        {
          label: '에어컨 에너지',
          data: airconValues,
          backgroundColor: 'rgba(54, 162, 235, 0.2)',
          borderColor: 'rgba(54, 162, 235, 1)',
          borderWidth: 1
        },
        {
          label: '조명 에너지',
          data: lightValues,
          backgroundColor: 'rgba(255, 206, 86, 0.2)',
          borderColor: 'rgba(255, 206, 86, 1)',
          borderWidth: 1
        }
      ]
    },
    options: {
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }
  });
  const existingCanvas = document.getElementById('doughnutChartCanvas');
  if (chart2) {
      chart2.destroy();
  }
  chart2 = new Chart(existingCanvas, {
      type: 'doughnut',
      data: {
          labels: ["Plug", "Aircon", "Light"],
          datasets: [
              {
                  data: [totalPlugEnergy, totalAirconEnergy, totalLightEnergy],
                  backgroundColor: ["#e15449", "#22194D", "#dddd"],
                  borderWidth: 0,
                  borderRadius: 7,
              },
          ],
      },
      options: {
          cutout: '78%',
          hover: { mode: null },
          plugins: {
              legend: {
                  display: true,
              },
              tooltip: {
                  enabled: false,
              },
              datalabels: {
                  display: true,
                  color: 'white',
                  backgroundColor: function (context) {
                      return context.dataset.backgroundColor;
                  },
                  borderRadius: 7,
                  font: {
                      weight: 'bold',
                  },
                  formatter: function (value, context) {
                      return Math.round(value) + '%';
                  },
              },
          },
      },
  });

//데이터가 존재하는 경우에만 마지막 데이터의 값을 설정
  if (data.length > 0) {
    plugValueElement.textContent = data[data.length - 1].bePlugEnergy;
    airconValueElement.textContent = data[data.length - 1].beAcEnergy;
    lightValueElement.textContent = data[data.length - 1].beLightEnergy;
  }
}
//각 버튼에 대한 이벤트 리스너 추가
const menuButtons = document.querySelectorAll('.menu-button');
menuButtons.forEach(button => {
  button.addEventListener('click', (event) => {
    event.preventDefault();
    currentDataset = button.getAttribute('data-dataset');

    // 선택된 데이터셋으로 차트 업데이트
    addFloorChart({
      beFloor: selectedFloorText,
      currentDataset: currentDataset
    });

    menuButtons.forEach(btn => btn.classList.remove('selected'));
    button.classList.add('selected');
    if (chart) {
      chart.resize();
    }
  });
});

$(function () {
  $('.datas span').on('click', function () {
    $(this).toggleClass('clicked');
    $(this).closest('.datas').find('.silde_card').slideToggle('fast');
  });
}(jQuery));
