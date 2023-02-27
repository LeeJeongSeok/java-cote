package me.jeongseok.cote.dfs;

import me.jeongseok.cote.bfs.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 1. 상하좌우로 연결된 그림의 크기를 알아내기
 * 2. 도화지에 있는 모든 그림을 찾아내기
 *  * 도화지에 있는 모든 그림을 찾아내기 위해선 2중 for문으로 2차원 배열을 전체 탐색하면서 해당 인덱스가 bfs의 시작점이 될 수 있는지 없는지를 판단
 *  * 만약 bfs의 시작점이 될 수 있다면 bfs 로직 시작, 그렇지 않으면 continue
 */
public class BOJ_1926 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 1. 먼저 세로의 크기, 가로의 크기를 입력받는다. 그리고 방향 Array도 필수
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        int area = 0;
        int max = 0;
        int count = 0;

        // 2. 해당 크기의 2차원 배열을 선언한 후
        int[][] array = new int[n][m];

        // 3. 입력으로 들어온 그림의 정보를 2차원 배열을 초기화 시킨다.
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 4. 동일한 크기의 visit 배열을 생성하여 false로 초기화 시킨다.
        boolean[][] visit = new boolean[n][m];

        // 5. 큐를 선언
        Stack<Pair> stack = new Stack<>();

        // 6. 2중 for문을 돌면서 해당 인덱스가 bfs의 시작점인지 판단
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 7. 큐에 가장 첫 번째 원소를 집어넣고, visit 배열을 true 반환
                // 넣기 전에 방문 했거나, 0인 구역이 존재할 수 있으니 그에 대한 분기처리
                if (array[i][j] == 0 || visit[i][j] == true) {
                    continue;
                }

                // 8. bfs 시작 (가장 첫번째 원소를 먼저 넣어주는 작업부터)
                visit[i][j] = true;
                stack.push(new Pair(i, j));
                count++;
                area = 0;

                while (!stack.isEmpty()) {
                    Pair cur = stack.pop();
                    area++;
                    for (int k = 0; k < 4; k++) {
                        int nx = cur.getX() + dx[k];
                        int ny = cur.getY() + dy[k];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                            continue;
                        }

                        if(array[nx][ny] == 1 && !visit[nx][ny]){
                            stack.push(new Pair(nx, ny));
                            visit[nx][ny] = true;
                        }
                    }

                    if (area > max) {
                        max = area;
                    }
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }
}
