package part2;

import part1.IntCodeReader;

import java.util.List;

public class IntCodeReaderGenerator {


    public static final int IMPOSSIBLE = -1;
    private List<Integer> intCodeProgram;
    private int expectedOutput;

    public IntCodeReaderGenerator(List<Integer> intCodeProgram, int expectedOutput) {
        this.intCodeProgram = intCodeProgram;
        this.expectedOutput = expectedOutput;
    }

    public int findOperationWithDiscoveredInputs() {
        int maxIndex = Math.min(100, intCodeProgram.size());
        for (int noun = 0; noun < maxIndex; noun++) {
            for (int verb = 0; verb < maxIndex; verb++) {
                    IntCodeReader intCodeReader = new IntCodeReader(intCodeProgram, noun, verb);
                    int output = intCodeReader.valueAtFirstPositionAfterProgramHalts();
                    if (output == expectedOutput) return 100*noun+verb;
            }
        }
        return IMPOSSIBLE;
    }
}
