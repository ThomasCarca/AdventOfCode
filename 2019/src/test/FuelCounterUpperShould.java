import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FuelCounterUpperShould {

    private String inputPath = "src/test/acceptance-input";

    @Test
    @DisplayName("find the sum of the fuel values from an input file")
    public void findSumOfFuelValuesFromFile() throws IOException {
        // Given
        List<Integer> masses = InputReader.readFromPath(inputPath);

        // When
        FuelCounterUpper fuelCounterUpper = new FuelCounterUpper(masses);

        //Then
        assertEquals(4, masses.size());
        assertEquals(34241, fuelCounterUpper.processTotalFuel());
    }

}
