package Solved;

public class equalSumSubArray {
	
	/*
	 * Given an array (length n), find the subarray (length k) such that the sum
	 * of the first j elements of the subarray equals the sum of the remaining
	 * (k-j) elements of the subarray.
	 */
	
	public static void findSubarray(int[] nums) {
		String resultSB = new String(); // when not deleting, immutable string
										// will give better performance.
										// string builder would be even more
										// awesome, just a bit ugly looking
		int sumK = 0;
		int sumJ = 0;
		int j, k;
		for (int i = 0; i < nums.length - 1; i++) {
			j = i;
			k = i + 1;

			sumJ = nums[j];
			sumK = nums[k];

			resultSB = (nums[j] + ",") + resultSB;
			resultSB = resultSB + (nums[k] + ",");

			while (j > 0 && k < nums.length - 1) {
				if (sumJ > sumK) {
					sumK = (sumK + nums[++k]);
					resultSB = resultSB + (nums[k] + ",");
				} else if (sumJ < sumK) {
					sumJ = (sumJ + nums[--j]);
					resultSB = (nums[j] + ",") + resultSB;
				} else {
					System.out.println("[" + resultSB + "]");
					sumK = (sumK + nums[++k]);
					resultSB = resultSB + (nums[k] + ",");
					sumJ = (sumJ + nums[--j]);
					resultSB = (nums[j] + ",") + resultSB;
				}
			}
			if (sumJ == sumK)
				System.out.println("[" + resultSB + "]");
			resultSB = new String();
		}
	}

	public static void main(String[] args) {
		findSubarray(new int[] { 2, 2, 13, 4, 7, 3, 8, 13, 12, 9, 1, 5 });
	}

}
