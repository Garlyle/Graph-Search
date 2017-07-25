package sample.graph;

public class SearchAStar extends SearchDijkstra {
  Heuristic heuristic;

  public SearchAStar(Graph graph, int startIndex, int endIndex) {
    super(graph, startIndex, endIndex);
  }

  @Override
  protected double getCost(Edge edge) {
    if (heuristic == null) {
      heuristic = new HeuristicEuclid();
    }
    return super.getCost(edge) + heuristic.Calculate(graph.getNode(endIndex), graph.getNode(edge.getToNode()));
  }
}
