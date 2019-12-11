package part1;

import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Circuit should")
public class CircuitShould {


    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    @DisplayName("not list the central point")
    public void notListCentralPoint() {

        Wire wire1 = mock(Wire.class);
        Wire wire2 = mock(Wire.class);

        when(wire1.coordinates())
                .thenReturn(Arrays.asList(
                        new Point(0, 1),
                        new Point(1, 1),
                        new Point(1, 0),
                        new Point(0, 0),
                        new Point(0, 1)
                ));
        when(wire2.coordinates())
                .thenReturn(Arrays.asList(
                        new Point(0, -1),
                        new Point(-1, -1),
                        new Point(-1, 0),
                        new Point(0, 0),
                        new Point(0, -1)
                ));

        Circuit circuit = new Circuit(wire1, wire2);

        assertEquals(Collections.emptyList(), circuit.intersectionPoints());

    }

    @Test
    @DisplayName("give an empty list if the wires do not cross")
    public void giveEmptyListIfWiresDoNotCross() {

        Wire wire1 = mock(Wire.class);
        Wire wire2 = mock(Wire.class);

        when(wire1.coordinates())
                .thenReturn(Arrays.asList(
                        new Point(1, 1),
                        new Point(1, 2)
                ));
        when(wire2.coordinates())
                .thenReturn(Arrays.asList(
                        new Point(0, 0),
                        new Point(-1, 0),
                        new Point(-1, -1)
                ));

        Circuit circuit = new Circuit(wire1, wire2);

        assertEquals(Collections.emptyList(), circuit.intersectionPoints());
    }

    @Test
    @DisplayName("give a list of points where the wires cross")
    public void giveListOfPointsWhereWiresCross() {

        Wire wire1 = mock(Wire.class);
        Wire wire2 = mock(Wire.class);

        when(wire1.coordinates())
                .thenReturn(Arrays.asList(
                        new Point(1, 1),
                        new Point(1, 2),
                        new Point(1, 3)
                ));
        when(wire2.coordinates())
                .thenReturn(Arrays.asList(
                        new Point(0, 0),
                        new Point(1, 0),
                        new Point(1, 1),
                        new Point(1, 2)
                ));

        Circuit circuit = new Circuit(wire1, wire2);

        List<Point> intersectionPoints = circuit.intersectionPoints();

        Point intersection1 = new Point(1, 1);
        Point intersection2 = new Point(1, 2);

        assertEquals(2, intersectionPoints.size());
        assertEquals(intersection1, intersectionPoints.get(0));
        assertEquals(intersection2, intersectionPoints.get(1));
    }


}
