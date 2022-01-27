const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split('\n');
const length = input.length;
let result = "";

for (let i = 0; i < length; i++) {
  let numArr = input[i].split(" ");
  if(numArr.length === 1) continue;
  const a = Number(numArr[0]);
  const b = Number(numArr[1]);
  result += (a+b).toString() + "\n";
}
console.log(result);