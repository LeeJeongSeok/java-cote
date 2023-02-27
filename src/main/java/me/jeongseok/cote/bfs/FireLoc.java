package me.jeongseok.cote.bfs;

public class FireLoc {
    int x;
    int y;
    int count;
    boolean destroyed;

    public FireLoc(int x, int y, int count, boolean destroyed) {
        this.x = x;
        this.y = y;
        this.count = count;
        this.destroyed = destroyed;
    }

}
