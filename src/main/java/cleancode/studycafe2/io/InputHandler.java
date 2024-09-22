package cleancode.studycafe2.io;

import cleancode.studycafe2.machine.pass.StudyCafePass;
import cleancode.studycafe2.machine.pass.StudyCafePassType;
import java.util.List;

public interface InputHandler {

    StudyCafePassType getPassTypeSelectingUserAction();

    StudyCafePass getSelectPass(List<StudyCafePass> passes);

    boolean getLockerSelection();

}
