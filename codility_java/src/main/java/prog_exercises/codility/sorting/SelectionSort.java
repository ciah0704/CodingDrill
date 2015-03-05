package prog_exercises.codility.sorting;

import static java.lang.Math.min;
/**
 * Created by vkroz on 7/6/14.
 * 3,2,99,1
 * 2,3,99,1
 * 2,3,1,99
 */
public class SelectionSort implements Sort {
    @Override
    public int[] sort(int[] array) throws Exception {
        for(int i=0; i< array.length; i++) {
             // array[i] here will point in minimal element;
            for(int j=i+1; j<array.length; j++) {
                if( array[j] < array[i] ) {
                    // swap values
                    array[i] =  array[i] ^ array[j];
                    array[j] =  array[i] ^ array[j];
                    array[i] =  array[i] ^ array[j];
                }

            }
        }
        return array;
    }

    /*

    a^b                         a  b
    2^3     0010 ^ 0011 = 0001  1
    1^3     0001 ^ 0011 = 0010     2
    1^2     0001 ^ 0010 = 0011  3



     */
}
