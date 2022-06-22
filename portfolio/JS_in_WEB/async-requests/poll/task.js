const pollDiv = document.querySelector('.poll');

function start() {
  let request = new XMLHttpRequest();
  request.open("GET", 'https://netology-slow-rest.herokuapp.com/poll.php', true);
  request.onload = function () {
    const answer = JSON.parse(request.responseText);
    printPoll(answer);
  }
  request.send(null);
}

function printPoll(poll) {
  const pollQuestion = poll.data.title;
  const pollAnswers = poll.data.answers;
  const titleDiv = document.getElementById('poll__title');
  const answersDiv = document.getElementById('poll__answers');
  titleDiv.innerText = pollQuestion;

  for (let answer in pollAnswers) {
    const button = document.createElement('button');
    button.classList.add('poll__answer');
    button.innerText = pollAnswers[answer];
    answersDiv.appendChild(button);

    button.addEventListener('click', () => {
      alert('Спасибо, ваш голос засчитан!');
      sendAnswer(poll, answer);
    })
  }
  pollDiv.appendChild(answersDiv);
}

function sendAnswer(poll, answer) {
  const postString = `vote=${poll.id}&answer=${answer}`;

  const postRequest = new XMLHttpRequest();
  postRequest.open('POST', 'https://netology-slow-rest.herokuapp.com/poll.php');
  postRequest.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
  postRequest.send(postString);

  postRequest.onload = () => printStatistics(JSON.parse(postRequest.response));

}

function printStatistics(response) {
  let resultDiv = document.createElement('div')
  let sum = 0;
  for (element of response.stat) {
    sum += element.votes;
  }

  for (element of response.stat) {
    let statDiv = document.createElement('div');
    statDiv.innerText = element.answer + ': ' + ((element.votes / sum) * 100).toFixed(2) + '%';
    resultDiv.appendChild(statDiv);
  }
  let pollTitle = document.getElementById('poll__title');
  pollDiv.replaceChildren(pollTitle, resultDiv);
}

start();