package javaSyntaxHomework;

import java.util.Scanner;

public class P07_CountOfBitsOne {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int intNum = input.nextInt();
		int count = 0;
		while (intNum > 0) {
			int mask = intNum & 1;
			if (mask == 1) {
				count++;
			}
			intNum = intNum >> 1;
		}
		System.out.println(count);
	}	
}
