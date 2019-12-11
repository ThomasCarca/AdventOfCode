package part1;



import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Circuit {

    private Wire wire1;
    private Wire wire2;

    public Circuit(Wire wire1, Wire wire2) {
        this.wire1 = wire1;
        this.wire2 = wire2;
    }

    public List<Point> intersectionPoints() {
        List<Point> wire1Points = wire1.coordinates();
        List<Point> wire2Points = wire2.coordinates();
        return wire1Points.stream()
                .filter(point -> !point.equals(new Point(0,0)))
                .filter(wire2Points::contains)
                .collect(Collectors.toList());
    }
}
