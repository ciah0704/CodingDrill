package codility;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vkroz on 7/13/14.
 */
public class FindLeadersInArray {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int maxCount = -1;
        int maxNum = -1;
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for(int n: A) {
            Integer count = counts.get(n);
            if( count == null ) {
                count = 1;
            }
            else {
                count += 1;
            }
            counts.put(n, count);
            if( maxCount < count ) {
                maxCount = count;
                maxNum = n;
            }
        }
        return maxNum;

    }

}
