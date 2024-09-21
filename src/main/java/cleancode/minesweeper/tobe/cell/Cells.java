package cleancode.minesweeper.tobe.cell;

import java.util.Arrays;
import java.util.List;

public class Cells {

    private final List<Cell> cells;

    private Cells(List<Cell> cells) {
        this.cells = cells;
    }

    public static Cells of(List<Cell> cells) {
        return new Cells(cells);
    }

    public static Cells of(Cell[][] board) {
        List<Cell> cellList = Arrays.stream(board)
            .flatMap(Arrays::stream)
            .toList();

        return of(cellList);
    }

    public boolean isAllChecked() {
        return cells.stream()
            .allMatch(Cell::isChecked);
    }
}
