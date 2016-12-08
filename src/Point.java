import java.io.Serializable;

/**
 * Created by reset on 10/29/2016.
 */
public class Point implements Serializable {
    int x, y;
    String name;


    public Point(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public Point() {
    }

      public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}


