const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split('\n');
const result = Number(input[0]);
console.log(result - 543);

