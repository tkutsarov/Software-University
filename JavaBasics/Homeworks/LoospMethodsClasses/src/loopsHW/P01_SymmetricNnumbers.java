package loopsHW;

import java.util.Scanner;

public class P01_SymmetricNnumbers {
	public static void main(String[] args) {		
		Scanner input = new Scanner(System.in);
		int startNum = input.nextInt();
		int endNum = input.nextInt();
		printSymetricNums(startNum, endNum);
	}
	
	public static void printSymetricNums (int start, int end) {
		for (int i = start; i <= end; i++) {
			if (i < 10) {
				System.out.printf("%d ", i);
			} else if ((i > 9) && (i < 100)) {
				if(i % 10 == i/10 % 10) {
					System.out.printf("%d ", i);
				}
			} else {
				if (i % 10 == i/100 % 10) {
					System.out.printf("%d ", i);
				}
			}			
		}
	}	
}
