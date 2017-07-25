package graph;

public class HeuristicEuclid extends Heuristic {
  @Override
  public double Calculate(Node left, Node right) {
    return Math.abs(left.getPosition().x - right.getPosition().x) + Math.abs(left.getPosition().y - right.getPosition().y);
  }
}
