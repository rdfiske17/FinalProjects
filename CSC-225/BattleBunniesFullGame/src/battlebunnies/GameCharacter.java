package battlebunnies;

import java.util.Scanner;
import javax.swing.ImageIcon;

/**
 * The GameCharacter class represents a generic game character. Our heroes are
 * of this class and bosses extend this class
 *
 * @author Java Juice
 */
public class GameCharacter {
    //INSTANCE VARIABLES

    public String lineBreak = "---------------------------------------------------------------------------------";

    private String name = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int id = 0;

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    private int maxHP = 100; //changed to 100 so I could run the program to test it

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    private int currentHP = 100; //changed to 100 so I could run the program to test it

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    private int maxMP = 0;

    public int getMaxMP() {
        return maxMP;
    }

    public void setMaxMP(int maxMP) {
        this.maxMP = maxMP;
    }

    private int currentMP = 0;

    public int getCurrentMP() {
        return currentMP;
    }

    public void setCurrentMP(int currentMP) {
        this.currentMP = currentMP;
    }

    private String weakness = "";

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    private double baseDefence = 0;

    public double getBaseDefence() {
        return baseDefence;
    }

    public void setBaseDefence(double baseDefence) {
        this.baseDefence = baseDefence;
    }

    private double criticalChance = 0;

    public double getCriticalChance() {
        return criticalChance;
    }

    public void setCriticalChance(double criticalChance) {
        this.criticalChance = criticalChance;
    }

    private double maxBaseDefence = 0;

    public double getMaxBaseDefence() {
        return maxBaseDefence;
    }

    public void setMaxBaseDefence(double maxBaseDefence) {
        this.maxBaseDefence = maxBaseDefence;
    }

    private double maxCriticalChance = 0;

    public double getMaxCriticalChance() {
        return maxCriticalChance;
    }

    public void setMaxCriticalChance(double maxCriticalChance) {
        this.maxCriticalChance = maxCriticalChance;
    }

    private CharacterAbility basicAttack = new CharacterAbility();

    public CharacterAbility getBasicAttack() {
        return basicAttack;
    }

    public void setBasicAttack(CharacterAbility basicAttack) {
        this.basicAttack = basicAttack;
    }

    private CharacterAbility specialAbility1 = new CharacterAbility();

    public CharacterAbility getSpecialAbility1() {
        return specialAbility1;
    }

    public void setSpecialAbility1(CharacterAbility specialAbility1) {
        this.specialAbility1 = specialAbility1;
    }

    private CharacterAbility specialAbility2 = new CharacterAbility();

    public CharacterAbility getSpecialAbility2() {
        return specialAbility2;
    }

    public void setSpecialAbility2(CharacterAbility specialAbility2) {
        this.specialAbility2 = specialAbility2;
    }

    private int damageDealt = 0;

    public int getDamageDealt() {
        return damageDealt;
    }

    public void setDamageDealt(int damageDealt) {
        this.damageDealt = damageDealt;
    }

    private int damageTaken = 0;

    public int getDamageTaken() {
        return damageTaken;
    }

    public void setDamageTaken(int damageTaken) {
        this.damageTaken = damageTaken;
    }

    private CharacterAbility actionUsed = new CharacterAbility();

    public CharacterAbility getActionUsed() {
        return actionUsed;
    }

    public void setActionUsed(CharacterAbility actionUsed) {
        this.actionUsed = actionUsed;
    }

    private ImageIcon portrait = new ImageIcon();

    public ImageIcon getPortrait() {
        return portrait;
    }

    public void setPortrait(ImageIcon portrait) {
        this.portrait = portrait;
    }

    //CONSTRUCTORS
    /**
     * Empty constructor
     */
    public GameCharacter() {
    }

    /**
     * Added name only constructor for testing the program -Riley
     *
     * @param name
     */
    public GameCharacter(String name) {
        setName(name);
    }

    /**
     * Constructor for unit tests
     *
     * @param name name of character
     * @param actionUsed action last used
     */
    public GameCharacter(String name, CharacterAbility actionUsed) {
        setName(name);
        setActionUsed(actionUsed);
    }

