package javaSyntaxHomework;

import java.util.Scanner;

public class P08_CountOfEqualBitParts {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int intNum = input.nextInt();
		int count = 0;
		while (intNum > 0) {
			int mask = intNum & 1;
			intNum = intNum >> 1;
			if (mask == (intNum & 1)) {
				count++;
			}
		}
		System.out.println(count);
	}
}

