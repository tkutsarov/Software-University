package javaSyntaxHomework;

import java.util.Scanner;

public class P05_DecimalToHexadecimal {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println(Integer.toHexString(Integer.parseInt(input.nextLine())).toUpperCase());
	}
}
