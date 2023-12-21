document.addEventListener('DOMContentLoaded', () => {
  const savedTheme = localStorage.getItem('theme');
  if (savedTheme === 'true') {
    applyDarkTheme();
  }
});

function toggleTheme() {
  const isDarkTheme = document.body.classList.contains('dark-theme-variables');
  document.body.classList.toggle('dark-theme-variables');
  updateThemeStyles(!isDarkTheme);
  localStorage.setItem('theme', !isDarkTheme ? 'true' : 'false');
}

function applyDarkTheme() {
  document.body.classList.add('dark-theme-variables');
  updateThemeStyles(true);
}

function updateThemeStyles(isDark) {
  const themeToggler = document.querySelector('.theme-toggler');
  const activeClass = 'active';
  
  if (isDark) {
    themeToggler.querySelector('span:nth-child(1)').classList.remove(activeClass);
    themeToggler.querySelector('span:nth-child(2)').classList.add(activeClass);
  } else {
	  themeToggler.querySelector('span:nth-child(1)').classList.add(activeClass);
    themeToggler.querySelector('span:nth-child(2)').classList.remove(activeClass);
  }
}

const themeToggler = document.querySelector('.theme-toggler');
themeToggler.addEventListener('click', () => {
  toggleTheme();
});
