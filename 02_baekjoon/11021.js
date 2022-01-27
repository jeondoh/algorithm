const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split('\n');
const arr = Number(input[0]);
let result = "";

for (let i = 1; i <= arr; i++) {
  const arrNums = input[i].split(" ");
  const a = Number(arrNums[0]);
  const b = Number(arrNums[1]);
  result += `Case #${i}: ${a + b}\n`;
}
console.log(result);