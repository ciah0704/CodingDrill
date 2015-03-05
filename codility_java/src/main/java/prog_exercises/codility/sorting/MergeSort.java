package prog_exercises.codility.sorting;

public class MergeSort implements Sort {
    public int[] sort(int[] array) throws Exception {
        int[] sorted = _sort(array, 0, array.length - 1);
        System.out.println(sorted.toString());
        return sorted;
    }

    int[] _sort(int[] array, int firstElemPos, int lastElemPos) {
//        System.out.println("firstElemPos=" + firstElemPos + ",lastElemPos=" + lastElemPos);
        /*

        932     li=0,ri=2,m=1 => [0,1], [2,2]
        9 32
        9 3 2
        9 23
        239
         */
        int m = (lastElemPos - firstElemPos) / 2;
        if (lastElemPos - firstElemPos > 0) {
            int[] left = _sort(array, firstElemPos, m);
            int[] right = _sort(array, m + 1, lastElemPos);
            int[] merged = _merge(left, right);
            return merged;
        } else {
            int[] oneElemArr = new int[1];
            oneElemArr[0] = array[firstElemPos];
            return oneElemArr;
        }


    }

    private int[] _merge(int[] left, int[] right) {
//        int li = 0;
//        int ri = 0;
//        int k = 0;
        int[] merged = new int[left.length + right.length];

        for (int k = 0, li = 0, ri = 0; k < merged.length; ) {
            int max;
            if (li < left.length && ri < right.length) {
                if (left[li] < right[ri])
                    merged[k++] = left[li++];
                else
                    merged[k++] = right[ri++];
            } else if (li >= left.length) {
                merged[k++] = right[ri++];
            } else if (ri >= right.length) {
                merged[k++] = left[li++];
            } else {
//                System.out.println("Something very wrong here");
            }
        }
        return merged;
    }

}
