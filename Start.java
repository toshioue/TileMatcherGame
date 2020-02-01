import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
  * this class is responsible for changing button functionality in the GUI as well as setting up the timer for the GUI
  *@author: Oue, Hitoshi -204824
  */
public class Start implements ActionListener{

    private Board B;
    private Thread Count;
    private Count C;
    private JButton Button;
    private int s;
    private int check;
    private JLabel L;
  /**
    * this is the class constuctor that takes sets it private field that will be used for threading and changing GUI functionality
    *@param b is the board that will be used to turn of user-Board interaction until enabled.
    *@param bc is the JButton in the GUI that will be constantly changing when pressed and will affect Board functionality
    *@param t is the JLabel/ clock that will be passed to the thread for constant changing
    */ 
   public Start(Board b, JButton bc, JLabel t){
   B = b;
   Button = bc;
   L = t;
   Count = new Thread(C = new Count(t, bc));
   s = 0;
   check = 0;
   }
   /**
    * this is a method provided by the ActionListener interface that is defined to change button and board functionality in GUI when button is pressed
    *@param e the even to when a button is pressed
    */
   public void actionPerformed(ActionEvent e){ 
    if( Button.getText().equals("Exit")){  // if Button text is equal to Exit, end the GUI
        System.exit(0);
     }
      
      if( s == 0){  //boolean statement to check if button is ready to be paused
       Button.setText("Pause");
        B.turnOnOff();
     if(!Count.isAlive()){  // if thread has not started, start the thread, else revive it using kill()
     Count.start();
     }else{
     C.killOrRun();
     } 
     s = 1;
     
     }else{  // if button is in pause state, resume if button is pressed again
     Button.setText("Resume");
      C.killOrRun();
    
     check = 1;
     B.turnOnOff();
     s = 0;
     }
     }
}
