import java.util.Arrays;

public class MaxCommonElement {
	
	static public Integer getCommonMax(int[] arrA, int[] arrB) {
		Arrays.sort(arrA);
		Arrays.sort(arrB);
		
		int cntA=arrA.length-1;
		int cntB=arrB.length-1;
		do {
			int a = arrA[cntA]; 
			int b = arrB[cntB]; 
			if( a == b )
				return a;
			else if( a < b )
				cntB--;
			else
				cntA--;
		} while ( cntA>=0 && cntB>=0);

		return null;
	}

}
