package testExam1;

import java.util.HashMap;
import java.util.Scanner;

public class P4_CouplesFrequency {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String couples = input.nextLine();
		input.close();
		String[] arrSingles = couples.split(" ");
		HashMap<String, Integer> couplesMap = new HashMap<String, Integer>();
		
		int count = 0;
		
		for (int i = 0; i < arrSingles.length - 1; i++) {
			String couple = arrSingles[i] + " " + arrSingles[i + 1];
			if (couplesMap.containsKey(couple)) {
				couplesMap.put(couple, couplesMap.get(couple) + 1);	
			} else {
				couplesMap.put(couple, 1);	
			}				
			count++;
		}						
				
		for (int i = 0; i < arrSingles.length - 1; i++) {
			String key = arrSingles[i] + " " + arrSingles[i + 1];			
			if (couplesMap.containsKey(key)) {
				float percentage = ((float)(Integer)couplesMap.get(key)/count) * 100;			
				System.out.printf("%s -> %.2f%%%n", key, percentage);
				couplesMap.remove(key);				
			}						
		}
	}
}
