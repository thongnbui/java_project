package thong;

public class LargestPrimeFactor {
	public static int largestPrimeFactor(long number) {
		long input = number;
		int i;
		for (i=2; i <= input; i++) {
			// keep divide by i until u can't
			if (input % i == 0) {
				input /= i;
				i--;
			}
			
		}
		return i;
	}

	public static void main(String args[]) {
		System.out.println(largestPrimeFactor(13195));
		System.out.println(largestPrimeFactor(600851475143L));
	}
		
}
