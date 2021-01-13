package sample;

import java.sql.*;
import java.util.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;


    public class PieChart {
        // Everywhere 6 is used because possible GPAs are only A,B,C,D,W,F

        int no_of_students = 0;

        //Number of students having different GPAs
        int[] count_gpa = new int[6];

        //Total number of GPAs
        char[] gpa = new char[6];

        float[] percentage = new float[6];

        //angle of an arc
        float angle;

        //starting angle of an arc
        float startAngle = 90;

        //2_D array having RGB information of 'n' number of events
        int[][] rgb;

        PieChart(Connection con)
        {
            // 'n' number of events will have their own color and they
            //have to be described in the form of RGB. Hence there are
            // 3 columns for all the 'n' events.
            rgb = new int[6][3];

            try
            {
                //This code is used get the total number of data entries in the students table
                PreparedStatement p0 = con.prepareStatement("select count(*) from students");
                ResultSet r0 = p0.executeQuery();
                while(r0.next())
                {
                    no_of_students = r0.getInt("count(*)");
                }

                int i = 0;
                //The below query gives the GPA along with the number of students having that GPA.
                PreparedStatement p1 = con.prepareStatement("select count(studentID) , GPA from classes group by GPA order by GPA");
                ResultSet r2 = p1.executeQuery();
                while(r2.next())
                {
                    count_gpa[i] = r2.getInt("count(studentID)");
                    percentage[i] = (count_gpa[i]/(float)no_of_students) * 100;
                    gpa[i] = (char)r2.getString("GPA").charAt(0);
                    i++;
                }
            }
            catch(Exception e)
            {
                System.out.println("Exception caught " + e);
            }

            createRandomColor();
        }

        final void createRandomColor()
        {
            Random rand = new Random();

            for(int i=0; i<6; i++)
            {
                //The random generation is restricted to 255 only
                //because RGB components can only be in the range (0-255)
                rgb[i][0] = rand.nextInt(255);
                rgb[i][1] = rand.nextInt(255);
                rgb[i][2] = rand.nextInt(255);
            }
        }


        void draw(GraphicsContext gc)
        {
            //makes an circular outline for the arcs
            gc.strokeOval(200, 200, 300, 300);

            for(int i=0; i<6; i++)
            {
                angle = percentage[i] * (float)360 / 100;
                //Sets up the color that is to be filled in the arc
                gc.setFill(Color.rgb(rgb[i][0] , rgb[i][1] , rgb[i][2]));

                //An arc is created for a particular event
                //-angle is used because of clockwise drawing of arcs.
                gc.fillArc(200, 200, 300, 300, startAngle, -angle, ArcType.ROUND);

                //start angle is reduced by angle because ars are drawn in clockwise direction.
                startAngle = startAngle - angle;
            }
        }
    }

