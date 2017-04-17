package com.challenge.primes.multiplicaiton;

import java.util.*;

public class SieveEratosthenes {
	private BitSet bitSet;

	private SieveEratosthenes() {
	}

	private SieveEratosthenes(int size) {
		bitSet = new BitSet((size + 1) / 2);
	}
	
	public static List<Integer> getPrimes(int total) {
		double max = SieveEratosthenes.getUpperBound(total);

		SieveEratosthenes se = new SieveEratosthenes((int) (max + 1));
		for (int i = 3; i <= Math.sqrt(max); i += 2) {
			if (se.isComposite(i))
				continue;

			for (int j = (int) Math.pow(i,2); j <= max; j += 2 * i)
				se.setComposite(j);
		}

		List<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		
		for (int i = 3; i <= max; i += 2)
			if (!se.isComposite(i)) {
				if (primes.size() < total) {
					primes.add(i);
				}
			}

		return primes;
	}

	private static long getUpperBound(long number) {
		double bound = 0;
		double n = (double) number;
		
		double logn = Math.log(n);
		double log2n = Math.log(logn);

		if(n==1)return 2;
		else if(n==2)return 3;
		else if(n==3)return 5;

		/**
		 * @see <a href="https://arxiv.org/pdf/1203.5413.pdf">The n-th prime
		 *      asymptotically#page8</a>
		 */
		if (n >= 688383)
			bound = n * (logn + log2n - 1.0 + ((log2n - 2.00) / logn));
		/**
		 * @see <a href="https://arxiv.org/pdf/1002.0442.pdf">Estimates of Some
		 *      Functions Over Primes without R.H.#page7</a>
		 */
		else if (n >= 178974)
			bound = n * (logn + log2n - 1.0 + ((log2n - 1.95) / logn));
		/**
		 * @see <a href=
		 *      "http://public.gettysburg.edu/~dglass/spring04/chebyshev.pdf">Sharper
		 *      bounds for ψ, θ, π, pk#page4</a>
		 */
		else if (n >= 39017)
			bound = n * (logn + log2n - 0.9484);
		else if (n >= 27076)
			bound = n * (logn + log2n - 1 + (log2n - 1.8) / logn);//0.9487561613330602
		/**
		 * @see <a href="https://arxiv.org/pdf/1606.08293.pdf">
		 * STUDIES OF ENTROPY MEASURES CONCERNING THE GAPS OF PRIME NUMBERS page8</a>
		 */
		else if(n>=6)
			bound = n*(logn  +  0.6000 * log2n );
		else
			bound = n *(logn + log2n);

		if (bound >= (double) Long.MAX_VALUE)
			return Long.MAX_VALUE;

		return (long) Math.ceil(bound);
	}
	
	private boolean isComposite(int k) {
		assert( k >= 3 && (k % 2) == 1);
		return bitSet.get((k - 3) / 2);
	}

	private void setComposite(int k) {
		assert(k >= 3 && (k % 2) == 1);
		bitSet.set((k - 3) / 2);
	}
}