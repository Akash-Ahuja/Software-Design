//package sample;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//public class Main extends Application {
//
//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
//    }
//
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}

package sample;
import javafx.application.Application;
import javafx.scene.canvas.*;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application{

    final double CanvasLength = 800;
    final double CanvasWidth = 800;

    VBox root = new VBox();
    Scene scene = new Scene(root);
    Canvas canvas = new Canvas(CanvasLength , CanvasWidth);
    GraphicsContext gc = canvas.getGraphicsContext2D();

    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }

    void buildPieChart(String input)
    {
        try
        {
            int n = Integer.parseInt(input);
            PieChart p = new PieChart(n);
            p.draw(gc);
        }
        catch(Exception e)
        {
            System.out.println("Exception caught as follows\n" + e);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {

        //window and canvas creation code

        Text t = new Text();
        root.getChildren().add(t);
        t.setX(0);
        t.setY(30);
        t.setText("Enter the value of 'n' for most frequent occurrences of events(0 - 26)");
        t.setFont(Font.font(20));

        TextField field = new TextField();
        root.getChildren().add(field);
        field.setLayoutX(0);
        field.setLayoutY(35);

        Button bt = new Button("Submit");
        root.getChildren().add(bt);
        bt.setLayoutX(0);
        bt.setLayoutY(65);
//        bt.setOnAction(e -> buildPieChart(field.getText()));

        bt.setOnAction(e -> {
            gc.clearRect(0,0,800,790);
            buildPieChart(field.getText());
        });

        root.getChildren().add(canvas);
        primaryStage.setTitle("Pie Chart");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
