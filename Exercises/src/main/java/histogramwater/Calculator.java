package histogramwater;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;


/**
 * Created by vkroz on 7/4/14.
 */
public class Calculator {
    //</editor-fold>
    private final int[]  bars;

    public Calculator(int[] bars) {
        this.bars = bars;
    }

    /**
     * Returns area covered by water
     */
    int computeArea() {
//        int rightHigh =  -1;
        int pendingArea = 0;
        int area = 0;

        List<Integer> localMaxList = new ArrayList<Integer>();

        int cur = -1;
        int localMax = -1;
        int left = bars[0];
        for(int i = 0; i < bars.length; i++) {
            cur = bars[i];
            if( cur > left) {
                localMax = cur;
            }
            else {

            }
        }
        return 0;
    }
}
