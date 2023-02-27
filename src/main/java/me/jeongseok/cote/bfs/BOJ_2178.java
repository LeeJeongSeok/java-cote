package me.jeongseok.cote.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2178 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 1. 먼저 세로의 크기, 가로의 크기를 입력받는다. 그리고 방향 Array도 필수
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        // 2. 미로 선언과 동일한 크기로 거리를 계산할 배열 선언
        // 거리를 체크하면서 방문여부를 확인하기 때문에 '그림'문제 처럼 visit 배열 사용하지 않음
        char[][] maze = new char[n][m];
        int[][] distance = new int[n][m];

        // 3. 입력으로 들어온 그림의 정보를 2차원 배열을 초기화 시킨다.
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = line.charAt(j);
                distance[i][j] = -1;
            }
        }

        // 5. 큐를 선언
        LinkedList<Pair> queue = new LinkedList<>();

        // 6. bfs 시작
        distance[0][0] = 0;
        queue.offer(new Pair(0, 0));

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur.getX() + dx[k];
                int ny = cur.getY() + dy[k];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if(maze[nx][ny] == '0' || distance[nx][ny] != -1){
                    continue;
                }

                queue.offer(new Pair(nx, ny));
                distance[nx][ny] = distance[cur.getX()][cur.getY()] + 1;
            }
        }
        System.out.println(distance[n-1][m-1] + 1);
    }
}
