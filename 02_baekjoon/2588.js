const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split('\n');
const target = Number(input[0]);
const multi = input[1];
let result = "";

for (let i = multi.length - 1; i >= 0; i--) {
  result += (target * Number(multi[i])).toString() + "\n";
}

console.log(`${result}${target * Number(multi)}`);