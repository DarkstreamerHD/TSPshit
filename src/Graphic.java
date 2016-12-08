import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

/**
 * Created by reset on 10/29/2016.
 */
class Graphic extends JFrame {
    Route route;
        String info;
    public Graphic(){
        JFrame frame = new JFrame();

        JPanel panel=new JPanel();
        getContentPane().add(panel);
        setSize(Config.windowWidth, Config.windowHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);


    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponents(g);

        for (int i = 0; i< route.getPointAmount(); i++) {
            Ellipse2D.Double circle = new Ellipse2D.Double(route.points.get(i).x-5, route.points.get(i).y-0.5* Config.pointDiameter, Config.pointDiameter, Config.pointDiameter);
            g2.fill(circle);
            if (Config.drawPointNumbers){
                g2.drawString(route.points.get(i).name, route.points.get(i).getX(), route.points.get(i).getY() - 5 );
            }
        }

        if (route != null && route.points != null) {

            for (int i = 0; i < route.getPointAmount()+1; i++) {

                if (info != null) {
                    g2.drawString(info, Config.infoX, Config.infoY);
                }

                int p1x = route.connections.get(i).get(0).getX();
                int p1y = route.connections.get(i).get(0).getY();

                int p2x = route.connections.get(i).get(1).getX();
                int p2y = route.connections.get(i).get(1).getY();


                Line2D line = new Line2D.Float(p1x, p1y, p2x, p2y);
                g2.draw(line);







            }
        }
    }
}
