import org.junit.Before;
import org.junit.Test;

import com.cs.canvas.components.BucketFill;
import com.cs.canvas.components.ConsolCanvas;
import com.cs.canvas.components.Line;
import com.cs.canvas.components.Rectangle;


import static org.junit.Assert.*;

public class AppRunnerEndToEndTest {
    ConsolCanvas c;
    Line line, line2;
    Rectangle rectangle;
    BucketFill bucketFill;


    @Before
    public void setUp() throws Exception {
        c = new ConsolCanvas(4, 20);
        line = new Line(1, 2, 6, 2, c.getCanvasCoordinates(), 6, 22);
        line2 = new Line(6, 3, 6, 4, c.getCanvasCoordinates(), 6, 22);
        rectangle = new Rectangle(14, 1, 18, 3, c.getCanvasCoordinates(), 6, 22);
        bucketFill = new BucketFill(10, 3, "o", c.getCanvasCoordinates(), 6, 22);
    }


    @Test
    public void fillTest() {
        String expectedCoordinateString =
                        "----------------------\n" +
                        "|oooooooooooooxxxxxoo|\n" +
                        "|xxxxxxooooooox   xoo|\n" +
                        "|     xoooooooxxxxxoo|\n" +
                        "|     xoooooooooooooo|\n" +
                        "----------------------".trim();
        String actualCoordinateString = c.toString().trim();
        assertEquals("Comparing expected with actual", expectedCoordinateString, actualCoordinateString);
    }
}