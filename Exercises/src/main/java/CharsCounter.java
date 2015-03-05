import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Number of string manipulation methods
 */
public class CharsCounter {

	Date d;
	/**
	 * @return an array containing each character that appears in the input
	 *         string more than one time, and the number of total times that
	 *         each such character appears.
	 * 
	 */
	static public Map<Character, Integer> charsCount(String str) {
		int[] cnt = new int[Character.MAX_VALUE];
		Map<Character, Integer> retval = new HashMap<Character, Integer>();
		for (char ch : str.toCharArray()) {
			cnt[ch]++;
			if (cnt[ch] > 1) {
				retval.put(ch, cnt[ch]);
			}
		}
		return retval;
	}


}
