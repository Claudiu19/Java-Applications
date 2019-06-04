package lab7;

import java.util.*;

public class Bag {
	private final Queue<Character> letters = new LinkedList<>();
    public Bag() { 
    	for(char ch = 'a';ch<='z';ch++)
    	{
    		letters.add(ch);
    	}
    }
    
    public synchronized List<Character> extractLetters(int howMany) {
        List<Character> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) break;
            extracted.add(letters.poll());
        }
        return extracted;
    }
    
    public Queue<Character> getLetters()
    {
    	return letters;
    }
}
