import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * this class is a thread class that will be incrementing the counter while 
 * the board is in the running phase and stop the timer when the board is in 
 * the pause phase
 *@author: Oue, Hitoshi -204824
 */

public class Count implements Runnable{

  private JLabel T;
  private int sec;
  private int min;
  private volatile boolean stat;
  private volatile boolean stat2;
  private JButton B;
  

 
 /** this is the constructor that will be used to take in a button and timer
   * the timer will be constantly changing while the button is for a boolean check
   *@param t is a JLabel that wil act as a clock and will be constantly changing as long as the board is not paused
   *@param b is the button that will ultimately pause the timer/clock if its text is set to Exit
   */
  public Count(JLabel t, JButton b){
    T = t;
    stat = false;
    stat2 = false;
    sec = 0;
    min = 0;
    B = b;

  }

 /** the main part of the thread that will constantlly be changing the clock timer as long as board is in not in paused state
   * or if all tiles turn white
   * @throws Exception just extra error checking to use Thread.sleep()
   */
  public void run(){
    while(true){
     
       while(stat || B.getText().equals("Exit")){} // if status of board is in paused state or button text is equal to Exit, stop right here
    
      if(sec == 60){
        sec = 0;
        min++;
      }
      if(min < 10 && sec < 10){
        T.setText( "0" + Integer.toString(min) + ":0" + Integer.toString(sec));
      } else if(min < 10 && sec > 10){
        T.setText( "0" + Integer.toString(min) + ":" + Integer.toString(sec));
      } else if( min > 10 && sec < 10){
        T.setText( Integer.toString(min) + ":0" + Integer.toString(sec));
      }else{
        T.setText(Integer.toString(min) + ":" + Integer.toString(sec));
      }
      sec++;
      try{
        Thread.sleep(1000);
      } catch (Exception e){}
      
    }
  }
  /** this method allows the run() method to pause depending on the state of the board
    * it also allows the run() method to run again if the board is resumed
    */
  public void killOrRun(){
   if( stat == false)
     stat = true;
   else
     stat = false;
  } 
 
  
}
