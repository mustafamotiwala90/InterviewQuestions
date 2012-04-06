package Solved;

public class isBitSetCheck {
	public static void main(String[] args) {
		System.out.println(isBitSet(2, 0));
		System.out.println(isBitSet(2, 1));
		System.out.println(isBitSet(4, 1));
		System.out.println(isBitSet(8, 3));
	}
	
	private static boolean isBitSet(int no,int bitNo){
		if((no>>bitNo & 1) == 1) return true;
		else					 return false;
	}
}
