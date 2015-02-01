package Exam01Jun2014;

import java.util.Scanner;

public class P01_StuckNumbers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numCount = input.nextInt();
		int[] nums = new int[numCount];
		for (int i = 0; i < numCount; i++) {
			nums[i] = input.nextInt();
		}
		boolean isFound = false;
		
		for (int i = 0; i < nums.length; i++) {
			for (int i2 = 0; i2 < nums.length; i2++) {
				for (int j = 0; j < nums.length; j++) {
					for (int j2 = 0; j2 < nums.length; j2++) {
						String firstNum = "" + nums[i] + nums[i2];
						String secondNum = "" + nums[j] + nums[j2];
						
						if ((firstNum.equals(secondNum) && (nums[i] != nums[i2])) &&
								(nums[i2] != nums[j]) && (nums[j] != nums[j2]) &&							
								(nums[i] != nums[j]) && (nums[i] != nums[j2]) &&								
								(nums[i2] != nums[j2])){
							System.out.printf("%d|%d==%d|%d%n", nums[i], nums[i2],
									nums[j], nums[j2]);
							isFound = true;
						}
					}
				}
			}
		}
		
		if (!isFound) {
			System.out.println("No");
		}
	}
}
