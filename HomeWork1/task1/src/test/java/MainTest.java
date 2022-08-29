import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    int[][] testMatrix = {
            {1, -5, 3},
            {2, 25, -10},
            {12, 0, -8}};

    @Test
    public void getMax() {
        int result = 25;
        Assert.assertEquals("The maximum value must be = 25", result, Main.getMax(testMatrix));
    }

    @Test
    public void getMin() {
        int result = -10;
        Assert.assertEquals("The minimum value must be = -10", result, Main.getMin(testMatrix));
    }

    @Test
    public void getAverage() {
        int result = 2;
        Assert.assertEquals("The average value must be = 2", result, Main.getAverage(testMatrix));
    }
}