const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split('\n');

// 가지고 있는 숫자 카드의 개수
const cardNum = Number(input[0]);
// 숫자 카드에 적혀있는 정수
const cardArr = input[1].split(" ").map(Number);
// 비교할 카드 개수
const compareNum = Number(input[2]);
// 몇 개 가지고 있는 숫자 카드인지 구해야할 카드 배열
const compareArr = input[3].split(" ").map(Number);

function countByRange(cardArr, leftValue, rightValue){
  const rightIndex = upperBound(cardArr, rightValue, 0, cardArr.length);
  const leftIndex = lowerBound(cardArr, leftValue, 0, cardArr.length);
  return rightIndex - leftIndex;
}

// 정렬된 순서를 유지하면서 배열에 삽입할 가장 왼쪽 인덱스 반환
function lowerBound(arr, target, start, end) {
  while (start < end) {
    let mid = parseInt((start + end) / 2);
    if (arr[mid] >= target) end = mid; // 최대한 왼쪽으로 이동하기
    else start = mid + 1;
  }
  return end;
}
// 정렬된 순서를 유지하면서 배열에 삽입할 가장 오른쪽 인덱스 반환
function upperBound(arr, target, start, end) {
  while (start < end) {
    let mid = parseInt((start + end) / 2);
    if (arr[mid] > target) end = mid;
    else start = mid + 1; // 최대한 오른쪽으로 이동하기
  }
  return end;
}
// 정렬
cardArr.sort((a, b) => a - b);
let result = "";
for(let i = 0; i<compareNum; i++){
  result += countByRange(cardArr, compareArr[i], compareArr[i]) + " ";
}
console.log(result);
