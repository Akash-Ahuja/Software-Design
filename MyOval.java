package sample;

import java.lang.Math;
import javafx.scene.canvas.GraphicsContext;

public class MyOval extends MyShape {

    double perimeter;
    double area;

    MyRectangle m;

    MyOval ()
    {
        m = new MyRectangle();
        calculate();
    }

    MyOval(MyRectangle m)
    {
        m = m;
        calculate();
    }

    private void calculate()
    {
        perimeter = 2 * Math.PI * Math.sqrt((Math.pow(m.h, 2) + Math.pow(m.w, 2)) / 2);
        area = Math.PI * (m.h / 2) * (m.w / 2);
    }

    double getPerimeter() {
        return perimeter;
    }

    double getArea() {
        return area;
    }

    @Override
    public String toString() {
        calculate();

        String desc = getClass().getName() + "\n" + "Minor Axis = " + Double.toString((m.h / 2)) + "\n" + "Major Axis = " + Double.toString((m.w / 2))
                + "\n" + "Perimeter = " + Double.toString(perimeter) + "\n" + "Area = " + Double.toString(area);
        return desc;
    }

    @Override
    void draw(GraphicsContext gc)
    {
        usedX1 = usedX1>(x - (m.w / 2)) ? usedX1 : (x - (m.w / 2));
        usedX2 = usedX2>(x + (m.w / 2)) ? usedX2 : (x + (m.w / 2));

        usedY1 = usedY1>(y - (m.h / 2)) ? usedY1 : (y - (m.h / 2));
        usedY2 = usedY2>(y + (m.h / 2)) ? usedY2 : (y + (m.h / 2));

        gc.fillOval((m.x - (m.w/2)) , (m.y - (m.h/2)) , m.w , m.h);
    }


    @Override
    public MyRectangle getMyBoundingBox() {
        return m;
    }

    @Override
    public void setPoint(double x, double y) {
        return;
    }
}

