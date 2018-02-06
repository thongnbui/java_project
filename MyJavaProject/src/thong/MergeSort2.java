package thong;

import java.util.Arrays;

public class MergeSort2 {
	/**
	 * 1) Find midpoint: mid = (left + right) / 2
	 * 2) mergeSort(arr, left, mid)
	 * 3) mergeSort(arr, mid+1, right)
	 * 4) merge(arr, left, mid, right)
	 * 
	 */
	private int[] numbers;
	private int[] temp;
	
	public void sort(int[] values) {
		numbers = values;
		temp = new int[numbers.length];
		mergeSort(0, numbers.length-1);

	}
		
	void mergeSort(int low, int high) {
		System.out.println("mergeSort(" + low + "," + high + ")");
		if (low < high) {
			int mid = (low + high)/2;
			mergeSort(low, mid);
			mergeSort(mid + 1, high);
			merge(low, mid, high);
		}
	}
	// use temp array
	/**
	 * Merge 2 halves
	 * @param left
	 * @param mid
	 * @param right
	 */
	void merge(int low, int mid, int high) {
		System.out.println("merge(" + low + "," + mid + ","+ high + ")");
		int left = low;
		int index = low;
		int right = mid + 1;
		// Copy numbers -> temp and 
		// use temp as the source, numbers as result
		temp = new int[numbers.length];
		System.arraycopy(numbers, low, temp, low, high - low + 1);

		while (left <= mid && right <= high) {
			if (temp[left] < temp[right]) {
				numbers[index] = temp[left];
				left++;
			}
			else {
				numbers[index] = temp[right];
				right++;
			}
			index++;
		}
		
		//System.arraycopy(src, srcPos, dest, destPos, length);
		//Copy remaining left from temp -> right side of numbers
		System.out.println(" temp = " + Arrays.toString(temp));
		System.out.println(" numbers before = " + Arrays.toString(numbers));
		if (left < index && mid - left + 1 > 0) {
			System.arraycopy(temp, left, numbers, index, mid - left + 1);				
			System.out.println(" copying " + left + ", " + index + "," + (mid - left + 1));	
		}
		System.out.println(" numbers after = " + Arrays.toString(numbers));

	}
	

	public static final void main(String[] args) {
		MergeSort2 sort = new MergeSort2();
				
		int arr[] = {55,22,11,44,1,119,18,17,16,15};
		System.out.println(Arrays.toString(arr));
		sort.sort(arr);
		System.out.println(Arrays.toString(arr));

	}

}
