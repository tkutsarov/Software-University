package testExam1;

import java.util.Scanner;

public class P2_PythagoreanNumbers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		boolean hasNum = false;
		int numCount = Integer.parseInt(input.nextLine());
		int[] arrPow = new int[numCount];
		for (int i = 0; i < arrPow.length; i++) {
			int temp = input.nextInt();
			arrPow[i] = temp * temp;
		}
		input.close();
		
		for (int i = 0; i < arrPow.length; i++) {
			for (int j = 0; j < arrPow.length; j++) {
				for (int j2 = 0; j2 < arrPow.length; j2++) {
					if ((arrPow[i] + arrPow[j] == arrPow[j2]) && (arrPow[i] <= arrPow[j])) {
						int a = (int)Math.sqrt(arrPow[i]);
						int b = (int)Math.sqrt(arrPow[j]);
						int c = (int)Math.sqrt(arrPow[j2]);
						System.out.printf("%d*%d + %d*%d = %d*%d%n",a,a,b,b,c,c);	
						hasNum = true;
					}
				}				
			}
		}
		
		if ( hasNum == false) {
			System.out.println("No");
		}
	}
}
