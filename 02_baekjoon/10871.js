const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split('\n');
const arr = input[0].split(" ");
const x = Number(arr[1]); // 정수 X
const arrList = input[1].split(" "); // 수열

let result = arrList.reduce((acc, cur) => {
  cur < x ? acc += `${cur} ` : "";
  return acc;
}, "");

console.log(result);

