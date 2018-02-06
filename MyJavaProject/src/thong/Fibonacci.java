package thong;

import java.util.Arrays;

// f[i] = f[i-2] + f[i-1]
// 1) Naive approach: using recursive: lots of dupes. O= n^2
// 2) Using Dynamic Program here:
/**
 * f[i] = f[i-2] + f[i-1]
 * 1) Naive approach: using recursive: lots of dupes. O= n^2
 * 2) Using Dynamic Program here
 * @author thongbui
 *
 */
public class Fibonacci {
	/**
	 * O = n
	 * @param n
	 * @return
	 */
	static int[] getFibonacci(int n)
	{		
		int f[] = new int[n+1];
		
		if (n >= 0) f[0] = 0;
		if (n >= 1) f[1] = 1;
		if (n > 1) {
			for (int i = 2;  i <= n ; i++) {
				f[i] = f[i-2] + f[i-1];
				//System.out.println(i + "," + f[i]);
			}			
		}
		return f;
	}

	static int getFibonacciEvenSum(int n) {
		int f[] = new int[n + 1];

		int evenSum = 0;
		if (n >= 0)
			f[0] = 1;
		if (n >= 1) {
			f[1] = 1;
		}

		if (n > 1) {
			for (int i = 2; i <= n; i++) {
				f[i] = f[i - 2] + f[i - 1];
				if (f[i] % 2 == 0)
					evenSum += f[i];
			}
		}
		//System.out.println(Arrays.toString(f));

		return evenSum;
	}

	public static void main(String args[]) {
		//getFibonacci(2);
		for (int i=0; i <= 20; i++) {
			System.out.println(Arrays.toString(getFibonacci(i)));
	        System.out.println(i + ":" +getFibonacciEvenSum(i));
		}
	}
}
