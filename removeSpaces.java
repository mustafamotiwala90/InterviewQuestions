package solved;

public class removeSpaces {

	public static void main(String[] args) {
		System.out.println(replaceSpacesv1("The spaceman says, Everybody look down"));
		System.out.println(replaceSpacesv2("The spaceman says, Everybody look down"));
		System.out.println(replace20sv1("The%20spaceman%20says,%20Everybody%20look%20down"));
		System.out.println(replace20sv2("The%20spaceman%20says,%20Everybody%20look%20down"));
	}

	/**
	 * C-Style Approach
	 * 
	 * @param string
	 * @return
	 */
	private static char[] replaceSpacesv1(String string) {
		char[] arr = string.toCharArray();

		// count spaces
		int spaceCount = 0;
		for (char a : arr) {
			if (a == ' ')
				spaceCount++;
		}

		char[] returnChar = new char[arr.length + (spaceCount * 2)];
		int k = 0;
		for (char a : arr) {
			if (a == ' ') {
				returnChar[k] = '%';
				returnChar[k + 1] = '2';
				returnChar[k + 2] = '0';
				k += 3;
			} else
				returnChar[k++] = a;
		}

		return returnChar;
	}

	/**
	 * Reg-Ex Approach
	 * 
	 * @param string
	 * @return
	 */
	private static String replaceSpacesv2(String string) {
		return string.replaceAll(" ", "%20");
	}

	/**
	 * C-Style Approach
	 * 
	 * @param string
	 * @return
	 */
	private static char[] replace20sv1(String string) {
		char[] arr = string.toCharArray();

		int k = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i <= arr.length - 2 && arr[i] == '%' && arr[i + 1] == '2' && arr[i + 2] == '0') {
				arr[k++] = ' ';
				i += 2;
			} else
				arr[k++] = arr[i];
		}
		arr[k++] = '\0';

		return arr;
	}

	/**
	 * Reg-Ex Approach
	 * 
	 * @param string
	 * @return
	 */
	private static String replace20sv2(String string) {
		return string.replaceAll("%20", " ");
	}

	/*
	 * GREP
	 * 
	 * grep -rl matchstring somedir/ | xargs sed -i 's/string1/string2/g'
	 */

}