    /**
     * Constructor used for unit tests
     *
     * @param name name of the character
     * @param weakness attack weakness
     * @param actionUsed action last used
     */
    public GameCharacter(String name, String weakness, CharacterAbility actionUsed) {
        setName(name);
        setWeakness(weakness);
        setActionUsed(actionUsed);
    }

    /**
     * Constructor used for unit test
     *
     * @param name name of character
     * @param actionUsed action last used
     * @param damageDealt damage dealt this turn
     */
    public GameCharacter(String name, CharacterAbility actionUsed, int damageDealt) {
        setName(name);
        setActionUsed(actionUsed);
        setDamageDealt(damageDealt);
    }

    /**
     * Full constructor name of the character
     *
     * @param id ID number
     * @param maxHP maximum HP
     * @param maxMP maximum MP
     * @param weakness type the character is weak to
     * @param baseDefence current defence modifier
     * @param maxBaseDefence max defence modifier
     * @param criticalChance the current critical hit modifier
     * @param maxCriticalChance the max critical hit modifier
     * @param basicAttack attack 1
     * @param specialAbility1 attack 2
     * @param specialAbility2 attack 3
     */
    public GameCharacter(String name, int id, int maxHP, int maxMP, String weakness, double baseDefence, double maxBaseDefence, double criticalChance, double maxCriticalChance, CharacterAbility basicAttack, CharacterAbility specialAbility1, CharacterAbility specialAbility2) {
        setName(name);
        setID(id);
        setMaxHP(maxHP);
        setCurrentHP(maxHP);
        setMaxMP(maxMP);
        setCurrentMP(maxMP);
        setWeakness(weakness);
        setBaseDefence(baseDefence);
        setMaxBaseDefence(maxBaseDefence);
        setCriticalChance(maxCriticalChance);
        setMaxCriticalChance(criticalChance);
        setBasicAttack(basicAttack);
        setSpecialAbility1(specialAbility1);
        setSpecialAbility2(specialAbility2);
    }

    /**
     * Full constructor name of the character
     *
     * @param id ID number
     * @param maxHP maximum HP
     * @param maxMP maximum MP
     * @param weakness type the character is weak to
     * @param baseDefence current defence modifier
     * @param maxBaseDefence max defence modifier
     * @param criticalChance the current critical hit modifier
     * @param maxCriticalChance the max critical hit modifier
     * @param basicAttack attack 1
     * @param specialAbility1 attack 2
     * @param specialAbility2 attack 3
     * @param portrait character portrait
     */
    public GameCharacter(String name, int id, int maxHP, int maxMP, String weakness, double baseDefence, double maxBaseDefence, double criticalChance, double maxCriticalChance, CharacterAbility basicAttack, CharacterAbility specialAbility1, CharacterAbility specialAbility2, ImageIcon portrait) {
        setName(name);
        setID(id);
        setMaxHP(maxHP);
        setCurrentHP(maxHP);
        setMaxMP(maxMP);
        setCurrentMP(maxMP);
        setWeakness(weakness);
        setBaseDefence(baseDefence);
        setMaxBaseDefence(maxBaseDefence);
        setCriticalChance(maxCriticalChance);
        setMaxCriticalChance(criticalChance);
        setBasicAttack(basicAttack);
        setSpecialAbility1(specialAbility1);
        setSpecialAbility2(specialAbility2);
        setPortrait(portrait);
    }

