import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P4_ActivityTracker {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int lines = Integer.parseInt(input.nextLine());	
		TreeMap<Integer, TreeMap<String, Integer>>  activityByMonth = 
				new TreeMap<Integer, TreeMap<String, Integer>>();
		for (int i = 0; i < lines; i++) {
			String inputLine = input.nextLine();
			String[] lineArr = inputLine.split(" ");
			String[] date = lineArr[0].split("/");
			Integer month = Integer.parseInt(date[1]);
			TreeMap<String, Integer> user = new TreeMap<String, Integer>();			
			if (!activityByMonth.containsKey(month)) {
				user.put(lineArr[1], Integer.parseInt(lineArr[2]));
				activityByMonth.put(month, user);
			} else {
				user = activityByMonth.get(month);
				if (!user.containsKey(lineArr[1])) {
					user.put(lineArr[1], Integer.parseInt(lineArr[2]));
				} else {
					user.put(lineArr[1], user.get(lineArr[1]) + Integer.parseInt(lineArr[2]));
				}
				
				activityByMonth.put(month, user);
			}
		}
		
		for(Map.Entry<Integer,TreeMap<String,Integer>> entry : activityByMonth.entrySet()) {
			  Integer month = entry.getKey();
			  TreeMap<String, Integer> user = entry.getValue();
			  String nameOutput = month + ": ";
		  
			  for (Map.Entry<String,Integer> name : user.entrySet()) {
				  nameOutput += name.getKey() + "(" + name.getValue() + "), ";
			  }
			  nameOutput = nameOutput.substring(0, nameOutput.length() - 2);
			  System.out.println(nameOutput);
		}
	}
}
