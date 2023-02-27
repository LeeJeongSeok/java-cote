package me.jeongseok.cote.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4963 {
    static int w, h;
    static int[][] map;
    static int[] dx = new int[]{0, 0, 1, -1, -1, 1, -1, 1};
    static int[] dy = new int[]{1, -1, 0, 0, -1, 1, 1, -1};
    static boolean[][] visit;
    static int count;
    static int SEA = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];
            visit = new boolean[h][w];
            count = 0;

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == SEA && !visit[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                continue;
            }

            if (map[nx][ny] == SEA && !visit[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}
