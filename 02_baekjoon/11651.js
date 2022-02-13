const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split("\n")

function compare(a, b) {
  if (a[1] === b[1]) {
    return a[0] - b[0]
  }
  return a[1] - b[1];
}

let length = Number(input[0]);
let data = [];

for (let i = 1; i <= length; i++) {
  let [x, y] = input[i].split(' ').map(Number);
  data.push([x, y]);
}

data.sort(compare);

let answer = "";
for (let i = 0; i < length; i++) {
  answer += `${data[i][0]} ${data[i][1]}\n`;
}

console.log(answer);