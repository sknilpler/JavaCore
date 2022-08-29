import org.junit.Assert;
import org.junit.Test;


public class MainTest {
    int[] testArr = {5, 6, 3, 2, 5, 1, 4, 9};

    @Test
    public void sortedArr() {
        int[] result1 = {1, 2, 3, 4, 5, 5, 6, 9};
        int[] result2 = {9, 6, 5, 5, 4, 3, 2, 1};
        Assert.assertArrayEquals("Sort ascending not working", result1, Main.sortedArr(testArr, true));
        Assert.assertArrayEquals("Descending sort not working", result2, Main.sortedArr(testArr, false));
    }
}