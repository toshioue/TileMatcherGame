public class Pos {
  private int row, col;
  
  public Pos(int r, int c) {
    row = r;
    col = c;
  }

  public int getRow() {
    return row;
  }

  public int getCol() {
    return col;
  }

  public String toString() {
    return row + "," + col;
  }

  public boolean equals(Pos p) {
    return row == p.row && col == p.col;
  }
}
