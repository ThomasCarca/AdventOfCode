package part1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Wire should")
public class WireShould {


    @Test
    @DisplayName("give an empty list if no instructions are provided")
    public void giveEmptyListIfNoInstructions() {
        Wire wire = new Wire(Collections.emptyList());
        assertEquals(Collections.emptyList(), wire.coordinates());
    }

    @Test
    @DisplayName("give a list of coordinates when instructions are provided")
    public void giveListOfCoordinatesWhenInstructionsProvided() {
        Wire wire = new Wire(Arrays.asList("U2", "L2", "D1", "R1"));
        assertEquals(Arrays.asList(new Point(0,1),
                                    new Point(0,2),
                                    new Point(-1, 2),
                                    new Point(-2, 2),
                                    new Point(-2, 1),
                                    new Point(-1, 1)), wire.coordinates());
    }

}
