package Medium.Medium.interesting;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.Collectors;

//2:42
public class RectangleIntersection {
  public static void main(String[] args) {
    Rectangle r1 = new Rectangle(1, 10, 3,11, "r1");
    Rectangle r2 = new Rectangle(5, 12, 4,15, "r2");
    Rectangle r3 = new Rectangle(11, 25, 12,13, "r3");

    List<Rectangle> rectangles = new ArrayList<>();
    rectangles.add(r1);
    rectangles.add(r2);
    rectangles.add(r3);

    List<String[]> out = findIntersections(rectangles);
    out.stream().forEach(x -> System.out.println(x[0]+":"+x[1]));
  }

  public static List<String[]> findIntersections(List<Rectangle> rectangles) {
    List<Rectangle> startX1 = copy(rectangles, r -> r.x1);
    List<Rectangle> startX2 = copy(rectangles, r -> r.x2);

    Collections.sort(startX1, (r1, r2) -> r1.x1 - r2.x1);
    Collections.sort(startX2, (r1, r2) -> r1.x2 - r2.x2);

    List<String[]> overlaps = new ArrayList<>();
    int stIndex = 0;
    for (Rectangle x2 : startX2) {
      String l = x2.label;
      System.out.println("*"+l);
      while(stIndex < rectangles.size() && startX1.get(stIndex).x1 < x2.x2) {
        System.out.println("**"+startX1.get(stIndex).label);
        if (startX1.get(stIndex).label.equals(l)) {
          stIndex++;
          continue;
        }
        //overlaps in terms of X
        if (doesOverlap(x2.y1, x2.y2, startX1.get(stIndex).y1, startX1.get(stIndex).y2)) {
          overlaps.add(new String[]{l,startX1.get(stIndex).label});
        }
        stIndex++;
      }

    }

    return overlaps;
  }

  public static boolean doesOverlap(int y1, int y2, int secY1, int secY2) {
      if (y1 < secY1) {
        return secY1 < y2;
      } else {
        return y1 < secY2;
      }
  }

  public static List<Rectangle> copy(List<Rectangle> rectangles, Function<Rectangle,Integer> f) {
    return rectangles.stream().collect(Collectors.toList());
  }

  static class Rectangle {
    int x1,x2,y1,y2;
    String label;

    public Rectangle(int x1, int x2, int y1, int y2, String label) {
      this.x1 = x1;
      this.x2 = x2;
      this.y1 = y1;
      this.y2 = y2;
      this.label = label;

    }
  }

}
