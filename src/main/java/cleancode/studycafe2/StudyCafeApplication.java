package cleancode.studycafe2;

import cleancode.studycafe2.io.ConsoleInputHandler;
import cleancode.studycafe2.io.ConsoleOutputHandler;
import cleancode.studycafe2.io.FileHandler;
import cleancode.studycafe2.io.InputHandler;
import cleancode.studycafe2.io.OutputHandler;
import cleancode.studycafe2.io.StudyCafeFileHandler;
import cleancode.studycafe2.machine.Machine;
import cleancode.studycafe2.machine.pass.StudyCafePassMachine;

public class StudyCafeApplication {

    public static void main(String[] args) {

        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();
        FileHandler fileHandler = new StudyCafeFileHandler();

        Machine passMachine = new StudyCafePassMachine(
            inputHandler,
            outputHandler,
            fileHandler
        );

        passMachine.run();
    }

}
