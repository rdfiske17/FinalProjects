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
public class CharacterAbilityTest {
    
    public CharacterAbilityTest() {
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
     * Test of getName method, of class CharacterAbility.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        CharacterAbility instance = new CharacterAbility();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class CharacterAbility.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        CharacterAbility instance = new CharacterAbility();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class CharacterAbility.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        CharacterAbility instance = new CharacterAbility();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class CharacterAbility.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        CharacterAbility instance = new CharacterAbility();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAttackType method, of class CharacterAbility.
     */
    @Test
    public void testGetAttackType() {
        System.out.println("getAttackType");
        CharacterAbility instance = new CharacterAbility();
        String expResult = "";
        String result = instance.getAttackType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAttackType method, of class CharacterAbility.
     */
    @Test
    public void testSetAttackType() {
        System.out.println("setAttackType");
        String attackType = "";
        CharacterAbility instance = new CharacterAbility();
        instance.setAttackType(attackType);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBaseDamage method, of class CharacterAbility.
     */
    @Test
    public void testGetBaseDamage() {
        System.out.println("getBaseDamage");
        CharacterAbility instance = new CharacterAbility();
        int expResult = 0;
        int result = instance.getBaseDamage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBaseDamage method, of class CharacterAbility.
     */
    @Test
    public void testSetBaseDamage() {
        System.out.println("setBaseDamage");
        int baseDamage = 0;
        CharacterAbility instance = new CharacterAbility();
        instance.setBaseDamage(baseDamage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMPRequired method, of class CharacterAbility.
     */
    @Test
    public void testGetMPRequired() {
        System.out.println("getMPRequired");
        CharacterAbility instance = new CharacterAbility();
        int expResult = 0;
        int result = instance.getMPRequired();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMPRequired method, of class CharacterAbility.
     */
    @Test
    public void testSetMPRequired() {
        System.out.println("setMPRequired");
        int MPRequired = 0;
        CharacterAbility instance = new CharacterAbility();
        instance.setMPRequired(MPRequired);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}