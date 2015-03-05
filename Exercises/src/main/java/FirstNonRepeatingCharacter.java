import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Find first non-repeating character in array of characters  
 */
public class FirstNonRepeatingCharacter {

	/**
	 * We will use linked map data structure to count unique array elements while
	 * preserving order of they appearance in array 
	 * @param str
	 * @return
	 */
	public static char find(String str) {
		
		// Iterate through array and build linked map of characters with hit counters 
		Map<Character, Integer> table = new LinkedHashMap<Character, Integer>();
		for(char ch: str.toCharArray()) {
			Integer hits = table.get(ch);
			if( null != hits ) {
				hits = hits + 1;
			}
			else {
				hits = 1;
			}
			table.put(ch, hits);
		}
		
		// Now iterate via map and pick first element with value 1, key will be first non-repeating char
		for(Map.Entry<Character, Integer> entry: table.entrySet()) {
			if( entry.getValue() == 1 )
				return entry.getKey();
		}
		return 0;
	}
}
