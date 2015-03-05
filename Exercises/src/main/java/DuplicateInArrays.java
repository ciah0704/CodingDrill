import java.util.HashSet;

/**
 * Given an array of numbers, there is one number that has a duplicate. How
 * would you find the number?
 * 
 */
public class DuplicateInArrays {
	static public Integer findDuplicate(int[] arr) {
		HashSet<Integer> h = new HashSet<Integer>(arr.length);
		for(int x: arr) {
			if( !h.add(x) )
				return x;
		}
		return null;
	}

}