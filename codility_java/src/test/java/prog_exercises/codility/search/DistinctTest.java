package prog_exercises.codility.search;

import org.junit.Test;

import static org.junit.Assert.*;

public class DistinctTest {

    @Test
    public void testSolution() throws Exception {

        int[][] testData = {
                {0,1,2,3},
                {-1000000,1000000},
                {},
                {0},
                {0,0,0,0},
                {99,2,4,5,-99,-2,0,0}
        };

        Distinct app = new Distinct();
        assertEquals(4, app.solution(testData[0]));
        assertEquals(2, app.solution(testData[1]));
        assertEquals(0, app.solution(testData[2]));
        assertEquals(1, app.solution(testData[3]));
        assertEquals(1, app.solution(testData[4]));
        assertEquals(7, app.solution(testData[5]));
    }
}