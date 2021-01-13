package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyRectangle extends MyShape {

    double h;
    double w;

    double perimeter;
    double area;

    MyRectangle()
    {
        h = x;
        w = y;
    }

    public MyRectangle(double x, double y, double h, double w){
        super(x,y);
        h = h;
        w = w;
    }

    double getPerimeter() {
        return 2 * (h + w);
    }


    double getArea() {
        return h * w;
    }

    public String toString() {
        String desc = getClass().getName() + "\n" + "Width = " + Double.toString(w) + "\n" + "Height = " + Double.toString(h)
                + "\n" + "Perimeter = " + Double.toString(getPerimeter()) + "\n" + "Area = " + Double.toString(getArea());
        return desc;
    }

    void draw(GraphicsContext gc)
    {
        gc.fillRect((x - (w/2)) , (y - (h/2)) , w , h);
    }

    @Override
    public MyRectangle getMyBoundingBox() {
        return new MyRectangle(x,y,w,h);
    }

    @Override
    public void setPoint(double x, double y) {

    }

}

