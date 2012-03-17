package solved;


/**
 * Given an array find the maximum possible product of any 3 nos. 
 *  
 * @author Rishi Baldawa
 * 
 */
public class maxProdof3 {

	public static void main(String[] args) {
		System.out.println(getMaxProdcut(new int[] { -3, -2, -1, 0, 1, 2, 3, 4 }));
		System.out.println(getMaxProdcut(new int[] { -2, -1, 0, 1, 2, 3, 4 }));
		System.out.println(getMaxProdcut(new int[] { -2, -1, 0, 1 }));
		System.out.println(getMaxProdcut(new int[] { -1, -2, 1, 1 }));
		System.out.println(getMaxProdcut(new int[] { -4, -3, -2, -1 }));



	}

	public static int getMaxProdcut(int[] arr) {
		//TODO port it for prod of N nos.
		
		if (arr.length < 3) {
			// throw error
			return Integer.MIN_VALUE;
		}
		if (arr.length == 3) {
			return arr[0] * arr[1] * arr[2];
		}
		
		int[] p = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
		int[] n = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};

		for (int no : arr) {
			if (no >= 0) {
				//TODO convert into for loop
				if (p[0] <= no) {
					p[2] = p[1];
					p[1] = p[0];
					p[0] = no;
				} else if (p[1] <= no) {
					p[2] = p[1];
					p[1] = no;
				} else if (p[2] <= no) {
					p[2] = no;
				}
			} else {
				if (n[0] >= no) {
					n[2] = n[1];
					n[1] = n[0];
					n[0] = no;
				} else if (n[1] >= no) {
					n[2] = n[1];
					n[1] = no;
				} else if (n[2] >= no) {
					n[2] = no;
				}
			}
		}

		
		int max = Integer.MIN_VALUE ;
		if(p[2] >= 0)				max = Math.max(max, p[0]*p[1]*p[2]);
		if(p[1] >= 0 && n[0] < 0) 	max = Math.max(max, p[0]*p[1]*n[0]);
		if(p[0] >= 0 && n[1] < 0)	max = Math.max(max, p[0]*n[0]*n[1]);
		if(n[2] < 0)				max = Math.max(max, n[0]*n[1]*n[2]);
		return max;
	}
}