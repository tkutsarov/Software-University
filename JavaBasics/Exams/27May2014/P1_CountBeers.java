import java.util.Scanner;

public class P1_CountBeers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String line= input.nextLine();
		int beers = 0;
		while (!line.equals("End")) {
			String[] temp = line.split(" ");
			if (temp[1].equals("stacks")) {
				beers += Integer.parseInt(temp[0]) * 20;
			} else {
				beers += Integer.parseInt(temp[0]);
			}
			line = input.nextLine();
		}
		
		System.out.printf("%d stacks + %d beers", beers / 20, beers % 20);
	}
}
