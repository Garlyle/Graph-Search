import graph.*;
import sampling.Poisson;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Main extends JComponent{
    static class ImagePanel extends JPanel{
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            mainDraw(graphics);
        }
    }

    public static void mainDraw(Graphics graphics){
        Poisson sampling = new Poisson(800, 800, 5);

        graphics.setColor(Color.black);
        List<Point> output = sampling.Calculate();
        for (Point p : sampling.Calculate()) {
            graphics.fillOval(p.x, p.y, 2, 2);
        }
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Center Box Function");
        jFrame.setSize(new Dimension(800, 800));
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.add(new ImagePanel());
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

  public static void graphTest() {
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