    /**
     * Big boi constructor
     *
     * @param name name of the character
     * @param id ID number
     * @param maxHP maximum HP
     * @param currentHP current HP
     * @param maxMP maximum MP
     * @param currentMP current MP
     * @param weakness type the character is weak to
     * @param baseDefence current defence modifier
     * @param maxBaseDefence max defence modifier
     * @param criticalChance the current critical hit modifier
     * @param maxCriticalChance the max critical hit modifier
     * @param basicAttack attack 1
     * @param specialAbility1 attack 2
     * @param specialAbility2 attack 3
     * @param damageDealt the damage dealt this turn
     * @param damageTaken the damage taken this turn
     * @param actionUsed the action last used
     */
    public GameCharacter(String name, int id, int maxHP, int currentHP, int maxMP, int currentMP, String weakness, double baseDefence, double maxBaseDefence, double criticalChance, double maxCriticalChance, CharacterAbility basicAttack, CharacterAbility specialAbility1, CharacterAbility specialAbility2, int damageDealt, int damageTaken, CharacterAbility actionUsed) {
        setName(name);
        setID(id);
        setMaxHP(maxHP);
        setCurrentHP(currentHP);
        setMaxMP(maxMP);
        setCurrentMP(currentMP);
        setWeakness(weakness);
        setBaseDefence(baseDefence);
        setMaxBaseDefence(maxBaseDefence);
        setCriticalChance(maxCriticalChance);
        setMaxCriticalChance(criticalChance);
        setBasicAttack(basicAttack);
        setSpecialAbility1(specialAbility1);
        setSpecialAbility2(specialAbility2);
        setDamageDealt(damageDealt);
        setDamageTaken(damageTaken);
        setActionUsed(actionUsed);

    }

    //METHODS
    
    public boolean ability1(GameCharacter target) {
        if (getBasicAttack().getMPRequired() > getCurrentMP()) {
            System.out.println("You do not have enough MP to take this action. Please select a different action.");
            return false;
        } else {

            setActionUsed(basicAttack);
            BattleBunnies.damageCalculation(this, target);

            if (getCurrentMP() + 1 < getMaxMP()) {
                setCurrentMP(getCurrentMP() + 1);
            }
            return true;

        }

    }

    public boolean ability2(GameCharacter target) {

        {
            if (getSpecialAbility1().getMPRequired() > getCurrentMP()) {

                System.out.println("You do not have enough MP to take this action. Please select a different action.");
                return false;
            } else {

                setActionUsed(specialAbility1);
                BattleBunnies.damageCalculation(this, target);

                if (getCurrentMP() + 1 < getMaxMP()) {
                    setCurrentMP(getCurrentMP() + 1);
                }
                return true;
            }

        }

    }

    public boolean ability3(GameCharacter target) {
        if (getSpecialAbility2().getMPRequired() > getCurrentMP()) {
            System.out.println("You do not have enough MP to take this action. Please select a different action.");
            return false;
        } else {

            setActionUsed(specialAbility2);
            BattleBunnies.damageCalculation(this, target);

            if (getCurrentMP() + 1 < getMaxMP()) {
                setCurrentMP(getCurrentMP() + 1);
            }
            return true;

        }
    }

