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
public class PokerPlayer extends Player{
	private double money;
	private ArrayList<PokerCard> cards;
	private int handLevel;

    public PokerPlayer(String name) {
        super(name);
        money = 3000.0;
        cards = new ArrayList<>();
    }

    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	public int getHandLevel() {
		return handLevel;
	}

	public void setHandLevel(int handLevel) {
		this.handLevel = handLevel;
	}

	public ArrayList<PokerCard> getCards() {
		return cards;
	}

	public void setCards(ArrayList<PokerCard> cards) {
		this.cards = cards;
	}

	public double getMoney() {
		return money;
	}

	public void addMoney(double money) {
		this.money += money;
	}
	public void payMoney(double money) {
		this.money -= money;
	}
    
    public void showInfo(){
    	System.out.print("< "+this.getPlayerID()+" balance:"+this.getMoney()+">  ");
    }
}
