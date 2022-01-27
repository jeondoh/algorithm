// readline 모듈보다는 fs를 이용해 파일 전체를 읽어 들여 처리하기
const fs = require('fs');
const input = fs.readFileSync('./dev/stdin').toString().split('\n');

let n = Number(input[0]);
const start = n; // 처음에 입력된 수
let cnt = 0; // 사이클의 길이

while (true) {
  // n을 문자열로 변경
  n = n + "";
  // 10보다 작은 경우 앞에 0을 붙이기
  if (n.length === 1) {
    n = "0" + n;
  }
  // 자릿수의 합
  const summary = Number(n[0]) + Number(n[1]);
  // 주어진 수의 가장 오른쪽 자리 수와 자릿수의 합의 가장 오른쪽 자리 수를 이어 붙이기
  n = Number(n[1]) * 10 + summary % 10;

  // 사이클의 길이
  cnt += 1;
  if (n === start) break;
}

console.log(cnt);