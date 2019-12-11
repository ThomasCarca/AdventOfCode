package part1;

import static part1.Direction.*;

public class PointFactory implements AbstractPointFactory{

    @Override
    public Point createPoint(char direction, Point point) {
        switch (direction) {
            case LEFT:
                return new Left(point);
            case UP:
                return new Up(point);
            case RIGHT:
                return new Right(point);
            case DOWN:
                return new Down(point);
            default:
                return new Point(point);
        }
    }
}
