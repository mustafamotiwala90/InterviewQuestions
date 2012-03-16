package solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class intersectArrays {
	public static void main(String[] args) {
		System.out.println(intersect(new int[] { 1, 2, 3, 4 }, new int[] { 1,
				3, 5, 7 }));
	}

	public static List<Integer> intersect(int[] a, int[] b) {
		// start with arrays a and b.

		Arrays.sort(a); // log(a.length) time
		Arrays.sort(b); // log(b.length) time
		int aindex = 0;
		int bindex = 0;
		List<Integer> c = new ArrayList<Integer>();
		while (aindex < a.length && bindex < b.length) {
			if (a[aindex] == b[bindex]) {
				c.add(a[aindex++]);
				bindex++;
			} else if (a[aindex] < b[bindex]) {
				c.add(a[aindex++]);
			} else {
				c.add(b[bindex++]);
			}
		}

		while (aindex < a.length)			c.add(a[aindex++]);
		while (bindex < b.length)			c.add(b[bindex++]);

		return c;
	}
}
