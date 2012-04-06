package solved;

public class maxDiffIJ {

	public static void main(String[] args) {
		maxDiff(new int[]{1,2,3,7,5,8});
	}
	
	/*
	 * one unsorted array is given.Find out the index i and j ,j> i for which
	 * a[j] - a[i] is maximum.perform in linear time complexity
	 */
	
	public static void maxDiff(int[] arr){
		int max = 0;
		int min = 1;
		for(int i = 1 ; arr[i] >= max && i < arr.length -1; i++){
			min = i;
		}
		
		for(int i = 0 ; i < arr.length ; i++){
			if(arr[max] < arr[i] && i < min){
				max = i;
			}
			else if( arr[min] > arr[i] && i > max){
				min = i;
			}
		}
		
		if(arr[min] < arr[max]){
			System.out.println("max : " + max + "\tmin : " + min);
			System.out.println("max : " + arr[max] + "\tmin : " + arr[min]);
		}
	}
}
