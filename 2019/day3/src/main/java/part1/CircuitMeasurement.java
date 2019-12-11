package part1;

import java.util.Comparator;
import java.util.List;

public class CircuitMeasurement {
    public static final int IMPOSSIBLE = -1;
    private Circuit circuit;

    public CircuitMeasurement(Circuit circuit) {
        this.circuit = circuit;
    }

    public int distanceBetweenCenterAndClosestIntersection() {
        List<Point> intersections = circuit.intersectionPoints();
        return intersections.stream()
                .filter(point -> !point.equals(new Point(0,0)))
                .map(point -> Math.abs(point.x) + Math.abs(point.y))
                .min(Comparator.naturalOrder())
                .orElseGet(() -> IMPOSSIBLE);
    }
}
