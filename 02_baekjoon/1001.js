const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const result = input[0].split(" ");
console.log(parseInt(result[0]) - parseInt(result[1]))
