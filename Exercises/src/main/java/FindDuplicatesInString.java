import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FindDuplicatesInString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(FindDuplicatesInString.method1("aabcdeefhgH"));
		System.out.println(FindDuplicatesInString.method2("aabcdeefhgH"));
		

	}

	private static String method1(String in) {
		if (in == null)
			return null;
		char[] inAr = in.toCharArray();
		Set<Integer> outSet = new HashSet<Integer>();
		List<Integer> outList = new ArrayList<Integer>();
		for (char ch : inAr) {
			if (outSet.add((int) ch))
				outList.add((int) ch);
		}
		char[] outAr = new char[outList.size()];
		Iterator<Integer> it = outList.iterator();
		for (int i = 0; it.hasNext(); i++) {
			int outInt = it.next();
			outAr[i] = (char) outInt;
		}
		return String.copyValueOf(outAr);
	}

	private static String method2(String in) {
		if (in == null)
			return null;
		char[] inAr = in.toCharArray();
		Set<Integer> outSet = new HashSet<Integer>();
		StringBuilder outList = new StringBuilder();
		for (char ch : inAr) {
			if (outSet.add((int) ch))
				outList.append(ch);
		}
		return outList.toString();
	}

}
