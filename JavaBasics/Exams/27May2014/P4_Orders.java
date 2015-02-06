
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;


public class P4_Orders {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Map<String, TreeMap<String,Integer>> output = new HashMap<>();		
		int lines = Integer.parseInt(input.nextLine());
		List<String> inputOrder = new ArrayList<String>();
		
		for (int i = 0; i < lines; i++) {
			String[] line = input.nextLine().trim().split(" ");
			if (!inputOrder.contains(line[2])) {
				inputOrder.add(line[2]);
			}
			
			TreeMap<String,Integer> customer = new TreeMap<>();
			if (output.containsKey(line[2])) {
				customer.putAll(output.get(line[2]));
				if (customer.containsKey(line[0])) {
					customer.put(line[0], Integer.parseInt(line[1]) + customer.get(line[0]));
				} else {
					customer.put(line[0], Integer.parseInt(line[1]));
				}
				output.put(line[2], customer);
			} else {
				customer.put(line[0], Integer.parseInt(line[1]));
				output.put(line[2], customer);
			}			
		}
		
		List<String> result = new ArrayList<String>();
		for (Map.Entry<String, TreeMap<String,Integer>> e : output.entrySet()) {
			TreeMap<String,Integer> customer = new TreeMap<>();
			String outputLine = "";
			customer = e.getValue();
			outputLine += e.getKey() + ": ";
			for (Map.Entry<String,Integer> person : customer.entrySet()) {
				outputLine += person.getKey() + " " + person.getValue() + ", ";
			}
			outputLine = outputLine.substring(0, outputLine.length() - 2);						
			result.add(outputLine);
		}
		
		for (String product : inputOrder) {
			for (String prod : result) {
				String[] temp = prod.split(":");
				if (product.equals(temp[0])) {
					System.out.println(prod);
					break;
				}
			}
		}
	}
}
