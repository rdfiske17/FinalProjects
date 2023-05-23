package battlebunnies;

/**
 *
 * @author Java Juice
 */
public class CharacterAbility 
{
    private String name = "";
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    
    private String description = "";
    public String getDescription(){return description;}
    public void setDescription(String description){this.description = description;}
    
    private String attackType = "";
    public String getAttackType(){return attackType;}
    public void setAttackType(String attackType){this.attackType = attackType;}
    //attack types being fire,earth,air,water; fire beats earth,earth beats air,air beats water,water beats fire,physical is balanced
    
    private int baseDamage = 0;
    public int getBaseDamage(){return baseDamage;}
    public void setBaseDamage(int baseDamage){this.baseDamage = baseDamage;}
    
    private int MPRequired = 0;
    public int getMPRequired(){return MPRequired;}
    public void setMPRequired(int MPRequired){this.MPRequired = MPRequired;}
    
    
    public CharacterAbility()
    {
        
    }
    
    public CharacterAbility(String name,String description,String attackType,int baseDamage,int MPRequired)
    {
        setName(name);
        setDescription(description);
        setAttackType(attackType);
        setBaseDamage(baseDamage);
        setMPRequired(MPRequired);
    }
    
}
