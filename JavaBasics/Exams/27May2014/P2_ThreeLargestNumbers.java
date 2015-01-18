import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class P2_ThreeLargestNumbers {
	public static void main(String[] args) {		
		Scanner input = new Scanner(System.in);
		int numCount = Integer.parseInt(input.nextLine());
		BigDecimal[] nums = new BigDecimal[numCount];
		for (int i = 0; i < numCount; i++) {
			nums[i] = new BigDecimal(input.nextLine());
		}
			
		Arrays.sort(nums);
		System.out.println(nums[numCount - 1].toPlainString());
		if (numCount > 1) {
			System.out.println(nums[numCount - 2].toPlainString());
		}
		if (numCount > 2) {
			System.out.println(nums[numCount - 3].toPlainString());
		}		
	}
}
