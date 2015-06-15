package game.packmen;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import org.game.engine.Game;
import org.game.engine.GameApplication;

public class Packman extends Game {
	BufferedImage ciberPacman, mazeImage, ghosts;
	Integer frames;
	Integer rows, columns;
	Integer charCurrRow, charCurrCol;
	Integer direction, desiredDirection;
	Boolean status;
	int score, maxScore;
	Integer resetDelay;
	Integer alreadyDead;
	Boolean blockGhosts;
	Integer[] gDirection = { 39, 37, 38, 40 };
	int[] ghostsPositions;
	ArrayList<String> lines = new ArrayList<String>();
	ArrayList<Integer> path = new ArrayList<Integer>();
	char[][] pills;
	Maze maze = new Maze();
	static final Integer PACMAN_STEP = 2;
	static int finalScore;
	
	public Packman() { // Main window constructor
		title = "Packman Parallel Universe"; // Setting window title and
		blockGhosts = false;									// dimensions
		frames = 0;
		direction = desiredDirection = KeyEvent.VK_LEFT; // Setting character
															// initial position 									// and direction
		lines = maze.lines;
		pills = maze.getCells();
		charCurrRow = maze.row; // Character initial position
		charCurrCol = maze.column;
		maxScore = maze.maxScore;
		status = false;
		ghostsPositions = maze.ghostPositions;
		rows = maze.rows; // Maze size
		columns = maze.columns;
		width = maze.width + 100; // Windows dimensions
		height = maze.height;
		
		score = 0;
		resetDelay = 0;
		
		
		try {
			ciberPacman = ImageIO.read(new File("images/RedPacman.png")); 
			ghosts = ImageIO.read(new File("images/Ghosts.png"));
			mazeImage = ImageIO.read(new File("images/maze.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		GameApplication.start(new Packman());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() >= 37 && e.getKeyCode() <= 40) { // Allowing only
															// arrow keys
			desiredDirection = e.getKeyCode();
		}
	}

	@Override
	public void update() {		
		frames++;
		resetDelay++;

		if (frames >= 8) {
			frames = 0;
		}

		if (resetDelay >= 200) {
			delay = 30;
			blockGhosts = false;
		}
		
		if (!blockGhosts) {
			allowedDirs();
		}
			
		
		if (moveChar(desiredDirection) == 1) {
			direction = desiredDirection;
		} else {
			moveChar(direction);
		}
		
		isDead();
		
		if (pills[charCurrRow][charCurrCol] == '2') {
			score += 10;
			pills[charCurrRow][charCurrCol] = '1';
		} else if (pills[charCurrRow][charCurrCol] == '3') {
			pills[charCurrRow][charCurrCol] = '1';
			score += 50;
			delay = 15;
			blockGhosts = true;
			resetDelay = 0;
		}
	}

	public void allowedDirs() {
		Integer ghost = 0;
		for (int i = 0; i < ghostsPositions.length; i += 2) {
			if (ghostsPositions[i + 1] != 0
					&& (maze.charAt(ghostsPositions[i], ghostsPositions[i + 1]) != '1')
					&& (maze.charAt(ghostsPositions[i], ghostsPositions[i + 1]) != 'G')) {
				gDirection[ghost] = new Random().nextInt(4) + 37;
			}

			switch (gDirection[ghost]) {
			case 37:// Going Left
				if (ghostsPositions[i + 1] - 1 != 0
						&& (maze.charAt(ghostsPositions[i],
								ghostsPositions[i + 1] - 1) != '0')) {
					ghostsPositions[i + 1] -= 1;
				} else if (ghostsPositions[i + 1] - 1 == 0
						&& maze.charAt(ghostsPositions[i], columns - 1) != '0') {
					ghostsPositions[i + 1] = columns - 1;
				}
				break;
			case 38:// Going UP
				if (ghostsPositions[i] - 1 != 0
						&& (maze.charAt(ghostsPositions[i] - 1,
								ghostsPositions[i + 1]) != '0')) {
					ghostsPositions[i] -= 1;
				}
				break;
			case 39:// Going Right
				if (ghostsPositions[i + 1] + 1 < maze.columns
						&& (maze.charAt(ghostsPositions[i],
								ghostsPositions[i + 1] + 1) != '0')) {
					ghostsPositions[i + 1] += 1;
				} else if ((ghostsPositions[i + 1] + 1 >= columns && maze
						.charAt(ghostsPositions[i], 0) != '0')) {
					ghostsPositions[i + 1] = 0;
				}
				break;
			case 40:
				if (ghostsPositions[i] + 1 < maze.rows
						&& (maze.charAt(ghostsPositions[i] + 1,
								ghostsPositions[i + 1]) != '0')) {
					ghostsPositions[i] += 1;
				}
			default:
				break;
			}

			ghost++;
		}
	}

	public int moveChar(int newDirection) {
		switch (newDirection) {
		case KeyEvent.VK_LEFT: {
			if (charCurrCol - 1 <= 0
					&& maze.charAt(charCurrRow, columns - 1) != '0') {
				charCurrCol = columns - 1;

				return 1;
			} else if (maze.charAt(charCurrRow, charCurrCol - 1) != '0') {
				charCurrCol -= 1; // keyCharCode = 37

				return 1;
			}

			return -1;
		}
		case KeyEvent.VK_RIGHT: {
			if ((charCurrCol + 1 >= lines.get(charCurrRow).length() && maze
					.charAt(charCurrRow, 0) != '0')) {
				charCurrCol = 0;

				return 1;
			} else if (maze.charAt(charCurrRow, charCurrCol + 1) != '0') {
				charCurrCol += 1; // keyCharCode = 39

				return 1;
			}

			return -1;
		}
		case KeyEvent.VK_UP: {
			if (maze.charAt(charCurrRow - 1, charCurrCol) != '0') {
				charCurrRow -= 1; // keyCharCode = 38

				return 1;
			}

			return -1;
		}
		case KeyEvent.VK_DOWN: {
			if (maze.charAt(charCurrRow + 1, charCurrCol) != '0') {
				charCurrRow += 1; // keyCharCode = 40

				return 1;
			}

			return -1;
		}
		}		
		
		return -1;
	}

	public void isDead(){
		for (int i = 0; i < ghostsPositions.length; i+=2) {
			if (ghostsPositions[i] == charCurrRow && ghostsPositions[i + 1] == charCurrCol) {
				status = true;
			}
		}
	}
	@Override
	public void draw(Graphics2D g) {
		
		if (score != maxScore && !status) {
			g.drawImage(mazeImage, 0, 0, null);
			g.setColor(Color.WHITE);
			for (int r = 0; r < maze.rows; r++) {
				for (int c = 0; c < maze.columns; c++) {
					if (pills[r][c] == '2') {
						// draw pill
						g.fillOval(c * PACMAN_STEP - 15, r * PACMAN_STEP - 8, 5, 5);
					} else if (pills[r][c] == '3') {
						// draw power pill
						g.fillOval(c * PACMAN_STEP - 18, r * PACMAN_STEP - 10, 15, 15);
					}
				}
			}
			g.drawImage(ciberPacman.getSubimage((frames / 4) * 15,
					(direction - 37) * 34, 40, 34), charCurrCol * PACMAN_STEP - 20,
					charCurrRow * PACMAN_STEP - 17, null);
	
			for (int go = 0; go < ghostsPositions.length; go += 2) {
				g.drawImage(ghosts.getSubimage(0 + (go * 20), 0, 40, 35),
						ghostsPositions[go + 1] * PACMAN_STEP - 20,
						ghostsPositions[go] * PACMAN_STEP - 17, null);
			}
	
			g.setColor(Color.PINK);
			g.fillRect(width - 100, 0, 100, height);
			g.setColor(Color.WHITE);
			g.fillRect(width - 95, 5, 90, height - 10);
			g.setColor(Color.BLACK);
			g.drawString("SCORE: ", width - 90, 20);
			g.drawString(score + "", width - 90, 40);
		} else if (score == maxScore) {
			g.setColor(Color.DARK_GRAY);
			g.fillRect(0, 0, width, height);
			g.setColor(Color.WHITE);
			g.drawString("YOU WON!", width / 2 - 50, height / 2 - 50);
			g.drawString("SCORE: " + score, width / 2 - 50, height / 2);
		} else if (status) {
			finalScore = score;			
			g.setColor(Color.DARK_GRAY);
			g.fillRect(0, 0, width, height);
			g.setColor(Color.WHITE);
			g.drawString("YOU ARE DEAD", width / 2 - 50, height / 2 - 50);
			g.drawString("SCORE: " + finalScore, width / 2, height / 2);
		}
	}
}
