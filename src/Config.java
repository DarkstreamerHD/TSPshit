/**
 * Created by reset on 12/7/2016.
 */
public class Config {
    public static final int windowHeight, windowWidth,pointAmount,boarderThickness,pointDiameter, infoX, infoY;
    public static final boolean drawPointNumbers;

    static {
        windowHeight = 1080;     //in pixels
        windowWidth = 1920;     //in pixels
        pointAmount = 10;

        //Graphics
        boarderThickness = 50;  //in pixels
        pointDiameter = 10;     //in pixels
        infoX = 500;
        infoY = 40;
        drawPointNumbers = false;
    }
}
