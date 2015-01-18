package testExam1;

import java.util.Scanner;

public class P3_LargestRectangles {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String inputData = input.nextLine();
		input.close();
		
		inputData = inputData.replace(" ", "");
		inputData = inputData.replace("[", "");		
		String[] arrStrings = inputData.split("]");
		int[] arrInt = new int[arrStrings.length];
		for (int i = 0; i < arrStrings.length; i++) {
			String[] temp = arrStrings[i].split("x");					
			arrInt[i] = Integer.parseInt(temp[0]) * Integer.parseInt(temp[1]);
		}		
		
		int maxSequenceArea = Integer.MIN_VALUE;
		for (int i = 0; i < arrInt.length - 2; i++) {
			int temp = arrInt[i] + arrInt[i + 1] + arrInt[i + 2];
			if (temp > maxSequenceArea) {
				maxSequenceArea = temp;
			}
		}
		
		System.out.println(maxSequenceArea);
	}
}
