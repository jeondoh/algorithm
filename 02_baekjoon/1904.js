const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split("\n")

const n = Number(input[0]);
const d = new Array(n + 1).fill(0);

d[1] = 1;
d[2] = 2;

for(let x = 3; x <= n; x++){
  d[x] = d[x - 1] + d[x - 2];
  d[x] %= 15746;
}

console.log(d[n]);