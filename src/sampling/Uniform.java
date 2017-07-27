package sampling;

import java.awt.*;
import java.util.List;

public class Uniform extends Sampling {
    public Uniform(int width, int height, int distance) {
        super(width, height, distance);
    }

    public List<Point> Calculate() {
        int x = (int)((width - distance * Math.floor(width / distance)) / 2);
        int y = (int)((height - distance * Math.floor(height / distance)) / 2);
        for (int i = x; i < width; i += distance)
            for (int j = y; j < height; j += distance)
                samples.add(new Point(i, j));
        return samples;
    }
}
