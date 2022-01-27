const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split('\n');
const num = Number(input[0]);
let result = 0;

for (let i = 1; i <= num; i++) {
  result += i;
}
console.log(result);