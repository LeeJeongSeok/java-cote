package me.jeongseok.cote.dfs;

import java.util.ArrayList;

public class GraphList {
    private ArrayList<ArrayList<Integer>> graphList;

    public GraphList(int size) {
        this.graphList = new ArrayList<ArrayList<Integer>>();

        // 그래프 초기화
        // put(int x, int y) 에서 입력되는 정점의 값은 0 이상의 정수이나
        // ArrayList의 index는 0 부터 시작이므로
        // 정점을 담는 인접리스트의 size는 1을 더하여 초기화해줌
        // ex) initSize = 3
        // graphList[0]
        // graphList[1] -> 2 -> 3
        // graphList[2] -> 1 -> 3 -> 4
        // graphList[3] -> 1 -> 2 -> 4 -> 5
        for (int i = 0; i < size + 1; i++) {
            graphList.add(new ArrayList<Integer>());
        }
    }

    public ArrayList<ArrayList<Integer>> getGraphList() {
        return this.graphList;
    }

    // 그래프 추가 (양방향)
    public void put(int x, int y) {
        graphList.get(x).add(y);
        graphList.get(y).add(x);
    }

    // 그래프 추가 (단방향)
    public void putSingle(int x, int y) {
        graphList.get(x).add(y);
    }

    // 그래프 출력 (인접리스트)
    public void printAdjacencyGraphList() {
        for(int i = 1; i < graphList.size(); i++) {
            System.out.print("정점 " + i + "의 인접리스트");

            for(int j = 0; j < graphList.get(i).size(); j++) {
                System.out.print(" -> " + graphList.get(i).get(j));
            }
            System.out.println();
        }
    }
}
