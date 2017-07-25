package graph;

import java.util.ArrayList;
import java.util.List;

public abstract class GraphSearch {
  Graph graph;

  List<Integer> visited;

  int startIndex, endIndex;
  private boolean found;

  GraphSearch(Graph graph, int startIndex, int endIndex) {
    this.graph = graph;
    this.startIndex = startIndex;
    this.endIndex = endIndex;

    visited = new ArrayList<>();

    for (int i = 0; i < graph.nextValidIndex(); i++) {
      visited.add(null);
    }

    found = Search();
  }

  protected abstract boolean Search();

  public boolean isFound() {
    return found;
  }

  public List<Integer> getPathToTarget() {
    List<Integer> path = new ArrayList<>();

    if (!isFound()) {
      return null;
    }
    path.add(0, endIndex);
    int index = endIndex;
    while (index != startIndex) {
      index = visited.get(index);
      path.add(0, index);
    }

    return path;
  }
}
