package testExam1;

import java.util.Scanner;

public class P1_VideoDurations {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String inputData = input.nextLine();
		int hours = 0;
		int minutes = 0;
		while(!inputData.equals("End")){						
			String[] parts = inputData.split(":");
			hours += Integer.parseInt(parts[0]);			
			minutes += Integer.parseInt(parts[1]);
			inputData = input.nextLine();;
		}
		input.close();
		
		hours += minutes / 60;
		minutes = minutes % 60;
		if (minutes < 10) {
			System.out.format("%d:0%d", hours,minutes);
		} else {
			System.out.format("%d:%d", hours,minutes);	
		}			
	}	
}
