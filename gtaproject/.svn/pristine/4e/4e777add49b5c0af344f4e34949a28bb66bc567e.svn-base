const COUNT_PER_PAGE = 5;
let data; // 서버에서 받아온 게시판 데이터를 저장할 전역 변수
let currentPage = 1; // currentPage 변수를 초기화합니다.

// 비동기 함수를 사용하여 서버에서 데이터를 가져오는 함수
const fetchData = async () => {
  try {
    const response = await fetch( curl +'/inform/data');
    if (!response.ok) {
      throw new Error('Failed to fetch data');
    }

    data = await response.json();
    
    initializePagination();
  } catch (error) {
    console.error('Error fetching data:', error);
  }
};

// 페이지 버튼을 설정하는 함수
const setPageButtons = () => {
  const numberButtonWrapper = document.querySelector('.number-button-wrapper');
  if (!numberButtonWrapper) return; // 요소의 존재 여부를 확인합니다.

  numberButtonWrapper.innerHTML = '';

  for (let i = 1; i <= getTotalPageCount(); i++) {
    numberButtonWrapper.innerHTML += `<span class="number-button"> ${i} </span>`;
  }

  numberButtonWrapper.firstChild.classList.add('selected');
  pageNumberButtons = document.querySelectorAll('.number-button');
};

// 총 페이지 수를 계산하는 함수
const getTotalPageCount = () => {
  // data가 정의되어 있지 않거나, data.length가 없는 경우 에러가 발생할 수 있습니다.
  return Math.ceil(data.length / COUNT_PER_PAGE);
};

// 페이지 내용을 설정하는 함수
const setPageOf = (pageNumber) => {
  const informListContainer = document.getElementById('informListContainer');
  if (!informListContainer) return; // 요소의 존재 여부를 확인합니다.

  informListContainer.innerHTML = '';

  for (
    let i = COUNT_PER_PAGE * (pageNumber - 1);
    i < COUNT_PER_PAGE * pageNumber && i < data.length;
    i++
  ) {
    const inform = data[i];
    const li = document.createElement('li');
    li.className = 'post-container';

    li.innerHTML = `<a href="` + curl +`/inform/detail?iNum=${inform.iNum}">
        <div class="num">${inform.rowNum}</div>
        <div class="name">${inform.iName}</div>
        <div class="category">${inform.iRank}</div>
        <div class="title">${inform.iTitle}</div>
        <div class="date">${inform.iDate}</div>
        </a>
    `;

    informListContainer.appendChild(li);
  }
};

// 선택된 페이지 강조 효과를 이동시키는 함수
const moveSelectedPageHighlight = () => {
  const pageNumberButtons = document.querySelectorAll('.number-button');
  if (!pageNumberButtons) return; // 요소의 존재 여부를 확인합니다.

  pageNumberButtons.forEach((numberButton) => {
    if (numberButton.classList.contains('selected')) {
      numberButton.classList.remove('selected');
    }
  });

  pageNumberButtons[currentPage - 1].classList.add('selected');
};

// 페이지를 초기화하는 함수
const initializePagination = () => {
  setPageButtons();
  setPageOf(currentPage);

  document.querySelectorAll('.number-button').forEach((numberButton) => {
    numberButton.addEventListener('click', (e) => {
      currentPage = +e.target.innerHTML;
      setPageOf(currentPage);
      moveSelectedPageHighlight();
    });
  });

  document.querySelector('.prev-button').addEventListener('click', () => {
    if (currentPage > 1) {
      currentPage -= 1;
      setPageOf(currentPage);
      moveSelectedPageHighlight();
    }
  });

  document.querySelector('.next-button').addEventListener('click', () => {
    const totalPageCount = getTotalPageCount();
    if (currentPage < totalPageCount) {
      currentPage += 1;
      setPageOf(currentPage);
      moveSelectedPageHighlight();
    }
  });
};

// 페이지 로딩 시 데이터를 가져오도록 초기 호출
fetchData();