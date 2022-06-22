let cookieValue = document.cookie.split('; ')
                        .find(elem => elem.startsWith('isShown='))
                        ?.split('=')[1];
if (!cookieValue) {
    let modal = document.getElementById('subscribe-modal');
    modal.classList.add('modal_active');

    let modalClose = document.querySelectorAll('div.modal__close');
    modalClose.forEach(elem => elem.onclick = function () {
        modal.classList.remove('modal_active');
        document.cookie = 'isShown=true';
    })
}