    /**
     * Turn allow characters to take a turn and use a move against a boss.
     *
     * @param target the boss being targeted.
     */
    public void turn(GameCharacter target) {
        boolean hasTakenTurn = false;
        while (!hasTakenTurn) {
            System.out.println(lineBreak);
            System.out.println("It is " + getName() + "'s turn."
                    + "\n HP: " + getCurrentHP() + "/" + getMaxHP()
                    + "\n MP: " + getCurrentMP() + "/" + getMaxMP()
                    + "\n 1) Basic Ability: " + getBasicAttack().getName() + " (MP cost: " + getBasicAttack().getMPRequired() + ")"
                    + "\n 2) Special Ability: " + getSpecialAbility1().getName() + " (MP cost: " + getSpecialAbility1().getMPRequired() + ")"
                    + "\n 3) Special Ability: " + getSpecialAbility2().getName() + " (MP cost: " + getSpecialAbility2().getMPRequired() + ")"
                    + "\n Please enter 1, 2, or 3 to select a move.");

            Scanner userInput = new Scanner(System.in);
            String desiredAbility = userInput.next().trim();
            System.out.println(lineBreak);
            if (desiredAbility.equals("1")) {
                if (getBasicAttack().getMPRequired() > getCurrentMP()) {
                    System.out.println("You do not have enough MP to take this action. Please select a different action.");
                } else {

                    System.out.println(getBasicAttack().getDescription()
                            + "\n Please type \" 1 \" to confirm your selection");
                    String yesNoSelection = userInput.next().trim();
                    if (yesNoSelection.equals("1")) {
                        setActionUsed(basicAttack);
                        BattleBunnies.damageCalculation(this, target);
                        hasTakenTurn = true;
                        if (getCurrentMP() + 1 < getMaxMP()) {
                            setCurrentMP(getCurrentMP() + 1);
                        }

                    } else {
                        System.out.println(lineBreak);
                        System.out.println("Error: Please attempt turn again.");
                    }
                }
            } else if (desiredAbility.equals("2")) //function head, like ability2(Boss boss)
            {
                if (getSpecialAbility1().getMPRequired() > getCurrentMP()) {
                    System.out.println("You do not have enough MP to take this action. Please select a different action.");
                } else {
                    System.out.println(getSpecialAbility1().getDescription()
                            + "\n Please type \" 1 \" to confirm your selection");
                    String yesNoSelection = userInput.next().trim();
                    if (yesNoSelection.equals("1")) {
                        setActionUsed(specialAbility1);
                        BattleBunnies.damageCalculation(this, target);
                        hasTakenTurn = true;
                        if (getCurrentMP() + 1 < getMaxMP()) {
                            setCurrentMP(getCurrentMP() + 1);
                        }

                    } else {
                        System.out.println(lineBreak);
                        System.out.println("Error: Please attempt turn again.");
                    }
                }
            } else if (desiredAbility.equals("3")) {
                if (getSpecialAbility2().getMPRequired() > getCurrentMP()) {
                    System.out.println("You do not have enough MP to take this action. Please select a different action.");
                } else {
                    System.out.println(getSpecialAbility2().getDescription()
                            + "\n Please type \" 1 \" to confirm your selection");
                    String yesNoSelection = userInput.next().trim();
                    if (yesNoSelection.equals("1")) {
                        setActionUsed(specialAbility2);
                        BattleBunnies.damageCalculation(this, target);
                        hasTakenTurn = true;
                        if (getCurrentMP() + 1 < getMaxMP()) {
                            setCurrentMP(getCurrentMP() + 1);
                        }

                    } else {
                        System.out.println(lineBreak);
                        System.out.println("Error: Please attempt turn again.");
                    }
                }
            } else {
                System.out.println("Error: Please attempt turn again.");
            }
        }
    }

    /**
     * This method prints the combat feed. The combat feed updates the user what
     * moves were used during the turn.
     */
    public String printCombatFeed() {
        String output = "";
        if (getActionUsed().getAttackType().equals("Support")) {
            if (getActionUsed().getName().equals("Heal")) {
                output += getName() + " used " + getActionUsed().getName() + " and healed for " + getActionUsed().getBaseDamage() + " HP.";
                //System.out.println(lineBreak);
                //System.out.println(getName() + " used " + getActionUsed().getName() + " and healed for " + getActionUsed().getBaseDamage() + " HP.");
            } else if (getActionUsed().getName().equals("Lucky")) {
                output += getName() + " used " + getActionUsed().getName() + " and increased critical chance, but lowered defense.";
//System.out.println(lineBreak);
                //System.out.println(getName() + " used " + getActionUsed().getName() + " and increased critical chance, but lowered defense.");
            } else if (getActionUsed().getName().equals("Iron Wall")) {
                output += getName() + " used " + getActionUsed().getName() + " and increased defense.";
                //System.out.println(lineBreak);
                //System.out.println(getName() + " used " + getActionUsed().getName() + " and increased defense.");
            } else if (getActionUsed().getName().equals("Color Swap")) {
                output += getName() + " used " + getActionUsed().getName() + " and changed their weakness to " + getWeakness();
                //System.out.println(lineBreak);
                //System.out.println(getName() + " used " + getActionUsed().getName() + " and changed their weakness to " + getWeakness());
            }
        } else {
            output += getName() + " used " + getActionUsed().getName() + " and dealt " + getDamageDealt() + " damage.";
            //System.out.println(lineBreak);
            //System.out.println(getName() + " used " + getActionUsed().getName() + " and dealt " + getDamageDealt() + " damage.");
        }
        return output;
    }

}
