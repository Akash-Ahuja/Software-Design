package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import java.util.Random;

public class PieChart extends HistogramAlphabet{
    int n;
    float angle;
    float startAngle = 90;
    int[] rgb = new int[3];

    PieChart(int n)
    {
        this.n = n;

        super.calculate_probability();

        //sorting the probabilities and alphabets
        for(int i=0; i<25; i++)
        {
            for(int j=0; j<25-i; j++)
            {
                if (probability[j] < probability[j+1])
                {
                    float temp = probability[j];
                    probability[j] = probability[j+1];
                    probability[j+1] = temp;

                    char ch = alphabets[j];
                    alphabets[j] = alphabets[j+1];
                    alphabets[j+1] = ch;
                }
            }
        }
    }

    void createRandomColor()
    {
        Random rand = new Random();

        rgb[0] = rand.nextInt(255);
        rgb[1] = rand.nextInt(255);
        rgb[2] = rand.nextInt(255);
    }

    void draw(GraphicsContext gc)
    {
        gc.strokeOval(500, 5, 200, 200);


        for(int i=0; i<n; i++)
        {
            angle = probability[i] * (float)360;

            createRandomColor();

            gc.setFill(Color.rgb(rgb[0] , rgb[1] , rgb[2]));
            gc.fillArc(500, 5, 200, 200, startAngle, -angle, ArcType.ROUND);
            startAngle = startAngle - angle;
        }
    }
}
