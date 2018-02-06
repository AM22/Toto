import javax.swing.JComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

/**
 * Write a description of class GameComponent here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameComponent
{
   private static final int FRAME_WIDTH = 1920;
   private static final int FRAME_HEIGHT = 1080;

   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Toto");

      JPanel panel = new JPanel(new BorderLayout());

      ImageIcon waver = new ImageIcon("waverButton.png");
      ImageIcon epiman = new ImageIcon("epimanButton.png");
      ImageIcon kongie = new ImageIcon("kongieButton.png");

      JButton button = new JButton("Toto");
      button.setFont(new Font("Arial", Font.PLAIN, 100));
      button.setPreferredSize(new Dimension(200, 100));
      panel.add(button, BorderLayout.CENTER);
      JLabel label = new JLabel("                                        (use the mouse to advance)");
      label.setFont(new Font("Arial", Font.PLAIN, 40));
      panel.add(label, BorderLayout.PAGE_END);

      JButton waverButton = new JButton("", waver);
      JButton epimanButton = new JButton("", epiman);
      JButton kongieButton = new JButton("", kongie);
      JLabel choiceLabel = new JLabel("Waver:                        Epiman:                             Kongie:");
      choiceLabel.setFont(new Font("Arial", Font.PLAIN, 40));
      choiceLabel.setVisible(false);

      frame.add(panel);

      class ClickListener implements ActionListener { // this is an inner class, i.e., inside main method
          int clickCounter = 0;
          int starterCounter = 0;
          Bag myBag = new Bag();
          MyMonsters myMonsters = new MyMonsters();
          public void actionPerformed(ActionEvent event) {
              Object obj = event.getSource();
              clickCounter++;
              if(obj == waverButton)
              {
                  starterCounter++;
                  if(starterCounter == 1)
                  {
                      panel.add(waverButton, BorderLayout.CENTER);
                      epimanButton.setVisible(false);
                      kongieButton.setVisible(false);
                      label.setVisible(false);
                      choiceLabel.setText("                                                  You got Waver!");
                      Waver waver = new Waver(10);
                      waver.stats();
                      waver.display();
                      myMonsters.addMonster(waver);
                      myBag.addItem("Potion");
                      myBag.addItem("Potion");
                      myBag.addItem("Potion");
                      myBag.addItem("Toto Disc");
                      myBag.addItem("Toto Disc");
                      myBag.addItem("Toto Disc");
                  }
                  else
                  {
                      frame.remove(panel);
                      VictoryCity city = new VictoryCity(myMonsters, myBag, true, frame);
                      city.play();
                  }
              }
              else if(obj == epimanButton)
              {
                  starterCounter++;
                  if(starterCounter == 1)
                  {
                      waverButton.setVisible(false);
                      kongieButton.setVisible(false);
                      label.setVisible(false);
                      choiceLabel.setText("                                                  You got Epiman!");
                      Epiman epiman = new Epiman(10);
                      epiman.stats();
                      epiman.display();
                      myMonsters.addMonster(epiman);
                      myBag.addItem("Potion");
                      myBag.addItem("Potion");
                      myBag.addItem("Potion");
                      myBag.addItem("Toto Disc");
                      myBag.addItem("Toto Disc");
                      myBag.addItem("Toto Disc");
                  }
                  else
                  {
                      frame.remove(panel);
                      VictoryCity city = new VictoryCity(myMonsters, myBag, true, frame);
                      city.play();
                  }
              }
              else if(obj == kongieButton)
              {
                  starterCounter++;
                  if(starterCounter == 1)
                  {
                      panel.add(kongieButton, BorderLayout.CENTER);
                      waverButton.setVisible(false);
                      epimanButton.setVisible(false);
                      label.setVisible(false);
                      choiceLabel.setText("                                                  You got Kongie!");
                      Kongie kongie = new Kongie(10);
                      kongie.stats();
                      kongie.display();
                      myMonsters.addMonster(kongie);
                      myBag.addItem("Potion");
                      myBag.addItem("Potion");
                      myBag.addItem("Potion");
                      myBag.addItem("Toto Disc");
                      myBag.addItem("Toto Disc");
                      myBag.addItem("Toto Disc");
                  }
                  else
                  {
                      frame.remove(panel);
                      VictoryCity city = new VictoryCity(myMonsters, myBag, true, frame);
                      city.play();
                  }
              }
              else
              {
                  if(clickCounter == 1)
                  {
                      button.setFont(new Font("Arial", Font.PLAIN, 80));
                      button.setText("Welcome to the \nworld of Toto!");
                      label.setVisible(false);
                  }
                  else
                  {
                      button.setVisible(false);
                      label.setText("                                     Please choose your starter Toto!");
                      label.setVisible(true);
                      panel.add(choiceLabel, BorderLayout.PAGE_START);
                      panel.add(waverButton, BorderLayout.LINE_START);
                      panel.add(epimanButton, BorderLayout.CENTER);
                      panel.add(kongieButton, BorderLayout.LINE_END);
                      choiceLabel.setVisible(true);
                  }
              }
          }
        }

      // Link the listener to the button
      ActionListener listener = new ClickListener();
      ActionListener listenerW = new ClickListener();
      ActionListener listenerK = new ClickListener();
      ActionListener listenerE = new ClickListener();
      button.addActionListener(listener);
      waverButton.addActionListener(listenerW);
      epimanButton.addActionListener(listenerK);
      kongieButton.addActionListener(listenerE);

      frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}
