import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * this class pertains to creating a GUI that makes a 6x6 grid of tiles
 * it also requires a command line arg that is need for seeding
 *@author: Oue, Hitoshi -204824
 */
public class P2 {
 /**
   * this is the main function for the GUI which initiliazes a JFrame and add a Board and button/timer functionality
   *@param args will contain a number that will be used as a seed for randomizing color
   */
  public static void main(String[] args){
 
  Random rand = new Random();
  int seed = rand.nextInt(3000);
  if(args.length == 1){
   seed = Integer.parseInt(args[0]);
  }
  JFrame Grid = new JFrame(); // initialize frame
  
  Board B = new Board(seed); // create Board
 
  Sbutton l = new Sbutton(B); // create button/timer functionality

  B.setButton(l.getB()); // gets the button in Sbutton and sets it in Board class
 
 
  Grid.add(B);                    // add components to Grid/JFrame
  Grid.add(l, BorderLayout.NORTH);

  Grid.setLocation(200, 200);   // set configuration for JFrame
  Grid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  Grid.setVisible(true);
  Grid.pack();

  }
}

