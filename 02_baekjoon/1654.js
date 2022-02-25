const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split('\n');

const [n, m] = input[0].split(" ").map(Number);

let dataArr = [];
for (let i = 1; i<=n; i++){
  dataArr.push(Number(input[i]));
}

let start = 1;
let end = dataArr.reduce((a, b) => Math.max(a, b));

// 이진탐색
let result = 0;
while(start <= end){
  let total = 0;
  let middle = parseInt((start + end) / 2); // 중간점
  for (let data of dataArr){
    total += parseInt(data / middle);
  }
  if(total >= m) { // 개수가 충분, 길이 높이기
    result = middle;
    start = middle + 1;
  }else{ // 개수가 부족, 길이 낮추기
    end = middle - 1;
  }
}

console.log(result);