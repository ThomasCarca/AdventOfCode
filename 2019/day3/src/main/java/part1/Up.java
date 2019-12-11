package part1;

public class Up extends Point {

    public Up(Point point) {
        this.x = point.x;
        this.y = point.y+1;
    }
}
