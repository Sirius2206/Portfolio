function compareArrays(arr1, arr2) {
  return arr1.length === arr2.length && arr1.every((elem, index) => elem === arr2[index]);

}

function advancedFilter(arr) {
  return resultArr = arr.filter(x => (x > 0 && x % 3 === 0)).map(x => x * 10);
}
