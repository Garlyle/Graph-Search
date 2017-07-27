package sampling;

import java.awt.*;
import java.util.List;

public class Hexagonal extends Sampling{
    public Hexagonal(int width, int height, int distance) {
        super(width, height, distance);
    }

    public List<Point> Calculate() {
        int dy = (int)(Math.sqrt(3) * distance / 2);
        int x = (width - distance * (width / distance)) / 2;
        int y = (height - dy * (height / dy)) / 2;

        int count = 0;
        for (int j = y; j <= height; j += dy) {
            for (int i = x - (count % 2) * distance / 2; i <= width + distance / 2; i += distance)
                samples.add(new Point(i, j));
            count++;
        }
        return samples;
    }
}
