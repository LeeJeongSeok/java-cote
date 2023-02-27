package me.jeongseok.cote.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        int dx[] = {1,2,2,1,-1,-2,-2,-1};
        int dy[] = {-2,-1,1,2,2,1,-1,-2};

        while (tc-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            boolean[][] visit = new boolean[N][N];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());

            Queue<Pair> queue = new LinkedList<>();
            queue.offer(new Pair(startX, startY));

            while (!queue.isEmpty()) {
                Pair cur = queue.poll();

                if (cur.getX() == targetX && cur.getY() == targetY) {
                    System.out.println(map[cur.getX()][cur.getY()]);
                    break;
                }

                for (int i = 0; i < 8; i++) {
                    int nx = cur.getX() + dx[i];
                    int ny = cur.getY() + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                        continue;
                    }

                    if(!visit[nx][ny]){
                        queue.offer(new Pair(nx, ny));
                        map[nx][ny] = map[cur.getX()][cur.getY()] + 1;
                        visit[nx][ny] = true;
                    }
                }
            }
        }
    }
}
