package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
  private static int nextIndex = 0;

  private List<Node> nodeList;
  private List<Edge> edgeList;

  public Graph() {
    nodeList = new ArrayList<>();
    edgeList = new ArrayList<>();
  }

  public boolean isEmpty() {
    return nodeList.isEmpty();
  }

  public void clear() {
    nextIndex = 0;
    nodeList.clear();
    edgeList.clear();
  }

  public Node getNode(int index) {
    return nodeList.get(index);
  }

  public int nextValidIndex() {
    return nextIndex;
  }

  public int addNode(Node newNode) {
    nodeList.add(newNode);
    return nextIndex++;
  }

  public void removeNode(int index) {
    nodeList.remove(index);
  }

  public Edge getEdge(int from, int to) {
    for(Edge edge : edgeList) {
      if (edge.getFromNode() == from && edge.getToNode() == to) {
        return edge;
      }
    }
    return null;
  }

  public void addEdge(Edge edge) {
    if (nodeList.get(edge.getFromNode()) == null || nodeList.get(edge.getToNode()) == null) {
      return;
    }
    edgeList.add(edge);
  }

  public void removeEdge(int from, int to) {
    for(Edge edge : edgeList) {
      if (edge.getFromNode() == from && edge.getToNode() == to) {
        edgeList.remove(edge);
      }
    }
  }

  public List<Edge> getEdgeList() {
    return edgeList;
  }

  public List<Edge> getNeighbours(int index) {
    List<Edge> neighbours = new ArrayList<>();
    for (Edge edge : edgeList) {
      if (edge.getFromNode() == index) {
        neighbours.add(edge);
      }
    }
    return neighbours;
  }

}
