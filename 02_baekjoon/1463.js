const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split("\n")

const n = Number(input[0]);
// 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
let d = new Array(30001).fill(0);

// + 1을 하는 이유
// 1번의 연산을 사용하였기 때문
for(let i=2; i<=n; i++){
  // 현재 수에서 1빼는 경우
  d[i] = d[i - 1] + 1;
  // 현재 수가 2로 나누어 떨어지는 경우
  if(i % 2 === 0){
    d[i] = Math.min(d[i], d[parseInt(i / 2)] + 1);
  }
  // 현재 수가 3로 나누어 떨어지는 경우
  if(i % 3 === 0){
    d[i] = Math.min(d[i], d[parseInt(i / 3)] + 1);
  }
}

console.log(d[n]);