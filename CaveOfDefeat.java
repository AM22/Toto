import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComponent;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Stimulates the Cave of Defeat
 *
 * @author Joshua Wu
 * @version 1
 */
public class CaveOfDefeat
{
    // instance variables - replace the example below with your own
    private static final int FRAME_WIDTH = 1920; 
    private static final int FRAME_HEIGHT = 1080; 
    private MyMonsters myMonsters;
    private Bag myBag;
    private JFrame cFrame;
    private String enemyName;
    
    /**
     * Constructor for objects of class CaveOfDefeat
     */
    public CaveOfDefeat(MyMonsters monsters, Bag bag, JFrame frame)
    {
        myMonsters = monsters;
        myBag = bag;
        cFrame = frame;
        enemyName = "";
    }
    
    public void play()
    {
        JPanel panel = new JPanel(new BorderLayout());
        Random rng = new Random();

        ImageIcon cave2 = new ImageIcon("caveTwo.png");
        ImageIcon cave1 = new ImageIcon("caveOne.png");
        ImageIcon sfere = new ImageIcon("sfere.png");
        ImageIcon intersfere = new ImageIcon("intersfere.png");
        ImageIcon znake = new ImageIcon("znake.png");
        ImageIcon haznake = new ImageIcon("haznake.png");
        ImageIcon magon = new ImageIcon("magon.png");
        ImageIcon icagon = new ImageIcon("icagon.png");
        ImageIcon adagon = new ImageIcon("adagon.png");
        JLabel imageLabel = new JLabel(cave2); 
        JLabel imageLabel1 = new JLabel(cave1);
        panel.add(imageLabel, BorderLayout.LINE_START);
        cFrame.add(panel);
        
        JFrame tFrame = new JFrame("Cave of Defeat");
        JPanel tPanel = new JPanel(new BorderLayout());
        JButton next = new JButton("OK");
        JButton fight = new JButton("Fight");
        JButton left = new JButton("Left");
        JButton right = new JButton("Right");
        JButton back = new JButton("Go Back");
        JButton bag = new JButton("Bag");
        JButton potion = new JButton("Potion");
        JButton superP = new JButton("Super Potion");
        JButton hyperP = new JButton("Hyper Potion");
        JButton maxP = new JButton("Max Potion");
        JButton monocle = new JButton("Monocle");
        JButton stone = new JButton("Death Stone");
        left.setFont(new Font("Arial", Font.PLAIN, 60));
        right.setFont(new Font("Arial", Font.PLAIN, 60));
        back.setFont(new Font("Arial", Font.PLAIN, 60));
        next.setFont(new Font("Arial", Font.PLAIN, 60));
        bag.setFont(new Font("Arial", Font.PLAIN, 60));
        fight.setFont(new Font("Arial", Font.PLAIN, 60));
        potion.setFont(new Font("Arial", Font.PLAIN, 40));
        superP.setFont(new Font("Arial", Font.PLAIN, 40));
        hyperP.setFont(new Font("Arial", Font.PLAIN, 40));
        maxP.setFont(new Font("Arial", Font.PLAIN, 40));
        monocle.setFont(new Font("Arial", Font.PLAIN, 40));
        stone.setFont(new Font("Arial", Font.PLAIN, 40));
        ImageIcon box = new ImageIcon("textBox.png");
        JLabel textBox = new JLabel(box);
        textBox.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel text = new JLabel("Where will you go?");
        text.setFont(new Font("Arial", Font.PLAIN, 50));
        textBox.add(text);
        tFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        tFrame.add(textBox);
        tFrame.add(left);
        tFrame.add(right);
        tFrame.add(bag);
        tPanel.add(back);
        tFrame.add(tPanel);
        
        class ClickListener implements ActionListener {
            int firstCounter;
            JLabel monsterLabel;
            int averageLevel;
            int index;
            boolean exists;
            boolean goBack;
            JFrame frame = new JFrame();
            
            public void actionPerformed(ActionEvent event) 
            {
                Object obj = event.getSource();
                averageLevel = 0;
                index = 0;
                exists = false;
                goBack = false;
                Monster enemy;
                for(int i = 0; i < myMonsters.getCount(); i++)
                {
                    averageLevel = averageLevel + myMonsters.getMonsters()[i].getLevel();
                }
                averageLevel = averageLevel / myMonsters.getCount();
                if(obj == back)
                {
                    panel.remove(imageLabel);
                    panel.add(imageLabel1);
                    cFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
                    cFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    int bossNumber = rng.nextInt(100);
                    goBack = true;
                    if(bossNumber < 50)
                    {
                        tFrame.remove(left);
                        tFrame.remove(right);
                        tFrame.remove(bag);
                        tPanel.remove(back);
                        tFrame.add(fight);
                        tFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                        tFrame.setBounds(100, 500, 1100, 300);
                        JLabel label = new JLabel(intersfere);
                        frame.add(label);
                        text.setText("A wild Intersfere blocks your path!");
                        setName("Intersfere");
                        frame.setBounds(300, 0, 850, 500);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setVisible(true);
                    }
                    else if(bossNumber < 75 && bossNumber >= 50)
                    {
                        tFrame.remove(left);
                        tFrame.remove(right);
                        tFrame.remove(bag);
                        tPanel.remove(back);
                        tFrame.add(fight);
                        tFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                        tFrame.setBounds(100, 500, 1100, 300);
                        JLabel label = new JLabel(icagon);
                        frame.add(label);
                        text.setText("A wild Icagon blocks your path!");
                        setName("Icagon");
                        frame.setBounds(300, 0, 850, 500);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setVisible(true);
                    }
                    else if(bossNumber == 99)
                    {
                        tFrame.remove(left);
                        tFrame.remove(right);
                        tFrame.remove(bag);
                        tPanel.remove(back);
                        tFrame.add(fight);
                        tFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                        tFrame.setBounds(100, 500, 1100, 300);
                        JLabel label = new JLabel(adagon);
                        frame.add(label);
                        text.setText("A wild Adagon blocks your path!");
                        setName("Adagon");
                        frame.setBounds(300, 0, 850, 500);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setVisible(true);
                    }
                    else
                    {
                        tFrame.remove(left);
                        tFrame.remove(right);
                        tFrame.remove(bag);
                        tPanel.remove(back);
                        tFrame.add(fight);
                        tFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                        tFrame.setBounds(100, 500, 1100, 300);
                        JLabel label = new JLabel(haznake);
                        frame.add(label);
                        text.setText("A wild Haznake blocks your path!");
                        enemy = new Haznake(averageLevel);
                        enemy.display();
                        enemy.moves();
                        frame.setBounds(300, 0, 850, 500);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setVisible(true);
                    }
                }
                else if(obj == bag)
                {
                    text.setText("Which item will you use?");
                    tFrame.remove(left);
                    tFrame.remove(right);
                    tFrame.remove(bag);
                    tPanel.remove(back);
                    tFrame.add(potion);
                    tFrame.add(superP);
                    tFrame.add(hyperP);
                    tFrame.add(maxP);
                    tFrame.add(monocle);
                    tFrame.add(stone);
                    tFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                    tFrame.setBounds(100, 500, 1100, 300);
                }
                else if(obj == next)
                {
                    text.setText("Where will you go?");
                    tFrame.add(left);
                    tFrame.add(right);
                    tFrame.add(bag);
                    tPanel.add(back);
                    tFrame.remove(next);
                    tFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                    tFrame.setBounds(100, 500, 1100, 300);
                }
                else if(obj == potion)
                {
                    tFrame.remove(potion);
                    tFrame.remove(superP);
                    tFrame.remove(hyperP);
                    tFrame.remove(maxP);
                    tFrame.remove(monocle);
                    tFrame.remove(stone);
                    tPanel.remove(back);
                    tFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                    tFrame.setBounds(100, 500, 1100, 300);
                    for(int i = 0; i < myBag.getCount(); i++)
                    {
                        if(myBag.getItemName(i) == "Potion")
                        {
                            exists = true;
                            index = i;
                        }
                    }
                    if(exists)
                    {
                        text.setText(myMonsters.getMonsters()[0].getName() + " restored 20 HP.");
                        myMonsters.getMonsters()[0].setHealth(myMonsters.getMonsters()[0].getCurrentHealth() + 20);
                        myBag.destroyItem(index);
                    }
                    else
                    {
                        text.setText("You do not have this item!");
                    }
                    tFrame.add(next);
                }
                else if(obj == superP)
                {
                    tFrame.remove(potion);
                    tFrame.remove(superP);
                    tFrame.remove(hyperP);
                    tFrame.remove(maxP);
                    tFrame.remove(monocle);
                    tFrame.remove(stone);
                    tPanel.remove(back);
                    tFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                    tFrame.setBounds(100, 500, 1100, 300);
                    for(int i = 0; i < myBag.getCount(); i++)
                    {
                        if(myBag.getItemName(i) == "Super Potion")
                        {
                            exists = true;
                            index = i;
                        }
                    }
                    if(exists)
                    {
                        text.setText(myMonsters.getMonsters()[0].getName() + " restored 50 HP.");
                        myMonsters.getMonsters()[0].setHealth(myMonsters.getMonsters()[0].getCurrentHealth() + 50);
                        myBag.destroyItem(index);
                    }
                    else
                    {
                        text.setText("You do not have this item!");
                    }
                    tFrame.add(next);
                }
                else if(obj == hyperP)
                {
                    tFrame.remove(potion);
                    tFrame.remove(superP);
                    tFrame.remove(hyperP);
                    tFrame.remove(maxP);
                    tFrame.remove(monocle);
                    tFrame.remove(stone);
                    tPanel.remove(back);
                    tFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                    tFrame.setBounds(100, 500, 1100, 300);
                    for(int i = 0; i < myBag.getCount(); i++)
                    {
                        if(myBag.getItemName(i) == "Hyper Potion")
                        {
                            exists = true;
                            index = i;
                        }
                    }
                    if(exists)
                    {
                        text.setText(myMonsters.getMonsters()[0].getName() + " restored 200 HP.");
                        myMonsters.getMonsters()[0].setHealth(myMonsters.getMonsters()[0].getCurrentHealth() + 200);
                        myBag.destroyItem(index);
                    }
                    else
                    {
                        text.setText("You do not have this item!");
                    }
                    tFrame.add(next);
                }
                else if(obj == maxP)
                {
                    tFrame.remove(potion);
                    tFrame.remove(superP);
                    tFrame.remove(hyperP);
                    tFrame.remove(maxP);
                    tFrame.remove(monocle);
                    tFrame.remove(stone);
                    tPanel.remove(back);
                    tFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                    tFrame.setBounds(100, 500, 1100, 300);
                    for(int i = 0; i < myBag.getCount(); i++)
                    {
                        if(myBag.getItemName(i) == "Max Potion")
                        {
                            exists = true;
                            index = i;
                        }
                    }
                    if(exists)
                    {
                        text.setText(myMonsters.getMonsters()[0].getName() + " restored all HP.");
                        myMonsters.getMonsters()[0].setHealth(myMonsters.getMonsters()[0].getHealth());
                        myBag.destroyItem(index);
                    }
                    else
                    {
                        text.setText("You do not have this item!");
                    }
                    tFrame.add(next);
                }
                else if(obj == monocle)
                {
                    tFrame.remove(potion);
                    tFrame.remove(superP);
                    tFrame.remove(hyperP);
                    tFrame.remove(maxP);
                    tFrame.remove(monocle);
                    tFrame.remove(stone);
                    tPanel.remove(back);
                    tFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                    tFrame.setBounds(100, 500, 1100, 300);
                    for(int i = 0; i < myBag.getCount(); i++)
                    {
                        if(myBag.getItemName(i) == "Monocle")
                        {
                            exists = true;
                            index = i;
                        }
                    }
                    if(exists)
                    {
                        if(myMonsters.getMonsters()[0].getName() == "Sfere")
                        {
                            myMonsters.getMonsters()[0] = new Sircumference(myMonsters.getMonsters()[0].getLevel());
                            text.setText("Sfere transformed into Sircumference!");
                        }
                        else
                        {
                            text.setText("You cannot use that right now!");
                        }
                    }
                    else
                    {
                        text.setText("You do not have this item!");
                    }
                    tFrame.add(next);
                }
                else if(obj == stone)
                {
                    tFrame.remove(potion);
                    tFrame.remove(superP);
                    tFrame.remove(hyperP);
                    tFrame.remove(maxP);
                    tFrame.remove(monocle);
                    tFrame.remove(stone);
                    tPanel.remove(back);
                    tFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                    tFrame.setBounds(100, 500, 1100, 300);
                    for(int i = 0; i < myBag.getCount(); i++)
                    {
                        if(myBag.getItemName(i) == "Monocle")
                        {
                            exists = true;
                            index = i;
                        }
                    }
                    if(exists)
                    {
                        if(myMonsters.getMonsters()[0].getName() == "Magon")
                        {
                            myMonsters.getMonsters()[0] = new Boby(myMonsters.getMonsters()[0].getLevel());
                            text.setText("Magon transformed into Boby!");
                        }
                        else
                        {
                            text.setText("You cannot use that right now!");
                        }
                    }
                    else
                    {
                        text.setText("You do not have this item!");
                    }
                    tFrame.add(next);
                }
                else if(obj == fight)
                {
                    tFrame.setVisible(false);
                    frame.setVisible(false);
                    cFrame.remove(panel);
                    if(getName().equals("Znake"))
                    {
                        enemy = new Znake(averageLevel);
                        enemy.display();
                        enemy.moves();
                    }
                    else if(getName().equals("Haznake"))
                    {
                        enemy = new Haznake(averageLevel);
                        enemy.display();
                        enemy.moves();
                    }
                    else if(getName().equals("Magon"))
                    {
                        enemy = new Magon(averageLevel);
                        enemy.display();
                        enemy.moves();
                    }
                    else if(getName().equals("Icagon"))
                    {
                        enemy = new Icagon(averageLevel);
                        enemy.display();
                        enemy.moves();
                    }
                    else if(getName().equals("Adagon"))
                    {
                        enemy = new Adagon(averageLevel);
                        enemy.display();
                        enemy.moves();
                    }
                    else if(getName().equals("Intersfere"))
                    {
                        enemy = new Intersfere(averageLevel);
                        enemy.display();
                        enemy.moves();
                    }
                    else
                    {
                        enemy = new Sfere(averageLevel);
                        enemy.display();
                        enemy.moves();
                    }
                    Battle battle = new Battle(myMonsters, enemy, myBag, goBack, cFrame);
                    battle.startBattle();
                }
                else
                {
                    panel.remove(imageLabel);
                    panel.add(imageLabel1);
                    cFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
                    cFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    int enemyNumber = rng.nextInt(20);
                    if(enemyNumber < 10)
                    {
                        tFrame.remove(left);
                        tFrame.remove(right);
                        tFrame.remove(bag);
                        tPanel.remove(back);
                        tFrame.add(fight);
                        tFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                        tFrame.setBounds(100, 500, 1100, 300);
                        JLabel label = new JLabel(sfere);
                        frame.add(label);
                        text.setText("A wild Sfere appeared!");
                        enemy = new Sfere(averageLevel);
                        enemy.display();
                        enemy.moves();
                        frame.setBounds(300, 0, 850, 500);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setVisible(true);
                    }
                    else if(enemyNumber >= 10 && enemyNumber < 17)
                    {
                        tFrame.remove(left);
                        tFrame.remove(right);
                        tFrame.remove(bag);
                        tPanel.remove(back);
                        tFrame.add(fight);
                        tFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                        tFrame.setBounds(100, 500, 1100, 300);
                        JLabel label = new JLabel(znake);
                        frame.add(label);
                        text.setText("A wild Znake appeared!");
                        setName("Znake");
                        frame.setBounds(300, 0, 850, 500);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setVisible(true);
                    }
                    else
                    {
                        tFrame.remove(left);
                        tFrame.remove(right);
                        tFrame.remove(bag);
                        tPanel.remove(back);
                        tFrame.add(fight);
                        tFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                        tFrame.setBounds(100, 500, 1100, 300);
                        JLabel label = new JLabel(magon);
                        frame.add(label);
                        text.setText("A wild Magon appeared!");
                        setName("Magon");
                        frame.setBounds(300, 0, 850, 500);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setVisible(true);
                    }
                }
            }
        }
        
        ActionListener listenerLeft = new ClickListener();
        ActionListener listenerRight = new ClickListener();
        ActionListener listenerBack = new ClickListener();
        ActionListener listenerBag = new ClickListener();
        ActionListener listenerNext = new ClickListener();
        ActionListener listenerFight = new ClickListener();
        ActionListener listenerP = new ClickListener();
        ActionListener listenerS = new ClickListener();
        ActionListener listenerH = new ClickListener();
        ActionListener listenerM = new ClickListener();
        ActionListener listenerMon = new ClickListener();
        ActionListener listenerStone = new ClickListener();
        left.addActionListener(listenerLeft);
        right.addActionListener(listenerRight);
        back.addActionListener(listenerBack);
        bag.addActionListener(listenerBag);
        next.addActionListener(listenerNext);
        fight.addActionListener(listenerFight);
        potion.addActionListener(listenerP);
        superP.addActionListener(listenerS);
        hyperP.addActionListener(listenerH);
        maxP.addActionListener(listenerM);
        monocle.addActionListener(listenerMon);
        stone.addActionListener(listenerStone);
        
        cFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        cFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        cFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cFrame.setVisible(true);
        
        tFrame.setBounds(100, 500, 1100, 300);
        tFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tFrame.setVisible(true);
    }
    
    public String getName()
    {
        return enemyName;
    }
    
    public void setName(String name)
    {
        enemyName = name;
    }
}