package battlebunnies;

/**
 * CharacterAbility controls all the abilities that GameCharacters can use. 
 * Abilities have names, descriptions, an attack type, a damage they deal, and 
 * an MP requirement.
 * @author Java Juice
 */
public class CharacterAbility 
{
    //INSTANCE VARIABLES
    
    private String name = "";
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    
    private String description = "";
    public String getDescription(){return description;}
    public void setDescription(String description){this.description = description;}
    
    private String attackType = "";
    public String getAttackType(){return attackType;}
    public void setAttackType(String attackType){this.attackType = attackType;}
    
    private int baseDamage = 0;
    public int getBaseDamage(){return baseDamage;}
    public void setBaseDamage(int baseDamage){this.baseDamage = baseDamage;}
    
    private int MPRequired = 0;
    public int getMPRequired(){return MPRequired;}
    public void setMPRequired(int MPRequired){this.MPRequired = MPRequired;}
    
    //CONSTRUCTORS
    
    /**
     * Empty Constructor.
     */
    public CharacterAbility()
    {
        
    }
    
    /**
     * Full constructor.
     * @param name name of the ability
     * @param description a description of what the ability does.
     * @param attackType the typing of the ability.
     * @param baseDamage the amount of damage the ability does.
     * @param MPRequired the amount of MP required to use.
     */
    public CharacterAbility(String name,String description,String attackType,int baseDamage,int MPRequired)
    {
        setName(name);
        setDescription(description);
        setAttackType(attackType);
        setBaseDamage(baseDamage);
        setMPRequired(MPRequired);
    }
}
