package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.*;

public class Main extends Application {
    static Connection con = null;

    @Override
    public void start(Stage primaryStage) throws Exception {
        {
            VBox root = new VBox();
            Scene scene1 = new Scene(root, 1000, 1000);

            PieChart p = new PieChart(con);
            for (int i = 0; i < 6; i++) {
                Text t = new Text();
                root.getChildren().add(t);
                t.setFill(Color.rgb(p.rgb[i][0], p.rgb[i][1], p.rgb[i][2]));
                t.setFont(Font.font(20));
                t.setText(p.gpa[i] + " - " + p.count_gpa[i] + " - " + p.percentage[i] + "% Overall");
            }

            Text t = new Text();
            root.getChildren().add(t);
            t.setFill(Color.BLACK);
            t.setFont(Font.font(20));
            t.setText("Total students - " + p.no_of_students);

            Canvas canvas = new Canvas(500, 500);
            GraphicsContext gc = canvas.getGraphicsContext2D();
            root.getChildren().add(canvas);
            p.draw(gc);


            primaryStage.setTitle("Pie Chart");
            primaryStage.setScene(scene1);
            primaryStage.show();
        }
    }


    public static void main(String[] args) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //user and password is also entered for logging in to the database
            //This login condition varies from database to database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=EST", "root", "Wocaonimade123!");
            System.out.println("Connection Established");

            TableGenerator.createTables(con);

            TableGenerator.studentsInfo(con);

            TableGenerator.coursesTable(con);

            TableGenerator.classesTable(con);

//            TableGenerator.readStudentsList(con);
            System.out.println("Database Successfully built!");

            TableGenerator.deleteStudentsRow(con, 23734892);
            //The following commands will only work if I stop adding a new entry//
//            TableGenerator.deleteStudentsRow(con, 23734892);
//            TableGenerator.deleteStudentsRow(con, 23364959);
//            TableGenerator.deleteStudentsRow(con,23364906);
//            TableGenerator.deleteStudentsRow(con,23366782);

            TableGenerator.createNewStudent(con,23534876, "MS", "DHONI", "M");


            TableGenerator.updateStudent(con,23534876, "MS", "DHONI" );
        }
        catch (Exception e) {
            System.out.println("Exception caught " + e);
        }
        launch(args);
    }
}


//            PreparedStatement s = con.prepareStatement("drop table students, courses , classes");
//            s.executeUpdate();
//            System.out.println("Classes dropped");
//
//            system.out.println("Creating tables...");
//            TableGenerator.createTables(con);
//
//            System.out.println("Building courses table...");
//            TableGenerator.coursesTable(con);
//
//            System.out.println("Building students table...");
//            TableGenerator.studentsInfo(con);
//
//            System.out.println("Building classes table...");
//            TableGenerator.classesTable(con);
//
//            System.out.println("Database successfully built!");


        //This what is asked in the exercise to display number of students with the given condition
//            System.out.println("Number of students enrolled in CSC211 in the Fall 2019 are");
//            PreparedStatement p = con.prepareStatement("select count(studentID) from classes natural join courses where year = 2019 and semester = 'Fall' and courseTitle = 'CS211'");
//            ResultSet r1 = p.executeQuery();
//            while(r1.next())
//            {
//                System.out.println(r1.getInt("count(studentID)"));
//            }

        //This contains list of students who has cleared the desired conditions.
//            System.out.println("List of students :-");
//            PreparedStatement p1 = con.prepareStatement("select studentID , first_name , last_name, GPA from classes natural join courses natural join students where year = 2019 and semester = 'Fall' and courseTitle = 'CS211';");
//            ResultSet r2 = p1.executeQuery();
//            System.out.println("StudentID\t" + "First Name\t" + "Last Name\t\t" + "   GPA");
//            while(r2.next())
//            {
//                System.out.print(r2.getInt("studentID") + "\t\t");
//                System.out.print(r2.getString("first_name") + "\t\t");
//                System.out.print(r2.getString("last_name") + "\t\t");
//                System.out.print(r2.getString("GPA"));
//
//                System.out.println();
//            }
//
//            launch(args);
//        }
