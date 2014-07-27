package solved;

import java.util.Arrays;
import java.util.Stack;

public class reverseArray {
	public static void main(String[] args) {
		int[] i = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		reversev2(i);
		System.out.println(Arrays.toString(i));
	}

	public static void reverse(int[] arr) {
		int N = arr.length;
		for (int i = 0; i < N / 2; i++) {
			//swapping arr[i] and arr[N-i-1]
			int t = arr[i];
			arr[i] = arr[N - i - 1];
			arr[N - i - 1] = t;
		}
	}
	
	public static void reversev2(int[] arr){
		Stack<Integer> st = new Stack<Integer>();
		for(int i : arr){
			st.add(i);
		}
		
		int k = 0;
		while(!st.isEmpty()){
			arr[k++] = st.pop();
		}
	}
}
