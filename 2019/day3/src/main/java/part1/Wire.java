package part1;

import java.util.ArrayList;
import java.util.List;

public class Wire {

    private List<Point> points = new ArrayList<>();
    private Point currentPosition = new Point(0, 0);
    private List<String> instructions;

    public Wire(List<String> instructions) {
        this.instructions = instructions;
    }


    public List<Point> coordinates() {
        for (String instruction: instructions) {
            coordinatesForInstruction(instruction);
        }
        return points;
    }

    private void coordinatesForInstruction(String instruction) {
        char direction = direction(instruction);
        int distance = distance(instruction);
        for (int i = 0; i < distance; i++) {
            currentPosition = new PointFactory().createPoint(direction, currentPosition);
            points.add(currentPosition);
        }
    }


    private int distance(String instruction) {
        return Integer.parseInt(instruction.substring(1));
    }

    private char direction(String instruction) {
        return instruction.charAt(0);
    }

}
