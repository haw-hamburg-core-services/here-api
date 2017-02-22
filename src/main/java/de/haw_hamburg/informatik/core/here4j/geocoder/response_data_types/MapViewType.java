package de.haw_hamburg.informatik.core.here4j.geocoder.response_data_types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.haw_hamburg.informatik.core.here4j.base_data_types.GeoCoordinateType;

/**
 * Created by TimoHäckel on 22.02.2017.
 *
 * Bounding box of the location optimized for display
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MapViewType {

    private GeoCoordinateType TopLeft;
    private GeoCoordinateType BottomRight;

    public MapViewType(GeoCoordinateType topLeft, GeoCoordinateType bottomRight) {
        TopLeft = topLeft;
        BottomRight = bottomRight;
    }

    public MapViewType() {
    }

    public GeoCoordinateType getTopLeft() {
        return TopLeft;
    }

    public void setTopLeft(GeoCoordinateType topLeft) {
        TopLeft = topLeft;
    }

    public GeoCoordinateType getBottomRight() {
        return BottomRight;
    }

    public void setBottomRight(GeoCoordinateType bottomRight) {
        BottomRight = bottomRight;
    }

    @Override
    public String toString() {
        return "MapViewType{" +
                "TopLeft=" + TopLeft +
                ", BottomRight=" + BottomRight +
                '}';
    }
}
