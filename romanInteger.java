package solved;

public class romanInteger {
	static String[] RCODE 	= { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
	static int[] BVAL 		= { 1000, 900, 500,  400, 100,   90,  50,   40, 10,     9,   5,    4,   1 };

	public static void main(String[] args) {
		//XI 11, IX 9, XXX 30, DC 600, CM 900, XCVIII 98
		System.out.println(intToRoman(99));
		System.out.println(romanToInt("IX"));
		
	}
	
	public static int romanToInt(String str){
		int n = 0;
		int offset = 0;
		for (int i = 0; i < RCODE.length; i++) {
			while (str.startsWith(RCODE[i], offset)) {
				offset += RCODE[i].length();
				n += BVAL[i];
			}
		}
		return n;
	}
	
	public static String intToRoman(int n){
		StringBuilder retSB = new StringBuilder();
		for (int i = 0; i < BVAL.length; i++) {
			if(n < BVAL[i]) continue;
			while(n >= BVAL[i]){
				retSB.append(RCODE[i]);
				n -= BVAL[i];
			}
		}
		return retSB.toString();
	}
}
