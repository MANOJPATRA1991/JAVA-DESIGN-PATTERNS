package Patterns.Factories;

enum CoordinateSystem {
    CARTESIAN, POLAR
}

class Point {
    private double x, y;

    /**
     * The constructor is made private in order to
     * force the user to make use of the static methods
     */
    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

//    NOT ALLOWED IN JAVA
//    public Point(double rho, double theta) {
//        x = rho * Math.cos(theta);
//        y = rho * Math.sin(theta);
//    }

//    UGLY AND LESS USEFUL
//    Cannot change the name of the constructor(or function)
//    and thus, no hint is provided on whether we are constructing a cartesian point or a polar point

//    Solution is to make use of the FACTORY FUNCTION

//    public Point(double a, double b, CoordinateSystem cs) {
//        switch (cs) {
//            case CARTESIAN:
//                this.x = a; // a is x if cartesian or rho if polar
//                this.y = b; // b is y if cartesian or theta if polar
//                break;
//            case POLAR:
//                this.x = a * Math.cos(b);
//                this.y = a * Math.sin(b);
//                break;
//        }
//    }

    /**
     * Create a cartesian point
     * @param x
     * @param y
     * @return PointF instance
     */
    public static Point newCartesianPoint(double x, double y) {
        return new Point(x, y);
    }

    /**
     * Create a polar point
     * @param rho
     * @param theta
     * @return PointF instance
     */
    public static Point newPolarPoint(double rho, double theta) {
        return new Point(rho*Math.cos(theta),
                rho*Math.sin(theta));
    }
}

class Demo {
    /**
     * This is the main method which demonstrates HTMLBuilder example.
     * @param args Unused
     */
    public static void main(String[] args) {
        Point point = Point.newPolarPoint(2, 3);
    }
}