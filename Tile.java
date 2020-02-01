import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 * this class will deal with package a tile into a JPanel so that more can be simply created
 *@author:Oue, Hitoshi -204824
 */
public class Tile extends JPanel {

  private TileListener Tl;
  private JLabel tile;
  private Mouse listen;
  private int ID;
  private Pos P;
  private boolean status;
  private int Mstatus;


  /**
   * this is the constructor for Tile which constructs Tile that has certain dimensions and color
   *@param a is the random color that will be assigned to the Tile
   *@param ps is the coordinate of the tile
   */
  public Tile( Color a, Pos ps){
     Mstatus = 1;
    status = false;
    this.setLayout(new GridLayout());
    tile = new JLabel("", SwingConstants.CENTER);
    tile.setPreferredSize(new Dimension(100, 100));   
    tile.setBorder(BorderFactory.createLineBorder(Color.black));
    tile.setBackground(a);
    tile.setOpaque(true);
    P = ps;
    listen = new Mouse(this);
    tile.addMouseListener(listen);
    this.add(tile);
  }
 /**
   * this method adds functionality of the TileListener in the board class,
   * this alllows the tile and Board to communicate
   *@param tl is the tile listener that will be called in added in Board class
   *
   */
  public void addTileListener(TileListener tl){
    Tl = tl;

  }
/**
  * this method is responsible for when a tile gets activated when it is pressed
  * on the board and turns the status of tile to true and prints the activation statement
  *
  */
  public void activated(){
    status = true;
  System.out.println("Tile " + P.toString() + " activated");
  
    Tl.activated(this);
  }

 /**
   * this method is responisble for when a tile gets deactivated by switching 
   * the status to false as well as printing the statement of deactivation and 
   * calling the deactivated method in Board
   */
  public void deactivate(){
  status = false;
  listen.changeBorder();
  System.out.println("Tile " + P.toString() + " deactivated");
  Tl.deactivated(this);
   } 

  /**
    * this method is reponsible for changing the color to white and removing the mouselistener of
    * the tile so that it would not perform when pressed
    */
  public void change (){
    Mstatus = 3;
    tile.setBackground(Color.WHITE);
    tile.removeMouseListener(listen);
  } 
 /**
  * this method is reponsible for returning a color.toString() used for
  * comparison purposes
  */
  public String getColor(){
  return tile.getBackground().toString();
   }
 
  /**
   * this method returns the status of the tile if it is activated or deactivated
   */
  public boolean getStatus(){
   return status;      
  }  
 
  /**
   * this method returns the status if a tile has turned white and has been deactivated
   */ 
  public int getMStatus(){
    return Mstatus;
  }
 
 /**
  * this method is responsible for setting the IDs of a particular tile
  */
 public void setID(int n){
  ID = n;
   }
 /**
  * this method is responsible for getting the ID of a tile
  */
 public int getID(){
  return ID;
  }
/**
  * this method is responsible for removing all mouseclick functionality to a tile and ultimately the board
  */
 public void removeMouse(){
   if(Mstatus == 1){
     tile.removeMouseListener(listen);
     Mstatus = 2;
    }
   else if (Mstatus == 2){
     tile.addMouseListener(listen);
     Mstatus = 1;
     }
   }


}



