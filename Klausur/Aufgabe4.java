public class Rectangle {
    protected int width, height;

    // getter und setter
    public int area() {
        return width * height;
    }
}

public class Square extends Rectangle {
    public void setWidth(int w) {
        width = w;
        height = w;
    }

    public void setHeight(int h) {
        width = h;
        height = h;
    }
}

@Test
public void areaTest(Rectangle r) {
    int width = 4;
    int height = 5;
    r.setWidth(width);
    r.setHeight(height);
    int area = r.area();
    assertEquals(width * height, area);
}