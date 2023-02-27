package me.jeongseok.cote.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026 {

    static int N;
    static int[][] map;
    static int[][] map2;
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        map2= new int[N][N];

        int count = 0;
        int count2 = 0;

        Queue<Pair> redQueue = new LinkedList<>();
        Queue<Pair> greenQueue = new LinkedList<>();
        Queue<Pair> blueQueue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < line.length; j++) {
                if (line[j].equals("R")) {
                    map[i][j] = -1;
                }

                if (line[j].equals("G")) {
                    map[i][j] = -2;
                }

                if (line[j].equals("B")) {
                    map[i][j] = -3;
                }
            }

            // 적록색약인 사람
            for (int j = 0; j < line.length; j++) {
                if (line[j].equals("R") || line[j].equals("G")) {
                    map2[i][j] = -1;
                }

                if (line[j].equals("B")) {
                    map2[i][j] = -3;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == -1) {
                    redQueue.add(new Pair(i, j));
                    count++;
                    bfs(redQueue, "R");
                }

                if (map[i][j] == -2) {
                    greenQueue.add(new Pair(i, j));
                    count++;
                    bfs(greenQueue, "G");
                }

                if (map[i][j] == -3) {
                    blueQueue.add(new Pair(i, j));
                    count++;
                    bfs(blueQueue, "B");
                }
            }
        }

        redQueue.clear();
        greenQueue.clear();
        blueQueue.clear();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map2[i][j] == -1) {
                    redQueue.add(new Pair(i, j));
                    count2++;
                    bfs2(redQueue, "R");
                }

                if (map2[i][j] == -3) {
                    blueQueue.add(new Pair(i, j));
                    count2++;
                    bfs2(blueQueue, "B");
                }
            }
        }

        System.out.println(count + " " + count2);
    }

    public static void bfs(Queue<Pair> queue, String color) {
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.getX() + dx[i];
                int ny = cur.getY() + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                if (color.equals("R") && map[nx][ny] == -1) {
                    map[nx][ny] = 1;
                    queue.offer(new Pair(nx, ny));
                }

                if (color.equals("G") && map[nx][ny] == -2) {
                    map[nx][ny] = 2;
                    queue.offer(new Pair(nx, ny));
                }

                if (color.equals("B") && map[nx][ny] == -3) {
                    map[nx][ny] = 3;
                    queue.offer(new Pair(nx, ny));
                }
            }
        }
    }

    public static void bfs2(Queue<Pair> queue, String color) {
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.getX() + dx[i];
                int ny = cur.getY() + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                if (color.equals("R") && map2[nx][ny] == -1) {
                    map2[nx][ny] = 1;
                    queue.offer(new Pair(nx, ny));
                }

                if (color.equals("B") && map2[nx][ny] == -3) {
                    map2[nx][ny] = 3;
                    queue.offer(new Pair(nx, ny));
                }
            }
        }
    }
}
