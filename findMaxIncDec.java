package solved;

public class findMaxIncDec {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 30, 40, 50, 60, 70, 23, 20 };
		System.out.println("Change is at :"
				+ (findMaximum(arr, 0, arr.length - 1) + 1));
		arr = new int[] { 1, 3, 50, 10, 9, 7, 6 };
		System.out.println("Change is at :"
				+ (findMaximum(arr, 0, arr.length - 1) + 1));
		arr = new int[] { 10, 20, 30, 40, 50 };
		System.out.println("Change is at :"
				+ (findMaximum(arr, 0, arr.length - 1) + 1));
		arr = new int[] { 120, 100, 80, 20, 0 };
		System.out.println("Change is at :"
				+ (findMaximum(arr, 0, arr.length - 1) + 1));

	}

	/**
	 * Given an array of integers which is initially increasing and then
	 * decreasing, find where this change has occured
	 */

	/**
	 * SOLUTION : Using modified Binary Search
	 */

	private static int findMaximum(int[] arr, int low, int high) {
		/* Base Case: Only one element is present in arr[low..high] */
		if (low == high)
			return high;

		/*
		 * if there are two elements
		 */
		if (high == low + 1) {
			if (arr[low] >= arr[high])
				return low; // 1st > 2nd
			else
				return high; // 2nd > 1st
		}

		int mid = (low + high) / 2;

		// check the mid
		if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1])
			return mid;

		/*
		 * if m-1 > m > m+1 check left
		 * else 			check right
		 */
		if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1])
			return findMaximum(arr, low, mid - 1);
		else
			return findMaximum(arr, mid + 1, high);
	}
}
