/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battlebunnies;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Unit Tests for the the main method and the static methods bellow it.
 * @author emily
 */
public class BattleBunniesTest {
    
    public BattleBunniesTest() {
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
     * Test of main method, of class BattleBunnies.
     */
    @Test
    public void testMain() {
        
    }

    /**
     * When the attacker uses "Heal" their HP is increased and their MP is decreased the correct amount.
     */
    @Test 
    public void damageCalculation_attackerUsesHeal_attackerHPIncreases() 
    {
        GameCharacter testAttacker = new GameCharacter("Test",0,100,50,20,20,"Test",0,0,0,0,new CharacterAbility("Heal","Test","Support",20,5),new CharacterAbility(),new CharacterAbility(), 0,0, new CharacterAbility("Heal","Test","Support",20,5));
        GameCharacter testDefender = new GameCharacter();
        
        BattleBunnies.damageCalculation(testAttacker, testDefender);
        int expectedHP = 70;
        int expectedMP = 15;
        assertEquals(expectedHP,testAttacker.getCurrentHP());
        assertEquals(expectedMP, testAttacker.getCurrentMP());
    }
    
    /**
     * When the attacker uses "Heal" but their HP is at 100, they are not healed.
     */
    @Test 
    public void damageCalculation_attackerUsesHealOn100HP_attackerHPDoesNotIncrease() 
    {
        GameCharacter testAttacker = new GameCharacter("Test",0,100,100,20,20,"Test",0,0,0,0,new CharacterAbility("Heal","Test","Support",20,5),new CharacterAbility(),new CharacterAbility(), 0,0, new CharacterAbility("Heal","Test","Support",20,5));
        GameCharacter testDefender = new GameCharacter();
        
        BattleBunnies.damageCalculation(testAttacker, testDefender);
        int expectedHP = 100;
        int expectedMP = 15;
        assertEquals(expectedHP,testAttacker.getCurrentHP());
        assertEquals(expectedMP, testAttacker.getCurrentMP());
    }
    
    /**
     * When the attacker uses "Lucky" their crit chance is set to 1 (or 100%).
     */
    @Test 
    public void damageCalculation_attackerUsesLucky_attackerCritChanceIncreases()
    {
        GameCharacter testAttacker = new GameCharacter("Test",0,100,100,20,20,"Test",0,0,0,1,new CharacterAbility("Lucky","Test","Support",0,10),new CharacterAbility(),new CharacterAbility(), 0,0, new CharacterAbility("Lucky","Test","Support",0,10));
        GameCharacter testDefender = new GameCharacter();
        
        BattleBunnies.damageCalculation(testAttacker, testDefender);
        int expectedCritChance = 1;
        int expectedDefence = 2;
        int expectedMP = 10;
        assertEquals(expectedCritChance,testAttacker.getCriticalChance(),0.15);
        assertEquals(expectedDefence, testAttacker.getBaseDefence(),0.15);
        assertEquals(expectedMP, testAttacker.getCurrentMP());
    }
    
    /**
     * When the attacker uses "Iron Wall" their defence is set to 0.5 (or doubled).
     */
    @Test 
    public void damageCalculation_attackerUsesIronWall_attackerdefenceDoubles()
    {
        GameCharacter testAttacker = new GameCharacter("Test",0,100,100,20,20,"Test",1,1,0,1,new CharacterAbility("Iron Wall","Test","Support",0,10),new CharacterAbility(),new CharacterAbility(), 0,0, new CharacterAbility("Iron Wall","Test","Support",0,10));
        GameCharacter testDefender = new GameCharacter();
        
        BattleBunnies.damageCalculation(testAttacker, testDefender);
        double expectedDefence = 0.5;
        int expectedMP = 10;
        assertEquals(expectedDefence,testAttacker.getBaseDefence(),0.15);
        assertEquals(expectedMP, testAttacker.getCurrentMP());
    }
    
    /**
     * When the attacker uses "Color Swap" their weakness is changed at random. 
     * There is no need to test each individual case because we only need to test 
     * that it changes to something within expected boundaries. We used a simple 
     * boolean test for this.
     */
    @Test 
    public void damageCalculation_attackerUsesColorSwap_attackerWeaknessChanges()
    {
        GameCharacter testAttacker = new GameCharacter("Test",0,100,100,20,20,"Test",0,0,0,0,new CharacterAbility("Color Swap","Test","Support",0,10),new CharacterAbility(),new CharacterAbility(), 0,0, new CharacterAbility("Color Swap","Test","Support",0,10));
        GameCharacter testDefender = new GameCharacter();
        
        BattleBunnies.damageCalculation(testAttacker, testDefender);
        
        int expectedMP = 10;
        boolean weaknessChanged = false;
        if (testAttacker.getWeakness().equals("Fire") || testAttacker.getWeakness().equals("Water") || testAttacker.getWeakness().equals("Air") || testAttacker.getWeakness().equals("Earth") || testAttacker.getWeakness().equals("Physical"))
        {
            weaknessChanged = true;
        }
        
        assertTrue(weaknessChanged);
        assertEquals(expectedMP, testAttacker.getCurrentMP());
    }
    
    /**
     * When the attacker uses an attack that the defender is weak to, the defender 
     * takes double damage. 
     */
    @Test
    public void damageCalculation_defenderIsWeakToAttacker_DefenderTakesDoubleDamage()
    {
        GameCharacter testAttacker = new GameCharacter("Test",0,100,100,20,20,"Test",0,0,0,0,new CharacterAbility("Test","Test","Fire",10,5),new CharacterAbility(),new CharacterAbility(), 0,0, new CharacterAbility("Test","Test","Fire",10,5));
        GameCharacter testDefender = new GameCharacter("Test",0,100,100,20,20,"Fire",1,1,0,0,new CharacterAbility(),new CharacterAbility(),new CharacterAbility(), 0,0, new CharacterAbility());
      
        BattleBunnies.damageCalculation(testAttacker, testDefender);

        int expectedMP = 15;
        int expectedHP = 80;
        

        assertEquals(expectedHP, testDefender.getCurrentHP());
        assertEquals(expectedMP, testAttacker.getCurrentMP());  
    }
    
    /**
     * When the attacker uses an attack on the defender, the defender will take 
     * damage. 
     */
    @Test
    public void damageCalculation_defenderIsNotWeakToAttacker_DefenderTakesBaseDamage()
    {
        GameCharacter testAttacker = new GameCharacter("Test",0,100,100,20,20,"Test",0,0,0,0,new CharacterAbility("Test","Test","Test",10,5),new CharacterAbility(),new CharacterAbility(), 0,0, new CharacterAbility("Test","Test","Test",10,5));
        GameCharacter testDefender = new GameCharacter("Test",0,100,100,20,20,"Fire",1,1,0,0,new CharacterAbility(),new CharacterAbility(),new CharacterAbility(), 0,0, new CharacterAbility());
        
        BattleBunnies.damageCalculation(testAttacker, testDefender);
        
        int expectedMP = 15;
        int expectedHP = 90;
        
        assertEquals(expectedHP, testDefender.getCurrentHP());
        assertEquals(expectedMP, testAttacker.getCurrentMP());
    }
}    