package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *	This class is a Compare Tool which is to compare players hand cards
 * @author Meng
 */

public class CompareTool {

	/**
	 *	This method is main comparing method, return winner's index number
	 *  First compare ranking level, then compare card value
	 */
    public static int compare(ArrayList<PokerPlayer> players) {
        ArrayList<PokerPlayer> sameLevelPlayers = new ArrayList<>();
        if (players.size() == 1) {
            return 0;
        }
        for (int i = 0; i < players.size(); i++) {
            System.out.println("Level" + level(players.get(i).getCards()));
            players.get(i).setHandLevel(level(players.get(i).getCards()));
        }
        boolean sameLevel = false;
        int winnerLevel = players.get(0).getHandLevel();
        int winner = 0;
        for (int i = 1; i < players.size(); i++) {
            if (players.get(i).getHandLevel() < winnerLevel) {
                winnerLevel = players.get(1).getHandLevel();
                winner = i;
            }
        }

        sameLevelPlayers.add(players.get(winner));
        for (int i = 1; i < players.size(); i++) {
            if (players.get(i).getHandLevel() == winnerLevel) {
                sameLevelPlayers.add(players.get(i));
                System.out.println("same level");
                sameLevel = true;
            }
        }
        if (sameLevel) {
            for (int i = 0; i < sameLevelPlayers.size(); i++) {
                Collections.sort(sameLevelPlayers.get(i).getCards());
            }

            if (winnerLevel == 3 || winnerLevel == 4 || winnerLevel == 7
                    || winnerLevel == 8 || winnerLevel == 9) {
                switch (winnerLevel) {
                    case 3:
                        winner = compareLevelThree(sameLevelPlayers);
                        break;
                    case 4:
                        winner = compareLevelFour(sameLevelPlayers);
                        break;
                    case 7:
                        winner = compareLevelSeven(sameLevelPlayers);
                        break;
                    case 8:
                        winner = compareLevelEight(sameLevelPlayers);
                        break;
                    case 9:
                        winner = compareLevelNine(sameLevelPlayers);
                        break;
                }
            } else {
                for (PokerPlayer player : sameLevelPlayers) {
                    if (player
                            .getCards()
                            .get(player.getCards().size()-1)
                            .compareTo(
                                    players.get(winner)
                                            .getCards()
                                            .get(players.get(winner).getCards()
                                                    .size()-1)) > 0) {
                        winner = players.indexOf(player);
                    }
                }
            }
        }

        return winner;
    }

	/**
	 * This method is to compare level 3
	 */
    public static int compareLevelThree(ArrayList<PokerPlayer> players) {
        ArrayList<PokerCard> playersCardsArrayList = new ArrayList<>();
        for (PokerPlayer player : players) {
            if (player.getCards().get(0) == player.getCards().get(1)) {
                playersCardsArrayList.add(player.getCards().get(0));
            } else {
                playersCardsArrayList.add(player.getCards().get(1));
            }
        }
        int index = 0;
        for (int i = 1; i < playersCardsArrayList.size(); i++) {
            if ((playersCardsArrayList.get(i).compareTo(playersCardsArrayList.get(index)) > 0)) {
                index = i;
            }
        }
        return players.indexOf(playersCardsArrayList.get(index));
    }
	/**
	 * This method is to compare level 4
	 */
    public static int compareLevelFour(ArrayList<PokerPlayer> players) {
        ArrayList<PokerCard> playersCardsArrayList = new ArrayList<>();
        for (PokerPlayer player : players) {
            for (int i = 0; i < players.size(); i++) {

            }
        }
        return 0;
    }
	/**
	 * This method is to compare level 7
	 */
    public static int compareLevelSeven(ArrayList<PokerPlayer> players) {
        return 0;
    }
	/**
	 * This method is to compare level 8
	 */
    public static int compareLevelEight(ArrayList<PokerPlayer> players) {
        return 0;
    }
	/**
	 * This method is to compare level 9
	 */
    public static int compareLevelNine(ArrayList<PokerPlayer> players) {
        return 0;
    }
	/**
	 * This method is to get hand cards' ranking level 
	 */
    public static int level(ArrayList<PokerCard> cards) {
        Collections.sort(cards);
        boolean suitSame = true;
        boolean sequence = true;
        boolean royalFlush = true;
        boolean sameRank = false;
        boolean fullHouse = false;

        ArrayList<Integer> threeKindsNum = new ArrayList<>();
        int sameRankTimes = 1;
        int sameRankTime2 = 0;
        for (int i = 1; i < cards.size(); i++) {
            if (!cards.get(i).getSuit().equals(cards.get(i - 1).getSuit())) {
                suitSame = false;
            }
            if (cards.get(i).cardValueNum(cards.get(i)) != (cards.get(i - 1)
                    .cardValueNum(cards.get(i - 1)) + 1)) {
                sequence = false;
            }
            if (!cards.get(0).getValue().equals("A")) {
                royalFlush = false;
            }
            if (cards.get(i).getValue().equals(cards.get(i - 1).getValue())) {
                sameRankTimes += 1;
                if ((cards.size() == 5 && sameRankTimes == 4)
                        || (cards.size() < 5 && sameRankTimes == cards.size())) {
                    sameRank = true;
                }
            }
            if (cards.size() == 5
                    && cards.get(i).getValue()
                            .equals(cards.get(i - 1).getValue())) {
                sameRankTime2 += 1;
                if (sameRankTime2 == 3) {
                    fullHouse = true;
                }
                threeKindsNum.add(i);
            }
        }
        // same suit
        if (suitSame) {
            // same sequence
            if (sequence) {
                // royal Flush
                if (royalFlush) {
                    return 1;
                } else {
                    return 2;
                }
            }
            return 5;
        }
        if (sameRank) {
            return 3;
        }
        if (fullHouse) {
            return 4;
        }
        if (sequence) {
            return 6;
        }
        if (threeKindsNum.size() == 2) {
            if (threeKindsNum.get(1) == threeKindsNum.get(0) + 1) {
                return 7;
            } else {
                return 8;
            }
        }
        if (threeKindsNum.size() == 1) {
            return 9;
        }

        return 10;
    }
}
