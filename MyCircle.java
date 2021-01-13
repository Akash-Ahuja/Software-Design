package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyCircle extends MyShape {

    double radius;
    double perimeter;
    double area;

    MyCircle()
    {
        radius = 0;
        x = 0;
        y = 0;
        calculate();
    }

    MyCircle(double radius , double x , double y) {
        x = x;
        y = y;
        radius = radius;
        calculate();
    }

    double getRadius()
    {
        return radius;
    }

    void setRadius(double radius) {
        this.radius = radius;
    }

    private void calculate()
    {
        perimeter = 2 * 3.14 * radius;
        area = 3.14 * radius * radius;
    }

    @Override
    public String toString()
    {

        calculate();

        String desc;
        desc = getClass().getName() + "\n" + "Radius = " + radius + "\n"
                + "Center(x,y) = " + "(" + x + "," + y + ")";

        return desc;
    }

    @Override
    public void draw(GraphicsContext gc)
    {
        usedX1 = Math.max(usedX1, (x - radius));
        usedX2 = Math.max(usedX2, (x + radius));

        usedY1 = Math.max(usedY1, (y - radius));
        usedY2 = Math.max(usedY2, (y + radius));

        gc.fillOval(x - radius , y - radius , 2 * radius , 2 * radius);
    }

    @Override
    public MyRectangle getMyBoundingBox()
    {
        return new MyRectangle(x , y , 2 * radius , 2 * radius);
    }

    @Override
    public void setPoint(double x, double y) {

    }
}

