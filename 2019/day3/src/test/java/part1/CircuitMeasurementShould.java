package part1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@DisplayName("CircuitMeasurement should")
public class CircuitMeasurementShould {

    @Test
    @DisplayName("not consider the central point")
    public void notConsiderTheCentralPoint() throws IOException {

        Circuit circuit = mock(Circuit.class);

        when(circuit.intersectionPoints())
                .thenReturn(Arrays.asList(
                        new Point(0, 0),
                        new Point(4, 3)
                ));

        CircuitMeasurement circuitMeasurement = new CircuitMeasurement(circuit);

        assertEquals(7, circuitMeasurement.distanceBetweenCenterAndClosestIntersection());
    }

    @ParameterizedTest
    @MethodSource("providePoints")
    @DisplayName("measure the manhattan distance between the center and the closest intersection point")
    public void findDistanceBetweenCenterAndClosestIntersection(List<Point> input, int expectedDistance) throws IOException {

        Circuit circuit = mock(Circuit.class);

        when(circuit.intersectionPoints())
                .thenReturn(input);

        CircuitMeasurement circuitMeasurement = new CircuitMeasurement(circuit);

        assertEquals(expectedDistance, circuitMeasurement.distanceBetweenCenterAndClosestIntersection());
    }

    private static Stream<Arguments> providePoints() {
        return Stream.of(
                Arguments.of(Arrays.asList(
                        new Point(3, 9),
                        new Point(13, 16)
                ), 12),
                Arguments.of(Arrays.asList(
                        new Point(-1, -1),
                        new Point(2, 2)
                ), 2),
                Arguments.of(Arrays.asList(
                        new Point(-2, 2),
                        new Point(4, 2)
                ), 4)
        );
    }

}
