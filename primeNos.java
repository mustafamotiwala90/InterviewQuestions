package Solved;

import java.util.Set;
import java.util.TreeSet;

public class primeNos {

	public static void main(String[] args) {
		for (int i : findPrimeNos(444)) {
			System.out.println(i);
		}
	}

	
	public static Set<Integer> findPrimeNos(int N) {

		boolean notMultiple;

		if (N < 2)
			return null; // if negative or 0 or 1

		Set<Integer> primeSet = new TreeSet<Integer>();
		for (int i = 2; i < N; i++) {
			/*
			 * check against every prime no till now. this is more efficient
			 * because based on observations usually no of non-primes is
			 * generally way more than no of primes. so this alternative method
			 * of sieve of Eratosthenes is more efficient
			 */

			notMultiple = false;
			for (int n : primeSet) {
				if (i % n == 0) {
					notMultiple = true;
					break;
				}
			}

			if (!notMultiple)
				//is prime
				primeSet.add(i);
		}

		return primeSet;
	}

}
