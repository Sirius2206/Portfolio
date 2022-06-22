function solveEquation(a, b, c) {
  let arr = [];
  let d = b ** 2 - 4 * a * c;
  if (d < 0) {
    return arr;
  }
  if (d === 0) {
    arr.push(-b/(2 * a));
  }
  if (d > 0) {
    arr.push((-b + Math.sqrt(d))/(2*a));
    arr.push((-b - Math.sqrt(d))/(2*a));
  }
  return arr; // array
}

function calculateTotalMortgage(percent, contribution, amount, date) {
  let totalAmount = 0;
  if (isNaN(percent) || (percent < 0)) return `Параметр "Процентная ставка" содержит неправильное значение "${percent}"`;
  if (isNaN(contribution) || (contribution < 0)) return `Параметр "Начальный взнос" содержит неправильное значение "${contribution}"`;
  if (isNaN(amount) || (amount < 0)) return `Параметр "Общая стоимость" содержит неправильное значение "${amount}"`;
  percent = +percent / 100;
  contribution = +contribution;
  amount = +amount;
  let dateTo = date;
  let dateFrom = new Date();
  let months = dateTo.getMonth() - dateFrom.getMonth() + (12 * (dateTo.getFullYear() - dateFrom.getFullYear()));
  let finalLoan = amount - contribution;
  let payment = finalLoan * (percent / 12 + ((percent / 12) / (((1 + (percent / 12)) ** months) - 1)));
  totalAmount = payment * months;
  return +totalAmount.toFixed(2);
}
