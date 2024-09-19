package cleancode.minesweeper.tobe;

import cleancode.minesweeper.tobe.gamelevel.Beginner;
import cleancode.minesweeper.tobe.gamelevel.GameLevel;

public class GameApplication {

    public static void main(String[] args) {
        GameLevel level = new Beginner();
        Minesweeper minesweeperGame = new Minesweeper(level);
        minesweeperGame.initialize();
        minesweeperGame.run();
    }

}
