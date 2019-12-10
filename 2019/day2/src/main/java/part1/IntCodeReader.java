package part1;

import java.util.ArrayList;
import java.util.List;

public class IntCodeReader {
    public static final int STOP_OP_CODE = 99;
    public static final int ADDITION = 1;
    public static final int MULTIPLICATION = 2;
    public static final int UNEXPECTED_OPERATION = -1;

    private List<Integer> intCodeProgram;

    public IntCodeReader(List<Integer> intCodeProgram, int noun, int verb) {
        this.intCodeProgram = new ArrayList<>(intCodeProgram);
        this.intCodeProgram.set(1, noun);
        this.intCodeProgram.set(2, verb);
    }

    public int valueAtFirstPositionAfterProgramHalts() {
        for (int i = 0; i < intCodeProgram.size(); i += 4) {
            if (intCodeProgram.get(i) == STOP_OP_CODE) break;
            int result = processCalculationForIndex(i);
            int resultIndex = intCodeProgram.get(i+3);
            intCodeProgram.set(resultIndex, result);
        }
        return intCodeProgram.get(0);
    }

    private int processCalculationForIndex(int index) {
        int operation = intCodeProgram.get(index);
        Integer leftOperationIndex = intCodeProgram.get(index + 1);
        Integer rightOperationIndex = intCodeProgram.get(index + 2);
        if (operation == ADDITION) {
            return intCodeProgram.get(leftOperationIndex) + intCodeProgram.get(rightOperationIndex);
        }
        if (operation == MULTIPLICATION) {
            return intCodeProgram.get(leftOperationIndex) * intCodeProgram.get(rightOperationIndex);
        }
        return UNEXPECTED_OPERATION;
    }
}
