const tasksList = document.getElementById('tasks__list');
const savedData = window.localStorage;
restoreSavedData();

const closeBtns = tasksList.querySelectorAll('.task__remove');
initializeCloseBtns();

const addButton = document.getElementById('tasks__add');
const input = document.getElementById('task__input');
initializeAddBtns();

function addTask() {
    if (input.value.trim() == '') {
        input.value = '';
        return;
    }
    const resultDiv = document.createElement('div');
    resultDiv.classList.add('task');

    const taskTitle = document.createElement('div');
    taskTitle.classList.add('task__title');
    taskTitle.innerText = input.value;
    resultDiv.appendChild(taskTitle);

    const taskRemoveBtn = document.createElement('a');
    taskRemoveBtn.classList.add('task__remove');
    taskRemoveBtn.setAttribute('href', '#');
    taskRemoveBtn.innerText = '×';
    taskRemoveBtn.addEventListener('click', removeTask);
    resultDiv.appendChild(taskRemoveBtn);

    tasksList.appendChild(resultDiv);

    input.value = '';

    saveData();
}

function initializeAddBtns() {
    addButton.addEventListener('click', e => {
        addTask();
        e.preventDefault();
    });

    input.addEventListener('keydown', e => {
        if (e.code === 'Enter') {
            addTask();
            e.preventDefault();
        }
    })
}

function initializeCloseBtns() {
    for (let btn of closeBtns) {
        btn.addEventListener('click', removeTask);
    }
}

function removeTask() {
    this.closest('div.task').remove();
    savedData.clear();
    let toSave = tasksList.innerHTML;
    savedData.setItem('tasks', toSave);
}

function restoreSavedData() {
    if (savedData.getItem('tasks')) {
        tasksList.innerHTML = savedData.getItem('tasks');
    }
}

function saveData() {
    savedData.clear();
    let toSave = tasksList.innerHTML;
    savedData.setItem('tasks', toSave);
}