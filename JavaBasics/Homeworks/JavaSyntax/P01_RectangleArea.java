package javaSyntaxHomework;

import java.util.Scanner;

public class P01_RectangleArea {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] areaSides = input.nextLine().split(" ");
		int rectArea = Integer.parseInt(areaSides[0]) * Integer.parseInt(areaSides[1]);
		System.out.println(rectArea);
	}
}
