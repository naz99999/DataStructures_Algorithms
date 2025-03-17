package LLD.SnakeAndLadder.initial;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Cell> cells;
    private final List<Snake> snakes;
    private final List<Ladder> ladders;
    private final List<Player> players;

    public Board(List<Cell> cells, List<Snake> snakes, List<Ladder> ladders, List<Player> players) {
        this.cells = new ArrayList<>(101);
        this.snakes = snakes;
        this.ladders = ladders;
        this.players = players;
    }
    public void takeTurn(Player player) {
        int move = diceRoll();
        int newCell = player.getCell().getCellNo() + move;

        if (newCell == 100) {
            System.out.println(player.getPlayerColor() + " has won the game!");
            return;
        }

        if (newCell >= 100) {
            System.out.println(player.getPlayerColor() + " cant move beyond 100");
            return;
        }


        int snakeTail = isSnakeCell(player);
        if (snakeTail != -1) {
            player.setCell(getCell(snakeTail));
            System.out.println(player.getPlayerColor() + " got bit by a snake, move to " + player.getCell().getCellNo());
            return;
        }

        int ladderTop = isLadderCell(player);
        if (ladderTop != -1) {
            player.setCell(getCell(ladderTop));
            System.out.println(player.getPlayerColor() + " found a ladder, move to " + player.getCell().getCellNo() );
            return;
        }

        player.setCell(getCell(newCell));
        System.out.println(player.getPlayerColor() + " move to " + player.getCell().getCellNo());
    }

    private Cell getCell(int cellNo) {
        for (Cell cell : cells) {
            if (cell.getCellNo() == cellNo) {
                return cell;
            }
        }
        return null;
    }

    private int isLadderCell(Player player) {
        for (Ladder ladder : ladders) {
            if (ladder.getBottom() == player.getCell().getCellNo()) {
                return ladder.getTop();
            }
        }
        return -1;
    }

    private int isSnakeCell(Player player) {
        for (Snake snake : snakes) {
            if (snake.getHead() == player.getCell().getCellNo()) {
                return snake.getTail();
            }
        }
        return -1;
    }

    private int diceRoll() {
        return (int)Math.ceil(Math.random() * 6);
    }
}
