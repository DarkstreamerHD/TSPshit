import java.util.ArrayList;

/**
 * Created by reset on 10/29/2016.
 */
public class Utilities {

    public static double distancePoints(Point a, Point b){
        return pythagoras(Math.abs(a.getX() - b.getX()), Math.abs(a.getY() -b.getY()));
    }

    public static double pythagoras(double a, double b){
        return Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
    }


    public static Point closestPoint(ArrayList<Point> list, Point p){
        Point best = new Point();
        double bestDistance = Double.POSITIVE_INFINITY;
        for (int i = 0;i<list.size();i++){
            if (Utilities.distancePoints(list.get(i),p) < bestDistance){
                best = list.get(i);
                bestDistance = Utilities.distancePoints(list.get(i),p);
            }
        }

        return best;
    }

    public static ArrayList<Point> generateRandomMap(int length){
        ArrayList<Point> result = new ArrayList<>();

        for (int i = 0; i<length; i++){
        Point p = new Point();
            int rdmX = (int) Math.round(Math.random()*(Config.windowWidth - 2* Config.boarderThickness) + Config.boarderThickness);
            int rdmY = (int) Math.round(Math.random()*(Config.windowHeight- 2* Config.boarderThickness) + Config.boarderThickness);
            p.setX(rdmX);
            p.setY(rdmY);
            p.name = String.valueOf(i);
            result.add(p);
        }

        return result;

    }
}
