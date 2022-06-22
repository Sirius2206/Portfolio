const signinForm = document.getElementById('signin__form');
const signinBtn = document.getElementById('signin__btn');
const logoutBtn = document.getElementById('logout__btn');
const localStorage = window.localStorage;
restoreSavedData();
initializeButtons();

function restoreSavedData() {
    if (localStorage.getItem('user_id')) {
        signinSuccess(localStorage.getItem('user_id'));
    }
}

function initializeButtons() {
    signinForm.addEventListener('keydown', e => {
        if (e.code === 'Enter') {
            signinBtn.dispatchEvent(new Event('click'));
        }
    })

    logoutBtn.addEventListener('click', e => {
        localStorage.clear();
        const welcome = document.getElementById('welcome');
        document.getElementById('signin').classList.add('signin_active')
        welcome.classList.remove('welcome_active')
    })

    signinBtn.addEventListener('click', e => {
        e.preventDefault();
        const formData = new FormData(signinForm);

        let xhr = new XMLHttpRequest()

        xhr.open('POST', 'https://netology-slow-rest.herokuapp.com/auth.php', true);
        xhr.send(formData);
        xhr.onload = () => {
            const resp = JSON.parse(xhr.response);
            if (resp.success) {
                signinSuccess(resp.user_id);
            } else {
                signinForm.elements.login.value = '';
                signinForm.elements.password.value = '';
                const fail = document.querySelector('.auth__failed');
                fail.classList.add('auth__failed_active');
            }
        }
    });
}

function signinSuccess(id) {
    localStorage.setItem('user_id', id);
    const welcome = document.getElementById('welcome');
    document.getElementById('signin').classList.remove('signin_active')
    welcome.classList.add('welcome_active')
    const userID = document.getElementById('user_id');
    userID.innerText = id;
}