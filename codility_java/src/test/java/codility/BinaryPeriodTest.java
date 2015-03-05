package codility;

import codility.BinaryPeriod;
import org.junit.Assert;
import org.junit.Test;

public class BinaryPeriodTest {

    @Test
    public void testSolution() throws Exception {
        BinaryPeriod s = new BinaryPeriod();
        Assert.assertEquals(8, s.solution("codilitycodilityco"));
        Assert.assertEquals(7, s.solution("abracadabracadabra"));

        Assert.assertEquals(4, s.solution(955));
        Assert.assertEquals(-1, s.solution(102));
    }
}