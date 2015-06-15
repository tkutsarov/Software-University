package game.packmen;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Maze {
	ArrayList<String> lines;
	Integer row, column;
	Integer rows, columns;
	Integer width, height;
	int maxScore = 0;
	Integer supermenR, supermenC;
	int[] ghostPositions = new int[8];
	public Maze() {
		Integer ghostCounter = 0;
		try {
			Scanner scan = new Scanner(new File("maze.txt"));
			lines = new ArrayList<String>();
			
			Integer startRow = 0;
			while (scan.hasNextLine()) {
				String singleLine = scan.nextLine();
				if (singleLine.contains("P")) {
					row = startRow;
					column = singleLine.indexOf('P');
				}
				
				if (singleLine.contains("G")) {
					ghostPositions[ghostCounter] = startRow;
					ghostPositions[ghostCounter + 1] = singleLine.indexOf("G");
					
					ghostCounter+=2;
				}
				
				if (singleLine.contains("2") || singleLine.contains("3")) {
					for (int i = 0; i < singleLine.length(); i++) {
						if (singleLine.charAt(i) == '2') {
							maxScore += 10;
						} else if (singleLine.charAt(i) == '3') {
							maxScore += 50;
						}
					}
				}
				
				startRow++;
				lines.add(singleLine);				
			}
			
			scan.close();
			
			rows = lines.size();
			columns = lines.get(0).length();
			
			height = lines.size() * 2;
			width = lines.get(0).length() * 2;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public char charAt(int r, int c) {
		return lines.get(r).charAt(c);
	}

	public char[][] getCells() {
		char[][] cells = new char[rows][columns];
		for (int r = 0; r < rows; r++) {
			System.arraycopy(lines.get(r).toCharArray(), 0, cells[r], 0, columns);
		}
		return cells;
	}
}
