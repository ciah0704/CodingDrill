package prog_exercises.search;


public class BinarySearch {
	
	/**
	 * Returns array index containing value being saught, or -1 if not found 
	 */
	static public int find(int[] arrA, int value) {
		int hi = arrA.length-1;
		int lo = 0;
		
		int ix = (hi-lo)/2;
		
		if(arrA[ix]==value) {
			return ix;
		}
		return -1;
	}

}
