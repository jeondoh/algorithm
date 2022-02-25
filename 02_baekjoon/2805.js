const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split('\n');

const [n, m] = input[0].split(" ");
const treeCntArr = input[1].split(" ");

let start = 0;
let end = treeCntArr.map(Number).reduce((a, b) => Math.max(a, b));

// 이진탐색
let result = 0;
while(start <= end){
  let total = 0;
  let middle = parseInt((start + end) / 2); // 중간점
  for (let tree of treeCntArr){
    // 중간점에서 잘랐을때 얻을 수 있는 나무 길이
    if(tree > middle) total += tree - middle;
  }
  if(total < m) {
    end = middle - 1; // 나무 길이가 부족한 경우 더 많이 자르기
  }else{
    result = middle;
    start = middle + 1;
  }
}

console.log(result);