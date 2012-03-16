package solved;

public class Compress {

	private static String compress(char[] s) {
		char a = s[0];
		int counter = 1;
		StringBuilder retS = new StringBuilder();
		for (char c : s) {
			if (c == a) {
				counter++;
			} else {
				retS.append(a + "" + counter);
				a = c;
				counter = 1;
			}
		}

		retS.append(a + "" + counter); 
		// "" so that a and counter aren't added mathematically
		
		return retS.toString();
	}
}
