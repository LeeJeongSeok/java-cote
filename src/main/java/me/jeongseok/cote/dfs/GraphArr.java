package me.jeongseok.cote.dfs;

public class GraphArr {
    private int[][] graph;

    // 그래프 초기화
    public GraphArr(int size) {
        // 그래프 문제에서 들어오는 인풋이 1 ~ n 기준인 경우가 많고
        // get할 때 1번 부터 편하게 가져오기 위해서 실제 개수보다 한개 더 많게 선언
        this.graph = new int[size + 1][size + 1];
    }

    // 그래프 return
    public int[][] getGraph() {
        return this.graph;
    }

    // 양방향 그래프 추가
    public void put(int x, int y) {
        graph[x][y] = graph[y][x] = 1;
    }

    // 단방향 그래프 추가
    public void putSingle(int x, int y) {
        graph[x][y] = 1;
    }

    // 인접행렬 출력
    public void printAdjacencyGraph() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
