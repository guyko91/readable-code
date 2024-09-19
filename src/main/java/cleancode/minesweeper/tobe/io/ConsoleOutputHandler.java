package cleancode.minesweeper.tobe.io;

import cleancode.minesweeper.tobe.GameBoard;
import cleancode.minesweeper.tobe.GameException;
import cleancode.minesweeper.tobe.Cell;

public class ConsoleOutputHandler {

    public void showGameStartComments() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("지뢰찾기 게임 시작!");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    public void showBoard(GameBoard gameBoard) {
        System.out.println("   a b c d e f g h i j");
        for (int row = 0; row < gameBoard.getRowSize(); row++) {
            System.out.printf("%d  ", row + 1);
            for (int col = 0; col < gameBoard.getColSize(); col++) {
                System.out.print(gameBoard.getSign(row, col) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printGameWinningComment() {
        System.out.println("축하합니다! 지뢰를 모두 찾았습니다.");
    }

    public void printGameLosingComment() {
        System.out.println("아쉽습니다. 지뢰를 밟았습니다.");
    }

    public void printCommentForSelectingCell() {
        System.out.println("선택할 좌표를 입력하세요. (예: a1)");
    }

    public void printCommentForUserAction() {
        System.out.println("선택한 셀에 대한 행위를 선택하세요. (1: 오픈, 2: 깃발 꽂기)");
    }

    public void printExceptionMessage(GameException exception) {
        System.out.println(exception.getMessage());
    }

    public void printSimpleMessage(String s) {
        System.out.println(s);
    }
}
