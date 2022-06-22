const send = document.getElementById('send');
const progress = document.getElementById('progress');
send.addEventListener('click', e => {
    sendFile();
    e.preventDefault();
});

function sendFile() {
let file = document.getElementById('file').files[0];
let formData = new FormData();           
formData.append("file", file);

let xhr = new XMLHttpRequest();

xhr.upload.onprogress = function(event) {
    progress.setAttribute('value', (event.loaded / event.total).toFixed(3))
  }

  xhr.upload.onload = function() {
    alert('Закачка завершена');
  }
xhr.open('POST', 'https://netology-slow-rest.herokuapp.com/upload.php', true);
xhr.send(formData); 
}