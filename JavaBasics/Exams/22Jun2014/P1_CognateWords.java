package Exam22Jun2014;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class P1_CognateWords {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String inputLine = input.nextLine();
		String[] words = inputLine.split("[^a-zA-Z]+");
		boolean isFound = false;
		
		HashMap<String,String> concWords = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			for (int i2 = 0; i2 < words.length; i2++) {
				for (int j = 0; j < words.length; j++) {
					String concatWord = words[i] + words[i2];
					if ((concatWord.equals(words[j])) && (!concWords.containsKey(words[j]))) {
						concWords.put(words[j], words[i] + "|" + words[i2]);					
						isFound = true;
					}
				}
			}
		}
		
		if (!isFound) {
			System.out.println("No");
		} else {
			for (Entry<String, String> e : concWords.entrySet()) {
				System.out.println(e.getValue() + "=" + e.getKey());
			}
		}		
	}
}
