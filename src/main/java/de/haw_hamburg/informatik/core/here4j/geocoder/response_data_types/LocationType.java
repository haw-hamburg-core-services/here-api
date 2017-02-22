package de.haw_hamburg.informatik.core.here4j.geocoder.response_data_types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private String LocationId;

    /**
     * Indicates the type of the location.
     */
    private LocationTypeType LocationType;

    /**
     * The name of a location. This is relevant for landmarks like parks and lakes.
     */
    private String Name;

    /**
     * The display position contains the coordinates at which to place a marker indicating the given location on the
     * map.
     */
    private GeoCoordinateType DisplayPosition;

    /**
     * A navigation position contains the coordinates of a potential route waypoint. It is used for routes that pass
     * through the given location.
     */
    private GeoCoordinateType [] NavigationPosition;

    /**
     * Bounding box of the location optimized for display
     */
    private MapViewType MapView;

    /**
     * Address record of a Location. Attributes are normalized to US feature names and can be mapped to the local
     * feature levels (for example, State matches "Bundesland" in Germany) using mapping tables.
     */
    private AddressType Address;

    public LocationType(String locationId, LocationTypeType locationType, String name, GeoCoordinateType displayPosition, GeoCoordinateType[] navigationPosition, MapViewType mapView, AddressType address) {
        LocationId = locationId;
        LocationType = locationType;
        Name = name;
        DisplayPosition = displayPosition;
        NavigationPosition = navigationPosition;
        MapView = mapView;
        Address = address;
    }

    public LocationType() {
    }

    public String getLocationId() {
        return LocationId;
    }

    public void setLocationId(String locationId) {
        LocationId = locationId;
    }

    public LocationTypeType getLocationType() {
        return LocationType;
    }

    public void setLocationType(LocationTypeType locationType) {
        LocationType = locationType;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public GeoCoordinateType getDisplayPosition() {
        return DisplayPosition;
    }

    public void setDisplayPosition(GeoCoordinateType displayPosition) {
        DisplayPosition = displayPosition;
    }

    public GeoCoordinateType[] getNavigationPosition() {
        return NavigationPosition;
    }

    public void setNavigationPosition(GeoCoordinateType[] navigationPosition) {
        NavigationPosition = navigationPosition;
    }

    public MapViewType getMapView() {
        return MapView;
    }

    public void setMapView(MapViewType mapView) {
        MapView = mapView;
    }

    public AddressType getAddress() {
        return Address;
    }

    public void setAddress(AddressType address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "LocationType{" +
                "LocationId='" + LocationId + '\'' +
                ", LocationType=" + LocationType +
                ", Name='" + Name + '\'' +
                ", DisplayPosition=" + DisplayPosition +
                ", NavigationPosition=" + Arrays.toString(NavigationPosition) +
                ", MapView=" + MapView +
                ", Address=" + Address +
                '}';
    }
}
