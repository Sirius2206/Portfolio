const tooltipLinks = Array.from(document.querySelectorAll('.has-tooltip'));
initializeTooltipLinks();


function initializeTooltipLinks() {
    const position = ['top', 'right', 'bottom', 'left'];
    let index = 0;
    for (let link of tooltipLinks) {
        const tooltipDiv = document.createElement('div');
        tooltipDiv.classList.add('tooltip');
        tooltipDiv.textContent = link.getAttribute('title');
        tooltipDiv.dataset.position = position[index++ % 4];
        link.parentNode.insertBefore(tooltipDiv, link.nextSibling);

        link.addEventListener('click', e => {
            let prev = document.querySelector('.tooltip_active');
            
            if(prev) {
                prev.classList.remove('tooltip_active');
                if (prev === e.target.nextSibling) {
                    e.preventDefault();
                    return;
                }
            }
            tooltipDiv.classList.add('tooltip_active');
            positionElement(tooltipDiv.dataset.position, link, tooltipDiv);
            e.preventDefault();
        })
    }
}

function positionElement(direction, link, tooltip) {
    switch (direction){
        case 'top':
            tooltip.style.left = link.offsetLeft + 'px';
            tooltip.style.top = link.offsetTop - tooltip.offsetHeight + 'px';
            break;
        case 'right' :
            tooltip.style.left = link.offsetLeft + link.offsetWidth +'px';
            tooltip.style.top = link.offsetTop + 'px';
            break;
        case 'bottom' :
            tooltip.style.left = link.offsetLeft + 'px';
            break;
        case 'left' :
            tooltip.style.left = link.offsetLeft - tooltip.offsetWidth + 'px';
            tooltip.style.top = link.offsetTop + 'px';
            break;

    }
}