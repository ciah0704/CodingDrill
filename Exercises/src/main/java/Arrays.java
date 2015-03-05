import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Array - reliated tasks
 * 
 */
public class Arrays {
	
	/**
	 * Returns true if arr contains all elements from subarr 
	 */
	static public boolean isSubset(char[] arr, char[] subarr) {
		
		// count all unique elements in source array 
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(char ch: arr) {
			Integer count = map.get(ch); 
			if( null != count ) {
				count = count + 1;
			}
			else {
				count = 1;
			}
			map.put(ch, count);

		}
		
		// Now start iterating over sub array, for each element lookup in the map above
		// if element found - decrement it's counter intil 0, and then remove element
		// f element is not found in map - sub array is not subset
		for(char ch: subarr) {
			Integer count = map.get(ch); 
			if( null == count ) {
				return false;
			}
			else if( count > 0) {
				count = count - 1;
				map.put(ch, count);
			}
			else {
				return false;
			}
		}
		// If we reached this point then sub array is a subset of array  
		return true;
	}
	
	
	static public int[] getTopElements(int[] arr, int k) {
		Random rnd = new Random();

		int r = 0;
		do {
			r = rnd.nextInt(arr.length); 
		} while ( r==0 );

		
		int pivot = arr[r];
		
//		Vector<Integer> arr1 = new Vect;
//		int[] arr2;
//		
//		for(int i=1; i<arr.length; i++) {
//			if( arr[i] < pivot )
//				arr[i]
//		}
		
		return null;
	}

}