package sample;

public interface MyPointInterface {
    MyRectangle getMyBoundingBox();
    boolean doOverlap();
    double[] getPoint();
    void setPoint(double x, double y);
    void moveTo(double delX, double delY);
    double distanceTo(double x, double y);
}
