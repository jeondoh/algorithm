const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split('\n');
let loop = true;
let index = 0;
let result = "";

while (loop) {
  const arr = input[index++].split(" ");
  const a = Number(arr[0]);
  const b = Number(arr[1]);
  if (a === 0 && b === 0) {
    break;
  }
  result += (a + b).toString() + "\n";
}
console.log(result);
