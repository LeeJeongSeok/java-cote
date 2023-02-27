package me.jeongseok.cote.dfs;

import me.jeongseok.cote.bfs.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2469 {

    static int n;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n][n];

        if (n == 0) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findSafetyArea();
        System.out.println(count);
    }

    public static void findSafetyArea() {

        // 다중 for문을 돌면서 n보다 큰 값은 영역으로 count
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (map[i][j] > n && visit[i][j] == false) {
                    count++;

                    Stack<Pair> stack = new Stack<>();
                    stack.push(new Pair(i, j));
                    visit[i][j] = true;

                    while (!stack.isEmpty()) {
                        Pair cur = stack.pop();

                        for (int k = 0; k < 4; k++) {
                            int nx = cur.getX() + dx[k];
                            int ny = cur.getY() + dy[k];

                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                                continue;
                            }
                            if (map[nx][ny] > n && visit[nx][ny] == false) {
                                stack.push(new Pair(nx, ny));
                                visit[nx][ny] = true;
                            }
                        }
                    }
                }
            }
        }
    }
}
