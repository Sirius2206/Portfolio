// Задание 1
function getArrayParams(arr) {
  let min = arr[0];
  let max = arr[0];
  let sum = 0;
  arr.forEach(el => {
    min = (el < min) ? el : min;
    max = (el > max) ? el : max;
    sum += el;
  });

  let avg = +((sum / arr.length).toFixed(2));
  return { min: min, max: max, avg: avg };
}

// Задание 2
function worker(arr) {
  return arr.reduce((sum, cur) => sum + cur, 0);
}

function makeWork(arrOfArr, func) {
  let max = -Infinity;
  let sum = 0;
  arrOfArr.forEach(el => {
    sum = func(el);
    max = (sum > max) ? sum : max;
  });
  return max;
}

// Задание 3
function worker2(arr) {
  let min = arr[0];
  let max = arr[0];
  arr.forEach(el => {
    min = (el < min) ? el : min;
    max = (el > max) ? el : max;
  });

  return max - min;
}
