import java.awt.Rectangle;
import java.util.ArrayList;

public class BigRectLister {
    public static void main(String[] args) {
        ArrayList<Rectangle> rectangles = new ArrayList<>();

        rectangles.add(new Rectangle(1, 1)); // perimeter 4
        rectangles.add(new Rectangle(2, 2)); // perimeter 8
        rectangles.add(new Rectangle(2, 3)); // perimeter 10
        rectangles.add(new Rectangle(1, 4)); // perimeter 10
        rectangles.add(new Rectangle(3, 3)); // perimeter 12
        rectangles.add(new Rectangle(2, 4)); // perimeter 12
        rectangles.add(new Rectangle(4, 4)); // perimeter 16
        rectangles.add(new Rectangle(5, 2)); // perimeter 14
        rectangles.add(new Rectangle(1, 6)); // perimeter 14
        rectangles.add(new Rectangle(6, 6)); // perimeter 24

        Filter filter = new BigRectangleFilter();

        System.out.println("Rectangles with perimeter greater than 10:");

        for (Rectangle rectangle : rectangles) {
            if (filter.accept(rectangle)) {
                int perimeter = 2 * (rectangle.width + rectangle.height);
                System.out.println(
                        rectangle.width + " x " + rectangle.height
                                + " — perimeter: " + perimeter
                );
            }
        }
    }
}