package exercise;

// BEGIN
public class Segment {
    private Point beginPoint;
    private Point endPoint;

    public Segment(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }

    public Point getBeginPoint() {
        return beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Point getMidPoint() {
        var x1 = getBeginPoint().getX();
        var x2 = getEndPoint().getX();
        var y1 = getBeginPoint().getY();
        var y2 = getEndPoint().getY();
        return new Point((x1 + x2) / 2, (y1 + y2) / 2);
    }
}
// END
