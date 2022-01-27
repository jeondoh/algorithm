const fs = require('fs');
const input = fs.readFileSync("/dev/stdin").toString().split('\n');

let i = 0;
while (i < input.length - 1) {
  let [a, b] = input[i].split(' ').map(val => Number(val));
  console.log(a + b);
  i++
}