const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split('\n');
const [n, k] = input[0].split(" ");

let count = 0;

for(let i = 0; i<=n; i++){
  for(let j = 0; j<=59; j++){
    for(let l = 0; l<=59; l++){
      const time = i.toString().padStart(2, "0") + j.toString().padStart(2, "0") + l.toString().padStart(2, "0");
      if(time.includes(k)) count++;
    }
  }
}

console.log(count);