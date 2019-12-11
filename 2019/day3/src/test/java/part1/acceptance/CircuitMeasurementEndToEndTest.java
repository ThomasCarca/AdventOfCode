package part1.acceptance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import part1.Circuit;
import part1.CircuitMeasurement;
import part1.Point;
import part1.Wire;
import reader.InputReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("CircuitMeasurement should")
public class CircuitMeasurementEndToEndTest {

    @ParameterizedTest
    @MethodSource("provideInputs")
    @DisplayName("measure the manhattan distance between the center and the closest intersection point")
    public void findDistanceBetweenCenterAndClosestIntersection(String input, int expectedDistance) throws IOException {
        // Given
        List<List<String>> wiresInstructions = InputReader.readFromPathWithLineBreaksAndCommas(input);

        Wire wire1 = new Wire(wiresInstructions.get(0));
        Wire wire2 = new Wire(wiresInstructions.get(1));

        Circuit circuit = new Circuit(wire1, wire2);

        // When
        CircuitMeasurement circuitMeasurement = new CircuitMeasurement(circuit);

        // Then
        assertEquals(expectedDistance, circuitMeasurement.distanceBetweenCenterAndClosestIntersection());
    }

    private static Stream<Arguments> provideInputs() {
        return Stream.of(
                Arguments.of("src/test/java/part1/acceptance/acceptance-input1", 159),
                Arguments.of("src/test/java/part1/acceptance/acceptance-input2", 135)
        );
    }

}
