import java.lang.reflect.Array;
import java.util.ArrayList;

public class Ship {
    private Point origin;
    private boolean isVertical;
    private int shipLength;
    private ArrayList<Point> points;
    private boolean[] fires;
    private boolean sank;
    private int hitCount;

    public Ship(Point origin, boolean isVertical, int shipLength) {
        this.origin = origin;
        this.isVertical = isVertical;
        this.shipLength = shipLength;

        this.points = new ArrayList<Point>();
        this.fires = new boolean[this.shipLength];
        for(int i = 0; i < this.shipLength; i++) {
//            System.out.println(this.isVertical);
//            System.out.println(origin.getX() + (this.isVertical ? 0 : 1));
//            System.out.println(origin.getY() + (this.isVertical ? 1 : 0));
            this.points.add(new Point(origin.getX() + i*(this.isVertical ? 0 : 1),
                    origin.getY() + i*(this.isVertical ? 1 : 0)));
        }
        this.sank = false;
        this.hitCount = 0;
    }

    public ArrayList<Point> getPoints() {
        return this.points;
    }

    public int getShipLength() {
        return this.shipLength;
    }

    public boolean containsPoint(Point p) {
        for (Point internalPoint: this.points) {
            if(internalPoint.getX() == p.getX() && internalPoint.getY() == p.getY()) {
                return true;
            }
        }
        return false;
    }

    public int getPointIndex(Point p) {
        for (int i = 0; i < this.points.size(); i++) {
            if(points.get(i).getX() == p.getX() && points.get(i).getY() == p.getY()) {
                return i;
            }
        }
        return -1;
    }

    public boolean collidesWith(Ship anotherShip) {
        ArrayList<Point> pointsAnotherShip = anotherShip.getPoints();
        for (Point externalPoint: pointsAnotherShip) {
            if (this.containsPoint(externalPoint)) {
                return true;
            }
        }
        return false;
    }

    // Always call isHitAtPoint with a following isSank, since ship might sank
    public boolean isHitAtPoint(Point p) {
        if (this.containsPoint(p)) {
            int pointIndex = this.getPointIndex(p);
            if (!fires[pointIndex]) {
                this.fires[pointIndex] = true;
                this.hitCount += 1;
                return true;
            }
        }
        return false;
    }

    public boolean isSank() {
        if (this.hitCount == this.shipLength) {
            this.sank = true;
            return true;
        }
        return false;
    }

    public String toString() {
        return String.format("origin=%s, isVertical=%b, shipLength=%d", this.origin.toString(),
                this.isVertical, this.shipLength);
    }
}
