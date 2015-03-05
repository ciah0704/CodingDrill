/**
 * Generates Fibonacci numbers
 *
 */
public class FiboncciNumbers {

	/**
	 * Fibonacci: 0, 1, (n[i-1]+n[i-2])
	 * 
	 * @param count
	 * @return
	 */
	public static int method1(int count) {
		int n=0, n1=0, n2=0;
		for (int i = 0; i < count; i++) {

			switch (i) {
			case 0:
				n2 = 0;
				n1 = 0;
				break;
			case 1:
				n2 = 0;
				n1 = 1;
				break;
			default:
				n2 = n1;
				n1 = n;
			}
			n = n1 + n2;
		}
		return n;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i=0; i<10; i++) {
			System.out.println(FiboncciNumbers.method1(i));
		}

	}


}
