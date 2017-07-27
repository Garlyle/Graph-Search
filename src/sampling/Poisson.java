package sampling;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Poisson extends Sampling {
    private final int k = 30;

    int cellSize;
    int[][] grid;

    public Poisson(int width, int height, int distance) {
        super(width, height, distance);

        // Calculate distance of cells
        cellSize = (int)(distance / Math.sqrt(2));

        // Create grid for samples
        int cols = width / cellSize;
        int rows = height / cellSize;
        grid = new int[cols][rows];
        for (int i = 0; i < cols; i++)
        for (int j = 0; j < rows; j++)
        grid[i][j] = -1;
    }

    public List<Point> Calculate() {
        List<Point> active = new ArrayList<>();

        Point sample = new Point(width / 2, height / 2);
        addToGrid(sample);
        active.add(sample);

        while(!active.isEmpty()) {
            int i = (int)(Math.random() * active.size());
            Point current = active.get(i);
            boolean found = false;

            for (int j = 0; j < k; j++) {
                double angle = Math.random() * (Math.PI * 2);
                int nextDistance = (int)(Math.random() * distance) + distance;
                int x = current.x + (int)(Math.sin(angle) * nextDistance);
                int y = current.y + (int)(Math.cos(angle) * nextDistance);
                Point newPoint = new Point(x, y);
                if (!hasNeighbours(newPoint)) {
                    found = true;
                    addToGrid(newPoint);
                    active.add(newPoint);
                    break;
                }
            }
            if (!found) {
                active.remove(i);
            }
        }
        return samples;
    }

    private boolean hasNeighbours(Point point) {
        int x = point.x / cellSize;
        int y = point.y / cellSize;
        if (x < 0 || y < 0 || x >= width / cellSize || y >= height / cellSize || grid[x][y] != -1) {
            return true;
        }

        // Check with neighbours on the grid
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i < 0 || j < 0 || i >= width / cellSize || j >= height / cellSize)
                    continue;
                int id = grid[i][j];
                if (id != -1) {
                    if (samples.get(id).distance(point) < distance) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void addToGrid(Point sample) {
        int x = sample.x / cellSize;
        int y = sample.y / cellSize;
        samples.add(sample);
        grid[x][y] = samples.size() - 1;
    }
}
