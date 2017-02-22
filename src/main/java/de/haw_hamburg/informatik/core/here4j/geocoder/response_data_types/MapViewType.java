package de.haw_hamburg.informatik.core.here4j.geocoder.response_data_types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.haw_hamburg.informatik.core.here4j.base_data_types.GeoCoordinateType;

/**
 * Created by TimoHäckel on 22.02.2017.
 *
 * Bounding box of the location optimized for display
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MapViewType {

    @JsonProperty("TopLeft")
    private GeoCoordinateType topLeft;
    @JsonProperty("BottomRight")
    private GeoCoordinateType bottomRight;

    public MapViewType(GeoCoordinateType topLeft, GeoCoordinateType bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public MapViewType() {
    }

    public GeoCoordinateType getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(GeoCoordinateType topLeft) {
        this.topLeft = topLeft;
    }

    public GeoCoordinateType getBottomRight() {
        return bottomRight;
    }

    public void setBottomRight(GeoCoordinateType bottomRight) {
        this.bottomRight = bottomRight;
    }

    @Override
    public String toString() {
        return "MapViewType{" +
                "topLeft=" + topLeft +
                ", bottomRight=" + bottomRight +
                '}';
    }
}
