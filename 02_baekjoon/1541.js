const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split("\n")

let data = input[0];
let groups = data.split("-");
let result = 0;

result += groupsReduce(groups[0])
for(let i = 1; i<groups.length; i++){
  result -= groupsReduce(groups[i]);
}

console.log(result);

function groupsReduce(value){
  return value.split("+").map(Number).reduce((a, b) => a+b);
}

