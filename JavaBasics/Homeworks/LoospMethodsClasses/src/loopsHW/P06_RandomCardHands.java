package loopsHW;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.sun.org.apache.bcel.internal.generic.IFNULL;

public class P06_RandomCardHands {
	public static void main(String[] args) {
		// create the deck of 52 cards
		String[] cards = new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10",
				"J", "Q", "K", "A"};
		String[] suits = new String[] {"\u2663", "\u2666", "\u2665", "\u2660"};		
		String[] deck = new String[52];
		int count = 0;
		for (int card = 0; card < cards.length; card++) {
			for (int suit = 0; suit < suits.length; suit++) {
				deck[count] = cards[card] + suits[suit];
				count++;
			}
		}
		
		Random rand = new Random();
		Scanner input = new Scanner(System.in);
		int combinations = input.nextInt();
		List<String> hand = new ArrayList<String>();
		// use random generator to store an entire hand of 5 cards in a list and print them
		for (int i = 1; i <= combinations; i++) {
			while (hand.size() < 5) {
				String card = deck[rand.nextInt(deck.length)];
				if (!hand.contains(card)) {
					hand.add(card);
				}
			}	
			for (String element : hand) {
				System.out.print(element + " ");
			}
			hand.clear();
			System.out.println();
		}	
	}
}
