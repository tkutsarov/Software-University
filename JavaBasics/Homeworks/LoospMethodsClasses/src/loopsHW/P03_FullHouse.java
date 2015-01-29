package loopsHW;

public class P03_FullHouse {
	public static void main(String[] args) {
		String[] cards = new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10",
				"J", "Q", "K", "A"};
		String[] suits = new String[] {"\u2663", "\u2666", "\u2665", "\u2660"};		
		printFullHouse(cards, suits);
	}
	
	public static void printFullHouse(String[] cards, String[] suits){
		int count = 0;		
		// first loop will go over all cards and be used to print the three of a kind
		for (int trips = 0; trips < cards.length; trips++) {
			// the second loop will be used to print the pair to complete the full house
			for (int pairs = 0; pairs < cards.length; pairs++) {
				// if the card forming the trips and that forming the pair are the same,
				// skip this part of the loop. You can not have 5 times the same card.
				if (trips == pairs) {
					continue;
				}
				// 5 loops to get every possible suit of the three of a kind and the pair.
				// Each loop is for one of the cards. First three for the three of a kind,
				// which is why each next for loop starts with the previous integer + 1;
				for (int suit1 = 0; suit1 < suits.length; suit1++) {
					for (int suit2 = suit1 + 1; suit2 < suits.length; suit2++) {						
						for (int suit3 = suit2 + 1; suit3 < suits.length; suit3++) {
							// last two loops are for the pair. Same logic as above
							for (int suit4 = 0; suit4 < suits.length; suit4++) {
								for (int suit5 = suit4 + 1; suit5 < suits.length; suit5++) {
									System.out.printf("(%s%s %s%s %s%s %s%s %s%s)%n",
											cards[trips], suits[suit1],
											cards[trips], suits[suit2],
											cards[trips], suits[suit3],
											cards[pairs], suits[suit4],
											cards[pairs], suits[suit5]);
									count++;
								}
							}
						}
					}
				}
			}
		}		
		System.out.println(count + " full houses");
	}
}
