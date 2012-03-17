package solved;

/**
 * Longest Common SubString Problem
 * 
 * @author Rishi Baldawa
 *
 */
public class LongestCommonSubString  {

	public static void main(String[] args) {
		System.out.println(LCStr("abcrfghwetf".toCharArray(), "abrfghwwetxyab".toCharArray()));
		System.out.println(LCStr("aaabbaaaccdeqjncsdddmmmkkkmmmddd".toCharArray()));
	}

	/**
	 * For longest common substring of two strings
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static String LCStr(char[] a,char[] b) {
		/*
		 * dynamic programming using a matrix. O(M*N) space and O(M*N) time
		 */
		StringBuilder retStr = new StringBuilder();
		int X = a.length;
		int Y = b.length;
		int max = 0;
		int[][] M = new int[X][Y];
		for (int i = 0; i < X; i++) {
			for (int j = 0; j < Y; j++) {
				if (a[i] == b[j]) {
					if (i == 0 || j == 0) {
						M[i][j] = 1; // boundary case
					} else {
						M[i][j] = M[i - 1][j - 1] + 1;
					}
					if (M[i][j] > max) {
						max = M[i][j];
						retStr = new StringBuilder();
						for (int k = i - max + 1; k <= i; k++)
							retStr.append(a[k]);
					}
				} else {
					M[i][j] = 0;
				}
			}
		}

		return retStr.toString();
	}
	
	/**
	 * For longest palindrome of a string.
	 * adding a hook.
	 * 
	 * @param a
	 * @return
	 */
	public static String LCStr(char[] a) {
		char[] b = a.clone();
		int X = b.length;
		
		//reversing b O(X/2)
		for (int i = 0; i < X / 2; i++) {
			//swapping 
			char temp = b[i];
			b[i] = b[X - i - 1];
			b[X - i - 1] = temp;
		}

		return LCStr(a,b);
	}
	
}
