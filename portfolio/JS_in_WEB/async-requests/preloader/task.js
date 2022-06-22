let localStorage = window.localStorage;
const items = document.getElementById('items');
if(localStorage.getItem('valutesPrev')) {
  items.innerHTML = localStorage.getItem('valutesPrev');
}

  function start() {
    var request = new XMLHttpRequest();
    request.open("GET", 'https://netology-slow-rest.herokuapp.com', true);
    request.onload = function () {
      items.innerHTML = '';
      const valutes = JSON.parse(request.responseText).response.Valute;
      print(valutes);
      document.getElementById('loader').classList.remove('loader_active')
    }
    request.send(null);
  }

  function print(valutes) {
    for (const valute in valutes) {
      items.appendChild(createItem(valutes[valute]));
    }
    localStorage.setItem('valutesPrev', items.innerHTML);
  }

  function createItem(item) {
    const resultDiv = document.createElement('div');
    resultDiv.classList.add('item');

    const itemCode = document.createElement('div');
    itemCode.classList.add('item__code');
    itemCode.innerText = item.CharCode;
    resultDiv.appendChild(itemCode);

    const itemValue = document.createElement('div');
    itemValue.classList.add('item__value');
    itemValue.innerText = item.Value;
    resultDiv.appendChild(itemValue);

    const itemCurrency = document.createElement('div');
    itemCurrency.classList.add('item__currency');
    itemCurrency.innerText = 'руб.'
    resultDiv.appendChild(itemCurrency)
    return resultDiv;
  }

  start();