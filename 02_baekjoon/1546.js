const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split("\n")
const resultArr = input[1].split(" ").map(Number);
const max = resultArr.reduce((acc, cur) => acc > cur ? acc : cur);

const result = resultArr.reduce((acc, cur) => {
  acc += cur / max * 100
  return acc;
}, 0);

console.log((result / resultArr.length).toFixed(2));