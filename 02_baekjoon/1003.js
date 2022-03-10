const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split("\n")

const range = Number(input[0]);

for(let i=1; i<=range; i++){
  // 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
  const d = new Array(range + 1).fill(0);
  const num = Number(input[i]);

  if(num === 0){
    console.log(1, 0);
    continue;
  } else if(num === 1){
    console.log(0, 1);
    continue;
  }

  d[0] = 0;
  d[1] = 1;

  for(let i=2;i<=num;i++){
    d[i] = d[i-2] + d[i-1];
  }

  console.log(d[num - 1], d[num]);
}

