package me.jeongseok.cote.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BFS {
    static List<Integer>[] nodeList;
    static int[] visited;
    // 큐 용도로 사용 할 Array Deque 정의
    static ArrayDeque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) {
        int N = 5;
        int[][] nodes = {{0,1},{0,2},{1,3},{1,4}};

        // 리스트, 배열 초기화
        nodeList = new ArrayList[N];

        for(int i=0; i<N; i++) {
            nodeList[i] = new ArrayList<>();
        }

        visited = new int[N];

        // 입력받은 간선을 간선 리스트에 저장
        // ex) 1-2 : nodeList[1].add(2); nodeList[2].add(1);
        // 무방향성이므로 양쪽을 저장
        for(int[] e : nodes){
            nodeList[e[0]].add(e[1]);
            nodeList[e[1]].add(e[0]);
        }

        queue.clear(); // 큐 초기화
        bfs(0); // 0부터 출발
    }
    static void bfs(int start) {
        visited[start] = 1; // 0은 방문 처리
        queue.add(start); // 0을 큐에 저장

        while(!queue.isEmpty()){ // 큐에 아무것도 없을때까지 동작
            int cur = queue.poll(); // 큐에서 제일 먼저 넣은 정점을 꺼냄
            for(int next : nodeList[cur]) {
                if(visited[next] == 0) { // 이어진 점이 방문한 곳이 아니면
                    visited[next] = 1; // 방문 처리하고
                    queue.add(next); // 큐에 방문한 정점을 저장
                }
            }
        }
    }
}
