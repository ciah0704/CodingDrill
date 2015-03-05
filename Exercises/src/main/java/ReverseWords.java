import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Reverse words in the string
 */
public class ReverseWords {

	/**
	 * Reverse string using tokenizer
	 * 
	 * @param input
	 * @return Reversed string
	 */
	static public String reverse1(String input) {
		String[] tokens = input.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for (int i = tokens.length - 1; i >= 0; i--) {
			sb.append(tokens[i]);
			if (i > 0)
				sb.append(" ");
		}
		return sb.toString();
	}

	/**
	 * Reverse long string including delimiters using iteration
	 * 
	 * @param input
	 * @return Reversed string
	 */
	static public String reverse2(String input) {
		StringBuilder buf = new StringBuilder();
		int beginIndex = input.length() - 1;
		int endIndex = input.length();

		while (beginIndex >= 0) {

			// rewind startPos to start of current word
			while (beginIndex > 0 && input.charAt(beginIndex) != ' ')
				beginIndex--;

			// Select word from string
			String s = input.substring(((beginIndex == 0) ? beginIndex
					: beginIndex + 1), endIndex);
			buf.append(s);
			if (beginIndex != 0)
				buf.append(" ");

			// Reposition pointers
			endIndex = beginIndex--;
		}

		return buf.toString();
	}

	/**
	 * Reverse string using stack
	 * 
	 * @param input
	 * @return Reversed string
	 */
	static public String reverse3(String input) {
		Stack<String> stack = new Stack<String>();

		// Scan string chars
		StringBuilder buf = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch != ' ') {
				buf.append(ch);
			} else {
				// A word has been read - place buffer into stack
				stack.push(buf.toString());
				buf = new StringBuilder();
			}
		}
		stack.push(buf.toString());

		StringBuilder retval = new StringBuilder();
		while (!stack.empty()) {
			retval.append(stack.pop());
			if (stack.size() > 0)
				retval.append(" ");
		}
		return retval.toString();
	}

}
