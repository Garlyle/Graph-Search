package sample.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SearchDijkstra extends GraphSearch {
  List<Double> traverseCost;

  public SearchDijkstra(Graph graph, int startIndex, int endIndex) {
    super(graph, startIndex, endIndex);
  }

  @Override
  protected boolean Search() {
    traverseCost = new ArrayList<>();
    for (int i = 0; i < graph.nextValidIndex(); i++) {
      traverseCost.add(null);
    }

    PriorityQueue<Edge> frontier = new PriorityQueue<Edge>(graph.getEdgeList().size(), new EdgeComparator());

    Edge current = new Edge(startIndex, startIndex);

    frontier.add(current);
    visited.set(startIndex, startIndex);
    traverseCost.set(startIndex, 0.);

    while (!frontier.isEmpty()) {
      current = frontier.poll();

      if (current.getToNode() == endIndex) {
        return true;
      }

      for (Edge edge : graph.getNeighbours(current.getToNode())) {
        double newCost = getCost(edge);
        if (traverseCost.get(edge.getToNode()) == null || newCost < traverseCost.get(edge.getToNode())) {
          traverseCost.set(edge.getToNode(), newCost);
          frontier.add(edge);
          visited.set(edge.getToNode(), edge.getFromNode());
        }
      }
    }

    return false;
  }

  protected double getCost(Edge edge) {
    return traverseCost.get(edge.getFromNode()) + edge.getTraverseCost();
  }

  protected class EdgeComparator implements Comparator<Edge> {
    @Override
    public int compare(Edge left, Edge right) {
      double first = getCost(left);
      double second = getCost(right);
      if (first < second) {
        return -1;
      }
      if (first > second) {
        return 1;
      }
      return 0;
    }
  }
}
