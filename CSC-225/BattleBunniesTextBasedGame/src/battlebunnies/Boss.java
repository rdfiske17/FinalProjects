package battlebunnies;

import java.util.Random;
import javax.swing.ImageIcon;

/**
 * This class deals with all of the boss behavior. Bosses have all the attributes 
 * of gameCharacters but can select their targets without user input.
 * @author Java Juice
 */
public class Boss extends GameCharacter
{
    public Random rng = new Random();
    
    //CONSTRUCTORS
    
    /**
     * Empty constructor.
     */
    public Boss(){}
    
    /**
     * Name constructor. Used for unit testing.
     * @param name name of the boss.
     */
    public Boss(String name)
    {
        setName(name);
    }
    
    /**
     * Name and action constructor. Used for unit testing.
     * @param name name of the boss.
     * @param actionUsed the action last used by the boss.
     */
    public Boss(String name, CharacterAbility actionUsed)
    {
        setName(name);
        setActionUsed(actionUsed);
    }
    
    /**
     * Name, weakness, and action constructor. Used in unit testing.
     * @param name name of the boss.
     * @param weakness weakness of the boss.
     * @param actionUsed the action last used by the boss.
     */
    public Boss(String name, String weakness, CharacterAbility actionUsed)
    {
        setName(name);
        setWeakness(weakness);
        setActionUsed(actionUsed);
    }
    
    /**
     * Name, action, and damage dealt constructor. Used in unit testing.
     * @param name name of the boss.
     * @param actionUsed the action last used by the boss.
     * @param damageDealt the damage dealt by the boss.
     */
    public Boss(String name, CharacterAbility actionUsed, int damageDealt)
    {
        setName(name);
        setActionUsed(actionUsed);
        setDamageDealt(damageDealt);
    }
    
    /**
     * Full constructor. This constructor is the same as the one in it's super class.
     * @param name name of the boss.
     * @param id ID number of the boss.
     * @param maxHP HP of the boss.
     * @param maxMP MP of the boss.
     * @param weakness the weakness of the boss.
     * @param baseDefence the basic defence value of the boss.
     * @param maxBaseDefence the maximum defence value of the boss.
     * @param criticalChance the basic critical chance of the boss.
     * @param maxCriticalChance the max critical chance of the boss.
     * @param basicAttack the first attack of the boss.
     * @param specialAbility1 the second attack of the boss.
     * @param specialAbility2 the third attack of the boss.
     */
    public Boss(String name, int id, int maxHP, int maxMP, String weakness, double baseDefence, double maxBaseDefence, double criticalChance, double maxCriticalChance, CharacterAbility basicAttack, CharacterAbility specialAbility1, CharacterAbility specialAbility2)
    {
        super(name,id,maxHP,maxMP,weakness,baseDefence,maxBaseDefence,criticalChance,maxCriticalChance,basicAttack,specialAbility1,specialAbility2);
    }
    
    /**
     * Full constructor. This constructor is the same as the one in it's super class.
     * @param name name of the boss.
     * @param id ID number of the boss.
     * @param maxHP HP of the boss.
     * @param maxMP MP of the boss.
     * @param weakness the weakness of the boss.
     * @param baseDefence the basic defence value of the boss.
     * @param maxBaseDefence the maximum defence value of the boss.
     * @param criticalChance the basic critical chance of the boss.
     * @param maxCriticalChance the max critical chance of the boss.
     * @param basicAttack the first attack of the boss.
     * @param specialAbility1 the second attack of the boss.
     * @param specialAbility2 the third attack of the boss.
     * @param portrait boss portrait icon
     */
    public Boss(String name, int id, int maxHP, int maxMP, String weakness, double baseDefence, double maxBaseDefence, double criticalChance, double maxCriticalChance, CharacterAbility basicAttack, CharacterAbility specialAbility1, CharacterAbility specialAbility2, ImageIcon portrait)
    {
        super(name,id,maxHP,maxMP,weakness,baseDefence,maxBaseDefence,criticalChance,maxCriticalChance,basicAttack,specialAbility1,specialAbility2,portrait);
    }
    
    //METHODS
    
