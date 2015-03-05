import java.util.ArrayList;
import java.util.List;

/**
 * Parses input string of format "(a b c (d e (f)))" into Java List
 * To use call method parse()  
 */
public class SimpleStringParser1 {

	final static String DELIMITERS = " |(|)";
	int tokenCnt;
	boolean firstBracket;
	
	@SuppressWarnings("rawtypes")
	List parse(String input) {
		String[] tokens = input.split(DELIMITERS);
		this.tokenCnt = 0;
		this.firstBracket = true;
		List retval = scan(tokens);
		return retval;
	}
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	List scan(String[] tokens) {
		List retval = new ArrayList();
		
		for(; tokenCnt<tokens.length; tokenCnt++) {
			String token = tokens[tokenCnt];
			if(isEmpty(token)) {
				; //skip
			}
			else if(isStartList(token)) {
				// if this is first bracket from input - do nothing, skip to next token 
				if(this.firstBracket) {
					this.firstBracket = false;
				}
				// if this is NOT first bracket from input - call recursion 
				else {
					this.tokenCnt++;
					List obj = scan(tokens);
					retval.add(obj);
				}
			}
			else if(isValue(token)) {
				retval.add(token);
			}
			else if(isEndList(token)) {
				// return object
				this.tokenCnt++;
				break;
			}
		}
		return retval;
	}
	
	/** Returns true if token is value */
	private boolean isValue(String token) {
		return token.matches("[a-zA-Z]+");
	}

	/** Returns true if token is 'end of the list' expression */
	private boolean isEndList(String token) {
		return token.matches("\\)");
	}

	/** Returns true if token is 'begin of the list' expression */
	private boolean isStartList(String token) {
		return token.matches("\\(");
	}

	/** Returns true if token is empty */
	private boolean isEmpty(String token) {
		return token.length()==0;
	}
}
