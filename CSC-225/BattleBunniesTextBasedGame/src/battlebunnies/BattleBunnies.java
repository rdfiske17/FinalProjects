package battlebunnies;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;


/**
 * Battle Bunnies is a boss rush RPG with 6 bosses and 3 player characters. This 
 * main method runs the main loop of the game where all the action happens.
 * At the bottom of the class is the damage calculation method which enables 
 * turns to work.
 * @author Java Juice
 */
public class BattleBunnies {

    /**
     * @param args the command line arguments
     */
    

    public static void main(String[] args)
    {
        String lineBreak = "---------------------------------------------------------------------------------";
        
        System.out.println("Welcome to Battle Bunnies! This is the text based simulation of the game that will eventually be put into a graphical interface."
                + "\n The purpose of this test is to verify that the battle calculations work under the hood before making it visual.");
       
        //ABILITY CREATION
        CharacterAbility attack = new CharacterAbility("Attack","A simple physical attack","Physical",5,0);
        CharacterAbility fireball = new CharacterAbility("Fireball","Shoots a fireball dealing a little damage","Fire",10,3);
        CharacterAbility rockspike = new CharacterAbility("Rock Spike","Rock juts out of the ground dealing a little damage","Earth",10,4);
        CharacterAbility airBlast = new CharacterAbility("Air Blast","Shoots a bullet of air dealing a little damage","Air",10,3);
        CharacterAbility bubbles = new CharacterAbility("Bubbles","Bubbles pop in the enemy's face dealing a little damage","Water",10,4);
        CharacterAbility headbutt = new CharacterAbility("Headbutt","A karate chop on the enemy dealing a little damage","Physical",15,5);
        CharacterAbility tidalwave = new CharacterAbility("Tidal Wave","A huge wave of water dealing a lot of damage","Water",20,7);
        CharacterAbility fireblast = new CharacterAbility("Fire Blast","A large ball of fire dealing a lot of damage","Fire",20,8);
        CharacterAbility hurricane = new CharacterAbility("Hurricane","A hurricane is summoned dealing a lot of damage","Air",20,7);
        CharacterAbility steelspike = new CharacterAbility("Steel Spike","A steel spike shoots from the ground dealing a lot of damage","Earth",20,8);
        CharacterAbility flurrystrike = new CharacterAbility("Flurry Strike","A flurry of strikes too fast to see dealing a lot of damage","Physical",20,7);
        CharacterAbility heal = new CharacterAbility("Heal","Heal a small amount of HP","Support",15,8);
        CharacterAbility lucky = new CharacterAbility("Lucky","On the next turn, a critical hit is guaranteed, but defence is halved","Support",0,6);
        CharacterAbility ironwall = new CharacterAbility("Iron Wall","Defence is doubled for one turn.","Support",0,6);
        CharacterAbility stab = new CharacterAbility("Stab","Stab the enemy","Physical",15,3);
        CharacterAbility windcutter = new CharacterAbility("Wind Cutter","Swings knife at blinding speed damaging all enemies","Air",20,10);
        CharacterAbility eviscerate = new CharacterAbility("Eviscerate","Tears into the enemy with wild abandon","Physical",30,7);
        CharacterAbility shadowedwind = new CharacterAbility("Shadowed Wind","The wind tears into all enemies","Air",10,5);
        CharacterAbility starstrike = new CharacterAbility("Star Strike","A star falls on the enemy","Fire",45,12);
        CharacterAbility colorswap = new CharacterAbility("Color Swap","Changes an enemy's weakness to a random weakness for the rest of the battle","Support",0,3);
        CharacterAbility ironhooves = new CharacterAbility("Iron Hooves","Kicks an enemy with iron hooves","Earth",20,4);
        
        
        //PORTRAIT CREATION
        ImageIcon hero1Portrait = new ImageIcon("src\\battlebunnies\\images\\AllyRedSlime.png");
        ImageIcon hero2Portrait = new ImageIcon("src\\battlebunnies\\images\\AllyBlueSlime.png");
        ImageIcon hero3Portrait = new ImageIcon("src\\battlebunnies\\images\\AllyGreenSlime.png");
        ImageIcon boss1Portrait = new ImageIcon("src\\battlebunnies\\images\\EnemyBunny.png");
        ImageIcon boss2Portrait = new ImageIcon("src\\battlebunnies\\images\\EnemyKnifeBunny.png");
        ImageIcon boss3Portrait = new ImageIcon("src\\battlebunnies\\images\\EnemyNightBunny.png");
        ImageIcon boss4Portrait = new ImageIcon("src\\battlebunnies\\images\\EnemyAlbinoBunny.png");
        ImageIcon boss5Portrait = new ImageIcon("src\\battlebunnies\\images\\EnemyZebraBunny.png");
        ImageIcon boss6Portrait = new ImageIcon("src\\battlebunnies\\images\\EnemyStarBunny.png");

        //CHARACTER CREATION
        GameCharacter hero1 = new GameCharacter("Red Slime",1,100,20,"Water",1,1,0.25,0.25,attack,fireball,heal,hero1Portrait);
        GameCharacter hero2 = new GameCharacter("Blue Slime",2,100,20,"Earth",1,1,0.25,0.25,attack,bubbles,lucky,hero2Portrait);
        GameCharacter hero3 = new GameCharacter("Green Slime",3,100,20,"Fire",1,1,0.25,0.25,attack,steelspike,ironwall,hero3Portrait);
        Boss boss1 = new Boss("Lazy Bunny",4,300,50,"Earth",1,1,0.25,0.25,attack,windcutter,colorswap,boss1Portrait);
        Boss boss2 = new Boss("Knife Bunny",5,300,50,"Air",1,1,0.25,0.25,attack,stab,rockspike,boss2Portrait);
        Boss boss3 = new Boss("Night Bunny",6,300,50,"Fire",1,1,0.25,0.25,attack,hurricane,tidalwave,boss3Portrait);
        Boss boss4 = new Boss("Albino Bunny",7,300,50,"Physical",1,1,0.25,0.25,attack,eviscerate,shadowedwind,boss4Portrait);
        Boss boss5 = new Boss("Zebra Bunny",8,300,50,"Water",1,1,0.25,0.25,attack,headbutt,ironhooves,boss5Portrait);
        Boss boss6 = new Boss("Star Bunny",9,300,50,"Water",1,1,0.25,0.25,attack,starstrike,fireblast,boss6Portrait);
        
        
        //LIST CREATION
        ArrayList<GameCharacter> playerParty = new ArrayList();
        playerParty.add(hero1);
        playerParty.add(hero2);
        playerParty.add(hero3);
        ArrayList <Boss> bossList = new ArrayList();
        bossList.add(boss1);
        bossList.add(boss2);
        bossList.add(boss3);
        bossList.add(boss4);
        bossList.add(boss5);
        bossList.add(boss6);
        int bossIndex = 0;
        Boss currentBoss = bossList.get(bossIndex);
        
        while(bossIndex < bossList.size() && (hero1.getCurrentHP() > 0 || hero2.getCurrentHP() > 0 || hero3.getCurrentHP() > 0)) //set conditions for the game to run
        {
            currentBoss = bossList.get(bossIndex);
            System.out.println(lineBreak + "\n" + currentBoss.getName() + " approaches!");
            
            //if a boss is alive and at least one party member is alive, then a turn will happen.
            while(currentBoss.getCurrentHP()>0 && (hero1.getCurrentHP() > 0 || hero2.getCurrentHP() > 0 || hero3.getCurrentHP() > 0))
            {
                for(GameCharacter currentCharacter : playerParty)
                {
                    if(currentCharacter.getCurrentHP()>0)
                    {
                        currentCharacter.turn(currentBoss); 
                    }
                }
                for(GameCharacter currentCharacter : playerParty)
                {
                    if(currentCharacter.getCurrentHP()>0)
                    {
                        currentCharacter.printCombatFeed();
                    }
                }
                currentBoss.turn(hero1,hero2,hero3);
            }
            //reset hp and mp between battles
            for(GameCharacter currentCharacter : playerParty) 
            {
                if(currentCharacter.getCurrentHP()>0)
                {
                    currentCharacter.setCurrentHP(currentCharacter.getMaxHP());
                    currentCharacter.setCurrentMP(currentCharacter.getMaxMP());
                }
            }
            System.out.println(lineBreak + "\n" + currentBoss.getName() + " has been defeated!");
            bossIndex++;
        }
        //if you beat all of the bosses, the game ends.
        if((hero1.getCurrentHP() > 0 || hero2.getCurrentHP() > 0 || hero3.getCurrentHP() > 0))
        {
            System.out.println(lineBreak + "\n Congratulations, you have beat Battle Bunnies! \n Developed By: The Java Juice Team (Riley Fiske, Emily Liddell, Nathan Kraft)");
        }
        //if all your characters die, the game ends.
        else
        {
            System.out.println("Game Over.");
        }
    }
    
    

