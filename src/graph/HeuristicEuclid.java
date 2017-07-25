package graph;

public class HeuristicEuclid extends Heuristic {
  @Override
  public double Calculate(Node left, Node right) {
    return Math.abs(left.getDistance(right));
  }
}
