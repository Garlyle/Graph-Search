package sampling;

import java.awt.*;
import java.util.List;

public class Random extends Sampling {
    public Random(int width, int height, int distance) {
        super(width, height, distance);
    }

    public List<Point> Calculate() {
        int n = (width * height) / (distance * distance);
        for (int i = 0; i < n; i++) {
            int x = (int)(Math.random() * width);
            int y = (int)(Math.random() * height);
            samples.add(new Point(x, y));
        }
        return samples;
    }
}
