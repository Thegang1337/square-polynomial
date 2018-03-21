import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class SquarePolynomialTest {
    @DataProvider
    public static Object[][] data() {
        return new Object[][] {
                { new double[] {4, 2, -2}, new double[] { 0.5, -1 } },
                { new double[] {1, 0, 2}, new double[] { } },
                { new double[] {1, 0, 0}, new double[] { 0 } },
                { new double[] {1, 2, 0}, new double[] { 0, -2 } },
                { new double[] {0, 2, 0}, new double[] { 0 } },
                { new double[] {0, 2, 2}, new double[] { -1 } },
                { new double[] {0, 0, 3}, null },
                { new double[] {0, 0, 0}, null }
        };
    }

    @Test(dataProvider = "data")
    public void findRootsTest(double[] spInput, double spExpected[]) {
        SquarePolynomial p = new SquarePolynomial(spInput[0], spInput[1], spInput[2]);
        assertEquals(Arrays.toString(spExpected), Arrays.toString(p.findRoots()));
    }
}
