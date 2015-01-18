import java.util.Scanner;

public class P1_DozensOfEggs {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);		
		int eggs = 0;
		for (int i = 0; i < 7; i++) {
			String[] temp = input.nextLine().split(" ");
			if (temp[1].equals("dozens")) {
				eggs += Integer.parseInt(temp[0]) * 12;
			} else {
				eggs += Integer.parseInt(temp[0]);
			}
		}
		input.close();	
		System.out.printf("%d dozens + %d eggs", eggs/12, eggs % 12);		
	}
}
