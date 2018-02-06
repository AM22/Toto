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
import javax.swing.JOptionPane;

/**
 * Simulates a battle between two Totos.
 *
 * @author Joshua Wu
 * @version 1
 */
public class Battle
{
    private MyMonsters myMonsters;
    private Monster enemy;
    private boolean caught;
    private boolean goBack;
    private JFrame bFrame;
    private Bag myBag;
    private JLabel healthBar;
    private static final int FRAME_WIDTH = 1920; 
    private static final int FRAME_HEIGHT = 1080; 
    
    public Battle(MyMonsters myTotos, Monster enemyMonster, Bag bag, boolean back, JFrame frame)
    {
        enemy = enemyMonster;
        enemy.stats();
        enemy.display();
        enemy.moves();
        myMonsters = myTotos;
        goBack = back;
        caught = false;
        bFrame = frame;
        myBag = bag;
        healthBar = new JLabel(myMonsters.getMonsters()[0].getName() + " " + myMonsters.getMonsters()[0].getCurrentHealth() + "/" + myMonsters.getMonsters()[0].getHealth() + "                                                    " + enemy.getName() + " " + enemy.getCurrentHealth() + "/" + enemy.getHealth());
    }
    
    public void startBattle()
    {
        JPanel panel = new JPanel(new BorderLayout());
        
        ImageIcon myToto = myMonsters.getMonsters()[0].getPicture();
        ImageIcon enemyToto = enemy.getPicture();
        JLabel myPic = new JLabel(myToto);
        JLabel enemyPic = new JLabel(enemyToto);
        panel.add(myPic, BorderLayout.LINE_START);
        panel.add(enemyPic, BorderLayout.LINE_END);
        bFrame.add(panel);
        myMonsters.getMonsters()[0].moves();
        myMonsters.getMonsters()[0].stats();
        JFrame tFrame = new JFrame();
        JPanel tPanel = new JPanel(new FlowLayout());
        JLabel text = new JLabel("A wild " + enemy.getName() + " appeared!");
        JLabel endGame = new JLabel("GAME OVER");
        JButton fight = new JButton("Fight");
        JButton bag = new JButton("Bag");
        JButton back = new JButton("Back");
        JButton attack1 = new JButton(myMonsters.getMonsters()[0].getMoves()[0]);
        JButton attack2 = new JButton(myMonsters.getMonsters()[0].getMoves()[1]);
        JButton attack3 = new JButton(myMonsters.getMonsters()[0].getMoves()[2]);
        JButton attack4 = new JButton(myMonsters.getMonsters()[0].getMoves()[3]);
        JButton disc = new JButton("Toto Disc");
        JButton potion = new JButton("Potion");
        JButton superP = new JButton("Super Potion");
        JButton hyperP = new JButton("Hyper Potion");
        JButton maxP = new JButton("Max Potion");
        JButton next = new JButton("OK");
        JButton end = new JButton("End");
        JButton cont = new JButton("Continue");
        text.setFont(new Font("Arial", Font.PLAIN, 50));
        endGame.setFont(new Font("Arial", Font.PLAIN, 60));
        fight.setFont(new Font("Arial", Font.PLAIN, 60));
        bag.setFont(new Font("Arial", Font.PLAIN, 60));
        back.setFont(new Font("Arial", Font.PLAIN, 60));
        attack1.setFont(new Font("Arial", Font.PLAIN, 60));
        attack2.setFont(new Font("Arial", Font.PLAIN, 60));
        attack3.setFont(new Font("Arial", Font.PLAIN, 60));
        attack4.setFont(new Font("Arial", Font.PLAIN, 60));
        disc.setFont(new Font("Arial", Font.PLAIN, 60));
        potion.setFont(new Font("Arial", Font.PLAIN, 60));
        superP.setFont(new Font("Arial", Font.PLAIN, 60));
        hyperP.setFont(new Font("Arial", Font.PLAIN, 60));
        maxP.setFont(new Font("Arial", Font.PLAIN, 60));
        next.setFont(new Font("Arial", Font.PLAIN, 60));
        end.setFont(new Font("Arial", Font.PLAIN, 60));
        cont.setFont(new Font("Arial", Font.PLAIN, 60));
        tPanel.add(text);
        tPanel.add(next);
        tFrame.add(tPanel);
        
        class ClickListener implements ActionListener {
            int firstCounter;
            boolean exists;
            int index;
            int damage = 0;
            int movePower = 0;
            int[] movePowers = myMonsters.getMonsters()[0].getMovePower();
            int enemyPower = 0;
            int[] enemyPowers = enemy.getMovePower();
            Random rng = new Random();

            public void actionPerformed(ActionEvent event) 
            {
                Object obj = event.getSource();
                exists = false;
                index = 0;
                healthBar.setFont(new Font("Arial", Font.PLAIN, 50));
                if(obj == next)
                {
                    firstCounter++;
                    if(firstCounter == 1)
                    {
                        text.setText("Go! " + myMonsters.getMonsters()[0].getName() + "!");
                        panel.add(healthBar, BorderLayout.PAGE_START);
                    }
                    else if(firstCounter >= 2)
                    {
                        text.setText("What will " + myMonsters.getMonsters()[0].getName() + " do?");
                        tPanel.remove(next);
                        tPanel.add(fight);
                        tPanel.add(bag);
                    }
                }
                else if(obj == fight)
                {
                        tPanel.remove(fight);
                        tPanel.remove(bag);
                        Monster active = myMonsters.getMonsters()[0];
                        do {
                                                String moves = JOptionPane.showInputDialog(null,  "What does " + active.getName() + " use?\n 1) " + active.getMoves()[0] + " 2) " + active.getMoves()[1] + " 3) " + active.getMoves()[2] + " 4) " + active.getMoves()[3] + " 5) Back");
                                                switch (moves) {
                                                    case "1":
                                                        movePower = movePowers[0];
                                                        damage = (int) (enemy.getLevel() * movePower * (double) active.getAtt() / (double) enemy.getDef() / 125.0);
                                                        JOptionPane.showMessageDialog(null, active.getName() + " used " + active.getMoves()[0] + "! Did " + damage + " damage!");
                                                        enemy.setHealth(enemy.getCurrentHealth() - damage);
                                                        healthBar.setText(myMonsters.getMonsters()[0].getName() + " " + active.getCurrentHealth() + "/" + myMonsters.getMonsters()[0].getHealth() + "                                                    " + enemy.getName() + " " + enemy.getCurrentHealth() + "/" + enemy.getHealth());
                                                        bFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
                                                        bFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                                                        tFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                                                        tFrame.setBounds(100, 625, 1100, 300);tFrame.setBounds(100, 625, 1100, 300);
                                                        break;
                                                    case "2": 
                                                        movePower = movePowers[1];
                                                        damage = (int) (enemy.getLevel() * movePower * (double) active.getAtt() / (double) enemy.getDef() / 125.0);
                                                        JOptionPane.showMessageDialog(null, active.getName() + " used " + active.getMoves()[1] + "! Did " + damage + " damage!");
                                                        enemy.setHealth(enemy.getCurrentHealth() - damage);
                                                        healthBar.setText(myMonsters.getMonsters()[0].getName() + " " + active.getCurrentHealth() + "/" + myMonsters.getMonsters()[0].getHealth() + "                                                    " + enemy.getName() + " " + enemy.getCurrentHealth() + "/" + enemy.getHealth());
                                                        bFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
                                                        bFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                                                        tFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                                                        tFrame.setBounds(100, 625, 1100, 300);tFrame.setBounds(100, 625, 1100, 300);
                                                        break;
                                                    case "3": 
                                                        movePower = movePowers[2];
                                                        damage = (int) (enemy.getLevel() * movePower * (double) active.getSatt() / (double) enemy.getSdef() / 125.0);
                                                        JOptionPane.showMessageDialog(null, active.getName() + " used " + active.getMoves()[2] + "! Did " + damage + " damage!");
                                                        enemy.setHealth(enemy.getCurrentHealth() - damage);
                                                        healthBar.setText(myMonsters.getMonsters()[0].getName() + " " + active.getCurrentHealth() + "/" + myMonsters.getMonsters()[0].getHealth() + "                                                    " + enemy.getName() + " " + enemy.getCurrentHealth() + "/" + enemy.getHealth());
                                                        bFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
                                                        bFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                                                        tFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                                                        tFrame.setBounds(100, 625, 1100, 300);tFrame.setBounds(100, 625, 1100, 300);
                                                        break;
                                                    case "4": 
                                                        movePower = movePowers[3];
                                                        damage = (int) (enemy.getLevel() * movePower * (double) active.getSatt() / (double) enemy.getSdef() / 125.0);
                                                        JOptionPane.showMessageDialog(null, active.getName() + " used " + active.getMoves()[3] + "! Did " + damage + " damage!");
                                                        enemy.setHealth(enemy.getCurrentHealth() - damage);
                                                        healthBar.setText(myMonsters.getMonsters()[0].getName() + " " + active.getCurrentHealth() + "/" + myMonsters.getMonsters()[0].getHealth() + "                                                    " + enemy.getName() + " " + enemy.getCurrentHealth() + "/" + enemy.getHealth());
                                                        bFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
                                                        bFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                                                        tFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                                                        tFrame.setBounds(100, 625, 1100, 300);tFrame.setBounds(100, 625, 1100, 300);
                                                        break;
                                                    case "5":
                                                        tPanel.add(back);
                                                        tFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                                                        tFrame.setBounds(100, 625, 1100, 300);tFrame.setBounds(100, 625, 1100, 300);
                                                }
                                                if(enemy.getCurrentHealth() <= 0)
                                                {
                                                    break;
                                                }
                                                int var1 = rng.nextInt(4);
                                                enemyPower = enemyPowers[var1];
                                                damage = (int) (enemy.getLevel() * enemyPower * (double) enemy.getAtt() / (double) active.getDef() / 125.0);
                                                JOptionPane.showMessageDialog(null, enemy.getName() + " used " + enemy.getMoves()[var1] + "! Did " + damage + " damage!");
                                                active.setHealth(active.getCurrentHealth() - damage);
                                                JOptionPane.showMessageDialog(null, active.getName() + " has " + active.getCurrentHealth() + " health left!");
                                                healthBar.setText(myMonsters.getMonsters()[0].getName() + " " + active.getCurrentHealth() + "/" + myMonsters.getMonsters()[0].getHealth() + "                                                    " + enemy.getName() + " " + enemy.getCurrentHealth() + "/" + enemy.getHealth());
                                                bFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
                                                bFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                                                tFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                                                tFrame.setBounds(100, 625, 1100, 300);tFrame.setBounds(100, 625, 1100, 300);
                                            }while (enemy.getCurrentHealth() > 0 && caught == false && active.getCurrentHealth() > 0);
                                            tPanel.remove(back);
                                            tPanel.add(end);
                                            tFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                                            tFrame.setBounds(100, 625, 1100, 300);tFrame.setBounds(100, 625, 1100, 300);
                }
                else if(obj == bag)
                {
                        tPanel.remove(fight);
                        tPanel.remove(bag);
                        tPanel.add(back);
                        tPanel.add(potion);
                        tPanel.add(superP);
                        tPanel.add(hyperP);
                        tPanel.add(maxP);
                        tPanel.add(disc);
                        tFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                        tFrame.setBounds(100, 625, 1100, 300);tFrame.setBounds(100, 625, 1100, 300);
                }
                else if(obj == back)
                {
                        tPanel.remove(potion);
                        tPanel.remove(superP);
                        tPanel.remove(hyperP);
                        tPanel.remove(maxP);
                        tPanel.remove(disc);
                        tPanel.remove(attack1);
                        tPanel.remove(attack2);
                        tPanel.remove(attack3);
                        tPanel.remove(attack4);
                        tPanel.remove(back);
                        tPanel.add(fight);
                        tPanel.add(bag);
                        tFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                        tFrame.setBounds(100, 625, 1100, 300);tFrame.setBounds(100, 625, 1100, 300);
                }
                else if(obj == potion)
                {
                    tPanel.remove(potion);
                    tPanel.remove(superP);
                    tPanel.remove(hyperP);
                    tPanel.remove(maxP);
                    tPanel.remove(disc);
                    tPanel.remove(back);
                    tFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                    tFrame.setBounds(100, 625, 1100, 300);tFrame.setBounds(100, 625, 1100, 300);
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
                        healthBar.setText(myMonsters.getMonsters()[0].getName() + " " + myMonsters.getMonsters()[0].getCurrentHealth() + "/" + myMonsters.getMonsters()[0].getHealth() + "                                                    " + enemy.getName() + " " + enemy.getCurrentHealth() + "/" + enemy.getHealth());
                        myBag.destroyItem(index);
                    }
                    else
                    {
                        text.setText("You do not have this item!");
                    }
                    tPanel.add(next);
                }
                else if(obj == superP)
                {
                    tPanel.remove(potion);
                    tPanel.remove(superP);
                    tPanel.remove(hyperP);
                    tPanel.remove(maxP);
                    tPanel.remove(disc);
                    tPanel.remove(back);
                    tFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                    tFrame.setBounds(100, 625, 1100, 300);tFrame.setBounds(100, 625, 1100, 300);
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
                        healthBar.setText(myMonsters.getMonsters()[0].getName() + " " + myMonsters.getMonsters()[0].getCurrentHealth() + "/" + myMonsters.getMonsters()[0].getHealth() + "                                                    " + enemy.getName() + " " + enemy.getCurrentHealth() + "/" + enemy.getHealth());
                        myBag.destroyItem(index);
                    }
                    else
                    {
                        text.setText("You do not have this item!");
                    }
                    tPanel.add(next);
                }
                else if(obj == hyperP)
                {
                    tPanel.remove(potion);
                    tPanel.remove(superP);
                    tPanel.remove(hyperP);
                    tPanel.remove(maxP);
                    tPanel.remove(disc);
                    tPanel.remove(back);
                    tFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                    tFrame.setBounds(100, 625, 1100, 300);tFrame.setBounds(100, 625, 1100, 300);
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
                        healthBar.setText(myMonsters.getMonsters()[0].getName() + " " + myMonsters.getMonsters()[0].getCurrentHealth() + "/" + myMonsters.getMonsters()[0].getHealth() + "                                                    " + enemy.getName() + " " + enemy.getCurrentHealth() + "/" + enemy.getHealth());
                        myBag.destroyItem(index);
                    }
                    else
                    {
                        text.setText("You do not have this item!");
                    }
                    tPanel.add(next);
                }
                else if(obj == maxP)
                {
                    tPanel.remove(potion);
                    tPanel.remove(superP);
                    tPanel.remove(hyperP);
                    tPanel.remove(maxP);
                    tPanel.remove(disc);
                    tPanel.remove(back);
                    tFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                    tFrame.setBounds(100, 625, 1100, 300);tFrame.setBounds(100, 625, 1100, 300);
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
                        healthBar.setText(myMonsters.getMonsters()[0].getName() + " " + myMonsters.getMonsters()[0].getCurrentHealth() + "/" + myMonsters.getMonsters()[0].getHealth() + "                                                    " + enemy.getName() + " " + enemy.getCurrentHealth() + "/" + enemy.getHealth());
                        myBag.destroyItem(index);
                    }
                    else
                    {
                        text.setText("You do not have this item!");
                    }
                    tPanel.add(next);
                }
                else if(obj == disc)
                {
                    tPanel.remove(potion);
                    tPanel.remove(superP);
                    tPanel.remove(hyperP);
                    tPanel.remove(maxP);
                    tPanel.remove(disc);
                    tPanel.remove(back);
                    tFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                    tFrame.setBounds(100, 625, 1100, 300);tFrame.setBounds(100, 625, 1100, 300);
                    for(int i = 0; i < myBag.getCount(); i++)
                    {
                        if(myBag.getItemName(i) == "Toto Disc")
                        {
                            exists = true;
                            index = i;
                        }
                    }
                    if(exists)
                    {
                        if(enemy.getHealth() / enemy.getCurrentHealth() >= 5 && goBack == false && myMonsters.getCount() < 6)
                        {
                            caught = true;
                            text.setText("The wild " + enemy.getName() + " was caught!");
                            tPanel.remove(fight);
                            tPanel.remove(bag);
                            tPanel.add(end);
                        }
                        else
                        {
                            text.setText("You cannot catch this Toto right now!");
                        }
                    }
                    else
                    {
                        text.setText("You do not have this item!");
                    }
                    tPanel.add(next);
                }
                else if(obj == end)
                {
                    if(enemy.getCurrentHealth() <= 0)
                    {
                            text.setText(enemy.getName() + " was defeated!");
                            if(myMonsters.getMonsters()[0].getLevel() >= myMonsters.getMonsters()[0].getThreshold() && myMonsters.getMonsters()[0].getThreshold() != 0)
                            {
                                String old = myMonsters.getMonsters()[0].getName();
                                myMonsters.getMonsters()[0].transform(myMonsters.getMonsters());
                                text.setText(old + " transformed into " + myMonsters.getMonsters()[0].getName() + "!");
                            }
                            if(goBack)
                            {
                                myBag.addMoney(enemy.getLevel() * 10);
                                myMonsters.getMonsters()[0].setLevel(myMonsters.getMonsters()[0].getLevel() + 1);
                                tPanel.remove(end);
                                tPanel.remove(fight);
                                tPanel.remove(bag);
                                JLabel money = new JLabel("You got " + enemy.getLevel() * 10 + " pg.");
                                money.setFont(new Font("Arial", Font.PLAIN, 60));
                                tPanel.add(money);
                                tPanel.add(cont);
                            }
                            else
                            {
                                myBag.addMoney(enemy.getLevel() * 10);
                                myMonsters.getMonsters()[0].setLevel(myMonsters.getMonsters()[0].getLevel() + 1);
                                tPanel.remove(end);
                                tPanel.remove(fight);
                                tPanel.remove(bag);
                                JLabel money = new JLabel("You got " + enemy.getLevel() * 10 + " pg.");
                                money.setFont(new Font("Arial", Font.PLAIN, 60));
                                tPanel.add(money);
                                tPanel.add(cont);
                            }
                    }
                    else if(caught)
                    {
                        text.setText(enemy.getName() + " was added to the party!");
                        myMonsters.addMonster(enemy);
                        myBag.addMoney(enemy.getLevel() * 10);
                        myMonsters.getMonsters()[0].setLevel(myMonsters.getMonsters()[0].getLevel() + 1);
                        tPanel.remove(end);
                        tPanel.remove(fight);
                        tPanel.remove(bag);
                        JLabel money = new JLabel("You got " + enemy.getLevel() * 10 + " pg.");
                        money.setFont(new Font("Arial", Font.PLAIN, 60));
                        tPanel.add(money);
                        tPanel.add(cont);
                        tFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                        tFrame.setBounds(100, 625, 1100, 300);
                    }
                    else
                    {
                        boolean alive = false;
                        for(int i = 0; i < myMonsters.getCount(); i++)
                        {
                            if(myMonsters.getMonsters()[i].getCurrentHealth() > 0)
                            {
                                alive = true;
                                break;
                            }
                        }
                        
                        if(alive)
                        {
                            Monster temp = myMonsters.getMonsters()[0];
                            for(int i = 0; i < myMonsters.getCount() - 1; i++)
                            {
                                myMonsters.getMonsters()[i] = myMonsters.getMonsters()[i + 1];
                            }
                        }
                        else
                        {
                            tFrame.dispose();
                            bFrame.remove(panel);
                            bFrame.add(endGame, BorderLayout.CENTER);
                            bFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
                            bFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                        }
                    }
                }
                else if(obj == cont)
                {
                    if(goBack)
                    {
                        tFrame.dispose();
                        bFrame.remove(panel);
                        VictoryCity victoryCity = new VictoryCity(myMonsters, myBag, false, bFrame);
                        victoryCity.play();
                    }
                    else
                    {
                        tFrame.dispose();
                        bFrame.remove(panel);
                        CaveOfDefeat caveOfDefeat = new CaveOfDefeat(myMonsters, myBag, bFrame);
                        caveOfDefeat.play();
                    }
                }
            }
        }
        
        ActionListener listenerFight = new ClickListener();
        ActionListener listenerBag = new ClickListener();
        ActionListener listenerBack = new ClickListener();
        ActionListener listenerNext = new ClickListener();
        ActionListener listenerP = new ClickListener();
        ActionListener listenerS = new ClickListener();
        ActionListener listenerH = new ClickListener();
        ActionListener listenerM = new ClickListener();
        ActionListener listenerD = new ClickListener();
        ActionListener listenerEnd = new ClickListener();
        ActionListener listenerC = new ClickListener();
        
        back.addActionListener(listenerBack);
        bag.addActionListener(listenerBag);
        next.addActionListener(listenerNext);
        fight.addActionListener(listenerFight);
        potion.addActionListener(listenerP);
        superP.addActionListener(listenerS);
        hyperP.addActionListener(listenerH);
        maxP.addActionListener(listenerM);
        disc.addActionListener(listenerD);
        end.addActionListener(listenerEnd);
        cont.addActionListener(listenerC);
        
        bFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        bFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        bFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bFrame.setVisible(true);
        
        tFrame.setBounds(100, 625, 1100, 300);
        tFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tFrame.setVisible(true);
    }
}
