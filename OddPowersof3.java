package Solved;

public class OddPowersof3 {
	public static void main(String[] args) {
		printOddPowersof3(3);
	}

	private static void printOddPowersof3(int i) {
		int product = 3;
		System.out.println( "\t" + product + "\t" + Integer.toBinaryString(product));
		for(int j = 0; j < i ; j++){
			product += (product<<3);
			System.out.println( ((j+1)*2+1) + "\t" + product + "\t" + Integer.toBinaryString(product));
		}
	}
}
