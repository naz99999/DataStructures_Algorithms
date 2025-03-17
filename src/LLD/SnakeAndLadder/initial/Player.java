package LLD.SnakeAndLadder.initial;

public class Player {
    private final String name;
    private final PlayerColor playerColor;

    private Cell cell;

    public Player(String name, PlayerColor playerColor) {
        this.name = name;
        this.playerColor = playerColor;
        this.cell = new Cell(0);
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public String getName() {
        return name;
    }

    public PlayerColor getPlayerColor() {
        return playerColor;
    }

    public Cell getCell() {
        return cell;
    }
}
