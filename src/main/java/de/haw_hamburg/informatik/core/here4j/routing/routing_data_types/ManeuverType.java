package de.haw_hamburg.informatik.core.here4j.routing.routing_data_types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.haw_hamburg.informatik.core.here4j.base_data_types.GeoCoordinateType;

/**
 * Created by TimoHäckel on 21.02.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ManeuverType {
    private GeoCoordinateType position;
    private String instruction;
    private double travelTime;
    private double lenght;
    private String id;
    private String _type;

    public ManeuverType(GeoCoordinateType position, String instruction, double travelTime, double lenght, String id, String _type) {
        this.position = position;
        this.instruction = instruction;
        this.travelTime = travelTime;
        this.lenght = lenght;
        this.id = id;
        this._type = _type;
    }

    public ManeuverType() {
    }

    public GeoCoordinateType getPosition() {
        return position;
    }

    public void setPosition(GeoCoordinateType position) {
        this.position = position;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public double getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(double travelTime) {
        this.travelTime = travelTime;
    }

    public double getLenght() {
        return lenght;
    }

    public void setLenght(double lenght) {
        this.lenght = lenght;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    @Override
    public String toString() {
        return "ManeuverType{" +
                "position=" + position +
                ", instruction='" + instruction + '\'' +
                ", travelTime=" + travelTime +
                ", lenght=" + lenght +
                ", id='" + id + '\'' +
                ", _type='" + _type + '\'' +
                '}';
    }
}
