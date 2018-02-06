package thong;

import java.util.ArrayList;
import java.util.List;

public class LineJustifier {
	
	static public String createNString(String s, int n) {
		StringBuffer outputBuffer = new StringBuffer(n);
		for (int i = 0; i < n; i++) {
			outputBuffer.append(s);
		}
		return outputBuffer.toString();
	}

	private static void addToJustifiedLines(int maxWidth, List<String> lines, List<String> line) {
		int allStringLength =  String.join("", line).length();
		int padLen = maxWidth - allStringLength;
		if (line.size() == 1) {
			lines.add(line.get(0));
			return;
		}
		int avgPadLen = padLen / (line.size() - 1);
		int totalLength = allStringLength + (avgPadLen * (line.size() - 1));
		int firstExtraPadLength = maxWidth - totalLength;
		StringBuffer outputBuffer = new StringBuffer(maxWidth);
		boolean first = true;
		String spaces = createNString(" ", avgPadLen + firstExtraPadLength);
		for (String word : line) {
			if (first) {
				outputBuffer.append(word);
				first = false;	
			}
			else {
				outputBuffer.append(spaces + word);	
				spaces = createNString(" ", avgPadLen);
			}
		}
		
		lines.add(outputBuffer.toString());
	}
	
    static public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<String>();
        int lineLen = 0;
    	List<String> line = new ArrayList<String>();

    	int i=0;
    	int lastWordIdx = words.length -1;
        for (String word : words) {
        	if (i == lastWordIdx && lineLen + word.length() <= maxWidth) {
                line.add(word);
                lineLen += word.length() ;
        	}
        	else if (lineLen + word.length() + 1 <= maxWidth) {
                line.add(word);
                lineLen += word.length() + 1; // at least 1 space
            }
            else {            	
            	addToJustifiedLines(maxWidth, lines, line);
            	// Start a new line
            	line =  new ArrayList<String>();
            	line.add(word);
            	lineLen = word.length();
            }
            i++;
        }
        if (lineLen > 0) {
        	addToJustifiedLines(maxWidth, lines, line);
        }

        return lines;
    }


    
    public static final void main(String[] args) {
    	String[] words =  "This is an example of text justification".split(" ");
    	for (int length = 15; length <= 40; length++) {
        	for (String line: fullJustify(words, length)) {
        		System.out.println(line + ":" + line.length());
        	}    		
    	}

    }

}
