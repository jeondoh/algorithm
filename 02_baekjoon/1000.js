const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split('\n');

const line = input[0].split(' ');
const a = parseInt(line[0]);
const b = parseInt(line[1]);

console.log(a + b);