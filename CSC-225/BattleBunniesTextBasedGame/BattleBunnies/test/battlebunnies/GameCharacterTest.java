/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battlebunnies;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emily
 */
public class GameCharacterTest {
    
    public GameCharacterTest() {
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
     * Test of getName method, of class GameCharacter.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        GameCharacter instance = new GameCharacter();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class GameCharacter.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        GameCharacter instance = new GameCharacter();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getID method, of class GameCharacter.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        GameCharacter instance = new GameCharacter();
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setID method, of class GameCharacter.
     */
    @Test
    public void testSetID() {
        System.out.println("setID");
        int id = 0;
        GameCharacter instance = new GameCharacter();
        instance.setID(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxHP method, of class GameCharacter.
     */
    @Test
    public void testGetMaxHP() {
        System.out.println("getMaxHP");
        GameCharacter instance = new GameCharacter();
        int expResult = 0;
        int result = instance.getMaxHP();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaxHP method, of class GameCharacter.
     */
    @Test
    public void testSetMaxHP() {
        System.out.println("setMaxHP");
        int maxHP = 0;
        GameCharacter instance = new GameCharacter();
        instance.setMaxHP(maxHP);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentHP method, of class GameCharacter.
     */
    @Test
    public void testGetCurrentHP() {
        System.out.println("getCurrentHP");
        GameCharacter instance = new GameCharacter();
        int expResult = 0;
        int result = instance.getCurrentHP();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentHP method, of class GameCharacter.
     */
    @Test
    public void testSetCurrentHP() {
        System.out.println("setCurrentHP");
        int currentHP = 0;
        GameCharacter instance = new GameCharacter();
        instance.setCurrentHP(currentHP);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxMP method, of class GameCharacter.
     */
    @Test
    public void testGetMaxMP() {
        System.out.println("getMaxMP");
        GameCharacter instance = new GameCharacter();
        int expResult = 0;
        int result = instance.getMaxMP();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaxMP method, of class GameCharacter.
     */
    @Test
    public void testSetMaxMP() {
        System.out.println("setMaxMP");
        int maxMP = 0;
        GameCharacter instance = new GameCharacter();
        instance.setMaxMP(maxMP);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentMP method, of class GameCharacter.
     */
    @Test
    public void testGetCurrentMP() {
        System.out.println("getCurrentMP");
        GameCharacter instance = new GameCharacter();
        int expResult = 0;
        int result = instance.getCurrentMP();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentMP method, of class GameCharacter.
     */
    @Test
    public void testSetCurrentMP() {
        System.out.println("setCurrentMP");
        int currentMP = 0;
        GameCharacter instance = new GameCharacter();
        instance.setCurrentMP(currentMP);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeakness method, of class GameCharacter.
     */
    @Test
    public void testGetWeakness() {
        System.out.println("getWeakness");
        GameCharacter instance = new GameCharacter();
        String expResult = "";
        String result = instance.getWeakness();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWeakness method, of class GameCharacter.
     */
    @Test
    public void testSetWeakness() {
        System.out.println("setWeakness");
        String weakness = "";
        GameCharacter instance = new GameCharacter();
        instance.setWeakness(weakness);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBaseDefence method, of class GameCharacter.
     */
    @Test
    public void testGetBaseDefence() {
        System.out.println("getBaseDefence");
        GameCharacter instance = new GameCharacter();
        double expResult = 0.0;
        double result = instance.getBaseDefence();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBaseDefence method, of class GameCharacter.
     */
    @Test
    public void testSetBaseDefence() {
        System.out.println("setBaseDefence");
        double baseDefence = 0.0;
        GameCharacter instance = new GameCharacter();
        instance.setBaseDefence(baseDefence);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCriticalChance method, of class GameCharacter.
     */
    @Test
    public void testGetCriticalChance() {
        System.out.println("getCriticalChance");
        GameCharacter instance = new GameCharacter();
        double expResult = 0.0;
        double result = instance.getCriticalChance();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCriticalChance method, of class GameCharacter.
     */
    @Test
    public void testSetCriticalChance() {
        System.out.println("setCriticalChance");
        double criticalChance = 0.0;
        GameCharacter instance = new GameCharacter();
        instance.setCriticalChance(criticalChance);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxBaseDefence method, of class GameCharacter.
     */
    @Test
    public void testGetMaxBaseDefence() {
        System.out.println("getMaxBaseDefence");
        GameCharacter instance = new GameCharacter();
        double expResult = 0.0;
        double result = instance.getMaxBaseDefence();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaxBaseDefence method, of class GameCharacter.
     */
    @Test
    public void testSetMaxBaseDefence() {
        System.out.println("setMaxBaseDefence");
        double maxBaseDefence = 0.0;
        GameCharacter instance = new GameCharacter();
        instance.setMaxBaseDefence(maxBaseDefence);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxCriticalChance method, of class GameCharacter.
     */
    @Test
    public void testGetMaxCriticalChance() {
        System.out.println("getMaxCriticalChance");
        GameCharacter instance = new GameCharacter();
        double expResult = 0.0;
        double result = instance.getMaxCriticalChance();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaxCriticalChance method, of class GameCharacter.
     */
    @Test
    public void testSetMaxCriticalChance() {
        System.out.println("setMaxCriticalChance");
        double maxCriticalChance = 0.0;
        GameCharacter instance = new GameCharacter();
        instance.setMaxCriticalChance(maxCriticalChance);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBasicAttack method, of class GameCharacter.
     */
    @Test
    public void testGetBasicAttack() {
        System.out.println("getBasicAttack");
        GameCharacter instance = new GameCharacter();
        CharacterAbility expResult = null;
        CharacterAbility result = instance.getBasicAttack();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBasicAttack method, of class GameCharacter.
     */
    @Test
    public void testSetBasicAttack() {
        System.out.println("setBasicAttack");
        CharacterAbility basicAttack = null;
        GameCharacter instance = new GameCharacter();
        instance.setBasicAttack(basicAttack);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSpecialAbility1 method, of class GameCharacter.
     */
    @Test
    public void testGetSpecialAbility1() {
        System.out.println("getSpecialAbility1");
        GameCharacter instance = new GameCharacter();
        CharacterAbility expResult = null;
        CharacterAbility result = instance.getSpecialAbility1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSpecialAbility1 method, of class GameCharacter.
     */
    @Test
    public void testSetSpecialAbility1() {
        System.out.println("setSpecialAbility1");
        CharacterAbility specialAbility1 = null;
        GameCharacter instance = new GameCharacter();
        instance.setSpecialAbility1(specialAbility1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSpecialAbility2 method, of class GameCharacter.
     */
    @Test
    public void testGetSpecialAbility2() {
        System.out.println("getSpecialAbility2");
        GameCharacter instance = new GameCharacter();
        CharacterAbility expResult = null;
        CharacterAbility result = instance.getSpecialAbility2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSpecialAbility2 method, of class GameCharacter.
     */
    @Test
    public void testSetSpecialAbility2() {
        System.out.println("setSpecialAbility2");
        CharacterAbility specialAbility2 = null;
        GameCharacter instance = new GameCharacter();
        instance.setSpecialAbility2(specialAbility2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDamageDealt method, of class GameCharacter.
     */
    @Test
    public void testGetDamageDealt() {
        System.out.println("getDamageDealt");
        GameCharacter instance = new GameCharacter();
        int expResult = 0;
        int result = instance.getDamageDealt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDamageDealt method, of class GameCharacter.
     */
    @Test
    public void testSetDamageDealt() {
        System.out.println("setDamageDealt");
        int damageDealt = 0;
        GameCharacter instance = new GameCharacter();
        instance.setDamageDealt(damageDealt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDamageTaken method, of class GameCharacter.
     */
    @Test
    public void testGetDamageTaken() {
        System.out.println("getDamageTaken");
        GameCharacter instance = new GameCharacter();
        int expResult = 0;
        int result = instance.getDamageTaken();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDamageTaken method, of class GameCharacter.
     */
    @Test
    public void testSetDamageTaken() {
        System.out.println("setDamageTaken");
        int damageTaken = 0;
        GameCharacter instance = new GameCharacter();
        instance.setDamageTaken(damageTaken);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getActionUsed method, of class GameCharacter.
     */
    @Test
    public void testGetActionUsed() {
        System.out.println("getActionUsed");
        GameCharacter instance = new GameCharacter();
        CharacterAbility expResult = null;
        CharacterAbility result = instance.getActionUsed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setActionUsed method, of class GameCharacter.
     */
    @Test
    public void testSetActionUsed() {
        System.out.println("setActionUsed");
        CharacterAbility actionUsed = null;
        GameCharacter instance = new GameCharacter();
        instance.setActionUsed(actionUsed);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of turn method, of class GameCharacter.
     */
    @Test
    public void testTurn() {
        System.out.println("turn");
        GameCharacter target = null;
        GameCharacter instance = new GameCharacter();
        instance.turn(target);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of printCombatFeed method, of class GameCharacter
     */
    @Test
    public void testPrintCombatFeed() {
        System.out.println("printCombatFeed");
        GameCharacter instance = new GameCharacter();
        instance.printCombatFeed();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}