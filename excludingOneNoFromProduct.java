package Solved;

public class excludingOneNoFromProduct {

	/*
	 * given non-zero number array A, create array B where B[i] = product of all
	 * elements in A except A[i].
	 */
	static int[] preArr = null, postArr = null;

	public static void main(String[] args) {
		int[] arr = {4,2,3};
		System.out.println(productExcludingNo(1,arr));
	}

	public static int productExcludingNo(int i, int[] arr) {
		int len = arr.length;
		if (i < 0 || i > len)
			return -1;// error

		if (preArr == null) {
			//preProcessing
			preArr = new int[len];
			postArr = new int[len];

			for (int j = 0; j < len; j++) {
				preArr[j] = 1;
				postArr[j] = 1;
			}
			
			//array of multiplying all nos before the elem
			for(int j = 1; j < len ; j++){
				preArr[j] = arr[j-1]*preArr[j-1];
			}
			
			//array of mutipling all nos after the elem
			for(int j = len-2; j >= 0 ; j--){
				postArr[j] = arr[j+1]*postArr[j+1];
			}
			
		}

		//simple returning value
		return preArr[i]*postArr[i];
	}
}
