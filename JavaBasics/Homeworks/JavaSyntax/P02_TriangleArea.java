package javaSyntaxHomework;

import java.util.Scanner;

public class P02_TriangleArea {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] points = new int[6];
		int count = 0;
		for (int i = 1; i <= 3; i++) {			
			String[] point = input.nextLine().split(" ");
			points[count] = Integer.parseInt(point[0]);
			points[count + 1] = Integer.parseInt(point[1]);
			count += 2;
		}
		
		int triangArea = (points[0]*(points[3] - points[5]) + 
				points[2]*(points[5] - points[1]) + 
				points[4]*(points[1] - points[3])) / 2;
		System.out.println(Math.abs(triangArea));
	}
}
