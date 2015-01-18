import java.util.Scanner;


public class P2_AddingAngles {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int anglesCount = Integer.parseInt(input.nextLine());
		String[] inputAngles = input.nextLine().split(" ");
		input.close();
		int[] angles = new int[inputAngles.length];
		boolean hasCircle = false;
		
		for (int i = 0; i < inputAngles.length; i++) {
			angles[i] = Integer.parseInt(inputAngles[i]);
		}
		
		for (int i = 0; i < angles.length - 2; i++) {
			for (int j = i + 1; j < angles.length - 1; j++) {
				for (int j2 = j + 1; j2 < angles.length; j2++) {
					int circle = angles[i] + angles[j] + angles[j2];
					if (circle % 360 == 0) {
						System.out.printf("%d + %d + %d = %d degrees%n", 
								angles[i], angles[j], angles[j2], circle);
						hasCircle = true;
					}
				}
			}
		}
		
		if (hasCircle == false) {
			System.out.println("No");
		}
	}
}
