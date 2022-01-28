const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split("\n")
const arrNums = input.map(Number);
const resultArr = new Set();

for (let i = 0; i < 10; i++) {
  resultArr.add(arrNums[i] % 42);
}

console.log(resultArr.size);
