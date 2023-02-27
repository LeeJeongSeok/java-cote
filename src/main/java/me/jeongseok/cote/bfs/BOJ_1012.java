package me.jeongseok.cote.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] dx = new int[]{1, 0, -1, 0};
            int[] dy = new int[]{0, 1, 0, -1};
            int count = 0;

            int[][] map = new int[M][N];
            boolean[][] visit = new boolean[M][N];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }

            LinkedList<Pair> queue = new LinkedList<>();

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 0 || visit[i][j] == true) {
                        continue;
                    }

                    // 8. bfs 시작 (가장 첫번째 원소를 먼저 넣어주는 작업부터)
                    visit[i][j] = true;
                    queue.offer(new Pair(i, j));
                    count++;

                    while (!queue.isEmpty()) {
                        Pair cur = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = cur.getX() + dx[k];
                            int ny = cur.getY() + dy[k];

                            if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                                continue;
                            }

                            if(map[nx][ny] == 1 && !visit[nx][ny]){
                                queue.offer(new Pair(nx, ny));
                                visit[nx][ny] = true;
                            }
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
}
