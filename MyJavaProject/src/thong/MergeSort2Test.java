package thong;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.Before;

public class MergeSort2Test {

	@Before
	public void setUp() throws Exception {
		
	}


	@Test
	public void test() {
        long startTime = System.currentTimeMillis();
        MergeSort2 sorter = new MergeSort2();
		int arr[] = {55,22,11,44,1,119,18,17,16,15};
		System.out.println(Arrays.toString(arr));

		sorter.sort(arr);
        //Arrays.sort(arr);

        System.out.println("Mergesort " + (System.currentTimeMillis() - startTime));
		System.out.println(Arrays.toString(arr));

		for (int i=0; i < arr.length-1; i++) {
			assertTrue(arr[i] <= arr[i++]);
		}
        		
	}
	
}
