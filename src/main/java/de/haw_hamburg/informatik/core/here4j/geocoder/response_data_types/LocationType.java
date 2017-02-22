package de.haw_hamburg.informatik.core.here4j.geocoder.response_data_types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.haw_hamburg.informatik.core.here4j.base_data_types.GeoCoordinateType;

import java.util.Arrays;

/**
 * Created by TimoHäckel on 22.02.2017.
 *
 * The location type refers to a physical location including the physical extent. A location can be referenced either
 * by Location ID or by specifying the address.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationType {

    /**
     * A key uniquely identifying a physical location.
     */
    @JsonProperty("LocationId")
    private String locationId;

    /**
     * Indicates the type of the location.
     */
    @JsonProperty("LocationType")
    private LocationTypeType locationType;

    /**
     * The name of a location. This is relevant for landmarks like parks and lakes.
     */
    @JsonProperty("Name")
    private String name;

    /**
     * The display position contains the coordinates at which to place a marker indicating the given location on the
     * map.
     */
    @JsonProperty("DisplayPosition")
    private GeoCoordinateType displayPosition;

    /**
     * A navigation position contains the coordinates of a potential route waypoint. It is used for routes that pass
     * through the given location.
     */
    @JsonProperty("NavigationPosition")
    private GeoCoordinateType [] navigationPosition;

    /**
     * Bounding box of the location optimized for display
     */
    @JsonProperty("MapView")
    private MapViewType mapView;

    /**
     * address record of a Location. Attributes are normalized to US feature names and can be mapped to the local
     * feature levels (for example, State matches "Bundesland" in Germany) using mapping tables.
     */
    @JsonProperty("Address")
    private AddressType address;

    public LocationType(String locationId, LocationTypeType locationType, String name, GeoCoordinateType displayPosition, GeoCoordinateType[] navigationPosition, MapViewType mapView, AddressType address) {
        this.locationId = locationId;
        this.locationType = locationType;
        this.name = name;
        this.displayPosition = displayPosition;
        this.navigationPosition = navigationPosition;
        this.mapView = mapView;
        this.address = address;
    }

    public LocationType() {
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public LocationTypeType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationTypeType locationType) {
        this.locationType = locationType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GeoCoordinateType getDisplayPosition() {
        return displayPosition;
    }

    public void setDisplayPosition(GeoCoordinateType displayPosition) {
        this.displayPosition = displayPosition;
    }

    public GeoCoordinateType[] getNavigationPosition() {
        return navigationPosition;
    }

    public void setNavigationPosition(GeoCoordinateType[] navigationPosition) {
        this.navigationPosition = navigationPosition;
    }

    public MapViewType getMapView() {
        return mapView;
    }

    public void setMapView(MapViewType mapView) {
        this.mapView = mapView;
    }

    public AddressType getAddress() {
        return address;
    }

    public void setAddress(AddressType address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "locationType{" +
                "locationId='" + locationId + '\'' +
                ", locationType=" + locationType +
                ", name='" + name + '\'' +
                ", displayPosition=" + displayPosition +
                ", navigationPosition=" + Arrays.toString(navigationPosition) +
                ", mapView=" + mapView +
                ", address=" + address +
                '}';
    }
}
