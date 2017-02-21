package de.haw_hamburg.informatik.core.here4j.routing.parameters;

import javafx.geometry.Point2D;

/**
 * Created by TimoHäckel on 21.02.2017.
 */
public class Area {
    //four corners of area rectangle
    private Point2D topLeft;
    private Point2D bottomRight;

    public Area(Point2D topLeft, Point2D bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public Area(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY) {
        this.topLeft = new Point2D(topLeftX, topLeftY);
        this.bottomRight = new Point2D(bottomRightX, bottomRightY);
    }

    public Point2D getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point2D topLeft) {
        this.topLeft = topLeft;
    }

    public Point2D getBottomRight() {
        return bottomRight;
    }

    public void setBottomRight(Point2D bottomRight) {
        this.bottomRight = bottomRight;
    }

    @Override
    public String toString() {
        return "Area{" +
                "topLeft=" + topLeft +
                ", bottomRight=" + bottomRight +
                '}';
    }

    public String toRequestString() {
        return topLeft.getX() + "," + topLeft.getY() + ";" + bottomRight.getX() + "," + bottomRight.getY();
    }
}
