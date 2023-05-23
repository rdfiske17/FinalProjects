package battlebunnies;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
public class BossTest {
    
    /**
     * This chunk of code at the start comes from StackOverflow: https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println.
     * Its used to test the expected result with what is being printed to the console.
     */
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
    
    public BossTest() {
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
     * 
     */
    @Test
    public void turn_BossHasOneTargetAnd3Moves_BossUses1MoveOn1Target() 
    {
        Boss testBoss = new Boss("Test",10,10,10,"Test",0,0,0,0,new CharacterAbility("Test1","","",0,0),new CharacterAbility("Test2","","",0,0),new CharacterAbility("Test3","","",0,0));
        GameCharacter testTarget = new GameCharacter("TestTarget");
        testBoss.turn(testTarget, testTarget, testTarget);
        
        boolean moveUsed = false;
        if (testBoss.getActionUsed().getName().equals("Test1")||testBoss.getActionUsed().getName().equals("Test2")||testBoss.getActionUsed().getName().equals("Test3"))
        {
            moveUsed = true;
        }
        assertTrue(moveUsed);
    }
    
    /**
     * 
     */
    @Test
    public void turn_BossHas3TargetAnd1Move_BossUses1MoveOn1Target()
    {
        Boss testBoss = new Boss("Test",10,10,10,"Test",0,0,0,0,new CharacterAbility("Test1","","",10,1),new CharacterAbility("Test2","","",10,1),new CharacterAbility("Test3","","",10,1));
        GameCharacter testTarget = new GameCharacter("TestTarget",10,10,10,"Test",0,0,0,0,new CharacterAbility("Test1","","",0,0),new CharacterAbility("Test2","","",0,0),new CharacterAbility("Test3","","",0,0));
        GameCharacter testTarget2 = new GameCharacter("TestTarget2",10,10,10,"Test",0,0,0,0,new CharacterAbility("Test1","","",0,0),new CharacterAbility("Test2","","",0,0),new CharacterAbility("Test3","","",0,0));
        GameCharacter testTarget3 = new GameCharacter("TestTarget3",10,10,10,"Test",0,0,0,0,new CharacterAbility("Test1","","",0,0),new CharacterAbility("Test2","","",0,0),new CharacterAbility("Test3","","",0,0));
        testBoss.turn(testTarget, testTarget2, testTarget3);
        
        System.out.println(testTarget.getCurrentHP() + testTarget2.getCurrentHP() + testTarget3.getCurrentHP());
        boolean targetSelected = false;
        if(testBoss.getCurrentMP()==11)
        {
            targetSelected = true;
        }
        assertTrue(targetSelected);
    }

    /**
     * When the boss uses heal, the expected text is printed.
     */
    @Test
    public void printCombatFeed_abilityUsedHeal_healTextPrinted() 
    {
        Boss testCharacter = new Boss("testCharacter",new CharacterAbility("Heal","","Support",20,10));
        testCharacter.printCombatFeed();
        String expectedResult = "---------------------------------------------------------------------------------" + "\ntestCharacter used Heal and healed for 20 HP.\n";
        assertEquals(expectedResult, outContent.toString());
    }
    
    /**
     * When the boss uses Lucky, the expected text is printed.
     */
    @Test
    public void printCombatFeed_abilityUsedLucky_luckyTextPrinted()
    {
        Boss testCharacter = new Boss("testCharacter",new CharacterAbility("Lucky","","Support",20,10));
        testCharacter.printCombatFeed();
        String expectedResult = "---------------------------------------------------------------------------------" + "\ntestCharacter used Lucky and increased critical chance, but lowered defense.\n";
        assertEquals(expectedResult, outContent.toString());
    }
    
    /**
     * When the boss uses Iron Wall, the expected text is printed.
     */
    @Test
    public void printCombatFeed_abilityUsedIronWall_IronWallTextPrinted()
    {
        Boss testCharacter = new Boss("testCharacter",new CharacterAbility("Iron Wall","","Support",20,10));
        testCharacter.printCombatFeed();
        String expectedResult = "---------------------------------------------------------------------------------" + "\ntestCharacter used Iron Wall and increased defense.\n";
        assertEquals(expectedResult, outContent.toString());
    }
    
    /**
     * When the boss uses Color Swap, the expected text is printed.
     */
    @Test
    public void printCombatFeed_abilityUsedColorSwap_ColorSwapTextPrinted()
    {
        Boss testCharacter = new Boss("testCharacter","testWeakness",new CharacterAbility("Color Swap","","Support",20,10));
        testCharacter.printCombatFeed();
        String expectedResult = "---------------------------------------------------------------------------------" + "\ntestCharacter used Color Swap and changed their weakness to testWeakness\n";
        assertEquals(expectedResult, outContent.toString());
    }
    
    /**
     * When the boss uses an attacking move, the generic attack text is printed.
     */
    @Test
    public void printCombatFeed_usedAttackingAbility_dealsGenericDamage()
    {
        Boss testCharacter = new Boss("testCharacter",new CharacterAbility("Test Ability","","Test",20,10));
        testCharacter.printCombatFeed(new GameCharacter("Test",new CharacterAbility("Test Ability","","Test",20,10),20));
        String expectedResult = "---------------------------------------------------------------------------------" + "\ntestCharacter used Test Ability on Test and dealt 0 damage.\n" + "---------------------------------------------------------------------------------" + "\ntestCharacter has 100/100 HP remaining.\n";
        assertEquals(expectedResult, outContent.toString());
    }
    
}
