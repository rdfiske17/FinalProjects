package battlebunnies;

import java.util.Scanner;

/**
 *
 * @author Java Juice
 */

//Have a portrait for each character
public class GameCharacter 
{
    public String lineBreak = "---------------------------------------------------------------------------------";
    
    private String name = "";
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    
    private int id = 0;
    public int getID(){return id;}
    public void setID(int id){this.id = id;}
    
    private int maxHP = 100; //changed to 100 so I could run the program to test it
    public int getMaxHP(){return maxHP;}
    public void setMaxHP(int maxHP){this.maxHP = maxHP;}
    
    private int currentHP = 100; //changed to 100 so I could run the program to test it
    public int getCurrentHP(){return currentHP;}
    public void setCurrentHP(int currentHP){this.currentHP = currentHP;}
    
    private int maxMP = 0;
    public int getMaxMP(){return maxMP;}
    public void setMaxMP(int maxMP){this.maxMP = maxMP;}
    
    private int currentMP = 0;
    public int getCurrentMP(){return currentMP;}
    public void setCurrentMP(int currentMP){this.currentMP = currentMP;}
    
    private String weakness = "";
    public String getWeakness(){return weakness;}
    public void setWeakness(String weakness){this.weakness = weakness;}
    
    private double baseDefence = 0;
    public double getBaseDefence(){return baseDefence;}
    public void setBaseDefence(double baseDefence){this.baseDefence = baseDefence;}
    
    private double criticalChance = 0;
    public double getCriticalChance(){return criticalChance;}
    public void setCriticalChance(double criticalChance){this.criticalChance = criticalChance;}
    
    private double maxBaseDefence = 0;
    public double getMaxBaseDefence(){return maxBaseDefence;}
    public void setMaxBaseDefence(double maxBaseDefence){this.maxBaseDefence = maxBaseDefence;}
    
    private double maxCriticalChance = 0;
    public double getMaxCriticalChance(){return maxCriticalChance;}
    public void setMaxCriticalChance(double maxCriticalChance){this.maxCriticalChance = maxCriticalChance;}
    
    private CharacterAbility basicAttack = new CharacterAbility();
    public CharacterAbility getBasicAttack(){return basicAttack;}
    public void setBasicAttack(CharacterAbility basicAttack){this.basicAttack = basicAttack;}
    
    private CharacterAbility specialAbility1 = new CharacterAbility();
    public CharacterAbility getSpecialAbility1(){return specialAbility1;}
    public void setSpecialAbility1(CharacterAbility specialAbility1){this.specialAbility1 = specialAbility1;}
    
    private CharacterAbility specialAbility2 = new CharacterAbility();
    public CharacterAbility getSpecialAbility2(){return specialAbility2;}
    public void setSpecialAbility2(CharacterAbility specialAbility2){this.specialAbility2 = specialAbility2;}
    
    private int damageDealt = 0;
    public int getDamageDealt(){return damageDealt;}
    public void setDamageDealt(int damageDealt){this.damageDealt = damageDealt;}
    
    private int damageTaken = 0;
    public int getDamageTaken(){return damageTaken;}
    public void setDamageTaken(int damageTaken){this.damageTaken = damageTaken;}
    
    private CharacterAbility actionUsed = new CharacterAbility();
    public CharacterAbility getActionUsed(){return actionUsed;}
    public void setActionUsed(CharacterAbility actionUsed){this.actionUsed = actionUsed;}
    
    //CONSTRUCTORS
    
    public GameCharacter(){}
    
    /**
     * Added name only constructor for testing the program -Riley
     * @param name 
     */
    public GameCharacter(String name)
    {
        setName(name);
    }
    
    public GameCharacter(String name, int id, int maxHP,int currentHP, int maxMP,int currentMP, String weakness, double baseDefence, double maxBaseDefence, double criticalChance, double maxCriticalChance, CharacterAbility basicAttack, CharacterAbility specialAbility1, CharacterAbility specialAbility2, int damageTaken, int damageDealt, CharacterAbility actionUsed )
    {
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
        setDamageTaken(damageTaken);
        setDamageDealt(damageDealt);
        setActionUsed(actionUsed);
        
    }
    
    //METHODS
    
