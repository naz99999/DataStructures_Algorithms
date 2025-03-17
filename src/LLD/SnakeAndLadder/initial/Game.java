package LLD.SnakeAndLadder.initial;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static Game instance;
    private final List<Board> boards;

    private Game() {
        this.boards = new ArrayList<>();
    }

    public void startNewGame(Board board) {
        boards.add(board);
    }
}
