package loopsHW;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class P07_DaysBetweenDates {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date startDate = formatter.parse(input.nextLine());
			Date endDate = formatter.parse(input.nextLine());
			long difference = endDate.getTime() - startDate.getTime();
			System.out.println(TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS));
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}		
	}	
}
