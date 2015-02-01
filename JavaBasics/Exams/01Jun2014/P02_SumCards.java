package Exam01Jun2014;


import java.util.Scanner;

public class P02_SumCards {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String [] cardsWithSuit = input.nextLine().split(" ");
		String [] hand = new String[cardsWithSuit.length];
		for (int i = 0; i < cardsWithSuit.length; i++) {
			hand[i] = cardsWithSuit[i].substring(0, cardsWithSuit[i].length() - 1);
		}
				
		int nextCard = 0;
		int card = getCardValue(hand[0]);
		int sum = 0;
		int tempSum = 0;
		if (hand.length == 1) {
			System.out.println(getCardValue(hand[0]));	
		} else {
			for (int i = 1; i < hand.length; i++) {		
				nextCard = getCardValue(hand[i]);
				if (card == nextCard) {	
					if (i == hand.length - 1) {
						tempSum += card * 2;
					} else {
						tempSum += card;
					}									
				} else {				
					if (tempSum != 0) {
						if (i == hand.length - 1) {
							tempSum += nextCard;
						}
						tempSum += card;
						sum += tempSum * 2;
						tempSum = 0;
					} else {
						if (i == hand.length - 1) {
							sum += nextCard;
						}
						sum += card;
					}
				}
				
				if ((tempSum != 0) && (i == hand.length - 1)) {
					sum += tempSum * 2;
				}
				card = nextCard;			
			}
			
			System.out.println(sum);	
		}			
	}
	
	public static int getCardValue(String cardStr) {
		int card = 0;
		switch (cardStr) {			
		case "2": card = 2; break;
		case "3": card = 3; break;
		case "4": card = 4; break;
		case "5": card = 5; break;
		case "6": card = 6; break;
		case "7": card = 7; break;
		case "8": card = 8; break;
		case "9": card = 9; break;
		case "10": card = 10; break;
		case "J": card = 12; break;
		case "Q": card = 13; break;
		case "K": card = 14; break;
		case "A": card = 15; break;						
		default: System.out.println("Check the switch!!!");
			break;
		}
		
		return card;
	}
}
