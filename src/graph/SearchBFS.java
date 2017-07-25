package graph;

import java.util.LinkedList;

public class SearchBFS extends GraphSearch {
  public SearchBFS(Graph graph, int startIndex, int endIndex) {
    super(graph, startIndex, endIndex);
  }

  @Override
  protected boolean Search() {
    LinkedList<Edge> frontier = new LinkedList<>();

    Edge current = new Edge(startIndex, startIndex);

    frontier.push(current);
    visited.set(startIndex, startIndex);

    while (!frontier.isEmpty()) {
      current = frontier.pop();

      if (current.getToNode() == endIndex) {
        return true;
      }

      for (Edge edge : graph.getNeighbours(current.getToNode())) {
        if (!visited.contains(edge.getToNode())) {
          frontier.push(edge);
          visited.set(edge.getToNode(), edge.getFromNode());
        }
      }
    }

    return false;
  }
}
