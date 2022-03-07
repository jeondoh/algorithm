const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split("\n");

const n = Number(input[0]); // 노드의 개수(N)
const m = Number(input[1]); // 간선의 개수(M)

let graph = []; // 전체 그래프
let result = 0;

for(let i=0; i<=n; i++){
  graph.push([]);
}

// 각 노드에 대한 방문 여부
let visited = new Array(n + 1).fill(false);

for(let i=2; i<m+2; i++){
  const [x, y] = input[i].split(' ').map(Number);
  graph[x].push(y);
  graph[y].push(x);
}

function dfs(x){
  result++; // 카운트
  visited[x] = true; // 방문처리
  // 인접한 노드 중 방문하지 않은 노드 방문
  for(let i of graph[x]){
    if(visited[i] === false){
      dfs(i);
    }
  }
}

dfs(1);
console.log(result - 1); // 본인을 제외한 노드