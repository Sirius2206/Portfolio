const editor = document.getElementById('editor');
const localStorage = window.localStorage;
const clearBtn = document.getElementById('clear');
restoreSavedData();

function restoreSavedData() {
    if (localStorage.getItem('editorValue')) {
        editor.value = localStorage.getItem('editorValue');
    }
}


clearBtn.addEventListener('click', () => {
    editor.value = '';
    localStorage.setItem('editorValue', editor.value);
})
editor.addEventListener('keyup', e => {
        localStorage.setItem('editorValue', editor.value)
})  