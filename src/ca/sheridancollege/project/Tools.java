package ca.sheridancollege.project;

public class Tools {
    public static void printRules(){
    	System.out.println("");
    	System.out.println(">> Rules : <<");
    	System.out.println("1) Everyone starts off with $3000.");	
    	System.out.println("2) In the first round, everyone must place a mandatory $50 and gets 2 cards (1 face up/1 face down).");
    	System.out.println("3) If you decide to a 3rd face up card, you have to place $100 or you can withdraw from the hand and lose your previous bet.");
    	System.out.println("4) Remaining players can then decide to get a 4th face up card but will need to place a bet of $150. If you decide not to proceed, you lose your previous bets.");
    	System.out.println("5) Remaining players can then decide to get a 5th face up card but will need to place a bet of $200. If you decide not to proceed, you lose your previous bets.");
    	System.out.println("6) If the remaining players decide to proceed with their 5 cards, they will need to place a bet of $250. If you decide not to proceed with your hand, you lose your previous bets.");
    	System.out.println("7) The remaining players will then reveal their face down card. Highest hand will collect the pot.");
    	System.out.println("** If there are no players that want to proceed before they get 5 cards, the last player who decides to proceed will collect the pot.");
    	System.out.println("** The last player standing with money will be the winner.");
    	System.out.println("** If you do not have enough money to bet through 5 rounds ($500), you are forced to lose the game and you will exit the game with the remaining money, thus, the minimum amount of money you need to play the game is $500.");
    	System.out.println("** If players forget knowledge of poker hand rankings, please input k");
    	System.out.println("");
    }
    public static void printRanking(){
    	System.out.println("");
    	System.out.println("1. Royal flush : A, K, Q, J, 10, all the same suit");
    	System.out.println("2. Straight flush : Five cards in a sequence, all in the same suit.");
    	System.out.println("3. Four of a kind : All four cards of the same rank.");
    	System.out.println("4. Full house : Three of a kind with a pair.");
    	System.out.println("5. Flush : Any five cards of the same suit, but not in a sequence.");
    	System.out.println("6. Straight : Five cards in a sequence, but not of the same suit.");
    	System.out.println("7. Three of a kind : Three cards of the same rank.");
    	System.out.println("8. Two pair : Two different pairs.");
    	System.out.println("9. Pair : Two cards of the same rank.");
    	System.out.println("10. High Card : When you haven't made any of the hands above, the highest card plays.");
    	System.out.println("");
    }
}
