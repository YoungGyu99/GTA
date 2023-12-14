const ctx = document.getElementById('myChart');
let currentDataset = 'now'; // 현재 선택된 데이터셋
let chart; // 차트 인스턴스를 저장하기 위한 변수

function updateChart(dataset) {
  let labels = [];
  let yesterdayData = [];
  let todayData = [];
  let totalModelData = [];

  $.ajax({
    url: curl+ "/chart.do",
    type:'post',
    contentType: 'application/json',
    data: JSON.stringify({ dataset: dataset }),
    success: function (responseData) {

      // 데이터 처리
      labels.length = 0;
      yesterdayData.length = 0;
      todayData.length = 0;
      totalModelData.length = 0;

      for (const item of responseData) {
        labels.push(item.label);
        yesterdayData.push(item.yesterdayData);
        todayData.push(item.todayData);
        totalModelData.push(item.totalModelData);
      }

      // 차트 업데이트
      updateChartWithMultipleDatasets(dataset, labels, yesterdayData, todayData, totalModelData);
    },
    error: function () {
      alert('실패');
    },
  });
}

function updateChartWithMultipleDatasets(dataset, labels, yesterdayData, todayData, totalModelData) {
	
  // 차트가 생성되었는지 확인
  if (chart) {
    // 차트가 이미 생성된 경우 데이터 및 옵션 업데이트
    chart.data.labels = labels;
    chart.data.datasets[0].data = yesterdayData;
    chart.data.datasets[0].label = (dataset === 'now') ? '전 12시간 단위 ' : 
        (dataset === 'day') ? '어제' :
        (dataset === 'week') ? '저번주' :
        (dataset === 'month') ? '저번달' : '';
    chart.data.datasets[1].data = todayData;
    chart.data.datasets[1].label = (dataset === 'now') ? '이번 12시간 단위' : 
        (dataset === 'day') ? '오늘' :
        (dataset === 'week') ? '이번주' :
        (dataset === 'month') ? '이번달' : '';
    chart.data.datasets[2].data = totalModelData;
    chart.data.datasets[2].label = (dataset === 'now') ? '다음 12시간 단위 예측' : 
        (dataset === 'day') ? '내일 예측' :
        (dataset === 'week') ? '다음주 예측' :
        (dataset === 'month') ? '다음달 예측' : '';

    // 차트 업데이트
    chart.update();
  } else {
    // 차트가 생성되지 않은 경우 초기화
    chart = new Chart(ctx, {
      type: 'bar', // 막대 그래프로 초기화
      data: {
        labels: labels,
        datasets: [
          {
        	  label : (dataset === 'now') ? '전 12시간 단위 ' : 
        	        (dataset === 'day') ? '어제' :
        	        (dataset === 'week') ? '저번주' :
        	        (dataset === 'month') ? '저번달' : '',
            data: yesterdayData,
            backgroundColor: 'rgba(128, 128, 128, 0.7)',
            borderColor: 'rgba(128, 128, 128, 1)',
            borderWidth: 1,
          },
          {
        	  label : (dataset === 'now') ? '이번 12시간 단위' : 
        	        (dataset === 'day') ? '오늘' :
        	        (dataset === 'week') ? '이번주' :
        	        (dataset === 'month') ? '이번달' : '',
            data: todayData,
            backgroundColor: 'rgba(54, 162, 235, 0.7)',
            borderColor: 'rgba(54, 162, 235, 1)',
            borderWidth: 2,
          },
          {
        	  label : (dataset === 'now') ? '다음 12시간 단위 예측' : 
        	        (dataset === 'day') ? '내일 예측' :
        	        (dataset === 'week') ? '다음주 예측' :
        	        (dataset === 'month') ? '다음달 예측' : '',
            data: totalModelData,
            fill: false,
            borderColor: 'rgba(255, 206, 86, 1)',
            borderWidth: 2,
            type: 'line', // 선형 차트로 변경
          },
        ],
      },
    
    });
  }
}

// 페이지 로드 시 초기 차트 생성
updateChart('month');

// 각 버튼에 대한 이벤트 리스너 추가
const menuButtons = document.querySelectorAll('.menu-button');

menuButtons.forEach(button => {
  button.addEventListener('click', (event) => {
    event.preventDefault(); // 기본 동작 중단
    currentDataset = button.getAttribute('data-dataset');
    updateChart(currentDataset);

    // 선택된 버튼에 클래스를 추가하여 시각적으로 표시
    menuButtons.forEach(btn => btn.classList.remove('selected'));
    button.classList.add('selected');

    // 차트 크기 업데이트
    if (chart) {
      chart.resize();
    }
  });
});

// 초기 상태로 'month' 버튼이 선택되도록 설정
document.querySelector('.menu-button[data-dataset="month"]').classList.add('selected');

// Resize 이벤트 리스너 추가
window.addEventListener('resize', () => {
  // 차트 크기 업데이트
  if (chart) {
    chart.resize();
  }
});

