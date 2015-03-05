package histogramwater;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTest {

    @Test
    public void testComputeArea() throws Exception {
        Calculator calc = new Calculator(new int[] {1,2,4,2,1,3,4,3});

        int area = calc.computeArea();
        assertEquals(area, 6);
    }

//    @BeforeMethod
//    public void setUp() throws Exception {
//
//
//    }
}