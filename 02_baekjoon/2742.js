const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split('\n');
const num = Number(input[0]);
let result = "";

for (let i = num; i >= 1; i--) {
  result += `${i}\n`;
}
console.log(result);
