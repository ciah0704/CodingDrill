package codility;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindLeadersInArrayTest {

    @Test
    public void testSolution() throws Exception {
        FindLeadersInArray s = new FindLeadersInArray();

        int[] test1 = {20, 10, 30, 30, 40, 10};
        int expected1 = 30;
        assertEquals(expected1, s.solution(test1) );

        assertEquals(0, s.solution(new int[] {0,0,0,0,0}) );
        assertEquals(1, s.solution(new int[] {1}) );
        assertEquals(10000, s.solution(new int[] {10000,10000,10000,1,2,3,9,9,9}) );

    }
}