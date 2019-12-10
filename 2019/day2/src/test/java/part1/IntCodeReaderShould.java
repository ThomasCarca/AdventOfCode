package part1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reader.InputReader;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("IntCodeReader should")
public class IntCodeReaderShould {

    private String inputPath1 = "src/test/java/part1/acceptance-input-1";
    private String inputPath2 = "src/test/java/part1/acceptance-input-2";
    private String inputPath3 = "src/test/java/part1/acceptance-input-3";
    private String inputPath4 = "src/test/java/part1/acceptance-input-4";
    private String inputPath5 = "src/test/java/part1/acceptance-input-5";

    @Test
    @DisplayName("find the value at position 0 of the program")
    public void findValueAtPosition0OfProgram() throws IOException {
        // Given
        List<Integer> intCodeProgram1 = InputReader.readFromPathWithCommas(inputPath1);
        List<Integer> intCodeProgram2 = InputReader.readFromPathWithCommas(inputPath2);
        List<Integer> intCodeProgram3 = InputReader.readFromPathWithCommas(inputPath3);
        List<Integer> intCodeProgram4 = InputReader.readFromPathWithCommas(inputPath4);
        List<Integer> intCodeProgram5 = InputReader.readFromPathWithCommas(inputPath5);

        // When
        int noun = 12;
        int verb = 2;
        IntCodeReader intCodeReader1 = new IntCodeReader(intCodeProgram1, noun, verb);
        IntCodeReader intCodeReader2 = new IntCodeReader(intCodeProgram2, noun, verb);
        IntCodeReader intCodeReader3 = new IntCodeReader(intCodeProgram3, noun, verb);
        IntCodeReader intCodeReader4 = new IntCodeReader(intCodeProgram4, noun, verb);
        IntCodeReader intCodeReader5 = new IntCodeReader(intCodeProgram5, noun, verb);

        //Then
        assertEquals(19, intCodeProgram1.size());
        assertEquals(3, intCodeReader1.valueAtFirstPositionAfterProgramHalts());

        assertEquals(17, intCodeProgram2.size());
        assertEquals(8, intCodeReader2.valueAtFirstPositionAfterProgramHalts());

        assertEquals(13, intCodeProgram3.size());
        assertEquals(1, intCodeReader3.valueAtFirstPositionAfterProgramHalts());

        assertEquals(14, intCodeProgram4.size());
        assertEquals(10, intCodeReader4.valueAtFirstPositionAfterProgramHalts());

        assertEquals(13, intCodeProgram5.size());
        assertEquals(113, intCodeReader5.valueAtFirstPositionAfterProgramHalts());

    }

}
