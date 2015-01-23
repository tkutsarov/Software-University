package javaSyntaxHomework;

import java.util.Scanner;

public class P06_FormattingNumbers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the first number:");
		int firstNum = Integer.parseInt(input.nextLine());
		System.out.println("Enter the second number:");
		double secondNum = Double.parseDouble(input.nextLine());
		System.out.println("Enter the third number:");
		double thirdNum = Double.parseDouble(input.nextLine());
		System.out.printf("|%-10s|%010d|%10.2f|%-10.3f|", 
				Integer.toHexString(firstNum).toUpperCase(), 
				Integer.parseInt(Integer.toBinaryString(firstNum)),
				secondNum, thirdNum);
	}
}
