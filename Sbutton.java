import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
  * this class is a custom JPanel that will house the start/pause button
  * as well as the Timer which will affect the overall board reaction
  * this class will interact with Mouse.java
  *@author: Oue, Hitoshi -204824
  */

public class Sbutton extends JPanel{

    private JButton B;
    private JLabel timer;
  /**
    * this is the constructor for Sbutton which intitilizes all
    * private fields, sets up the button, and timer
    *@param b is the board that will be passed to the timer thread
    */
    public Sbutton(Board b){
    B = new JButton("Start");
    timer = new JLabel("00:00");
    this.add(B);
    this.add(timer);
    B.addActionListener(new Start(b, B, timer));
    
   }

 /**
   * returns the JButton which would ultimately turn to the text Exit and 
   * exit the GUI
   */
   public JButton getB(){
     return B;
   }

    


}
