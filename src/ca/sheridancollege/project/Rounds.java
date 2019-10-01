package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

public class Rounds {

    public static GroupOfCards cards;
    private static ArrayList<PokerPlayer> players;
    private static PokerGame game;

    static {
        game = new PokerGame("PokerGame");
    }

    public void beginning() {
        Scanner scan = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("How many players are there?");
                int numPlayers = Integer.valueOf(scan.nextLine());
                if (numPlayers < 2) {
                    System.out.println("The number of players should be at least 2.");
                } else {
                    players = new ArrayList<>();
                    for (int i = 0; i < numPlayers; i++) {
                        System.out.println("No." + (i + 1) + " player, please input your name :");
                        String name = scan.nextLine();
                        players.add(new PokerPlayer(name));
                    }
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String roundOne() {
        ArrayList<Integer> deletePlayers = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            double money = players.get(i).getMoney();
            if (money < 500) {
                deletePlayers.add(i);
                System.out.println("Sorry " + players.get(i).getPlayerID() + ", you do not have at least $500, so you cannot join this game.");
                System.out.println(players.get(i).getPlayerID() + " left the game...");
            }
            players.get(i).payMoney(50.0);
            MoneyPool.addInMoneyPool(50.0);
        }
        for (int i = 0; i < deletePlayers.size(); i++) {
            players.remove(deletePlayers.get(i));
        }

        if (players.size() == 1) {
            return null;
        }
        System.out.println(">> First Round : <<");

        for (PokerPlayer player : players) {
            player.showInfo();
        }
        System.out.println("");
        for (int i = 0; i < players.size(); i++) {
            players.get(i).getCards().add(cards.showCards().get(0));
            cards.showCards().remove(0);
            players.get(i).getCards().add(cards.showCards().get(0));
            System.out.println(">> " + players.get(i).getPlayerID() + ": " + "SecertCard : " + players.get(i).getCards().get(1));
            cards.showCards().remove(0);
        }
        state();
        System.out.println("-------------------------------------------");
        return "";
    }

    public PokerPlayer getOnlyOnePlayer() {
        return players.get(0);
    }

    public ArrayList<PokerPlayer> nextRound() {
        for (int i = 2; i <= 4; i++) {
            if (players.size() >= 2) {
//				System.out.println(i);
                switch (i) {
                    case 2:
                        System.out.println(">> Second Round : <<");
                        break;
                    case 3:
                        System.out.println(">> Third Round : <<");
                        break;
                    case 4:
                        System.out.println(">> Final Round : <<");
                        break;
                }
                for (int l = 0; l < players.size(); l++) {
                    double money = players.get(l).getMoney();
                    players.get(l).payMoney(50 * i);
                    MoneyPool.addInMoneyPool(50 * i);
                }
                for (PokerPlayer player : players) {
                    player.showInfo();
                }
                System.out.println("");

                for (int j = 0; j < players.size(); j++) {
                    players.get(j).getCards().add(cards.showCards().get(0));
                    if (i < 4) {

                        System.out.println(">> " + players.get(j).getPlayerID() + ": " + "SecertCard," + players.get(j).getCards().get(1) + ","
                                + ((players.get(j).getCards().size() >= 3) ? players.get(j).getCards().get(2) : "") + ","
                                + ((players.get(j).getCards().size() >= 4) ? players.get(j).getCards().get(3) : "") + ","
                                + ((players.get(j).getCards().size() >= 5) ? players.get(j).getCards().get(4) : ""));

                    } else {
                        System.out.println(">> " + players.get(j).getPlayerID() + ": "
                                + players.get(j).getCards().get(0) + ","
                                + players.get(j).getCards().get(1) + ","
                                + players.get(j).getCards().get(2) + ","
                                + players.get(j).getCards().get(3) + ","
                                + players.get(j).getCards().get(4));
                    }
                    cards.showCards().remove(0);
                }
                if (i < 4) {
                    state();
                }
            } else {
                System.out.println("");
                players.get(0).addMoney(MoneyPool.getMoneyPool());
                MoneyPool.setInMoneyPool(0);
                System.out.println("There is only one person left. ");
                players.get(0).showInfo();
                System.out.println("");
                game.declareWinner();
                System.out.println(players.get(0).getPlayerID());
                return null;
            }
            System.out.println("");
            System.out.println("-------------------------------------------");
        }
        return players;
    }

    public void state() {
        Scanner scan = new Scanner(System.in);
        ArrayList<PokerPlayer> remove = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            while (true) {
                System.out.println(players.get(i).getPlayerID() + ", continue press 1, quit press 2, check hand rankings press anyother key :");
                String state = scan.nextLine();
                if (state.equals("1")) {
                    System.out.println("Good luck " + players.get(i).getPlayerID() + " !");
                    break;
                } else if (state.equals("2")) {
                    System.out.println("Bye " + players.get(i).getPlayerID() + "!");
                    remove.add(players.get(i));
                    break;
                } else {
                    Tools.printRanking();
                }
            }

        }
        for (PokerPlayer s : remove) {
            players.remove(players.indexOf(s));
        }
    }

    public static GroupOfCards getNewGroupOfCards() {
        cards = new GroupOfCards(52);
        cards.addCards(new ArrayList<PokerCard>());
        for (Suits suit : Suits.values()) {
            for (CardValues value : CardValues.values()) {
                cards.showCards().add(new PokerCard(suit.toString(), value.toString()));
            }
        }
        return cards;
    }
}
