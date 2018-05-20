/**
 * Liskov Substitution Principle(LSP)
 *
 * To substitute a subclass for a base class
 *
 * Example:
 *
 * If an API needs a class, we can substitute
 * a subclass in place without breaking anything
 */

class Rectangle {
    protected int width, height;

    public Rectangle() {

    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width*height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                "}";
    }

    public boolean isSquare() {
        return width == height;
    }
}

// VIOLATION OF LSP
class Square extends Rectangle {
    public Square() {}

    public Square(int size) {
        width = height = size;
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }
}

// FACTORY DESIGN PATTERN
class RectangleFactory {
    public static Rectangle newRectangle(int width, int height) {
        return new Rectangle(width, height);
    }

    public static Rectangle newSquare(int side) {
        return new Rectangle(side, side);
    }
}

class Demo3 {
    static void useIt(Rectangle r) {
        int width = r.getWidth();
        r.setHeight(10);

        // area = width * 10;

        System.out.println(
                "Expected area of " + (width*10) +
                        ", got " + r.getArea()
        );
    }

    public static void main(String[] args) {
        Rectangle rc = new Rectangle(2, 3);
        useIt(rc);

        Rectangle sq = new Square();
        sq.setWidth(5);
        useIt(sq);

        /**
         * RectangleFactory helps demonstrate the benefits
         * of Liskov Substitution Principle(LSP)
         */
        useIt(RectangleFactory.newRectangle(2, 3));
        useIt(RectangleFactory.newSquare(5));
    }
}