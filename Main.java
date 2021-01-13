package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args){
        // TODO code application logic here
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        final double CanvasLength = 800;
        final double CanvasWidth = 800;

        //window and canvas creation code
        Group root = new Group();
        Scene scene = new Scene(root);
        Canvas canvas = new Canvas(CanvasLength , CanvasWidth);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        double newradius = 250;

        double firstx = (CanvasLength/2);
        double firsty = (CanvasWidth/2) - newradius;

        double secondx = ((CanvasLength/2) - newradius * Math.cos(18 * Math.PI / 180));
        double secondy = ((CanvasWidth/2) - newradius * Math.sin(18 * Math.PI / 180));

        double thirdx = ((CanvasLength/2) - newradius * Math.cos(54 * Math.PI / 180));
        double thirdy = ((CanvasWidth/2) + newradius * Math.sin(54 * Math.PI / 180));

        double fourthx = ((CanvasLength/2) + newradius * Math.cos(54 * Math.PI / 180));
        double fourthy = ((CanvasWidth/2) + newradius * Math.sin(54 * Math.PI / 180));

        double fifthx = ((CanvasLength/2) + newradius * Math.cos(18 * Math.PI / 180));
        double fifthy = ((CanvasWidth/2) - newradius * Math.sin(18 * Math.PI / 180));


        //pair 1
        gc.setFill(MyColor.RED.getColor());
        MyCircle circle1 = new MyCircle(newradius , CanvasLength/2 , CanvasWidth/2);
        circle1.draw(gc);
        gc.setFill(MyColor.BLACK.getColor());
        MyPolygon polygon1 = new MyPolygon(new double[]{firstx , secondx , thirdx , fourthx , fifthx} , new double[]{firsty , secondy , thirdy , fourthy , fifthy} , 5);
        polygon1.draw(gc);
        newradius = newradius * Math.cos(3.14 / 5);

        firstx = (CanvasLength/2);
        firsty = (CanvasWidth/2) - newradius;

        secondx = ((CanvasLength/2) - newradius * Math.cos(18 * Math.PI / 180));
        secondy = ((CanvasWidth/2) - newradius * Math.sin(18 * Math.PI / 180));

        thirdx = ((CanvasLength/2) - newradius * Math.cos(54 * Math.PI / 180));
        thirdy = ((CanvasWidth/2) + newradius * Math.sin(54 * Math.PI / 180));

        fourthx = ((CanvasLength/2) + newradius * Math.cos(54 * Math.PI / 180));
        fourthy = ((CanvasWidth/2) + newradius * Math.sin(54 * Math.PI / 180));

        fifthx = ((CanvasLength/2) + newradius * Math.cos(18 * Math.PI / 180));
        fifthy = ((CanvasWidth/2) - newradius * Math.sin(18 * Math.PI / 180));

        //pair 2
        gc.setFill(MyColor.SILVER.getColor());
        MyCircle circle2 = new MyCircle(newradius , CanvasLength/2 , CanvasWidth/2);
        circle2.draw(gc);
        gc.setFill(MyColor.GREY.getColor());
        MyPolygon polygon2 = new MyPolygon(new double[]{firstx , secondx , thirdx , fourthx , fifthx} , new double[]{firsty , secondy , thirdy , fourthy , fifthy} , 5);
        polygon2.draw(gc);
        newradius = newradius * Math.cos(3.14 / 5);

        firstx = (CanvasLength/2);
        firsty = (CanvasWidth/2) - newradius;

        secondx = ((CanvasLength/2) - newradius * Math.cos(18 * Math.PI / 180));
        secondy = ((CanvasWidth/2) - newradius * Math.sin(18 * Math.PI / 180));

        thirdx = ((CanvasLength/2) - newradius * Math.cos(54 * Math.PI / 180));
        thirdy = ((CanvasWidth/2) + newradius * Math.sin(54 * Math.PI / 180));

        fourthx = ((CanvasLength/2) + newradius * Math.cos(54 * Math.PI / 180));
        fourthy = ((CanvasWidth/2) + newradius * Math.sin(54 * Math.PI / 180));

        fifthx = ((CanvasLength/2) + newradius * Math.cos(18 * Math.PI / 180));
        fifthy = ((CanvasWidth/2) - newradius * Math.sin(18 * Math.PI / 180));

        //pair 3
        gc.setFill(MyColor.PINK.getColor());
        MyCircle circle3 = new MyCircle(newradius , CanvasLength/2 , CanvasWidth/2);
        circle3.draw(gc);
        gc.setFill(MyColor.YELLOW.getColor());
        MyPolygon polygon3 = new MyPolygon(new double[]{firstx , secondx , thirdx , fourthx , fifthx} , new double[]{firsty , secondy , thirdy , fourthy , fifthy} , 5);
        polygon3.draw(gc);
        newradius = newradius * Math.cos(3.14 / 5);


//        gc.setFill(MyColor.WHITE.getColor());
//        MyCircle innerMostCircle = new MyCircle(newradius , CanvasLength/2 , CanvasWidth/2);
//        innerMostCircle.draw(gc);

        MyLine line1 = new MyLine(0 , 0 , CanvasLength , CanvasWidth);
        line1.draw(gc);
        MyLine line2 = new MyLine(CanvasLength , 0 , 0 , CanvasWidth);
        line2.draw(gc);



        //canvas and window attribute code
        root.getChildren().add(canvas);
        primaryStage.setTitle("Figure");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
