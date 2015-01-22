import java.util.Scanner;

public class P3_LongestOddEvenSequence {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String inputNums = input.nextLine();		
		String[] stringNums = inputNums.replaceFirst("^[( )]+","").split("[( )]+");
		int[] intNums = new int[stringNums.length];
		for (int i = 0; i < stringNums.length; i++) {
			intNums[i] = Integer.parseInt(stringNums[i]);
		}
		
		int maxCount = 1;
		int count = 1;
		boolean isEven = (intNums[0] % 2 == 0) ? true : false;
		for (int i = 1; i < intNums.length; i++) {		
			if(intNums[i] == 0){
				if (isEven == true) {
					isEven = false;
				} else {
					isEven = true;
				}
				count++;
			} else if (intNums[i] % 2 == 0) {
				if (isEven == false)  {						
					count++;
					isEven = true;
				} else {
					count = 1;
				}
			} else {
				if (isEven == true) {				
					count++;
					isEven = false;
				} else {
					count = 1;
				}
			}
			
			if (count > maxCount) {
				maxCount = count;
			}
		}
		
		System.out.println(maxCount);
	}
}
