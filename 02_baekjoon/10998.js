const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split('\n');
const result = input[0].split(" ");
const a = Number(result[0]);
const b = Number(result[1]);
console.log(a * b);
