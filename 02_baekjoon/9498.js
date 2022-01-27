const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let input = [];
rl.on('line', function (line) {
  // 콘솔 입력 창에서 줄바꿈(Enter)를 입력할 때마다 호출
  input.push(line);
}).on('close', function () {
  // 콘솔 입력 창에서 Ctrl + C 혹은 Ctrl + D를 입력하면 호출(입력의 종료)

  let result = "";
  const x = Number(input[0]);

  if (x >= 90 && x <= 100) {
    result = "A";
  } else if (x >= 80 && x <= 89) {
    result = "B";
  } else if (x >= 70 && x <= 79) {
    result = "C";
  } else if (x >= 60 && x <= 69) {
    result = "D";
  } else {
    result = "F"
  }

  console.log(result);

  process.exit();
});