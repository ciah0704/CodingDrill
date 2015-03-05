import java.util.HashSet;

/**
 * Number of string manipulation methods
 */
public class StringsUtils {


	/**
	 * Reverses input string
	 * 
	 * @return Reversed string
	 */
	static public String reverse(String s1) {
		byte[] c = s1.getBytes();
		int ix1 = 0;
		int ix2 = s1.length() - 1;
		while (ix1 < ix2) {
			c[ix1] ^= c[ix2];
			c[ix2] ^= c[ix1];
			c[ix1] ^= c[ix2];
			ix1++;
			ix2--;
		}
		return new String(c);
	}

	static public String removeDuplicateChars(String str) {
		StringBuilder sb = new StringBuilder();
		int[] hits = new int[Character.MAX_VALUE];
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			hits[c]++;
			if (hits[c] < 2) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	static public boolean isAnagtram(String str1, String str2) {
		int[] sym = new int[256];
		sym['a'] = 0x00000001 /* 0000 0000 0000 0000 0000 0000 0000 0001 */;
		sym['b'] = 0x00000002 /* 0000 0000 0000 0000 0000 0000 0000 0010 */;
		sym['c'] = 0x00000004 /* 0000 0000 0000 0000 0000 0000 0000 0100 */;
		sym['d'] = 0x00000008 /* 0000 0000 0000 0000 0000 0000 0000 1000 */;
		sym['e'] = 0x00000010 /* 0000 0000 0000 0000 0000 0000 0001 0000 */;
		sym['f'] = 0x00000020 /* 0000 0000 0000 0000 0000 0000 0010 0000 */;
		sym['g'] = 0x00000040 /* 0000 0000 0000 0000 0000 0000 0100 0000 */;
		sym['h'] = 0x00000080 /* 0000 0000 0000 0000 0000 0000 1000 0000 */;
		sym['i'] = 0x00000100 /* 0000 0000 0000 0000 0000 0001 0000 0000 */;
		sym['j'] = 0x00000200 /* 0000 0000 0000 0000 0000 0010 0000 0000 */;
		sym['k'] = 0x00000400 /* 0000 0000 0000 0000 0000 0100 0000 0000 */;
		sym['l'] = 0x00000800 /* 0000 0000 0000 0000 0000 1000 0000 0000 */;
		sym['m'] = 0x00001000 /* 0000 0000 0000 0000 0001 0000 0000 0000 */;
		sym['n'] = 0x00002000 /* 0000 0000 0000 0000 0010 0000 0000 0000 */;
		sym['o'] = 0x00004000 /* 0000 0000 0000 0000 0100 0000 0000 0000 */;
		sym['p'] = 0x00008000 /* 0000 0000 0000 0000 1000 0000 0000 0000 */;
		sym['q'] = 0x00010000 /* 0000 0000 0000 0001 0000 0000 0000 0000 */;
		sym['r'] = 0x00020000 /* 0000 0000 0000 0010 0000 0000 0000 0000 */;
		sym['s'] = 0x00040000 /* 0000 0000 0000 0100 0000 0000 0000 0000 */;
		sym['t'] = 0x00080000 /* 0000 0000 0000 1000 0000 0000 0000 0000 */;
		sym['u'] = 0x00100000 /* 0000 0000 0001 0000 0000 0000 0000 0000 */;
		sym['v'] = 0x00200000 /* 0000 0000 0010 0000 0000 0000 0000 0000 */;
		sym['w'] = 0x00400000 /* 0000 0000 0100 0000 0000 0000 0000 0000 */;
		sym['x'] = 0x00800000 /* 0000 0000 1000 0000 0000 0000 0000 0000 */;
		sym['y'] = 0x01000000 /* 0000 0001 0000 0000 0000 0000 0000 0000 */;
		sym['z'] = 0x02000000 /* 0000 0010 0000 0000 0000 0000 0000 0000 */;

		char[] src = str1.toCharArray();
		int stamp = 0;
		for (char c : src) {
			stamp |= sym[c];
		}
		char[] test = str2.toCharArray();
		int testStamp = 0;
		for (char c : test) {
			testStamp |= sym[c];
		}
		return stamp == testStamp;
	}

	public static boolean areAllCharsUnique(String str) {
		HashSet<Character> t = new HashSet<Character>();
		for (char ch : str.toCharArray()) {
			if (t.contains(ch))
				return false;
			else {
				t.add(ch);
			}
		}
		return true;
	}

}
