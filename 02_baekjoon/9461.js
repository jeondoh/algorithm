const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split("\n")

const d = new Array(101).fill(0);
d[1] = 1;
d[2] = 1;
d[3] = 1;

let textCases = Number(input[0]);
let line = 1;

while(textCases--){
  let n = Number(input[line]);
  for(let x = 4; x<=n; x++){
    d[x] = d[x - 2] + d[x - 3];
  }
  console.log(d[n]);
  line++;
}

