package Exam01Jun2014;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P4_LogsAggregator {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int rows = Integer.parseInt(input.nextLine());
		TreeMap<String, TreeMap<String, Integer>> output = new TreeMap();
		
		for (int i = 0; i < rows; i++) {
			String [] line = input.nextLine().split(" ");
			TreeMap<String, Integer> outputValue = new TreeMap();
			if (!output.containsKey(line[1])) {
				outputValue.put(line[0], Integer.parseInt(line[2]));
				output.put(line[1], outputValue);
			} else {
				outputValue = output.get(line[1]);
				if (!outputValue.containsKey(line[0])) {
					outputValue.put(line[0], Integer.parseInt(line[2]));
				} else {
					outputValue.put(line[0], Integer.parseInt(line[2]) + outputValue.get(line[0]));
				}
			}
			
		}
		
		for (Map.Entry<String, TreeMap<String, Integer>> e : output.entrySet()) {
			String user = e.getKey();
			TreeMap<String, Integer> data = e.getValue();
			String ip = "[";
			int timePerUser = 0;
			for (Map.Entry<String, Integer> e2 : data.entrySet()) {
				ip = ip + e2.getKey() + ", ";
				timePerUser += e2.getValue();
			}
			ip = ip.substring(0, ip.length() - 2);
			ip = ip + "]";
			
			System.out.println(user + ": " + timePerUser + " " + ip );
		}
	}
}