    /**
     * This method controls the turn of the boss. This method selects a 
     * gameCharacter to target and a CharacterAbility to use.
     * All commented out code are non-implemented ideas for the boss.
     * @param hero1 the first GameCharacter in your party.
     * @param hero2 the second GameCharacter in your party.
     * @param hero3 the third GameCharacter in your party.
     */
    public void turn(GameCharacter hero1, GameCharacter hero2, GameCharacter hero3)
    {
        /*double hero1percent = hero1.getCurrentHP()/hero1.getMaxHP();
        double hero2percent = hero2.getCurrentHP()/hero2.getMaxHP();
        double hero3percent = hero3.getCurrentHP()/hero3.getMaxHP();
        double hpPercentSum = hero1percent+hero2percent+hero3percent;
        double hero1chance = hero1percent/hpPercentSum;
        double hero2chance = hero2percent/hpPercentSum + hero1chance;
        double hero3chance = hero3percent/hpPercentSum;
        */
        
        GameCharacter selectedHero = hero1;
        
        //select target based off of lowest health, or if equal randomly select
        
        /*if(hero1.getCurrentHP() < hero2.getCurrentHP() && hero1.getCurrentHP() < hero3.getCurrentHP() && hero1.getCurrentHP() > 0)
        {
            selectedHero = hero1;
        }
        else if(hero2.getCurrentHP() < hero1.getCurrentHP() && hero2.getCurrentHP() < hero3.getCurrentHP() && hero2.getCurrentHP() > 0)
        {
            selectedHero = hero2;
        }
        else if(hero3.getCurrentHP() < hero1.getCurrentHP() && hero3.getCurrentHP() < hero2.getCurrentHP() && hero3.getCurrentHP() > 0)
        {
            selectedHero = hero3;
        }
        else
        {*/
            
            boolean hasSelectedTarget = false;
            while(!hasSelectedTarget)
            {
                int selectedHeroNumber = rng.nextInt(3) + 1;
                if(selectedHeroNumber==1 && hero1.getCurrentHP() > 0)
                {
                    hasSelectedTarget = true;
                    selectedHero = hero1;
                }
                else if (selectedHeroNumber==2 && hero2.getCurrentHP() > 0)
                {
                    hasSelectedTarget = true;
                    selectedHero = hero2;
                }
                else if (selectedHeroNumber==3 && hero3.getCurrentHP() > 0)
                {
                    hasSelectedTarget = true;
                    selectedHero = hero3;
                }
            }
        //}
        
        
        //randomly select ability 
        CharacterAbility selectedAbility = getBasicAttack();
        boolean hasSelectedAbility = false;
        while(!hasSelectedAbility)
        {
            int selectedAbilityNumber = rng.nextInt(3) + 1;
            if(selectedAbilityNumber==1)
            {
                selectedAbility=getBasicAttack();
            }
            else if(selectedAbilityNumber==2)
            {
                selectedAbility=getSpecialAbility1();
            }
            else if(selectedAbilityNumber==3)
            {
                selectedAbility=getSpecialAbility2();
            }
            if(selectedAbility.getMPRequired() <= getCurrentMP())
            {
                hasSelectedAbility=true;
            }
        }
        
        setActionUsed(selectedAbility);
        BattleBunnies.damageCalculation(this,selectedHero);
        printCombatFeed(selectedHero);
        setCurrentMP(getCurrentMP()+2);
    }
    
    /**
     * This method prints the combat feed. The combat feed updates the user what 
     * moves were used during the turn.
     * @param target the GameCharacter the boss is targeting.
     */
    public void printCombatFeed(GameCharacter target)
    {
        if(getActionUsed().getAttackType().equals("Support"))
        {
            if(getActionUsed().getName().equals("Heal"))
            {
                System.out.println(lineBreak);
                System.out.println(getName() + " used " + getActionUsed().getName() + " and healed for " + getActionUsed().getBaseDamage() + " HP.");
            }
            else if(getActionUsed().getName().equals("Lucky"))
            {
                System.out.println(lineBreak);
                System.out.println(getName() + " used " + getActionUsed().getName() + " and increased critical chance, but lowered defense.");
            }
            else if(getActionUsed().getName().equals("Iron Wall"))
            {
                System.out.println(lineBreak);
                System.out.println(getName() + " used " + getActionUsed().getName() + " and increased defense.");
            }
            else if (getActionUsed().getName().equals("Color Swap"))
            {
                System.out.println(lineBreak);
                System.out.println(getName() + " used " + getActionUsed().getName() + " and changed their weakness to " + getWeakness());
            }
        }
        else
        {
            System.out.println(lineBreak);
            System.out.println(getName() + " used " + getActionUsed().getName() + " on " + target.getName() + " and dealt " + getDamageDealt() + " damage.");
        }
        System.out.println(lineBreak);
        System.out.println(getName() + " has " + getCurrentHP() + "/" + getMaxHP() + " HP remaining.");
    }
}

