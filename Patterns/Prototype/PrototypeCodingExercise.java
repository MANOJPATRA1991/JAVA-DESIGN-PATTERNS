package Patterns.Prototype;

class Point
{
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Line
{
    public Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line deepCopy()
    {
        // todo
        Point p1 = new Point(start.x, start.y);
        Point p2 = new Point(end.x, end.y);
        return new Line(p1, p2);
    }

    @Override
    public String toString() {
        return "Line: " + "Point 1: " + start.x;
    }
}

class PrototypeExerciseDemo {
    public static void main(String[] args) {
        Point p1 = new Point(3, 4);
        Point p2 = new Point(6, 8);

        Line l1 = new Line(p1, p2);

        Line l2 = l1.deepCopy();

        l2.start.x = 5;

        System.out.println(l1);
        System.out.println(l2);
    }
}