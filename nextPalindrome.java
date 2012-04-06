package Solved;

public class nextPalindrome {
	/*
	 * Next Largest Palindrome
	 */

	public static void main(String[] args) {
		System.out.println(nextLargestPalindrome(1261521));
		System.out.println(nextLargestPalindrome(3012022));
		System.out.println(nextLargestPalindrome(98));
	}
	
	public static int nextLargestPalindrome(int i){
		
		String intStr = Integer.toString(i);
		int len = intStr.length();
		boolean isOdd = (len % 2 == 1);
		String midNo;
		int leftHalf;
		int retValue = i;
		
		if (isOdd){
			leftHalf = Integer.parseInt(intStr.substring(0,len/2));
			midNo = intStr.substring(len/2,len/2+1);
			retValue = mirrorImg(leftHalf++, midNo);
			while(retValue < i)
				retValue = mirrorImg(leftHalf++, midNo);
		}
		else{
			leftHalf = Integer.parseInt(intStr.substring(0, len/2 ));
			retValue = mirrorImg(leftHalf++);
			while(retValue < i)
				retValue = mirrorImg(leftHalf++);
		}
		
		return retValue;
	}
	
	public static int mirrorImg(int leftHalf, String midNo){
		StringBuilder str = new StringBuilder(Integer.toString(leftHalf));
		return Integer.parseInt(str + midNo + str.reverse());
	}
	
	public static int mirrorImg(int leftHalf){
		StringBuilder str = new StringBuilder(Integer.toString(leftHalf));
		return Integer.parseInt( str + "" + str.reverse());
	}
}