    public void turn(GameCharacter target)
    {
        boolean hasTakenTurn = false;
        while(!hasTakenTurn)
        {
            System.out.println(lineBreak);
            System.out.println("It is " + getName() + "'s turn."
            + "\n HP: " + getCurrentHP() + "/" + getMaxHP()
            + "\n MP: " + getCurrentMP() + "/" + getMaxMP()
            + "\n 1) Basic Ability: " + getBasicAttack().getName() + " (MP cost: " + getBasicAttack().getMPRequired() + ")"
            + "\n 2) Special Ability: " + getSpecialAbility1().getName() + " (MP cost: " + getSpecialAbility1().getMPRequired() + ")"
            + "\n 3) Special Ability: " + getSpecialAbility2().getName() + " (MP cost: " + getSpecialAbility2().getMPRequired() + ")"
            + "\n Please enter 1, 2, or 3 to select a move.");

            Scanner userInput = new Scanner(System.in);
            String desiredAbility = userInput.nextLine();
            System.out.println(lineBreak);
            if(desiredAbility.equals("1"))
            {
                if(getBasicAttack().getMPRequired()>getCurrentMP())
                {
                    System.out.println(lineBreak);
                    System.out.println("You do not have enough MP to take this action. Please select a different action.");
                }
                else
                {
                    
                    System.out.println(getBasicAttack().getDescription()
                    + "\n Please type \" 1 \" to confirm your selection");
                    String yesNoSelection = userInput.nextLine();
                    if(yesNoSelection.equals("1"))
                    {
                        setActionUsed(basicAttack);
                        BattleBunnies.damageCalculation(this, target);
                        hasTakenTurn = true;
                    }
                    else
                    {
                        System.out.println(lineBreak);
                        System.out.println("Error: Please attempt turn again.");
                    }
                }
            }
            else if(desiredAbility.equals("2"))
            {
                if(getSpecialAbility1().getMPRequired()>getCurrentMP())
                {
                    System.out.println(lineBreak);
                    System.out.println("You do not have enough MP to take this action. Please select a different action.");
                }
                else
                {
                    System.out.println(getSpecialAbility1().getDescription()
                    + "\n Please type \" 1 \" to confirm your selection");
                    String yesNoSelection = userInput.nextLine();
                    if(yesNoSelection.equals("1"))
                    {
                        setActionUsed(specialAbility1);
                        BattleBunnies.damageCalculation(this, target);
                        hasTakenTurn = true;
                    }
                    else
                    {
                        System.out.println(lineBreak);
                        System.out.println("Error: Please attempt turn again.");
                    }
                }
            }
            else if(desiredAbility.equals("3"))
            {
                if(getSpecialAbility2().getMPRequired()>getCurrentMP())
                {
                    System.out.println(lineBreak);
                    System.out.println("You do not have enough MP to take this action. Please select a different action.");
                }
                else
                {
                    System.out.println(getSpecialAbility2().getDescription()
                    + "\n Please type \" 1 \" to confirm your selection");
                    String yesNoSelection = userInput.nextLine();
                    if(yesNoSelection.equals("1"))
                    {
                        setActionUsed(specialAbility2);
                        BattleBunnies.damageCalculation(this, target);
                        hasTakenTurn = true;
                    }
                    else
                    {
                        System.out.println(lineBreak);
                        System.out.println("Error: Please attempt turn again.");
                    }
                }
            }
            else
            {
                System.out.println("Error: Please attempt turn again.");
            }
        }
    }
    
    public void printCombatFeed()
    {
        if(getActionUsed().getAttackType().equals("Support"))
        {
            if(getActionUsed().getName().equals("Heal"))
            {
                System.out.println(lineBreak);
                System.out.println(name + " used " + getActionUsed().getName() + " and healed for " + getDamageDealt() + " HP.");
            }
            else if(getActionUsed().getName().equals("Lucky"))
            {
                System.out.println(lineBreak);
                System.out.println(name + " used " + getActionUsed().getName() + " and increased critical chance, but lowered defense.");
            }
            else if(getActionUsed().getName().equals("Iron Wall"))
            {
                System.out.println(lineBreak);
                System.out.println(name + " used " + getActionUsed().getName() + " and increased defense.");
            }
        }
        else
        {
            System.out.println(lineBreak);
            System.out.println(name + " used " + getActionUsed().getName() + " and dealt " + getDamageDealt() + " damage.");
        }
    }
    
}
