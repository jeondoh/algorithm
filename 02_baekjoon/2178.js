const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split("\n");

class Queue {
  constructor() {
    this.items = {};
    this.headIndex = 0;
    this.tailIndex = 0;
  }
  enqueue(item) {
    this.items[this.tailIndex] = item;
    this.tailIndex++;
  }
  dequeue() {
    const item = this.items[this.headIndex];
    delete this.items[this.headIndex];
    this.headIndex++;
    return item;
  }
  peek() {
    return this.items[this.headIndex];
  }
  back() {
    return this.items[this.tailIndex - 1];
  }
  getLength() {
    return this.tailIndex - this.headIndex;
  }
}

const [n, m] = input[0].split(" ").map(Number);
let graph = [];
let visited = [];

for(let i=1; i<=n; i++){
  graph.push(input[i].split('').map(Number));
  visited.push(new Array(m).fill(0));
}

let queue = new Queue();
queue.enqueue([0, 0]);
visited[0][0] = 1;

// 상 하 좌 우
let dx = [-1, 1, 0, 0];
let dy = [0, 0, -1, 1];

// 큐가 빌 때까지 반복
while(queue.getLength() !== 0){
  let [x, y] = queue.dequeue();
  for(let i=0; i<4; i++){
    // 다음 위치
    let nx = x + dx[i];
    let ny = y + dy[i];
    // 미로 범위를 벗어나는 경우
    if(nx < 0 || ny < 0 || nx >=n || ny >= m){
      continue;
    }
    // 해당 위치를 처음 방문하면서 이동할 수 있는 경우
    if(visited[nx][ny] === 0 && graph[nx][ny] === 1){
      visited[nx][ny] = visited[x][y] + 1;
      queue.enqueue([nx, ny]);
    }
  }
}

console.log(visited[n - 1][m - 1]);
