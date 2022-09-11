import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    @Test
    public void fuzzySearch() {
        Assert.assertTrue(Main.fuzzySearch("car", "ca6$$#_rtwheel"));
        Assert.assertTrue(Main.fuzzySearch("cwhl", "cartwheel"));
        Assert.assertTrue(Main.fuzzySearch("cwhee", "cartwheel"));
        Assert.assertTrue(Main.fuzzySearch("cartwheel", "cartwheel"));
        Assert.assertFalse(Main.fuzzySearch("cwheeel", "cartwheel"));
        Assert.assertFalse(Main.fuzzySearch("lw", "cartwheel"));
    }
}
