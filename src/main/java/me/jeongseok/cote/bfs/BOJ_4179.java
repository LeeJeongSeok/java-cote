package me.jeongseok.cote.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        Queue<Pair> hoon = new LinkedList<>();
        Queue<Pair> fire = new LinkedList<>();
        int[][] hoonDist = new int[N][M];
        int[][] fireDist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                if (line[j].equals("#")) {
                    hoonDist[i][j] = 1;
                    fireDist[i][j] = 1;
                } else {
                    hoonDist[i][j] = -1;
                    fireDist[i][j] = -1;
                }

                if (line[j].equals("J")) {
                    hoonDist[i][j] = 0;
                    hoon.offer(new Pair(i, j));
                }
                if (line[j].equals("F")) {
                    fireDist[i][j] = 0;
                    fire.offer(new Pair(i, j));
                }
            }
        }

        while (!fire.isEmpty()) {
            Pair cur = fire.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.getX() + dx[i];
                int ny = cur.getY() + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (fireDist[nx][ny] == 1 || fireDist[nx][ny] != -1) {
                    continue;
                }

                fire.offer(new Pair(nx, ny));
                fireDist[nx][ny] = fireDist[cur.getX()][cur.getY()] + 1;
            }
        }

        while (!hoon.isEmpty()) {
            Pair cur = hoon.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.getX() + dx[i];
                int ny = cur.getY() + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    System.out.println(hoonDist[cur.getX()][cur.getY()] + 1);
                    return;
                }

                if (hoonDist[nx][ny] == 1 || hoonDist[nx][ny] != -1) {
                    continue;
                }

                if (fireDist[nx][ny] != -1 && fireDist[nx][ny] <= hoonDist[cur.getX()][cur.getY()] + 1) {
                    continue;
                }

                hoon.offer(new Pair(nx, ny));
                hoonDist[nx][ny] = hoonDist[cur.getX()][cur.getY()] + 1;
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
