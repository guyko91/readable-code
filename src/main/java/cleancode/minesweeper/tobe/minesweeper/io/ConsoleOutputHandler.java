package cleancode.minesweeper.tobe.minesweeper.io;

import cleancode.minesweeper.tobe.minesweeper.board.GameBoard;
import cleancode.minesweeper.tobe.minesweeper.board.cell.CellSnapshot;
import cleancode.minesweeper.tobe.minesweeper.board.position.CellPosition;
import cleancode.minesweeper.tobe.minesweeper.exception.GameException;
import cleancode.minesweeper.tobe.minesweeper.io.sign.CellSignProvider;
import java.util.List;
import java.util.stream.IntStream;

public class ConsoleOutputHandler implements OutputHandler {

    // CellSignProvider를 사용하기 전 CellSignFinder를 사용하던 코드
//    private static final String EMPTY_SIGN = "■";
//    private static final String LAND_MINE_SIGN = "☼";
//    private static final String FLAG_SIGN = "⚑";
//    private static final String UNCHECKED_SIGN = "□";
//    private final CellSignFinder cellSignFinder = new CellSignFinder();

    @Override
    public void showGameStartComments() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("지뢰찾기 게임 시작!");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    @Override
    public void showBoard(GameBoard gameBoard) {
        String alphabets = generateColAlphabets(gameBoard);

        System.out.println("    " + alphabets);
        for (int row = 0; row < gameBoard.getRowSize(); row++) {
            System.out.printf("%2d  ", row + 1);
            for (int col = 0; col < gameBoard.getColSize(); col++) {
                CellPosition cellPosition = CellPosition.of(row, col);

                CellSnapshot cellSnapshot = gameBoard.getSnapshot(cellPosition);
//                String cellSign = cellSignFinder.findCellSignFromCellSnapshot(cellSnapshot);
                String cellSign = CellSignProvider.findCellSignFrom(cellSnapshot);

                System.out.print(cellSign + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void showGameWinningComment() {
        System.out.println("축하합니다! 지뢰를 모두 찾았습니다.");
    }

    @Override
    public void showGameLosingComment() {
        System.out.println("아쉽습니다. 지뢰를 밟았습니다.");
    }

    @Override
    public void showCommentForSelectingCell() {
        System.out.println("선택할 좌표를 입력하세요. (예: a1)");
    }

    @Override
    public void showCommentForUserAction() {
        System.out.println("선택한 셀에 대한 행위를 선택 하세요. (1: 오픈, 2: 깃발 꽂기)");
    }

    @Override
    public void showExceptionMessage(GameException exception) {
        System.out.println(exception.getMessage());
    }

    @Override
    public void showSimpleMessage(String s) {
        System.out.println(s);
    }

    private String generateColAlphabets(GameBoard gameBoard) {
        List<String> alphabets = IntStream.range(0, gameBoard.getColSize())
            .mapToObj(index -> (char) ('a' + index))
            .map(Object::toString)
            .toList();
        return String.join(" ", alphabets);
    }
}
