package sample;

public interface MyShapePositionInterface extends MyPointInterface {
    MyRectangle getMyBoundingBox();
    boolean doOverlap();
}
