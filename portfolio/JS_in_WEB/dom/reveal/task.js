const revealElem = Array.from(document.querySelectorAll('.reveal'));

function isVisible(elem) {
    const coords = elem.getBoundingClientRect();
    const windowHeight = document.documentElement.clientHeight;
    if (coords.top + coords.height > 0 && coords.top < windowHeight) {
        return true;
    }
}

function revealItem() {
    revealElem.forEach(elem => {
        if (isVisible(elem)) {
            elem.classList.add('reveal_active');
        } else {
            elem.classList.remove('reveal_active');
        }
    })
}

window.onscroll = revealItem;