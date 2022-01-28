const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split("\n")
const arrNums = input[1].split(" ").map(Number);

const min = arrNums.reduce((acc, cur) => acc > cur ? cur : acc);
const max = arrNums.reduce((acc, cur) => acc > cur ? acc : cur);

console.log(min, max);