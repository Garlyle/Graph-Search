import graph.*;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
      Graph graph = new Graph();
      graph.addNode(new Node(graph.nextValidIndex(), new Point(4, 0)));
      graph.addNode(new Node(graph.nextValidIndex(), new Point(3, 1)));
      graph.addNode(new Node(graph.nextValidIndex(), new Point(2, 2)));
      graph.addNode(new Node(graph.nextValidIndex(), new Point(1, 3)));
      graph.addNode(new Node(graph.nextValidIndex(), new Point(2, 3)));
      graph.addNode(new Node(graph.nextValidIndex(), new Point(3, 2)));
      graph.addNode(new Node(graph.nextValidIndex(), new Point(4, 1)));
      graph.addNode(new Node(graph.nextValidIndex(), new Point(5, 1)));
      graph.addNode(new Node(graph.nextValidIndex(), new Point(5, 2)));
      graph.addNode(new Node(graph.nextValidIndex(), new Point(6, 2)));
      graph.addNode(new Node(graph.nextValidIndex(), new Point(5, 3)));
      graph.addNode(new Node(graph.nextValidIndex(), new Point(6, 3)));
      graph.addEdge(new Edge(0, 1));
      graph.addEdge(new Edge(1, 2));
      graph.addEdge(new Edge(2, 3));
      graph.addEdge(new Edge(2, 4));
      graph.addEdge(new Edge(1, 5));
      graph.addEdge(new Edge(0, 6));
      graph.addEdge(new Edge(0, 7));
      graph.addEdge(new Edge(7, 8));
      graph.addEdge(new Edge(7, 9));
      graph.addEdge(new Edge(8, 10));
      graph.addEdge(new Edge(8, 11));

      int startIndex = 0, endIndex = 11;

      SearchDFS searchDFS = new SearchDFS(graph, startIndex, endIndex);
      if (searchDFS.isFound()) {
        System.out.println(searchDFS.getPathToTarget());
      }

      SearchBFS searchBFS = new SearchBFS(graph, startIndex, endIndex);
      if (searchBFS.isFound()) {
        System.out.println(searchBFS.getPathToTarget());
      }

      SearchDijkstra searchDijkstra = new SearchDijkstra(graph, startIndex, endIndex);
      if (searchDijkstra.isFound()) {
        System.out.println(searchDijkstra.getPathToTarget());
      }

      SearchAStar searchAStar = new SearchAStar(graph, startIndex, endIndex);
      if (searchAStar.isFound()) {
        System.out.println(searchAStar.getPathToTarget());
      }
    }
}
