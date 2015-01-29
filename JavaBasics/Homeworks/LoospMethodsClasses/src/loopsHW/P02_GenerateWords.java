package loopsHW;

import java.util.Scanner;;

public class P02_GenerateWords {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] letters = input.nextLine().split("");
		printWords(letters);
	}
	
	public static void printWords(String[] letters) {
		for (int i1 = 0; i1 < letters.length; i1++) {
			for (int i2 = 0; i2 < letters.length; i2++) {
				for (int i3 = 0; i3 < letters.length; i3++) {
					System.out.print(letters[i1] + letters[i2] + letters[i3] + " ");
				}
			}
		}
	}
}
