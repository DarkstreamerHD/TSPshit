
import java.util.ArrayList;

/**
 * Created by reset on 12/7/2016.
 */
public class Route {
    public ArrayList<Point> points = new ArrayList<>();
    public ArrayList<ArrayList<Point>> connections = new ArrayList<>();
    public double distance;

    public Route(ArrayList<Point> points, ArrayList<ArrayList<Point>> connections ){
        this.connections = connections;
        this.points = points;
    }

    public Route(){}

    public void calculateDistance(){
        for (int i = 0; i < getPointAmount(); i++){
        distance += Utilities.distancePoints(connections.get(i).get(0),connections.get(i).get(1));
        }
        distance = Math.round(distance);
    }

    public int getPointAmount(){
        return points.size();
    }

    public void connectPointsRandomly(){
        connections.clear();
        ArrayList<Point> leftOver = (ArrayList<Point>) Main.deepClone(points);

        Point start = leftOver.get(0);
        Point current = start;
        leftOver.remove(current);

        for (int i = 0; i < getPointAmount()-1;i++){
            ArrayList<Point> connector = new ArrayList<>();
        Point next =  leftOver.get((int) Math.round(Math.random() * (leftOver.size()-1) ));
        connector.clear();
        connector.add(current);
        connector.add(next);
        connections.add(connector);
        leftOver.remove(next);
        current = next;

        }

       ArrayList<Point> last = new ArrayList<>();
        last.add(connections.get(connections.size()-1).get(1));
        last.add(connections.get(0).get(0));

        connections.add(last);

    }


}
