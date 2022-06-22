const rotator = document.querySelector('.rotator');
let rotatorActive = rotator.querySelector('.rotator__case_active');
let speed = rotatorActive.dataset.speed;
rotatorActive.style.color = rotatorActive.dataset.color;
let now = new Date();

setInterval(() => {
    if ((new Date() - now) >= speed) {
        rotatorActive.classList.remove('rotator__case_active');
        rotatorActive = rotatorActive.nextElementSibling;
        if (rotatorActive === null) {
            rotatorActive = rotator.firstElementChild;
        }
        rotatorActive.style.color = rotatorActive.dataset.color;
        rotatorActive.classList.add('rotator__case_active');
        speed = rotatorActive.dataset.speed;
        now = new Date();
    }
}, 100)