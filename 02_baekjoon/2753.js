const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split('\n');
const num = Number(input[0]);
let result = 0;
// 4의 배수이면서 100의 배수가 아닐때 또는 400의 배수일 때
if (num % 4 === 0 && num % 100 !== 0 || num % 400 === 0) {
  result = 1;
}

console.log(result);
