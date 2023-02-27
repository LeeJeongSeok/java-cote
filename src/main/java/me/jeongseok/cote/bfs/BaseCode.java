package me.jeongseok.cote.bfs;

import java.util.LinkedList;

/**
 * 1. 시작하는 칸을 큐에 넣고 방문했다는 표시를 남김
 * 2. 큐에서 원소를 꺼내어 그 칸에 상하좌우로 인접한 칸에 대해 3번을 진행
 * 3. 해당 칸을 이전에 방문했다면 아무 것도 하지 않고, 처음으로 방문했다면 방문했다는 표시를 남기고 해당 칸을 큐에 삽입
 * 4. 큐의 빌 때 까지 2번 항목을 반복
 *
 * 알아야할 개념은 상하좌우 방향 배열
 */



public class BaseCode {
    public static void main(String[] args) {
        int[][] board = new int[100][100];
        boolean[][] visit = new boolean[100][100];
        int n = 7;
        int m = 10;
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        LinkedList<Pair> queue = new LinkedList<>();
        visit[0][0] = true;
        queue.add(new Pair(0, 0));

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            System.out.println(cur.getX() + " " + cur.getY());
            for (int i = 0; i < 4; i++) {
                int nx = cur.getX() + dx[i];
                int ny = cur.getY() + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (visit[nx][ny] || board[nx][ny] != 1) {
                    visit[nx][ny] = true;
                }
                queue.add(new Pair(nx, ny));
            }
        }
    }
}
