package loopsHW;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class P08_SumNumsFromTextFile {
	public static void main(String[] args) throws IOException {
		try {
			BufferedReader in = new BufferedReader(new FileReader("src/loopsHW/test.txt"));
			String line;
			int sum = 0;
			while ((line = in.readLine()) != null) {
				sum += Integer.parseInt(line);				
			}
			System.out.println(sum);
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error");
		}
		
		
	}
}
