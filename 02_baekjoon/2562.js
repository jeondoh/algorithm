const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split("\n")
const arrNums = input.map(Number);

const max = arrNums.reduce((acc, cur) => acc > cur ? acc : cur);

console.log(max);
console.log(arrNums.indexOf(max) + 1);