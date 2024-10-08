package cleancode.minesweeper.tobe;

import cleancode.minesweeper.tobe.minesweeper.Minesweeper;
import cleancode.minesweeper.tobe.minesweeper.config.GameConfig;
import cleancode.minesweeper.tobe.minesweeper.gamelevel.Advanced;
import cleancode.minesweeper.tobe.minesweeper.io.ConsoleInputHandler;
import cleancode.minesweeper.tobe.minesweeper.io.ConsoleOutputHandler;

public class GameApplication {

    public static void main(String[] args) {
        GameConfig gameConfig = GameConfig.of(new Advanced(), new ConsoleInputHandler(),
            new ConsoleOutputHandler());

        Minesweeper minesweeperGame = new Minesweeper(gameConfig);
        minesweeperGame.initialize();
        minesweeperGame.run();
    }

    /**
     * DIP (Dependency Inversion Principle)
     *
     * DI (Dependency Injection) - "3"
     * 제 3자가 두 객체간 의존성을 맺어 준다. (Spring 에서는 스프링 컨텍스트가 이 역할을 한다.)
     *
     * IoC (Inversion of Control)
     * 제어의 순방향 : 개발자가 프로그램의 흐름을 제어한다.
     * 제어의 역전 : 프로그램의 흐름을 개발자가 아닌 프레임 워크가 제어한다. (객체의 생명 주기 및 의존성 관리를 프레임워크가 담당한다.)
     *
     */

}
