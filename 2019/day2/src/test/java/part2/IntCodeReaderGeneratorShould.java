package part2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reader.InputReader;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("IntCodeReaderGenerator should")
public class IntCodeReaderGeneratorShould {

    private String inputPath1 = "src/test/java/part2/acceptance-input-1";

    @Test
    @DisplayName("find the result of the operation with the discovered inputs")
    public void findTheResultOfOperationWithDiscoveredInputs() throws IOException {
        // Given
        List<Integer> intCodeProgram1 = InputReader.readFromPathWithCommas(inputPath1);
        int expectedOutput = 200;

        // When
        IntCodeReaderGenerator intCodeReaderGenerator = new IntCodeReaderGenerator(intCodeProgram1, expectedOutput);

        //Then
        assertEquals(19, intCodeProgram1.size());
        assertEquals(407, intCodeReaderGenerator.findOperationWithDiscoveredInputs());

    }

}
