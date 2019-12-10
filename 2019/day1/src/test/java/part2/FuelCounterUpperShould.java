package part2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reader.InputReader;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FuelCounterUpperShould {

    private String inputPath = "src/test/java/part2/acceptance-input";

    @Test
    @DisplayName("find the sum of the fuel values from an input file")
    public void findSumOfFuelValuesFromFile() throws IOException {
        // Given
        List<Integer> masses = InputReader.readFromPathWithLineBreaks(inputPath);

        // When
        FuelCounterUpper fuelCounterUpper = new FuelCounterUpper(masses);

        //Then
        assertEquals(2, masses.size());
        Assertions.assertEquals(968, fuelCounterUpper.processTotalFuel());
    }

}
