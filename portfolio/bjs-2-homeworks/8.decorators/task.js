function cachingDecoratorNew(func) {
  const cache = [];

  return function (...args) {
    const hash = args.join(',');
    let cachedResult = null;
    cache.forEach (elem => {
      if (elem.value === hash) {
        cachedResult = elem.result;
      }
    })
    if (cachedResult) {
      return "Из кэша: " + cachedResult;
    }
    const result = func(...args);
    cache.push({value: hash, result: result});
    if (cache.length > 5) {
      cache.shift();
    }
    return "Вычисляем: " + result;
  }
}


function debounceDecoratorNew(func, ms) {
  let timerId = null;
  let onCooldown = false;
  let count = 0;

  return function() {
    count++;
    console.log(count);
    if(timerId) clearTimeout(timerId);
    timerId = setTimeout(() => {
      func();
      onCooldown = true;
      setTimeout (() => onCooldown = false, ms)
    }, ms);
    if (!onCooldown) {
      func();
      onCooldown = true;
    }
  }
}

function debounceDecorator2(func, ms) {
  let start;
  let count = 0;

  return function() {
    count++;
    console.log(count);
    
    if (start === undefined) {
      start = Date.now();
      func();
    } else {
      let elapsedTime = Date.now() - start;
      start = Date.now();
      if (elapsedTime >= ms) {
        start = Date.now();
        func();
      }
    }
  }
}

const sendSignal = () => console.log("Сигнал отправлен");
const upgradedSendSignal = debounceDecoratorNew(sendSignal, 2000);

setTimeout(upgradedSendSignal); // Сигнал отправлен
setTimeout(upgradedSendSignal, 300); // проигнорировано так как от последнего вызова прошло менее 2000мс (300 - 0 < 2000)
setTimeout(upgradedSendSignal, 900); // проигнорировано так как времени от последнего вызова прошло: 900-300=600 (600 < 2000)
setTimeout(upgradedSendSignal, 1200); // проигнорировано так как времени от последнего вызова прошло: 1200-900=300 (300 < 2000)
setTimeout(upgradedSendSignal, 2300); // проигнорировано так как времени от последнего вызова прошло: 2300-1200=1100 (1100 < 2000)
setTimeout(upgradedSendSignal, 4400); // Сигнал отправлен так как времени от последнего вызова прошло: 4400-2300=2100 (2100 > 2000)
setTimeout(upgradedSendSignal, 4500); // Сигнал будет отправлен, так как последний вызов debounce декоратора (спустя 4500 + 2000 = 6500) 6,5с

setTimeout(() =>{
  console.log("\n------------------------\nЗадание №3")
  const task3 = debounceDecorator2(sendSignal, 2000);
  setTimeout(task3); // Сигнал отправлен
  setTimeout(task3, 300); // проигнорировано так как от последнего вызова прошло менее 2000мс (300 - 0 < 2000)
  setTimeout(task3, 900); // проигнорировано так как времени от последнего вызова прошло: 900-300=600 (600 < 2000)
  setTimeout(task3, 1200); // проигнорировано так как времени от последнего вызова прошло: 1200-900=300 (300 < 2000)
  setTimeout(task3, 2300); // проигнорировано так как времени от последнего вызова прошло: 2300-1200=1100 (1100 < 2000)
  setTimeout(task3, 4400); // Сигнал отправлен так как времени от последнего вызова прошло: 4400-2300=2100 (2100 > 2000)
  setTimeout(task3, 4500); // Сигнал будет отправлен, так как последний вызов debounce декоратора (спустя 4500 + 2000 = 6500) 6,5с
}, 7000)

