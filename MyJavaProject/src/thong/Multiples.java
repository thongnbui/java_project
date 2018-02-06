package thong;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. 
 * The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Multiples {
	private int one;
	private int two;
	
	public Multiples(int a, int b) {
		one = a;
		two = b;
	}
	
	public int getSum(int limit) {
		int result = one + two;
		// all the natural numbers below limit
		for (int i= Math.min(one, two)+1; i < limit; i++) {
			if (i != one && i!= two && (i % one == 0 || i % two == 0)) {
				result += i;
				//System.out.println(i + ": " + result);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Multiples m = new Multiples(3,5);
		System.out.println(m.getSum(10));
		System.out.println(m.getSum(1000));
	}
}
