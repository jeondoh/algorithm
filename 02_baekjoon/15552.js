const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split('\n');
const arr = input[0];
let result = "";

for(let i = 1; i<=arr; i++){
  const arrNums = input[i].split(" ");
  result += (Number(arrNums[0]) + Number(arrNums[1])).toString() + "\n";
}

console.log(result);