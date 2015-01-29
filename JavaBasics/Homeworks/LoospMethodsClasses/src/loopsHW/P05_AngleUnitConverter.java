package loopsHW;

import java.util.Scanner;

public class P05_AngleUnitConverter {
	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		int lines = Integer.parseInt(input.nextLine());
		
		for (int i = 1; i <= lines; i++) {
			String[] line = input.nextLine().split(" ");
			if (line[1].equals("deg")) {				
				System.out.printf("%.6f rad%n", convertDegToRadian(Integer.parseInt(line[0])));
			} else {
				System.out.printf("%.6f deg%n", convertRadToDegrees(Integer.parseInt(line[0])));
			}
		}
	}
	
	public static double convertDegToRadian(int degrees) {		
		return (degrees * Math.PI) / 180;
	}
	
	public static double convertRadToDegrees(int radians) {
		return (radians * 180) / Math.PI;
	}
}
