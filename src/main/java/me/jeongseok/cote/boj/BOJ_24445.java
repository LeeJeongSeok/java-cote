package me.jeongseok.cote.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_24445 {
    public static void bfs(int V, int E, int R) {

    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 정점의 수
        int M = Integer.parseInt(st.nextToken()); // 간선의 수
        int R = Integer.parseInt(st.nextToken()); // 시작 정점

        bfs(N, M, R);
    }
}
