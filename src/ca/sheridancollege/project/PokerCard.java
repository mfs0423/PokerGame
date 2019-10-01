/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 *
 * @author Meng
 */
public class PokerCard extends Card implements Comparable<PokerCard>{
    private String suit;
    private String value;
    
    public PokerCard(String suit, String value){
        this.suit = suit;
        this.value = value;
    }
    
    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return "| " +suit+" "+value+" ";
    }

	@Override
	public int compareTo(PokerCard c) {
		return cardValueNum(this) - cardValueNum(c);
	}
    public int cardValueNum(PokerCard c){
		switch(c.getValue()){
			case "Two": return 2; 
			case "Three": return 3; 
			case "Four": return 4; 
			case "Five": return 5;
			case "Six": return 6; 
			case "Seven": return 7; 
			case "Eight": return 8; 
			case "Nine": return 9;
			case "Ten": return 10; 
			case "Jack": return 11; 
			case "Queen": return 12; 
			case "King": return 13; 
			case "Ace": return 14; 
			default: return 0;
		}
    }
}
