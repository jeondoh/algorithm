const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split("\n")
const resultArr = new Array(10).fill(0);

const multiply = Number(input[0]) * Number(input[1]) * Number(input[2]);
const multiStr = String(multiply);

for (let i = 0; i < multiStr.length; i++) {
  resultArr[multiStr[i]] = resultArr[Number(multiStr[i])] + 1;
}

// 출력
for (let i = 0; i < resultArr.length; i++) {
  console.log(resultArr[i]);
}