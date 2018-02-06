
/**
 * Models the trainer's bag.
 *
 * @author Joshua Wu
 * @version 1
 */
public class Bag
{
    // instance variables - replace the example below with your own
    private String[] bag;
    private int money;
    private int itemCount;

    /**
     * Constructor for objects of class Bag
     */
    public Bag()
    {
        // initialise instance variables
        bag = new String[15];
        money = 0;
    }
    
    public void spendMoney(int amount)
    {
        money = money - amount;
    }
    
    public void addMoney(int amount)
    {
        money = money + amount;
    }
    
    public int getMoney()
    {
        return money;
    }
    
    public int getCount()
    {
        return itemCount;
    }
    
    public void addItem(String item)
    {
        bag[itemCount] = item;
        itemCount++;
    }
    
    public String getItemName(int index)
    {
        return bag[index];
    }
    
    public void destroyItem(int index)
    {
        for(int i = index; i < 14; i++)
        {
            bag[index] = bag[index + 1];
        }
    }
}
