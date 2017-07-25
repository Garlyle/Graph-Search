package sample.graph;

public class Edge {
  private int fromNode;
  private int toNode;
  private double traverseCost;

  public Edge(int from, int to) {
    fromNode = from;
    toNode = to;
    traverseCost = 1;
  }

  public Edge(int from, int to, double cost) {
    fromNode = from;
    toNode = to;
    traverseCost = cost;
  }

  public int getFromNode() {
    return fromNode;
  }

  public void setFromNode(int fromNode) {
    this.fromNode = fromNode;
  }

  public int getToNode() {
    return toNode;
  }

  public void setToNode(int toNode) {
    this.toNode = toNode;
  }

  public double getTraverseCost() {
    return traverseCost;
  }

  public void setTraverseCost(double traverseCost) {
    this.traverseCost = traverseCost;
  }

  @Override
  public String toString() {
    return "FROM: " + fromNode + ", TO: " + toNode;
  }
}
