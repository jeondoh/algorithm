const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split("\n")

let length = Number(input[0]);
let data = [];

for (let i = 1; i <= length; i++) {
  data.push(Number(input[i]));
}

data.sort((a, b) => a - b);

let answer = "";
for (let i = 0; i < length; i++) {
  answer += data[i] + "\n";
}

console.log(answer);