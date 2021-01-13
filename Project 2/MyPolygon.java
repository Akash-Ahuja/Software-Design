package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyPolygon extends MyShape{

    int n;
    private double[] xPoints;
    private double[] yPoints;

    MyPolygon()
    {
        n = 0;
    }

    MyPolygon(double[] xPoints , double[] yPoints , int n)
    {
        n = n;
        xPoints = xPoints;
        yPoints = yPoints;
    }

    @Override
    public String toString()
    {
        String desc;
        desc = getClass().getName() + "\n" + "N = " + n;
        return desc;
    }

    @Override
    public void draw(GraphicsContext gc)
    {
        usedX1 = Math.max(usedX1, (x - xPoints[1]));
        usedX2 = Math.max(usedX2, (x + xPoints[4]));

        usedY1 = Math.max(usedY1, (y - yPoints[0]));
        usedY2 = Math.max(usedY2, (y + yPoints[3]));

        gc.fillPolygon(xPoints , yPoints , n);
    }

    @Override
    public boolean doOverlap()
    {
        return true;
    }

    @Override
    public void setPoint(double x, double y) {
        return;
    }

    @Override
    public MyRectangle getMyBoundingBox()
    {

        return new MyRectangle(x , y , xPoints[4] - xPoints[1] , yPoints[3]);
    }
}
