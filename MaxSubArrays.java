package solved;

public class MaxSubArrays {
	public static void main(String[] args) {
		int[] n = new int[] { 1, 2, 3, -19, 5, 6, 7 };
		System.out.println(maxSubArray(n));
		System.out.println(maxContiguosSubArray(n));

	}
	private static int maxSubArray(int[] iArray) {
		//wont work if all is negative.
		int sum = 0;
		for (int i : iArray) {
			if (sum < sum + i)
				sum += i;
		}
		return sum;
	}
	
	private static int maxContiguosSubArray(int[] iArray) {
		int maxSoFar=0,maxEndTillNow=0;
		for (int i : iArray) {
			maxEndTillNow = Math.max(maxEndTillNow+i, 0);
			maxSoFar = Math.max(maxSoFar, maxEndTillNow);
		}
		return maxSoFar;
	}
}
