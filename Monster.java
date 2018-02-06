import javax.swing.ImageIcon;

/**
 * Abstract class for monsters.
 *
 * @author Joshua Wu
 * @version 1
 */
public abstract class Monster
{
    // instance variables - replace the example below with your own
    private int attack;
    private int defense;
    private int spatt;
    private int spdef;
    private int speed;
    private int hp;
    private int level;
    private int currentHP;
    private int thresholdLevel;
    private String[] moves;
    private int[] movePower;
    private String name;
    private ImageIcon monsterPic;
    

    /**
     * Constructor for objects of class Monster
     */
    public Monster(String monsterName)
    {
        attack = 0;
        defense = 0;
        spatt = 0;
        spdef = 0;
        speed = 0;
        hp = 0;
        level = 0;
        currentHP = 0;
        thresholdLevel = 0;
        name = monsterName;
        moves = new String[4];
        movePower = new int[4];
    }
    
    public abstract void stats();
    
    public abstract void display();
    
    public abstract void moves();
    
    public abstract void transform(Monster[] monsters);
    
    public void setStats(int att, int def, int satt, int sdef, int spd, int health, int lv)
    {
        attack = att;
        defense = def;
        spatt = satt;
        spdef = sdef;
        speed = spd;
        hp = health;
        level = lv;
        currentHP = hp;
    }
    
    public int getAtt()
    {
        return attack;
    }
    
    public int getDef()
    {
        return defense;
    }
    
    public int getSatt()
    {
        return spatt;
    }
    
    public int getSdef()
    {
        return spdef;
    }
    
    public int getSpd()
    {
        return speed;
    }
    
    public int getHealth()
    {
        return hp;
    }
    
    public int getLevel()
    {
        return level;
    }
    
    public void setLevel(int lv)
    {
        level = lv;
    }
    
    public void setThreshold(int level)
    {
        thresholdLevel = level;
    }
    
    public int getThreshold()
    {
        return thresholdLevel;
    }
    
    public void setName(String monsterName)
    {
        name = monsterName;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setMoves(String move1, String move2, String move3, String move4, int power1, int power2, int power3, int power4)
    {
        moves[0] = move1;
        moves[1] = move2;
        moves[2] = move3;
        moves[3] = move4;
        movePower[0] = power1;
        movePower[1] = power2;
        movePower[2] = power3;
        movePower[3] = power4;
    }
    
    public String[] getMoves()
    {
        return moves;
    }
    
    public int[] getMovePower()
    {
        return movePower;
    }
    
    public void setPicture(String file)
    {
        monsterPic = new ImageIcon(file);
    }
    
    public ImageIcon getPicture()
    {
        return monsterPic;
    }
    
    public void setHealth(int hp)
    {
        currentHP = hp;
    }
    
    public int getCurrentHealth()
    {
        return currentHP;
    }
}
