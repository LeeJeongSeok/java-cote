package me.jeongseok.cote.dfs;

import me.jeongseok.cote.bfs.Pair;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 1. 시작하는 칸을 스택에 넣고 방문했다는 표시를 남김
 * 2. 스택에서 원소를 꺼내어 그 칸에 상하좌우로 인접한 칸에 대해 3번을 진행
 * 3. 해당 칸을 이전에 방문했다면 아무 것도 하지 않고, 처음으로 방문했다면 방문했다는 표시를 남기고 해당 칸을 스택에 삽입
 * 4. 큐의 빌 때 까지 2번 항목을 반복
 * 모든 칸이 스택에 1번씩 들어가므로 시간복잡도는 칸이 N개일 때 O(N)
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

        Stack<Pair> stack = new Stack<>();
        visit[0][0] = true;
        stack.push(new Pair(0, 0));

        while (!stack.isEmpty()) {
            Pair cur = stack.pop();
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
                stack.push(new Pair(nx, ny));
            }
        }
    }
}
