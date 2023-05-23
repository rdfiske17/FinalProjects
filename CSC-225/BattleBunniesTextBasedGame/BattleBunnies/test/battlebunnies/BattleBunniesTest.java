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
 *
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
        System.out.println("main");
        String[] args = null;
        BattleBunnies.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of damageCalulation method, of class BattleBunnies.
     */
    //test heal
    //test lucky
    //test earth wall
    //test color swap
    //test revive
    //test weak damage
    //test not weak damage
    @Test
    public void damageCalculation_attackerUsesHeal_attackerHPIncreases() 
    {
        
    }
    
    @Test
    public void damageCalculation_attackerUsesLucky_attackerCritChanceIncreases()
    {
        
    }
    
    @Test
    public void damageCalculation_attackerUsesEarthWall_attackerdefenceDoubles()
    {
        
    }
    
    @Test
    public void damageCalculation_attackerUsesColorSwap_attackerWeaknessChanges()
    {
        
    }
    
    @Test
    public void damageCalculation_attackerUsesRevive_attackerHealedTo50HP()
    {
        
    }
    
    @Test
    public void damageCalculation_defenderIsWeakToAttacker_DefenderTakesDoubleDamage()
    {
        
    }
    
    @Test
    public void damageCalculation_defenderIsNotWeakToAttacker_DefenderTakesBaseDamage()
    {
        
    }

}    