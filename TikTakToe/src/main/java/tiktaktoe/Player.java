package tiktaktoe;

/**
 * Created by vkroz on 7/13/14.
 */
public abstract class Player {
    String name;
    char mark;
    public Player(String name, char mark) {
        this.mark = mark;
    }

    public abstract void makeMove(Board board);
}
