
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;


public class SettingsMenu {

   private JFrame settings;
   private JFrame game;
   private JLabel scores;
   private JPanel header;
   private JLabel title;
   
   private JPanel main;

   private JPanel northPanel;
   private JPanel optionsPanel;
   private JPanel eastPanel;
   private JPanel westPanel;
   private JPanel centerPanel;
   private JPanel descriptions;
   private JPanel options;

   final private JButton button = new JButton("START GAME");
   final private JButton button2 = new JButton("NEXT GAME");
   
   public static int p1Score; //keeps track of score
   public static int p2Score;
   
   private String[] colorList = {"Red","Blue","Green"};
   private String sC1;
   private String sC2;
   public static Color selectedColorP1;
   public static Color selectedColorP2;


   public SettingsMenu() {
   
      settings = new JFrame();
      game = new JFrame("JavaTron");
      scores = new JLabel("Player 1: "+p1Score+" VS Player 2: "+p2Score);
      title = new JLabel("JavaTron v2.0 by Nithin Joseph");
      header = new JPanel();
      
      main = new JPanel(new BorderLayout());
      
      northPanel = new JPanel();
      optionsPanel = new JPanel();
      eastPanel = new JPanel();
      westPanel = new JPanel();
      centerPanel = new JPanel();
      
      descriptions = new JPanel();
      options = new JPanel();
      
   }
   
   public void menu()
   {
      //lets get funky
      Sound menu = new Sound("UpbeatFunk.wav");
      Sound pizza = new Sound("pizzatheme.wav");
      menu.play();
      menu.loop();
      
      //sets up JFrame called settings
      settings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exits when closed
      Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); // sees the users screen size
      settings.setSize(size.width / 3, size.height - 100);
      settings.setLocation((size.width / 3) + 350, 50);
      settings.setResizable(false);
      settings.setBackground(new Color(5, 50, 10));
      settings.setSize(size.width / 3, ((size.height - 100) - ((size.height - 100) / 12))/2);
      
      
      
      //creates ComboBox for color selection
      JComboBox colorSelectionP1 = new JComboBox(colorList);
      JComboBox colorSelectionP2 = new JComboBox(colorList);
      
      colorSelectionP1.addActionListener(
         new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               sC1 = colorSelectionP1.getSelectedItem().toString();
               if(sC1 == "Red")
                  selectedColorP1 = Color.RED;
               else if(sC1 == "Blue")
                  selectedColorP1 = Color.BLUE;
               else
                  selectedColorP1 = Color.GREEN;
                  
            }
         });
         
      colorSelectionP2.addActionListener(
         new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
               sC2 = colorSelectionP2.getSelectedItem().toString();
               if(sC2 == "Red")
                  selectedColorP2 = Color.RED;
               else if(sC2 == "Blue")
                  selectedColorP2 = Color.BLUE;
               else
                  selectedColorP2 = Color.GREEN;
                  
            }
         });
         
      button.addActionListener( //INITIAL START GAME BUTTON
         new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {  
               //too much music
               menu.stop();
               
               //creates a header for keeping score
               scores.setForeground(Color.WHITE);
               scores.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
               header.setBackground(new Color(5, 50, 10));
               header.setSize(size.width / 3, (size.height - 100) / 24);
               header.add(scores);
               
               //creates new JFrame for the game window
            
               game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               game.setSize(JavaTron.HEIGHT*JavaTron.SCALE, JavaTron.WIDTH*JavaTron.SCALE);
               game.setResizable(false);
               game.setVisible(true);
               game.add(new JavaTron(scores)); //adds game content to frame
               settings.setVisible(false); //closes settings window
               game.add(header, BorderLayout.NORTH); //adds score to top
               optionsPanel.add(button2, BorderLayout.SOUTH);
               optionsPanel.add(options, BorderLayout.SOUTH);
               game.add(optionsPanel, BorderLayout.SOUTH); //adds restart/color options to bottom
               
               //pizza time
               pizza.play();
               pizza.loop();
            }
         });
      
      button2.addActionListener( //NEXT GAME BUTTON
         new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
                  //creates a header for keeping score
               scores.setForeground(Color.WHITE);
               scores.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
               header.setBackground(new Color(5, 50, 10));
               header.setSize(size.width / 3, (size.height - 100) / 24);
               header.add(scores);
               
               game.dispose();
               
               game = new JFrame("JavaTron");
               game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               game.setSize(JavaTron.HEIGHT*JavaTron.SCALE, JavaTron.WIDTH*JavaTron.SCALE);
               game.setResizable(false);
               game.setVisible(true);
               game.add(header, BorderLayout.NORTH); //adds score to top
               optionsPanel.add(button2, BorderLayout.SOUTH);
               optionsPanel.add(options, BorderLayout.SOUTH);
               game.add(optionsPanel, BorderLayout.SOUTH); //adds restart/color options to bottom
               game.add(new JavaTron(scores)); //takes in content from JavaTron.java
            
            }
         }
         );
         
      title.setForeground(Color.WHITE);
      title.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
      northPanel.setBackground(new Color(5, 50, 10));
      northPanel.setSize(size.width / 3, (size.height - 100) / 24);
      northPanel.add(title);
   
   
   //adds the color buttons to panel
      settings.add(main);
      main.add(northPanel, BorderLayout.NORTH);
      main.add(button, BorderLayout.SOUTH);
      main.add(westPanel, BorderLayout.WEST);
      main.add(eastPanel, BorderLayout.EAST);
      main.add(centerPanel, BorderLayout.CENTER);
      northPanel.add(title, BorderLayout.CENTER);
      centerPanel.add(descriptions,BorderLayout.WEST);
      centerPanel.add(options,BorderLayout.EAST);
      options.add(colorSelectionP1, BorderLayout.CENTER);
      options.add(colorSelectionP2, BorderLayout.CENTER);
   
      
      //submit
      settings.add(button, BorderLayout.SOUTH);
   
      
      settings.setVisible(true);
   }
   
   //getters
   public Color getColorP1() {
      return selectedColorP1;
   }
   
   public Color getColorP2() {
      return selectedColorP2;
   }
  
}