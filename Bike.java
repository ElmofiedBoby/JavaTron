
import java.util.*; //all of util
 
public class Bike {

   JavaTron main;

   public int direction = 0; //starts at 0
   public int length = 0;

   public int bikeX[] = new int[main.WIDTH * main.HEIGHT]; //array will store all places, so should be as big as screen
   public int bikeY[] = new int[main.WIDTH * main.HEIGHT];
   ArrayList<Integer> histX = new ArrayList<Integer>();
   ArrayList<Integer> histY = new ArrayList<Integer>();

 
   public Bike(int x0, int y0, int x1, int y1) {
   for(int x=0;x<JavaTron.WIDTH * JavaTron.HEIGHT;x++){  //when bike is called, location is set
      bikeX[0] = x0;
      bikeY[0] = y0;
      bikeX[x] = x1;
      bikeY[x] = y1;}
   }
   
   
   public int checkLocX(Bike s, int c) { //returns location of x axis of bike
      return bikeX[c];
   
   }
   
   public int checkLocY(Bike s, int c) { //returns location of y axis of bike
      return bikeY[c];
   }

     
   public void addHistX(Bike s, int c) { //adds x location to history (creates the trail behind)
      histX.add(s.checkLocX(s,0));
   }
   
   public void addHistY(Bike s, int c) { //adds y location to history (creates the trail behind)
      histY.add(s.checkLocY(s,0));
   }

   public void move() { //moves the bike
      
      for (int d = length; d > 0; d--) { //makes bike keep growing
         bikeX[d] = bikeX[d - 1];
         bikeY[d] = bikeY[d - 1];
      }
   
      if (direction == 0) bikeX[0]++; //direction changes
      if (direction == 1) bikeY[0]++;
      if (direction == 2) bikeX[0]--;
      if (direction == 3) bikeY[0]--;
   

      
      length++; //makes sure it keeps going everytime move is run
   
   }
   
   public void robot(Bike s3) { //code for computer generated player
   
   for (int d = length; d > 0; d--) { //keeps growing
      bikeX[d] = bikeX[d - 1];
      bikeY[d] = bikeY[d - 1];
      }
      
      Random rand = new Random();
      
      int  n = rand.nextInt(4);
   
         if(s3.checkLocX(s3,0) == 1||s3.checkLocX(s3,0)==JavaTron.HEIGHT-1){//left and right of screen turns down and up?
            if(n<3)
               s3.bikeX[0]++;
            else
               s3.bikeX[0]--;
         }
         
         else if(s3.checkLocY(s3,0) == 1||s3.checkLocY(s3,0)==JavaTron.HEIGHT-1){//right and down of screen turns right or left
             if(n<3)
               s3.bikeY[0]++;
            else
               s3.bikeY[0]--;
         }
           
         else{//the all goes to crap safety net
         
            if(n==1)
               s3.bikeX[0]++;
            
            else if(n==0)
               s3.bikeX[0]--;
            
            
            else if(n==2)
               s3.bikeY[0]++;
            
            else if(n==3)
               s3.bikeY[0]--;
            
         }
      
              
      s3.length++;
   }

}