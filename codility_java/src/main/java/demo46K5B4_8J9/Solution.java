package demo46K5B4_8J9;

/**
 * Created by vkroz on 7/5/14.
 */
public class Solution {
/**
 * 3,1,2,4,3
 *
 * 3,  1,2,4,3 => 7
 * 3,1  ,2,4,3 => 5
 * 3,1,2  ,4,3 => 1
 * 3,1,2,4  ,3 => 7
 *
 *
 */
    public int solution(int[] A) {
        int sum = 0;
        for( int elem: A)
            sum += elem;

        Integer minDiff = null;
        int p = -1;
        int sumLeft = 0;
        int sumRight = sum;
        for(int i = 0; i < A.length; i++) {
            sumLeft += A[i];
            sumRight -= A[i];
            if (null == minDiff) {
                minDiff = Math.abs(sumLeft-sumRight);
                p = i+1;
            }
            else {
                int d = Math.abs(sumLeft-sumRight);
                if( d < minDiff ) {
                    minDiff = d;
                    p = i+1;
                }
            }
        }
        return minDiff;
    }

}
