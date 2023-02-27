package me.jeongseok.cote.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5427 {

    static int T, w, h;
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int[][] fmap, smap;
    static boolean[][] fvisit, svisit;
    static Queue<Pair> fqueue, squeue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            fmap = new int[h][w];
            smap = new int[h][w];

            fvisit = new boolean[h][w];
            svisit = new boolean[h][w];

            fqueue = new LinkedList<>();
            squeue = new LinkedList<>();

            // 입력 초기화
            for (int i = 0; i < h; i++) {
                String[] line = br.readLine().split("");
                for (int j = 0; j < w; j++) {
                    if (line[j].equals("#")) {
                        fmap[i][j] = 1;
                        smap[i][j] = 1;
                    } else {
                        fmap[i][j] = -1;
                        smap[i][j] = -1;
                    }

                    if (line[j].equals("*")) {
                        fmap[i][j] = 0;
                        fqueue.offer(new Pair(i, j));
                        fvisit[i][j] = true;
                    }

                    if (line[j].equals("@")) {
                        smap[i][j] = 0;
                        squeue.offer(new Pair(i, j));
                        svisit[i][j] = true;
                    }
                }
            }
            bfs();
        }
    }

    public static void bfs() {
        while (!fqueue.isEmpty()) {
            Pair cur = fqueue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.getX() + dx[i];
                int ny = cur.getY() + dy[i];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                    continue;
                }

                if (fvisit[nx][ny] == true || fmap[nx][ny] == 1 && fmap[nx][ny] != -1) {
                    continue;
                }

                fqueue.offer(new Pair(nx, ny));
                fvisit[nx][ny] = true;
                fmap[nx][ny] = fmap[cur.getX()][cur.getY()] + 1;

            }
        }

        while (!squeue.isEmpty()) {
            Pair cur = squeue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.getX() + dx[i];
                int ny = cur.getY() + dy[i];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                    System.out.println(smap[cur.getX()][cur.getY()] + 1);
                    return;
                }

                if (svisit[nx][ny] == true || smap[nx][ny] == 1 && smap[nx][ny] != -1) {
                    continue;
                }

                if (fmap[nx][ny] != -1 && smap[cur.getX()][cur.getY()] + 1 >= fmap[nx][ny]) {
                    continue;
                }

                squeue.offer(new Pair(nx, ny));
                svisit[nx][ny] = true;
                smap[nx][ny] = smap[cur.getX()][cur.getY()] + 1;

            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
