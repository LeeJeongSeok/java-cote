package me.jeongseok.cote.dfs;

public class DfsTest {
    public static void main(String[] args) {
        int size = 6;
        GraphArr graphArr = new GraphArr(size);

        graphArr.put(1, 2);
        graphArr.put(1, 3);
        graphArr.put(2, 1);
        graphArr.put(3, 1);
        graphArr.put(4, 3);
        graphArr.put(5, 4);
        graphArr.put(6, 5);

        graphArr.printAdjacencyGraph();

        GraphList graphList = new GraphList(size);

        graphList.put(1, 2);
        graphList.put(1, 3);
        graphList.put(2, 3);
        graphList.put(2, 4);
        graphList.put(3, 4);
        graphList.put(3, 5);
        graphList.put(4, 5);
        graphList.put(4, 6);

        graphList.printAdjacencyGraphList();
    }
}
