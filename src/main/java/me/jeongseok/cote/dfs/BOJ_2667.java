package me.jeongseok.cote.dfs;

import me.jeongseok.cote.bfs.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2667 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        int totalCount = 0;
        int homeCount = 0;
        boolean[][] visit = new boolean[n][n];

        ArrayList<Integer> homes = new ArrayList<>();

        // 입력 초기화
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        // 집 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (arr[i][j] == 0 || visit[i][j] == true) {
                    continue;
                }

                Stack<Pair> stack = new Stack<>();
                stack.push(new Pair(i, j));
                visit[i][j] = true;
                totalCount++;
                homeCount = 0;

                while (!stack.isEmpty()) {
                    Pair cur = stack.pop();
                    homeCount++;

                    for (int k = 0; k < 4; k++) {
                        int nx = cur.getX() + dx[k];
                        int ny = cur.getY() + dy[k];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                            continue;
                        }

                        if (!visit[nx][ny] && arr[nx][ny] == 1) {
                            stack.push(new Pair(nx, ny));
                            visit[nx][ny] = true;
                        }
                    }
                }
                homes.add(homeCount);

            }
        }
        System.out.println(totalCount);
        Collections.sort(homes);
        for (int i = 0; i < homes.size(); i++) {
            System.out.println(homes.get(i));
        }
    }
}
