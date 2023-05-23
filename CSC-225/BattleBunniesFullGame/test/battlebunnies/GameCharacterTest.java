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
public class GameCharacterTest {
    
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
     * Test of turn method, of class GameCharacter.
     */
    @Test //Not complete yest. Use setIn and setOut
    public void testTurn() {
        
    }
    
    /**
     * When the user uses heal, the heal text is printed.
     */
    @Test
    public void printCombatFeed_abilityUsedHeal_healTextPrinted() 
    {
        GameCharacter testCharacter = new GameCharacter("testCharacter",new CharacterAbility("Heal","","Support",20,10));
        testCharacter.printCombatFeed();
        String expectedResult = "---------------------------------------------------------------------------------" + "\ntestCharacter used Heal and healed for 20 HP.\n";
        assertEquals(expectedResult, outContent.toString()); 
    }
    
    /**
     * When the user uses Lucky, the lucky text is printed.
     */
    @Test
    public void printCombatFeed_abilityUsedLucky_luckyTextPrinted()
    {
        GameCharacter testCharacter = new GameCharacter("testCharacter",new CharacterAbility("Lucky","","Support",20,10));
        testCharacter.printCombatFeed();
        String expectedResult = "---------------------------------------------------------------------------------" + "\ntestCharacter used Lucky and increased critical chance, but lowered defense.\n";
        assertEquals(expectedResult, outContent.toString());
    }
    
    /**
     * When the user uses Iron Wall, the Iron Wall text is printed.
     */
    @Test
    public void printCombatFeed_abilityUsedIronWall_IronWallTextPrinted()
    {
        GameCharacter testCharacter = new GameCharacter("testCharacter",new CharacterAbility("Iron Wall","","Support",20,10));
        testCharacter.printCombatFeed();
        String expectedResult = "---------------------------------------------------------------------------------" + "\ntestCharacter used Iron Wall and increased defense.\n";
        assertEquals(expectedResult, outContent.toString());
    }
    
    /**
     * When the user uses Color Swap, the color swap text is printed.
     */
    @Test
    public void printCombatFeed_abilityUsedColorSwap_ColorSwapTextPrinted()
    {
        GameCharacter testCharacter = new GameCharacter("testCharacter","testWeakness",new CharacterAbility("Color Swap","","Support",20,10));
        testCharacter.printCombatFeed();
        String expectedResult = "---------------------------------------------------------------------------------" + "\ntestCharacter used Color Swap and changed their weakness to testWeakness\n";
        assertEquals(expectedResult, outContent.toString());
    }
    
    /**
     * When the user uses an attacking ability, the generic attack text is printed.
     */
    @Test
    public void printCombatFeed_anyDamageUsed_genericDamageTextPrinted()
    {
        GameCharacter testCharacter = new GameCharacter("testCharacter",new CharacterAbility("testAttack","","",20,10),7357);
        testCharacter.printCombatFeed();
        String expectedResult = "---------------------------------------------------------------------------------\n" + "testCharacter used testAttack and dealt 7357 damage.\n";
        assertEquals(expectedResult, outContent.toString());
    }
}