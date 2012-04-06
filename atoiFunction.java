package Solved;

public class atoiFunction {

	public static void main(String[] args) {
		int a = '0';
		System.out.println(a);
		System.out.println(atoi("123".toCharArray()));
	}

	public static int atoi(char[] arr) {
		// not checking for negative aka - whose ascii values is 45
		int retValue = 0;
		for (char c : arr) {
			int i = c - 48;
			retValue *= 10;
			if (i >= 0 && i <= 9) {
				retValue += i;
			}
			// else{throw error if not between 0 and 9}
		}
		return retValue;
	}

}
