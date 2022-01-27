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

  let x = Number(input[0]);
  let y = Number(input[1]);

  if (x > 0 && y > 0) console.log(1);
  else if (x < 0 && y > 0) console.log(2);
  else if (x < 0 && y < 0) console.log(3);
  else console.log(4);

  process.exit();
});