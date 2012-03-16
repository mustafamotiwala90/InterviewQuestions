package solved;

public class maxChanges {
	public static void main(String[] args) {
		int[] arr = { 7, 5, 4, 3, 2, 1 };
		int sum = 13;

		maxChange(arr, sum, 0, "");
	}

	private static void maxChange(int[] arr, int sum, int strt, String s) {
		if (sum < 0)
			return;

		if (sum == 0) {
			System.out.println(s);
			return;
		}
		for (int i = strt; i < arr.length; i++) {
			maxChange(arr, sum - arr[i], i, s + arr[i]);
		}
		return;
	}
}
