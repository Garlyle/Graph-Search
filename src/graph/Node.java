package graph;

import java.awt.*;

public class Node {
  private int index;
  private Point position;

  public Node(int index, Point position) {
    this.index = index;
    this.position = position;
  }

  public Point getPosition() {
    return position;
  }

  public void setPosition(Point position) {
    this.position = position;
  }
}
