package sample.graph;

import java.util.Stack;

public class SearchDFS extends GraphSearch {
  public SearchDFS(Graph graph, int startIndex, int endIndex) {
    super(graph, startIndex, endIndex);
  }

  @Override
  protected boolean Search() {
    Stack<Edge> frontier = new Stack<>();

    Edge current = new Edge(startIndex, startIndex);

    frontier.push(current);

    while (!frontier.empty()) {
      current = frontier.pop();

      visited.set(current.getToNode(), current.getFromNode());
      if (current.getToNode() == endIndex) {
        return true;
      }

      for (Edge edge : graph.getNeighbours(current.getToNode())) {
        if (!visited.contains(edge.getToNode())) {
          frontier.push(edge);
        }
      }
    }

    return false;
  }
}
