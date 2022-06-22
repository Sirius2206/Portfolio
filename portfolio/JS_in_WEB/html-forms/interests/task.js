const interestsCb = Array.from(document.querySelectorAll('.interest__check'));

for (let checkbox of interestsCb) {
    checkbox.addEventListener('change', () => {
        changeCheckbox(checkbox, checkbox.checked);
    })
}

function changeCheckbox(checkbox, cbBool) {
    checkbox.indeterminate = false;
    checkbox.checked = cbBool;
    const cbCheck = Array.from(checkbox.closest('li').querySelectorAll('input'));

    for (let elem of cbCheck) {
        elem.checked = cbBool;
    }
    const upper = checkbox.closest('ul').closest('li');

    if (compareCheckboxes(checkbox.closest('li'))) {
        if (upper) {
            changeCheckbox(upper.querySelector('input'), cbBool)
        }  
    } else {
        if (upper) {
            upperIsIndeterminate(upper);
        }  
    }
}

function upperIsIndeterminate(list) {
    const upper = list.closest('ul').closest('li');

    list.querySelector('input').indeterminate = true;
    if (upper) {
        upperIsIndeterminate(upper);
    }  
}

function compareCheckboxes(list) {
    const cbAll = Array.from(list.closest('ul').querySelectorAll('input'));
    const cbCompare = Array.from(list.closest('ul').querySelectorAll('input:checked'));

    if (cbAll.length === cbCompare.length || cbCompare.length === 0) {
        return true;
    }
    return false;
}