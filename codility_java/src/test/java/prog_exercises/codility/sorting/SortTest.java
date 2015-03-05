package prog_exercises.codility.sorting;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SortTest {

    int[][] unsorted = {
            {3, 1, 2},
            {99, 22, 11, 12, 13, 4, 4, 99, 0, 2, 3, 3, 4, 6, 7, 8, 9},
            { 22, -99, 0 },
            {},
            {1}
    };
    int[][] sorted = {
            {1, 2, 3},
            {0, 2, 3, 3, 4, 4, 4, 6, 7, 8, 9, 11, 12, 13, 22, 99, 99},
            { -99, 0, 22},
            {},
            {1}
    };

    @BeforeMethod
    public void setUp() throws Exception {
    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

//    @Test
//    public void testMergeSort() throws Exception {
//        Sort sort = new MergeSort();
//        assertEquals(sort.sort(this.unsorted[0]), this.sorted[0]);
//        assertEquals(sort.sort(this.unsorted[1]), this.sorted[1]);
//        assertEquals(sort.sort(this.unsorted[2]), this.sorted[2]);
//        assertEquals(sort.sort(this.unsorted[3]), this.sorted[3]);
//        assertEquals(sort.sort(this.unsorted[4]), this.sorted[4]);
//    }

    @Test
    public void testSelectSort() throws Exception {
        Sort sort = new SelectionSort();
        int[] a = sort.sort(this.unsorted[0]);
        assertEquals(a, this.sorted[0]);
        assertEquals(sort.sort(this.unsorted[1]), this.sorted[1]);
        assertEquals(sort.sort(this.unsorted[2]), this.sorted[2]);
        assertEquals(sort.sort(this.unsorted[3]), this.sorted[3]);
        assertEquals(sort.sort(this.unsorted[4]), this.sorted[4]);
    }
}