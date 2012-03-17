package solved;

public class paranthesis {
	private static char left = '{';
	private static char right = '}';
	private static int allowed = 6; //made global because to reduce func stack overflow possibility 

	public static void main(String[] args) {
		printParenthesis("", 0);
		System.out.println(checkParenthesis("{}{}{}".toCharArray()));
		System.out.println(checkParenthesis("}}}{{{".toCharArray()));
	}

	public static void printParenthesis(String str, int counter) {
		if (counter > allowed || str.length() > 2 * allowed || counter < 0)
			// counter not between o and allowed, string too long.
			return;

		if (counter == 0 && str.length() == 2 * allowed) {
			System.out.println(str);
			return;
		}

		if (counter <= allowed) {
			//all lefts haven't been used, so lets use em
			printParenthesis(str + left, counter + 1);
		}
		printParenthesis(str + right, counter - 1);

	}
	
	public static boolean checkParenthesis(char[] arr){
		int counter = 0;
		for (char a : arr) {
			if (a == left)
				counter++;
			else if (a == right)
				counter--;

			if (counter < 0)return false;// there's a right without a left before it.
		}
		if(counter < 0)	return false;
		else			return true;
	}
}
