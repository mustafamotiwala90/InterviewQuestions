package solved;

public class bitCount {
	public static void main(String[] args) {
		System.out.println(bitcount(127));
	}

	public static int bitcount(int n) {
		int count;
		for (count = 0; n != 0; n = n >> 1)
			if ((n & 1) == 1)
				count++;
		return count;
	}
}
