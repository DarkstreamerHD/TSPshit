import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/**
 * Created by reset on 10/29/2016.
 */
public class Main {

    public static void main(String[] args) {
        Route r = new Route();
        r.points = Utilities.generateRandomMap(Config.pointAmount);
        r = random(r);
        r.calculateDistance();
        Graphic g = new Graphic();
        g.info = ("random, Distance: " + (int)r.distance);
        g.route = r;
        g.setVisible(true);
        System.out.println();
    }

    public static Route random(Route input){
        input.connections.clear();
        input.connectPointsRandomly();
        return input;
    }

    public static Route greedySearch(Route input){
        ArrayList<Point> leftOver = (ArrayList<Point>) deepClone(input.points);
        input.connections.clear();

        Point starter = input.points.get(0);
        Point current = starter;
        leftOver.remove(current);

        for (int i = 0; i < input.getPointAmount(); i++){
        ArrayList<Point> connector = new ArrayList<>();
        Point next;
        next = Utilities.closestPoint(leftOver, current);
            connector.add(0, current);
            connector.add(1, next);
            leftOver.remove(next);
            current = next;
            input.connections.add(connector);
        }
        ArrayList<Point> connector = new ArrayList<>();
        connector.add(current);
        connector.add(starter);
        input.connections.add(connector);
        return input;
    }





    public static Object deepClone(Object object) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String groupNumber(String str) {
        int floatPos = str.indexOf(".") > -1 ? str.length() - str.indexOf(".") : 0;
        int nGroups= (str.length()-floatPos-1-(str.indexOf("-")>-1?1:0))/3;
        for(int i=0; i<nGroups; i++){
            int commaPos = str.length() - i * 4 - 3 - floatPos;
            str = str.substring(0,commaPos) + "," + str.substring(commaPos,str.length());
        }
        return str;
    }




}
