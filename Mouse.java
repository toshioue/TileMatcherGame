import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * this class deals with printing messages to the screen when a specific 
 * mouse action is performed on a JLabel
 *@author: Oue, Hitoshi -204824
 */
public class Mouse implements MouseListener{
   private Tile T;
   private boolean isPressed;

  /**
   * this is the mouse constructor that take in fields required to print 
   * put the right information when a tile is clicked
   *@param t that the mouselistener listens to if pressed
   */
  public Mouse( Tile t){
    T = t;
    isPressed = false;
  }

  /**
    * this method  prints out messages when there is 
    * a click on a JLabel to tell if activated or deactivated
    *@param e the mouse clicking
    */
  public void mouseClicked(MouseEvent e){
    if(T.getStatus() == false){
         T.activated();
    }else{
         T.deactivate();
      }
    }
/**
  * method is not in use
  *@param e when mouse cursor enter added action listener
  */
  public void  mouseEntered(MouseEvent e){
  }
 /**
  * method is not in use
  *@param e when mouse aciton exits
  */ 
  public void  mouseExited(MouseEvent e){
   if(T.getStatus() == false && isPressed == true ){
   T.setBorder(BorderFactory.createLineBorder(Color.black, 0));
       
 } 
   }
  /**
    * this method prints message to terminal if mouse clicks
    * on JLABEL
    *@param e mouse click pressed
    */
  public void  mousePressed(MouseEvent e){
     isPressed = true;
   // System.out.println("Tile pressed");
     T.setBorder(BorderFactory.createLineBorder(Color.black, 3));
  }
 
  /**
    * a method that will print a message to terminal when 
    * mouse click is released,this method is not used
    *@param e mouse click releases
    */
  public void  mouseReleased(MouseEvent e){

  }
  /**
    * this method erases the thick black lable around the deactivated tile
    */
  public void changeBorder(){
  T.setBorder(BorderFactory.createLineBorder(Color.black, 0));
   }
 


}
