package Exam22Jun2014;

import java.util.Scanner;

public class P2_Durts {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String [] figCoords = input.nextLine().split(" ");
		int r = Integer.parseInt(input.nextLine());
		int n = Integer.parseInt(input.nextLine());
		int[] dartCoords = new int[n * 2];
		for (int i = 0; i < dartCoords.length; i++) {
			dartCoords[i] = input.nextInt();
		}
		
//		for (int i : dartCoords) {
//			System.out.println(i);
//		}
		
		int posX = Integer.parseInt(figCoords[0]);
		int posY = Integer.parseInt(figCoords[1]);
				
		for (int i = 0; i < dartCoords.length - 1; i+=2) {
			if ((dartCoords[i] < posX - r) || (dartCoords[i] > posX + r) ||
			(dartCoords[i + 1] < posY - r) || (dartCoords[i + 1] > posY + r) || 
			(((dartCoords[i] > posX + r/2) || (dartCoords[i] < posX - r/2)) &&			
			((dartCoords[i + 1] > posY + r/2) || (dartCoords[i + 1] < posY - r/2)))) {				
					System.out.println("no");				
			} else {
				System.out.println("yes");
			}
		}
	}
}
