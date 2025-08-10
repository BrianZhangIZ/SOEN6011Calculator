import static org.junit.jupiter.api.Assertions.*;
import org.junit.*;

public class StdDevMathTest {

    @Test
    public void normalDataset_returnsExpectedSigma() {
        double[] data = {2, 4, 4, 4, 5, 5, 7, 9};
        double sigma = StdDevMath.stddev(data);
        assertEquals(2.0, sigma, 1e-9); // tolerance for floating point
        System.err.println("Calculated standard deviation: " + sigma);
    }

    @Test
    public void singleValue_returnsZero() {
        assertEquals(0.0, StdDevMath.stddev(new double[]{5}), 1e-12);
    }

    @Test
    public void emptyArray_throwsException() {
        assertThrows(IllegalArgumentException.class, 
            () -> StdDevMath.stddev(new double[]{}));
    }
}
