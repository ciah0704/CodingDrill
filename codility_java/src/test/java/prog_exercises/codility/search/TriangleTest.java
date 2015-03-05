package prog_exercises.codility.search;

import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void testSolution() throws Exception {
        int[][] testData = {
                {10, 2, 5, 1, 8, 20},
                {10, 50, 5, 1},
                {-2147483648, 50, 5, 2147483647},
                {},
                {1},
                {1, 2},
                {3, 4, 5},
                {-3, -4, -5}

        };
        int[] expected = {
                1, 0, 0, 0, 0, 0, 1, 0
        };

        Triangle t = new Triangle();
        assertEquals(expected[0], t.solution(testData[0]));
        assertEquals(expected[1], t.solution(testData[1]));
        assertEquals(expected[2], t.solution(testData[2]));
        assertEquals(expected[3], t.solution(testData[3]));
        assertEquals(expected[4], t.solution(testData[4]));
        assertEquals(expected[5], t.solution(testData[5]));
        assertEquals(expected[6], t.solution(testData[6]));
        assertEquals(expected[7], t.solution(testData[7]));
    }
}