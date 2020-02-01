import javax.swing.*;
import java.awt.*;
import java.util.*;

public class DrBrownUtil {
  public static Color[] colors = {
    new Color(220,  20,  60),
    new Color(218, 112, 214),
    new Color(65,  105, 225),
    new Color(0,   245, 255),
    new Color(0,   201,  87),
    new Color(255, 255,   0),
    new Color(255, 140,   0),
    new Color(154, 255, 154)
  };

  public static Color randomColor(Random rand) {
    return colors[rand.nextInt(colors.length)];
  }

  public Pos randomPos(Random rand) {
    return new Pos(rand.nextInt(6), rand.nextInt(6));
  }

  public static Color[][] getRandomColorAssignments(int seed) {
    Random rand = new Random(seed);

    Pos[] A = new Pos[36];
    int k = 0;

    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 6; j++) {
        A[k++] = new Pos(i, j);
      }
    }

    for (int n = 0; n < 100; n++) {
      int i   = rand.nextInt(36);
      int j   = rand.nextInt(36);
      Pos tmp = A[i];
      A[i] = A[j];
      A[j] = tmp;
    }
    
    Color[][] M = new Color[6][6];

    for (int i = 0; i < 36; i += 2) {
      Color c = randomColor(rand);
      M[A[i].getRow()][A[i].getCol()]         = c;
      M[A[i + 1].getRow()][A[i + 1].getCol()] = c;
    }
    return M;
  }
}
