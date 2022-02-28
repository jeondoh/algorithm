const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split('\n');
const stack = [];
const answer = [];
const fn = {
  push: x => {
    stack.push(x);
  },
  pop: () => {
    return stack.length === 0 ? -1 : stack.pop()
  },
  size: () => {
    return stack.length;
  },
  empty: () => {
    return stack.length === 0 ? 1 : 0
  },
  top: () => {
    return stack.length === 0 ? -1 : stack[stack.length - 1]
  }
}

for(let i = 1; i <= input[0]; i++) {
  const [cmd, num] = input[i].trim().split(/\s/g);
  if (cmd === 'push'){
    fn.push(parseInt(num));
  } else {
    answer.push(fn[cmd]())
  }
}

console.log(answer.join("\n"));