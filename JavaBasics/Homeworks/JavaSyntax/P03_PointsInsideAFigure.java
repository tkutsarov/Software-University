package javaSyntaxHomework;

import java.util.Scanner;

public class P03_PointsInsideAFigure {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String point = input.nextLine();
		while (!point.equals("")) {		
			String[] coords = point.split(" ");
			double posX = Double.parseDouble(coords[0]);
			double posY = Double.parseDouble(coords[1]);
			if (((posX >= 12.5) && (posX <= 22.5) && (posY >= 6) && (posY <= 8.5)) ||
			((posX >= 12.5) && (posX <= 17.5) && (posY >= 8.5) && (posY <= 13.5)) ||
			((posX >= 20) && (posX <= 22.5) && (posY >= 8.5) && (posY <= 13.5))){
				System.out.println("Inside");
			} else {
				System.out.println("Outside");
			}
			point = input.nextLine();
		}
	}			
}
