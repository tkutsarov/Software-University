import java.util.Scanner;

public class P3_BigggestPrimeNums {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String strNumsRaw = input.nextLine();
		input.close();
		String[] strNums = strNumsRaw.split("[( )]+");
		
		int[] intNums = new int[strNums.length];
		for (int i = 0; i < strNums.length; i++) {
			if (strNums[i].equals("")) {				
				continue;
			}
			intNums[i] = Integer.parseInt(strNums[i]);
			if (intNums[i] <= 0) {
				intNums[i] = 1;
			}
			if (intNums[i] != 1) {
				boolean isPrime = isPrime(intNums[i]);
				if ( isPrime == false) {
					intNums[i] = 1;
				}
			}
		}
		
		int biggestSum = 0;
		boolean isFound = false;
		for (int i = 0; i < intNums.length - 2; i++) {
			for (int j = i + 1; j < intNums.length - 1; j++) {
				for (int j2 = j + 1; j2 < intNums.length; j2++) {
					if ((intNums[i] == 1) || (intNums[j] == 1) || (intNums[j2] == 1) ||
							(intNums[i] == 0) || (intNums[j] == 0) || (intNums[j2] == 0)) {
						continue;
					}
					if ((intNums[i] != intNums[j]) && (intNums[j] != intNums[j2]) &&
							(intNums[i] != intNums[j2])) {
						int sum = intNums[i] + intNums[j] + intNums[j2];
						if (sum > biggestSum ) {
							biggestSum = sum;									
						}
						isFound = true;
					}
				}
			}
		}
		
		if (isFound == true) {
			System.out.println(biggestSum);			
		} else {
			System.out.println("No");
		} 	
	}
	
	public static boolean isPrime(int num) {		
		for (int i = 2; i <= (int)Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;		
	}
}
