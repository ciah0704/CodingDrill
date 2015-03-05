package prog_exercises.codility.containers;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryPeriodTest {

    @Test
    public void testSolution() throws Exception {

        Solution s = new Solution();
        assertEquals(0, s.solution("(()"));
        assertEquals(0, s.solution("(([][][][][]()()())"));
        assertEquals(0, s.solution("[][][][][]()()())"));
        assertEquals(0, s.solution("x{]"));
        assertEquals(0, s.solution("}{}("));
        assertEquals(0, s.solution("}{"));
        assertEquals(0, s.solution("}"));
        assertEquals(0, s.solution("{"));
        assertEquals(1, s.solution("{[()()]}"));
        assertEquals(0, s.solution("([)()]"));
        assertEquals(1, s.solution("(){}[]()"));
        assertEquals(1, s.solution(""));
        assertEquals(0, s.solution("(}"));


    }
}