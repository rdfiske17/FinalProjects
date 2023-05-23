package battlebunnies;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Java Juice
 */
public class BattleBunnies {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("Welcome to Battle Bunnies! This is the text based simulation of the game that will eventually be put into a graphical interface."
                + "\n The purpose of this test is to verify that the battle calculations work under the hood before making it visual.");
       
        
        CharacterAbility attack = new CharacterAbility("Attack","","Physical",10,0);
        CharacterAbility airBlast = new CharacterAbility("Air Blast","","Air",20,5);
        CharacterAbility heal = new CharacterAbility("Heal","","Support",15,10);
        
        GameCharacter bill = new GameCharacter("Bill",1,100,100,20,20,"Fire",1,1,0.25,0.25,attack,airBlast,heal,0,0,new CharacterAbility());
        
        ArrayList<GameCharacter> playerParty = new ArrayList();
        playerParty.add(bill);
        ArrayList <GameCharacter> bossList = new ArrayList();
        bossList.add(new GameCharacter("The Eye of Cthulu",1,100,100,20,20,"Fire",1,1,0.25,0.25,attack,airBlast,heal,0,0,new CharacterAbility()));
        int bossIndex = 0;
        GameCharacter currentBoss = bossList.get(bossIndex);
        
        while(true) //set conditions for the game to run
        {
            while(currentBoss.getCurrentHP()>0)
            {
                for(GameCharacter currentCharacter : playerParty)
                {
                    if(currentCharacter.getCurrentHP()>0)
                    {
                        currentCharacter.turn(currentBoss); 
                    }
                }
                currentBoss.turn(bill); //THERE WILL BE A DIFFERENT TURN METHOD FOR THE BOSS
                for(GameCharacter currentCharacter : playerParty)
                {
                    if(currentCharacter.getCurrentHP()>0)
                    {
                        currentCharacter.printCombatFeed();
                    }
                    currentBoss.printCombatFeed();
                }
            }
        }
        
    }
    
    

    public static void damageCalculation(GameCharacter attacker, GameCharacter defender)
    {
        Random critChanceRNG = new Random();
        int CRITMODIFIER = 2;
        int damageDealt = 0;
        int WEAKNESSMODIFIER = 2;
        
        if (attacker.getActionUsed().getAttackType().equals("Support"))
        {
            //NEED TO MAKE IT SO THAT YOU CAN HEAL MORE THAN JUST YOURSELF
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
            else if(attacker.getActionUsed().getName().equals("Lucky"))
            {
                attacker.setCriticalChance(1);
                attacker.setBaseDefence(2);
                attacker.setCurrentMP((int)(attacker.getCurrentMP() - attacker.getActionUsed().getMPRequired())); //decreses the attacker's MP appropriatley
            }
            else if(attacker.getActionUsed().getName().equals("Iron Wall"))
            {
                attacker.setBaseDefence(0.5);
                attacker.setCurrentMP((int)(attacker.getCurrentMP() - attacker.getActionUsed().getMPRequired())); //decreses the attacker's MP appropriatley
            }
            
            //NEW CODE NEW CODE NEW CODE
            else if(attacker.getActionUsed().getName().equals("Color Swap"))
            {
                Random weakness = new Random();
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
                
            }
            else if(attacker.getActionUsed().getName().equals("Revive"))
            {
                attacker.setCurrentHP(50);
            }
        }
        
        //if the defender is weak they get double damage
        else if (attacker.getActionUsed().getAttackType().equals(defender.getWeakness()))
        {
            //If the critical chance is more than the random number, they perform a critical hit.
            if(critChanceRNG.nextDouble()<attacker.getCriticalChance())
            {
                damageDealt = (int)(defender.getBaseDefence()*CRITMODIFIER*WEAKNESSMODIFIER*attacker.getActionUsed().getBaseDamage());
            }
            else
            {
                damageDealt = (int)(defender.getBaseDefence()*WEAKNESSMODIFIER*attacker.getActionUsed().getBaseDamage());
            }

            defender.setCurrentHP((int)(defender.getCurrentHP() - damageDealt)); //decreses the defender's HP appropriatley
            attacker.setDamageDealt(damageDealt);
            attacker.setCurrentMP((int)(attacker.getCurrentMP() - attacker.getActionUsed().getMPRequired())); //decreses the attacker's MP appropriatley
            defender.setDamageTaken(defender.getDamageTaken() + damageDealt); //Updates the total damage taken by the defender. I dont think we will need this value, but I'll keep it here for now.
            attacker.setBaseDefence(attacker.getMaxBaseDefence());
            attacker.setCriticalChance(attacker.getMaxCriticalChance());
            
        }
        
        else
        {
            //If the critical chance is more than the random number, they perform a critical hit.
            if(critChanceRNG.nextDouble()<attacker.getCriticalChance())
            {
                damageDealt = (int)(defender.getBaseDefence()*CRITMODIFIER*attacker.getActionUsed().getBaseDamage());
            }
            else
            {
                damageDealt = (int)(defender.getBaseDefence()*attacker.getActionUsed().getBaseDamage());
            }

            defender.setCurrentHP((int)(defender.getCurrentHP() - damageDealt)); //decreses the defender's HP appropriatley
            attacker.setDamageDealt(damageDealt);
            attacker.setCurrentMP((int)(attacker.getCurrentMP() - attacker.getActionUsed().getMPRequired())); //decreses the attacker's MP appropriatley
            defender.setDamageTaken(defender.getDamageTaken() + damageDealt); //Updates the total damage taken by the defender. I dont think we will need this value, but I'll keep it here for now.
            attacker.setBaseDefence(attacker.getMaxBaseDefence());
            attacker.setCriticalChance(attacker.getMaxCriticalChance());
        }
        
        
    }
}