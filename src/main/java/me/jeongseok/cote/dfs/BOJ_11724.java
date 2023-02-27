package me.jeongseok.cote.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 나누어진 각각의 그래프를 연결 요소라고 한다.
public class BOJ_11724 {

    static int node, edge;
    static int[][] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        arr = new int[node + 1][node + 1];
        visit = new boolean[node + 1];
        int count = 0;

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = 1;
        }


        for (int i = 1; i < node + 1; i++) {
            if (!visit[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void dfs(int i) {
        visit[i] = true;
        for (int j = 1; j < node + 1; j++) {
            if (arr[i][j] == 1 && !visit[j]) {
                dfs(j);
            }
        }
    }
}
