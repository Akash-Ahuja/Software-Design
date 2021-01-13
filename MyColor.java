package sample;

import javafx.scene.paint.Color;

public enum MyColor {
    BLACK,
    RED,
    WHITE,
    GREY,
    PINK,
    YELLOW,
    SILVER;

    Color c;

    MyColor()
    {
        switch(this.ordinal())
        {
            case 0:
                this.c = Color.BLACK;
                break;
            case 1:
                this.c = Color.RED;
                break;
            case 2:
                this.c = Color.WHITE;
                break;
            case 3:
                this.c = Color.GREY;
                break;
            case 4:
                this.c = Color.PINK;
                break;
            case 5:
                this.c = Color.YELLOW;
                break;
            case 6:
                this.c = Color.SILVER;
                break;
            default:
                this.c = null;
        }
    }

    Color getColor()
    {
        return c;
    }

    static Color mix(Color color1, Color color2){

        Color color = new Color ((color1.getRed()+color2.getRed())/2,(color1.getGreen()+color2.getGreen())/2,
                (color1.getBlue()+color2.getBlue())/2,(color1.getOpacity()+color2.getOpacity())/2);

        return color;
    }
}
