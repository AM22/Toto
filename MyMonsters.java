
/**
 * Keeps track of the player's Totos.
 *
 * @author Joshua Wu
 * @version 1
 */
public class MyMonsters
{
    // instance variables - replace the example below with your own
    private Monster[] myMonsters;
    private int monsterCount = 0;

    /**
     * Constructor for objects of class MyMonsters
     */
    public MyMonsters()
    {
        myMonsters = new Monster[6];
    }

    public void addMonster(Monster toto)
    {
        if(monsterCount < 6)
        {
            myMonsters[monsterCount] = toto;
            monsterCount++;
        }
    }
    
    public Monster[] getMonsters()
    {
        return myMonsters;
    }
    
    public int getCount()
    {
        return monsterCount;
    }
}
