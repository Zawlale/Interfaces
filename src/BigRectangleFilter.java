import java.awt.Rectangle;

public class BigRectangleFilter implements Filter {
    @Override
    public boolean accept(Object x) {
        Rectangle rectangle = (Rectangle) x;
        int perimeter = 2 * (rectangle.width + rectangle.height);
        return perimeter > 10;
    }
}