package de.haw_hamburg.informatik.core.here4j.maptile;

/**
 * Created by skrec on 10.01.2017.
 */
public class GridCoordinate {
    private int column;
    private int row;

    private GridCoordinate(int xTile, int yTile) {
        column = xTile;
        row = yTile;
    }


    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public static GridCoordinate getGridCoordinateForGeoLocation(double latitude, double longitude, int zoomlevel){
        double latRad = latitude * Math.PI / 180;
        double n = Math.pow(2, zoomlevel);

        int xTile = (int)(n * ((longitude + 180) / 360));
        int yTile = (int) (n * (1-(Math.log(Math.tan(latRad) + 1/Math.cos(latRad)) /
                Math.PI)) / 2);

        return new GridCoordinate(xTile, yTile);
    }
}