    /**
     * This method handles all of the calculations--how much damage is done, HP 
     * and MP to take from the correct people, and special moves that heal, increase 
     * defence, increase critical chance, and change weakness.
     * @param attacker the game character that is performing the move.
     * @param defender the game character that is receiving the move.
     */
    public static void damageCalculation(GameCharacter attacker, GameCharacter defender)
    {
        int damageDealt = 0; //the damage the attacker has dealt this turn.
        int WEAKNESSMODIFIER = 2; //the modifier added to damage dealt to weak foes.
        
        //If the attacker uses a support skill, one of the following special effects will take place.
        if (attacker.getActionUsed().getAttackType().equals("Support"))
        {
            //if the attacker uses heal, they heal themselves by the action's base damage value.
            if(attacker.getActionUsed().getName().equals("Heal"))
            {
                 if ((attacker.getActionUsed().getBaseDamage() + attacker.getCurrentHP()) <= attacker.getMaxHP())
                 {
                     attacker.setCurrentHP(attacker.getActionUsed().getBaseDamage() + attacker.getCurrentHP());
                 }
                 else if ((attacker.getActionUsed().getBaseDamage() + attacker.getCurrentHP()) > attacker.getMaxHP())
                 {
                     attacker.setCurrentHP(attacker.getMaxHP());
                 }
                 attacker.setCurrentMP((int)(attacker.getCurrentMP() - attacker.getActionUsed().getMPRequired())); //decreses the attacker's MP appropriatley
            }
            
            //if the attacker uses lucky, their crit rate is 100% and their defence is halved.
            else if(attacker.getActionUsed().getName().equals("Lucky"))
            {
                attacker.setCriticalChance(1);
                attacker.setBaseDefence(2);
                attacker.setCurrentMP((int)(attacker.getCurrentMP() - attacker.getActionUsed().getMPRequired())); //decreses the attacker's MP appropriatley
            }
            
            //if the attacker uses iron wall, their defence is doubled until the next turn.
            else if(attacker.getActionUsed().getName().equals("Iron Wall"))
            {
                attacker.setBaseDefence(0.5);
                attacker.setCurrentMP((int)(attacker.getCurrentMP() - attacker.getActionUsed().getMPRequired())); //decreses the attacker's MP appropriatley
            }
            
            //if the attacker uses color swap, their weakness is randomly changed.
            else if(attacker.getActionUsed().getName().equals("Color Swap"))
            {
                Random weakness = new Random(); 
                //the weaknesses all have an equal chance to get picked.
                if (weakness.nextDouble() <= 0.2)
                {
                   attacker.setWeakness("Fire"); 
                }
                else if (weakness.nextDouble() <= 0.4)
                {
                    attacker.setWeakness("Water");
                }
                else if (weakness.nextDouble() <= 0.6)
                {
                    attacker.setWeakness("Air");
                }
                else if (weakness.nextDouble() <= 0.8)
                {
                    attacker.setWeakness("Earth");
                }
                else 
                {
                    attacker.setWeakness("Physical");
                }   
                attacker.setCurrentMP((int)(attacker.getCurrentMP() - attacker.getActionUsed().getMPRequired()));
            }
        }
        
        //if the defender is weak they get double damage.
        else if (attacker.getActionUsed().getAttackType().equals(defender.getWeakness()))
        {
            //actual damage calculation
            damageDealt = (int)(defender.getBaseDefence()*WEAKNESSMODIFIER*attacker.getActionUsed().getBaseDamage());
            //housekeeping
            defender.setCurrentHP((int)(defender.getCurrentHP() - damageDealt)); //decreses the defender's HP appropriately
            attacker.setDamageDealt(damageDealt);
            attacker.setCurrentMP((int)(attacker.getCurrentMP() - attacker.getActionUsed().getMPRequired())); //decreses the attacker's MP appropriatley
            defender.setDamageTaken(defender.getDamageTaken() + damageDealt); //Updates the total damage taken by the defender. 
            attacker.setBaseDefence(attacker.getMaxBaseDefence());
            attacker.setCriticalChance(attacker.getMaxCriticalChance());
            
        }
        
        //if the defender is not weak to the attack, they take base damage from the attack used on them.
        else
        {
            //actual damage calculation
            damageDealt = (int)(defender.getBaseDefence()*attacker.getActionUsed().getBaseDamage());
            //housekeeping
            defender.setCurrentHP((int)(defender.getCurrentHP() - damageDealt)); //decreses the defender's HP appropriately
            attacker.setDamageDealt(damageDealt);
            attacker.setCurrentMP((int)(attacker.getCurrentMP() - attacker.getActionUsed().getMPRequired())); //decreses the attacker's MP appropriatley
            defender.setDamageTaken(defender.getDamageTaken() + damageDealt); //Updates the total damage taken by the defender.
            attacker.setBaseDefence(attacker.getMaxBaseDefence());
            attacker.setCriticalChance(attacker.getMaxCriticalChance());
        }
    }
}