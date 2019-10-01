/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;


/**
 *
 * @author Meng
 */
public class PokerGame extends Game{

    public PokerGame(String givenName) {
        super(givenName);
    }

    @Override
    public void play(){
    	System.out.println(">> Welcome to "+super.getGameName()+"! <<");
    	Rounds rounds = new Rounds();
		rounds.beginning();
		Tools.printRules();
    	int gameNum = 1;
    	while(true){
    		Rounds.cards = Rounds.getNewGroupOfCards();
    		Rounds.cards.shuffle();
        	System.out.println(">> Poker Game "+gameNum+++" starts now ! <<");

    		if(rounds.roundOne()==null){
    			PokerPlayer player = getOnlyOnePlayer();
    			System.out.println("There is only one person own at least $500. ");
    			declareWinner();
    			System.out.print(player.getPlayerID()+", and own $"+player.getMoney()+".");
    		}
    		ArrayList<PokerPlayer> players = rounds.nextRound();
    		
    		if(players==null)break;
    	
    		int winner = CompareTool.compare(players);
    		players.get(winner).addMoney(MoneyPool.getMoneyPool());
    		MoneyPool.setInMoneyPool(0);
            for(PokerPlayer player : players){
            	player.showInfo();
            }
    		System.out.println("");
    		if(players!=null){
    			declareWinner();
    			System.out.print(players.get(winner).getPlayerID());
    		}
    		System.out.println("");
    		System.out.println(">>--------------------------------------<<");
    		System.out.println("Are you ready for "+super.getGameName()+"?" );
    		System.out.println("Let's go !" );
    		System.out.println(">>--------------------------------------<<");
    	}
    }
    private PokerPlayer getOnlyOnePlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    public void declareWinner() {
        System.out.print("The winner is :");
    }
    
}
