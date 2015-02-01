package Exam01Jun2014;

import java.math.BigDecimal;
import java.util.Scanner;

public class P3_SimpleExpression {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String expression = input.nextLine().replace(" ", "");
		String[] numbers = expression.split("(\\+)|(\\-)");
		int count = 1;
		
		BigDecimal result = new BigDecimal(numbers[0]);
		
		for (int i = 0; i < expression.length(); i++) {			
			char temp = expression.charAt(i);
			if (temp == '+') {
				BigDecimal num = new BigDecimal(numbers[count]);
				result = result.add(num);
				count++;
			} 
			
			if (temp == '-') {
				BigDecimal num = new BigDecimal(numbers[count]);
				result = result.subtract(num);
				count++;
			}
		}
		System.out.println(result);
	}
}
