package thong;

import java.util.Arrays;

public class FlipWords {
	private char[] string;
	
	public FlipWords(String s) {
		string = s.toCharArray();
	}

	/** 
	 * Flip string array using from index to to-index
	 * @param from
	 * @param to
	 */
	private void flip(int from, int to) {
	    System.out.println("flipChars: " + from +"," + to);
	    
	    char temp;
	    int j = to;
	    for (int i=from; (float) i < (float) from + ((to+1-from)/2); i++) {
	      temp = string[i];
	      string[i] = string[j];
	      string[j--] = temp;   
	      System.out.println(i + ": " + Arrays.toString(string));
	    }    
	  }
	
	
	public void flipWords() {
		// 1. Flip all the characters in the array
	    flip(0,  string.length-1);
	    
	    // 2. Flip each words in the array
	    int start = 0, end = 1;
	    while (end < string.length) {
	      System.out.println(start + ", " + end);
	      if (string[end] != ' ') {
	        end++;
	        continue;
	      }

	      // Here we found end char of word, so flip them
	      flip(start, end-1);
	      // Now, skip spaces until the next word
	      start=end;
	      while (string[start] == ' ') {
	        start++;
	        end = start+1;
	        continue;
	      }
	    }
	    // Flip the last word
	    flip(start, end-1);
	}
	
	public static void main(String[] args) {
		FlipWords fw = new FlipWords("Hello   my dear friends");
		fw.flipWords();
	}
}
