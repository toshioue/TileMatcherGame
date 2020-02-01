import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * this class will incorporate a gridlayout panel
 * that will be a 6x6 grid of tiles
 *@author: Oue, Hitoshi -204824
 */
public class Board extends JPanel implements TileListener {

  private Color[][] C;   // use to store 2D array of colors
  private Tile[] T; // tiles that will store 36
  private ArrayList<Tile> tempT;  // an arraylist to store two tiles to compare
  private int counter; // a counter for the Tile array and to add ID
  private int prevID; // serves as a an error check to make sure same tile is not compared itself
  private JButton press;
/**
  * this is the constructor for Board that initializes all the private fields 
  * and creates tiles and add them to the board
  *@param s is the seed value for color randomization
  */
  public Board(int s){
    prevID = 100;  // just sets previous ID to a bogus int
    tempT = new ArrayList<Tile>(); // initializes arraylist of two tiles
    T = new Tile[36];  // creates 36 tiles in an array
    counter = 0; // counter to keep track of Tiles and Pos
 

    // set grid layout for custom panel
    this.setLayout(new GridLayout(0,6));
    // this generates 6x6 colors
    C = DrBrownUtil.getRandomColorAssignments(s);


    // creating tiles and passing colors and creating Pos 
    for(int i = 0; i < 6;  i++){
      for(int j = 0; j< 6; j++){
        // initializes a tile and passes positon to it and color
        T[counter] = new Tile(C[i][j], new Pos(i, j));
        T[counter].setID(counter);
        T[counter].removeMouse(); 
        //adds the tile to the board
        this.add(T[counter]); 
        //increment counter for tile array
        counter++;
      }
    }
    // adds the board as a tilelistener for every tile.
    for( int k = 0; k < counter; k++){
      T[k].addTileListener(this);
    }



  }
  /**
   * this class is one of the method in the interface TileListener which will listen to when a tile gets activated,
   * stores the tile activated and when two tiles get activated, compares their color
   * if the two tile's colors match, the two tiles functionality get affected
   *@param t the tile that gets activated
   */
  public void activated(Tile t){

    tempT.add(t);


    if(tempT.size() == 2){  // if tile arraylist is size 2, compare tiles for color and take action if neccessary 
      Tile A = tempT.get(0);
      Tile B = tempT.get(1);
      if(A.getColor().equals(B.getColor())){   // compares two tiles color

        A.change();// changes color and remoeve functionality of tile A
        B.change(); // changes color and remove mouse functionality tile B
      }
      tempT.clear(); // clears the Arraylist temp
      A.deactivate();  // deactivates both button
      B.deactivate();  // deactivates both buttons
    }

  }
  /**
   * this method is responsible for checking if any deactivated tiles are still stored in the Tempt Arraylist and removes it
   * this function is needed so that tiles that get clicked twice will not get compared with one another and turn white
   *@param t compares this tile with the arraylist tempT
   */
  public void deactivated(Tile t){
    if(!tempT.isEmpty()){ // checks if tempT arraylist is not empty, iterate through, and remove any tile with similar IDs.
      for( int i = 0; i< tempT.size(); i++){
        if(tempT.get(i).getID() == t.getID())
          tempT.remove(i);
      }
    }
    check(); // checks if all tiles have been deactivated


  }
 /**
   * turns board functionality/mouse click off when button gets pressed
   */
  public void turnOnOff(){
    for(int i = 0; i< 36; i++)
      T[i].removeMouse();
  }
/**
  * this method checks to see if all board have been turned to white and sets the button text to Exit.
  */
  public void check(){
    int b = 0;
    for(int i = 0; i < 36; i++){
      if(T[i].getMStatus() != 3 )
        b = 1;
    }
    if( b == 0){
      press.setText("Exit");
      
       
    }
  }
 /**
   * this method takes in a Button from the Sbutton class
   *@param a the JButton that will be set to the private JButton press
   */
  public void setButton(JButton a){
    press = a;
  }




}


