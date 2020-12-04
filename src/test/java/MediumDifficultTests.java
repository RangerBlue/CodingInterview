import exercises.MediumDifficult;
import org.junit.Test;
import util.mediumdifficult.Pair;
import static org.junit.Assert.*;

public class MediumDifficultTests {
    @Test
    public void testNumberSwap() {
        int a = 5;
        int b = 6;
        Pair x = new Pair(a,b);
        MediumDifficult.swap(x);
        assertEquals(x.a, b);
        assertEquals(x.b, a);
    }
}
