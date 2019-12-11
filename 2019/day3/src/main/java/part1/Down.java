package part1;

public class Down extends Point {

    public Down(Point point) {
        this.x = point.x;
        this.y = point.y-1;
    }
}
