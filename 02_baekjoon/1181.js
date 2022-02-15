const fs = require('fs');
const input = fs.readFileSync("./test.txt").toString().split("\n")

function compare(a, b) {
  if (a.length !== b.length) {
    return a.length - b.length;
  }
  if (a < b) return -1;
  else if (a > b) return 1;
  else return 0;
}

let length = Number(input[0]);
let result = [];

for (let i = 1; i <= length; i++) {
  result.push(input[i]);
}

result = [...new Set(result)];

result.sort(compare);

for (let x of result) {
  console.log(x);
}