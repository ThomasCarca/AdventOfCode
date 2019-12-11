package part1;

public class Left extends Point {

    public Left(Point point) {
        this.x = point.x-1;
        this.y = point.y;
    }
}
