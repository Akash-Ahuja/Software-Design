package sample;

import javafx.scene.canvas.GraphicsContext;


public abstract class MyShape implements MyShapePositionInterface{

    //these are the extreme coordinates that are occupied by the shapes
    double usedX1 = 0;
    double usedX2 = 0;

    double usedY1 = 0;
    double usedY2 = 0;

    //x and y coordinates
    double x;
    double y;

    //Constructors for initializing the object
    MyShape()
    {
        x = 0;
        y = 0;
    }
    MyShape(double x , double y)
    {
        x = x;
        y = y;
    }

    //returning the values of x and y by individual functions
    double getX()
    {
        return x;
    }
    double getY()
    {
        return y;
    }

    //setting the values of x and y by individual functions
    void setX(double x)
    {
        x = x;
    }
    void setY(double y)
    {
        y = y;
    }


    //the overridden method should always be declared as public

    public abstract String toString();

    public double distanceTo(double target_x , double target_y)
    {
        return Math.sqrt( Math.pow((target_x - x) , 2.0) + Math.pow((target_y - y) , 2.0 ));
    }

    public void moveTo(double delta_x , double delta_y)
    {
        x = x + delta_x;
        y = y + delta_y;
    }

    public double[] getPoint()
    {
        return new double[]{this.x , this.y};
    }

    public boolean doOverlap()
    {
        MyRectangle bounded = this.getMyBoundingBox();
        if(
                (x - bounded.w/2) > usedX1 && (x + bounded.w/2) > usedX2
                        &&
                        (y - bounded.h/2) > usedY1 && (y + bounded.h/2) > usedY2
        )
        {
            return false;
        }
        return true;
    }

    abstract void draw(GraphicsContext gc);
}