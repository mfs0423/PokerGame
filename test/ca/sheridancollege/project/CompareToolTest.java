/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Meng
 */
public class CompareToolTest {
    
    public CompareToolTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of compare method, of class CompareTool.
     */
    @Test
    public void testCompare() {
        System.out.println("compare");
        
        ArrayList<PokerPlayer> players = new ArrayList<PokerPlayer>();
        PokerPlayer p1 = new PokerPlayer("John");
        PokerPlayer p2 = new PokerPlayer("Sally");
        
        ArrayList<PokerCard> cards1 = new ArrayList<>();
        cards1.add(new PokerCard(Suits.Diamond.toString(), CardValues.Six.toString()));
        cards1.add(new PokerCard(Suits.Heart.toString(), CardValues.Eight.toString()));
        cards1.add(new PokerCard(Suits.Heart.toString(), CardValues.Jack.toString()));
        cards1.add(new PokerCard(Suits.Heart.toString(), CardValues.Nine.toString()));
        cards1.add(new PokerCard(Suits.Heart.toString(), CardValues.Ten.toString()));
        
        ArrayList<PokerCard> cards2 = new ArrayList<>();
        cards2.add(new PokerCard(Suits.Heart.toString(), CardValues.Ace.toString()));
        cards2.add(new PokerCard(Suits.Diamond.toString(), CardValues.Eight.toString()));
        cards2.add(new PokerCard(Suits.Diamond.toString(), CardValues.Jack.toString()));
        cards2.add(new PokerCard(Suits.Diamond.toString(), CardValues.Nine.toString()));
        cards2.add(new PokerCard(Suits.Diamond.toString(), CardValues.Ten.toString()));
        
        
        p1.setCards(cards1);
        p2.setCards(cards2);
        
        players.add(p1);
        players.add(p2);
        
        int expResult = 1;
        int result = CompareTool.compare(players);
        System.out.println("result:"+result);
        assertEquals(expResult, result);
    }


        @Test
    public void testCompareFailed() {
        System.out.println("compare");
        
        ArrayList<PokerPlayer> players = new ArrayList<PokerPlayer>();
        PokerPlayer p1 = new PokerPlayer("John");
        PokerPlayer p2 = new PokerPlayer("Sally");
        
        ArrayList<PokerCard> cards1 = new ArrayList<>();
        cards1.add(new PokerCard(Suits.Diamond.toString(), CardValues.Six.toString()));
        
        players.add(p1);
        players.add(p2);
        
        int expResult = 0;
        int result = 1;
        try {
            CompareTool.compare(players);
        } catch (Exception e) {
            result = 0;
        }
        
        System.out.println("result:"+result);
        assertEquals(expResult, result);
    }
    
    
        @Test
    public void testCompareBoundry() {
        System.out.println("compare");
        
        ArrayList<PokerPlayer> players = new ArrayList<PokerPlayer>();
        PokerPlayer p1 = new PokerPlayer("John");
        PokerPlayer p2 = new PokerPlayer("Sally");
        
        ArrayList<PokerCard> cards1 = new ArrayList<>();
        cards1.add(new PokerCard(Suits.Diamond.toString(), CardValues.Six.toString()));
        
        ArrayList<PokerCard> cards2 = new ArrayList<>();
        cards2.add(new PokerCard(Suits.Heart.toString(), CardValues.Ace.toString()));
        
        
        p1.setCards(cards1);
        p2.setCards(cards2);
        
        players.add(p1);
        players.add(p2);
        
        int expResult = 1;
        int result = CompareTool.compare(players);
        System.out.println("result:"+result);
        assertEquals(expResult, result);
    }
}
