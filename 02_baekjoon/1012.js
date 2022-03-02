const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().split("\n")

const number = Number(input[0]);

// 북 동 남 서
let dx = [-1, 0, 1, 0];
let dy = [0, 1, 0, -1];
let line = 1;

for(let i=1; i<=number; i++){
  const [n, m, k] = input[line].split(" ").map(Number);
  let data = [];
  let visited = [];
  let result = 0;

  for(let j=0; j<n; j++){
    data.push(new Array(m).fill(0));
    visited.push(new Array(m).fill(false));
  }

  for(let j=line+1; j<=line+k; j++){
    const [x, y] = input[j].split(" ").map(Number);
    data[x][y] = 1;
  }

  // 모든 위치를 확인
  for(let k = 0; k < n; k++){
    for(let l = 0; l < m; l++){
      // 해당 위치가 배추가 심어진 곳이면서,, 아직 방문하지 않은 경우 (해당 위치가 포함된 단지를 처리하지 않은 경우)
      if(data[k][l] === 1 && visited[k][l] === false){
        dfs(k, l); // 연결된 모든 위치를 방문 처리
        result++; // 배추 수 카운트
      }
    }
  }
  console.log(result); // 배추 수 출력
  line += k + 1;

  // 연결된 모든 위치를 방문 처리
  function dfs(x, y) {
    visited[x][y] = true; // 방문 처리
    for (let i = 0; i < 4; i++) { // 북, 동, 남, 서 각각 확인
      let nx = x + dx[i];
      let ny = y + dy[i];
      // 맵의 범위를 벗어난 경우 무시
      if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
      // 해당 위치가 배추가 심어진 곳이면서, 아직 방문하지 않은 위치인 경우
      if (data[nx][ny] === 1 && visited[nx][ny] === false) {
        dfs(nx, ny); // 재귀적으로 방문 처리
      }
    }
  }
}

