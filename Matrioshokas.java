import java.util.*;
public class Matrioshokas {

public class Main {
  static class Doll {
    private int size;
    private int childSize;

    public Doll(int size, int childSize) {
      this.size = size;
      this.childSize = childSize;
    }

    public int getSize() {
      return size;
    }

    public int getChildSize() {
      return childSize;
    }

    public void incrementChildSize(int value) {
      this.childSize += value;
    }
  }