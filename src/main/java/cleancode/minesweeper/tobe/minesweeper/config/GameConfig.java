package cleancode.minesweeper.tobe.minesweeper.config;

import cleancode.minesweeper.tobe.minesweeper.gamelevel.GameLevel;
import cleancode.minesweeper.tobe.minesweeper.io.InputHandler;
import cleancode.minesweeper.tobe.minesweeper.io.OutputHandler;

public class GameConfig {

    private final GameLevel level;
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    private GameConfig(GameLevel level, InputHandler inputHandler, OutputHandler outputHandler) {
        this.level = level;
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public static GameConfig of(GameLevel level, InputHandler inputHandler, OutputHandler outputHandler) {
        return new GameConfig(level, inputHandler, outputHandler);
    }

    public GameLevel getLevel() {
        return level;
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public OutputHandler getOutputHandler() {
        return outputHandler;
    }
}
