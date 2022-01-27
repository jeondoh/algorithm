const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split('\n');
const num = Number(input[0].split(" "));
let result = "";

for (let i = 1; i < 10; i++) {
  result += `${num} * ${i} = ${num * i}\n`;
}

console.log(result);