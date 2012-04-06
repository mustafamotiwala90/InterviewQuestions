package Solved;

public class incSequence {
	public static void main(String[] args) {
		System.out.println(findSequence(new int[] { 11, 10, 7, 6, 5, 4, -2, 11,	10, 9, 3, -4, 4, 2, 1, -1 }));
	}

	private static boolean findSequence(int[] arr) {
		int min = 0, max = arr.length - 1, l = 1, r = arr.length - 2;

		while (l <= r) {

			if (arr[l] >= arr[min] && arr[l] <= arr[max]) {
				// check min < l < max
				return true;

			} else if (arr[r] >= arr[min] && arr[r] <= arr[max]) {
				// check min < r < max
				return true;

			} else if (arr[l] >= arr[min] && arr[l] <= arr[r]) {
				// check min < l < r
				return true;

			} else if (arr[r] >= arr[l] && arr[r] <= arr[max]) {
				// check l < r < max
				return true;

			} else {
				// combo doesn't work need to make changes

				if (arr[l] < arr[min]) {
					// move left & min pointer by one
					min = l;
					l++;
				}

				if (arr[r] > arr[max]) {
					// move right & max pointer by one
					max = r;
					r--;
				}

				if (arr[l] > arr[min] && arr[r] < arr[min]) {
					//move left & right pointer by one
					l++;
					r--;
				}
				
				//else do nothing
			}
		}

		return false;
	}

}
