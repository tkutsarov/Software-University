package Exam22Jun2014;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P3_ExamScore {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Map<Integer, TreeMap<String,Double>> result = new TreeMap<>();
		Map<String,Double> name = new TreeMap<>();
		
		input.nextLine();
		input.nextLine();
		input.nextLine();
		
		while (true) {
			String[] line = input.nextLine().split("[|\\s]+");
			if (line.length < 2) {
				break;
			}
			
			if (!result.containsKey(Integer.parseInt(line[3]))) {
				result.put(Integer.parseInt(line[3]), new TreeMap<String, Double>());
			}
			result.get(Integer.parseInt(line[3])).put(line[1] + " " + line[2], 
					Double.parseDouble(line[4]));
		}
		
		for (Map.Entry<Integer, TreeMap<String, Double>> e : result.entrySet()) {
			int score = e.getKey();
			TreeMap<String, Double> students = e.getValue();
			System.out.print(score + " -> ");
			System.out.print(e.getValue().keySet() + "; ");
			double gradeSum = 0;
			
			for (Map.Entry<String, Double> s : students.entrySet()) {
				gradeSum += s.getValue();
			}
			
			System.out.printf("avg=%.2f%n", gradeSum/students.size());
		}
	}
}
