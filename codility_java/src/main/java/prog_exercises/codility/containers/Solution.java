package prog_exercises.codility.containers;

import java.util.Stack;

public class Solution {

    /**
     * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
     * S is empty;
     * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
     * S has the form "VW" where V and W are properly nested strings.
     * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
     * Write a function:
     * class Solution { public int solution(String S); }
     * that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
     * For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.
     * Assume that:
     * N is an integer within the range [0..200,000];
     * string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
     * Complexity:
     * expected worst-case time complexity is O(N);
     * expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
     *
     * @param s
     * @return
     */
    public int solution(String s) {
        // read tokens and delimiters
        Stack<Character> stack = new Stack<Character>();

        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') /* new token */ {
                stack.push(c);
            } else if (c == '}' || c == ']' || c == ')') /* new token */ {
                if(stack.size()>0) {
                    char c0 = stack.pop();
                    if (!correctPair(c0, c)) {
                        return 0;
                    }
                }
                else {
                    return 0;
                }
            } else {
               // skip
            }
        }
        return (stack.size()==0) ? 1:0;

    }

    private boolean correctPair(char c0, char c2) {
        if ((c0 == '(' && c2 == ')')
                || (c0 == '[' && c2 == ']')
                || (c0 == '{' && c2 == '}'))
            return true;
        else
            return false;
    }
    /*
    {
        [
            sfsdfsdfdsf
        ]

    }
    */


}
