package thong;

import java.util.*;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * @author thongbui
 *
 */
public class SmallestNumber {
	Map<Integer, Integer> primeCount = new HashMap<Integer, Integer>();
	List<Integer> primes;
	
	public SmallestNumber(int upperLimit) {
		primes = generatePrimes(upperLimit);
	}

	//checks whether an int is prime or not.
	static boolean isPrime(int n) {
		if (n == 2) return true;
	    //check if n is a multiple of 2
	    if (n%2==0) return false;
	    //if not, then just check the odds
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	
	static List<Integer> generatePrimes(int upperLimit) {
		List<Integer> primes = new ArrayList<Integer>();
		for (int i= 2; i <= upperLimit; i++) {
			if(isPrime(i)) {
				primes.add(i);
			}
		}
		return primes;
	}
	
	void conditionalUpdateCount(int prime, int count) {
		Integer existingCount = primeCount.get(prime);
		if (existingCount == null)
			existingCount = 0;
		
		if (count > existingCount) {
			primeCount.put(prime, count);
		}
	}
	
	
	/**
	 * Is num completely divisible by these primes?
	 * @param num
	 * @param primes
	 * @return
	 */
	boolean isDivisible(int num, List<Integer> primes) {
		// Keep dividing until u can't
		int numCopy = num;
		int count = 0;
		int prime = 0;
		for (int i=0; i< primes.size() && numCopy > 1; i++) {
			prime = primes.get(i);
			if (numCopy % prime == 0) {
				numCopy /= prime;
				count++;
				i--;
			}
			else if (count > 0) {
				
				conditionalUpdateCount(prime, count);
				count=0;

			}
		}
		if (numCopy == 1) {
			conditionalUpdateCount(prime, count);
			return true;
		}
		else 
			return false;
	}

	int getSmallestNumber(int upperLimit) {
		int result = 1;
		for (int i=2; i <= upperLimit; i++) {
//			System.out.println(i + ":" + isDivisible(i, primes));
			isDivisible(i, primes);
		}
		for (Map.Entry<Integer, Integer> entry : primeCount.entrySet()) {
			result *= Math.pow(entry.getKey(), entry.getValue());
		}
		return result;
	}

	public static void main(String[] args) {
		SmallestNumber smallestNumber = new SmallestNumber(10);
		System.out.println(Arrays.toString(generatePrimes(10).toArray()));
		System.out.println(smallestNumber.getSmallestNumber(10));
		System.out.println(smallestNumber.getSmallestNumber(20));

	}
}
