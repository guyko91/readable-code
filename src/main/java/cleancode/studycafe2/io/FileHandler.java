package cleancode.studycafe2.io;

import cleancode.studycafe2.model.StudyCafeLockerPass;
import cleancode.studycafe2.machine.pass.StudyCafePass;
import java.util.List;

public interface FileHandler {

    List<StudyCafePass> readStudyCafePasses();
    List<StudyCafeLockerPass> readLockerPasses();

}
