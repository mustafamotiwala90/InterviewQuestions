package Solved;

public class nextLargeCombo {
	/*
	 * Given a number,find the next higher number using the same digits in the
	 * number. Eg- 15432, Soln- 21345
	 */
	public static void main(String[] args) {

		System.out.println(nextLargerSameDigits(15432));
		System.out.println(nextLargerSameDigits(13483));
		System.out.println(nextLargerSameDigits(37723971));
		System.out.println(nextLargerSameDigits(100001));
	}

	public static int nextLargerSameDigits(int no) {
		String str = Integer.toString(no);

		for (int i = str.length() - 2; i >= 0; i--) {
			if (!isDecCombo(str.substring(i))) {
				//if not decreasing, a higher combo is possible
				String str2 = (findNextHighestCombo(str.substring(i).toCharArray()));
				String str1 = str.substring(0, i);//for i=0 is null. doesn't affect
				return Integer.parseInt(str1 + "" + str2);//parse combo
			}
		}
		return no;
	}

	/*
	 * find the first highest combo by swapping first elem from back less the
	 * elem[0]
	 */
	private static String findNextHighestCombo(char[] substring) {

		for (int i = substring.length - 1; i > 0; i--) {
			if (substring[0] < substring[i]) {
				// swapping
				char temp = substring[0];
				substring[0] = substring[i];
				substring[i] = temp;
				break;
			}
		}

		return new String(substring);
	}

	/*
	 * check if the sequence is loosely decreasing
	 */
	private static boolean isDecCombo(String substring) {

		char prev = substring.charAt(0);

		for (int i = 1; i < substring.length(); i++) {
			if (prev < substring.charAt(i))		return false;
			prev = substring.charAt(i);
		}

		return true;
	}

}
