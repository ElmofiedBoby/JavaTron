
import java.util.Random; //can use random numbers
 
import javax.swing.*; //all of swing
import java.awt.*; //all of awt
import java.awt.event.ActionEvent; //ActionEvent, Listener, KeyEvent
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
 
public class JavaTron extends JPanel implements ActionListener {

   //settings
   public static final int SCALE = 10; //determines sizes of game window and scale of squares and speed
   public static final int WIDTH = 70;
   public static final int HEIGHT = 70;
   public static final int SPEED = 10;
   public boolean p1Win; //did player one win? used in driver
   public boolean p2Win;
   SettingsMenu c = new SettingsMenu(); //used to collect color chosen in settings menu
   public Color selectedColorP1 = c.getColorP1();
   public Color selectedColorP2 = c.getColorP2();
   
   Random rand = new Random(); //new random object
   
   Sound crash = new Sound("shroycrash1.wav");
   
   int  n = rand.nextInt(WIDTH/2); //used to randomize where bikes start
   int  n2 = rand.nextInt(HEIGHT/2);
   int  n3 = rand.nextInt(WIDTH/2);
   int  n4 = rand.nextInt(HEIGHT/2);

   Bike s = new Bike(n, n2, n3, n4); //first bike
   Bike s2 = new Bike(n4, n3, n2, n); //second bike
   Bike s3 = new Bike(n2, n3,n,n4); //computer controlled bike
   
   Timer t = new Timer(1000 / SPEED, this); //new timer. game stops when timer stops

   JLabel scores;

   public JavaTron(JLabel scores) {
   //starts game
      t.start(); //game starts!
      addKeyListener(new Keyboard()); //keyboard input
      setFocusable(true); //window can now receive input
      this.scores = scores;
   }

   public void paint(Graphics g) {
   //creates grid for the bikes
      g.setColor(new Color(5, 50, 10));
      g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
      g.setColor(new Color(255, 216, 0));
   
      for (int xx = 0; xx <= WIDTH * SCALE; xx += SCALE) {
         g.drawLine(xx, 0, xx, HEIGHT * SCALE);
      }
   
      for (int yy = 0; yy <= HEIGHT * SCALE; yy += SCALE) {
         g.drawLine(0, yy, WIDTH * SCALE, yy);
      }
   
      for (int d = 0; d < s.length; d++) {
         g.setColor(selectedColorP1); //user chosen color of first bike
         g.fillRect(s.bikeX[d] * SCALE + 1, s.bikeY[d] * SCALE + 1, SCALE - 1, SCALE - 1);
      }
      
      for(int d = 0; d < s2.length; d++) {
         g.setColor(selectedColorP2); //user c hosen color of second bike
         g.fillRect(s2.bikeX[d] * SCALE + 1, s2.bikeY[d] * SCALE + 1, SCALE - 1, SCALE - 1);
      }
      
      for(int d = 0; d < s3.length; d++) {
         g.setColor(new Color(0xFFF100)); //default yellow color for computer player
         g.fillRect(s3.bikeX[d] * SCALE + 1, s3.bikeY[d] * SCALE + 1, SCALE - 1, SCALE - 1);
      }
    
      if(p1Win == true) {
         SettingsMenu.p1Score++;
         t.stop();
         setFocusable(false);
      }
      else if(p2Win == true) {
         SettingsMenu.p2Score++;
         t.stop();
         setFocusable(false);
      }
   
      scores.setText("Player 1: "+SettingsMenu.p1Score+" VS Player 2: "+SettingsMenu.p2Score);
   
   
   }



   
   public void actionPerformed(ActionEvent e) {
      
      //keeps track of where bike has gone
      int counter = 0;
      counter = counter + 1;
      s.addHistX(s, counter);
      s.addHistY(s, counter); 
      s2.addHistX(s2, counter);
      s2.addHistY(s2, counter);
      s3.addHistX(s3, counter);
      s3.addHistY(s3, counter);
      
      //moves bikes
      s.move();
      s2.move();
      s3.robot(s3);
      
      //checks if bikes collide headon
      if(s.checkLocX(s,0) == s2.checkLocX(s2,0) && s.checkLocY(s,0) == s2.checkLocY(s2,0)) {
         t.stop();
         setFocusable(false);   
      }
   
      
      if(s2.checkLocX(s,0) == s.checkLocX(s,0) && s2.checkLocY(s2,0) == s.checkLocY(s,0)) {
         //crash.play();
         p1Win = true;
         t.stop();
         setFocusable(false);
      }
      
   
   
      for(int x=1;x<WIDTH * HEIGHT;x++){ //checks for collisions at past points of location
         
         
         if(s.checkLocX(s,0) == s2.checkLocX(s2,x) && s.checkLocY(s,0) == s2.checkLocY(s2,x) || s.checkLocX(s,0) == s.checkLocX(s,x) && s.checkLocY(s,0) == s.checkLocY(s,x)|| s.checkLocX(s,0) == s3.checkLocX(s3,x) && s.checkLocY(s,0) == s3.checkLocY(s3,x)) {
            crash.play();
            p2Win = true;
         
            t.stop();
            
            break;
         }
         
         if(s2.checkLocX(s2,0) == s.checkLocX(s2,x) && s2.checkLocY(s2,0) == s.checkLocY(s,x) || s2.checkLocX(s2,0) == s2.checkLocX(s2,x) && s2.checkLocY(s2,0) == s2.checkLocY(s2,x)|| s2.checkLocX(s2,0) == s3.checkLocX(s3,x) && s2.checkLocY(s2,0) == s3.checkLocY(s3,x)) {
            crash.play();
            p1Win = true;
            
            t.stop();
            
            break;
         }
         
         if (s.checkLocX(s, 0) > WIDTH - 2 || s.checkLocY(s, 0) > HEIGHT - 4|| s.checkLocX(s, 0) < 0 || s.checkLocY(s, 0) < 0) {
            crash.play();
            p2Win = true;
            
            t.stop();
            
            break;
         }
         
         if (s2.checkLocX(s2, 0) > WIDTH - 2 || s2.checkLocY(s2, 0) > HEIGHT - 4 || s2.checkLocX(s2, 0) < 0 || s2.checkLocY(s2, 0) < 0) {
            crash.play();
            p1Win = true;
          
            t.stop();
            
            break;
         }
         
      
      }
   
      
      repaint(); //graphics frame refresh
   
   
   }
   
   public boolean update() {
      return p1Win; //returns if player one won
   }

   private class Keyboard extends KeyAdapter { //takes in keyboard input
      public void keyPressed(KeyEvent kEve) {
         int key1 = kEve.getKeyCode();
      
         if ((key1 == KeyEvent.VK_RIGHT) & s.direction != 2) s.direction = 0; //player one controls using arrow keys
         if ((key1 == KeyEvent.VK_DOWN) & s.direction != 3) s.direction = 1;
         if ((key1 == KeyEvent.VK_LEFT) & s.direction != 0) s.direction = 2;
         if ((key1 == KeyEvent.VK_UP) & s.direction != 1) s.direction = 3;
         
         int key2 = kEve.getKeyCode();
         
         if ((key2 == KeyEvent.VK_D) & s2.direction != 2) s2.direction = 0; //player two controls using WASD
         if ((key2 == KeyEvent.VK_S) & s2.direction != 3) s2.direction = 1;
         if ((key2 == KeyEvent.VK_A) & s2.direction != 0) s2.direction = 2;
         if ((key2 == KeyEvent.VK_W) & s2.direction != 1) s2.direction = 3;
         
      }
   }
}