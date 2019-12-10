package part1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reader.InputReader;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("FuelCounterUpper should")
public class FuelCounterUpperShould {

    private String inputPath = "src/test/java/part1/acceptance-input";

    @Test
    @DisplayName("find the sum of the fuel values from an input file")
    public void findSumOfFuelValuesFromFile() throws IOException {
        // Given
        List<Integer> masses = InputReader.readFromPathWithLineBreaks(inputPath);

        // When
        FuelCounterUpper fuelCounterUpper = new FuelCounterUpper(masses);

        //Then
        assertEquals(4, masses.size());
        Assertions.assertEquals(34241, fuelCounterUpper.processTotalFuel());
    }

}
