package Patterns.Factories;

class PointF {
    private double x, y;

//    The constructor is made private in order to
//    force the user to make use of the static methods
    private PointF(double x, double y) {
        this.x = x;
        this.y = y;
    }

//    INNER FACTORY FOR CREATING OBJECTS OF PointF
//    CLASS WITHOUT USING THE CONSTRUCTOR FUNCTION
    public static class Factory {
        public static PointF newCartesianPoint(double x, double y) {
            return new PointF(x, y);
        }

        public static PointF newPolarPoint(double rho, double theta) {
            return new PointF(rho*Math.cos(theta),
                    rho*Math.sin(theta));
        }
    }
}

class FactoryDemo {
    public static void main(String[] args) {
        PointF point = PointF.Factory.newCartesianPoint(2, 3);
    }
}