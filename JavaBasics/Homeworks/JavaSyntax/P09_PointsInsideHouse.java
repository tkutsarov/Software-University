package javaSyntaxHomework;

import java.util.Scanner;

public class P09_PointsInsideHouse {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String point = input.nextLine();
		String[] pointCoords = point.split(" ");
		double posX = Double.parseDouble(pointCoords[0]);
		double posY = Double.parseDouble(pointCoords[1]);
		
		// Use the link provided with Problem 9. from the homework.
		// position = sign( (Bx-Ax)*(Y-Ay) - (By-Ay)*(X-Ax) )
		// point A(Ax, Ay) and point B(Bx, By) are given in the drawing so we know
		// their coordinates x and y. X and Y refer to the coordinates of the point that 
		// has been entered from the console.
		// Calculating the positions of the points compared to the triangle sides forming the roof.
		// positionLeft compares the posX and posY with the left roof side /if the result is
		// negative, then the point is to the left of the roof, 0 means on the roof and positive
		// if the point is to the right/.
		// positionRight does the same for the right side of the roof.
		// If a point is inside the roof /triangle/ or on it, then positionLeft has to be
		// 0 or positive, positionRight has to be 0 or negative and the posY coord of the
		// point has to be less than the bottom of the roof. That is the third part of the if
		// below. The first two parts are for the rectangles forming the house.
		
		double positionLeft = (17.5 - 12.5) * (posY - 8.5) - (3.5 - 8.5) * (posX - 12.5);
		double positionRight = (17.5 - 22.5) * (posY - 8.5) - (3.5 - 8.5) * (posX - 22.5);
		
		if (((posX >= 12.5) && (posX <= 17.5) && (posY >= 8.5) && (posY <= 13.5)) ||
		((posX >= 20) && (posX <= 22.5) && (posY >= 8.5) && (posY <= 13.5)) ||
		((positionLeft >= 0) && (positionRight <= 0) && (posY <= 8.5))) {
			System.out.println("Inside");
		} else{
			System.out.println("Outside");
		}
	}
}
