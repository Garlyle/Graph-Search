package sampling;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Sampling {
    int width, height, distance;
    java.util.List<Point> samples;


    public Sampling(int width, int height, int distance) {
        samples = new ArrayList<>();
        this.width = width;
        this.height = height;
        this.distance = distance;
    }

    public abstract List<Point> Calculate();
}
