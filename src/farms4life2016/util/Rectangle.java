package farms4life2016.util;

public class Rectangle extends java.awt.Rectangle {
    public Rectangle(int x, int y, int w, int h) {
        super(x, y, w, h);
    }
    public Rectangle(int w, int h) {
        super(0, 0, w, h);
    }
    public Rectangle() {
        super(0, 0, 0, 0);
    }
}
