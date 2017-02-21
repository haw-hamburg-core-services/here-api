package de.haw_hamburg.informatik.core.here4j.routing.parameters;


import java.util.Map;

/**
 * Created by TimoHäckel on 21.02.2017.
 */
public class RoutingMode {

    private RoutingType type = null;
    private TransportMode transportMode = null;
    private TrafficMode trafficMode = null;
    private Map<RouteFeature, RouteFeatureWeight> features = null;

    public RoutingMode(RoutingType type) {
        this.type = type;
    }

    public RoutingMode(RoutingType type, TransportMode transportMode) {
        this.type = type;
        this.transportMode = transportMode;
    }

    public RoutingMode(RoutingType type, TrafficMode trafficMode) {
        this.type = type;
        this.trafficMode = trafficMode;
    }

    public RoutingMode(RoutingType type, Map<RouteFeature, RouteFeatureWeight> features) {
        this.type = type;
        this.features = features;
    }

    public RoutingMode(RoutingType type, TransportMode transportMode, TrafficMode trafficMode) {
        this.type = type;
        this.transportMode = transportMode;
        this.trafficMode = trafficMode;
    }

    public RoutingMode(RoutingType type, TrafficMode trafficMode, Map<RouteFeature, RouteFeatureWeight> features) {
        this.type = type;
        this.trafficMode = trafficMode;
        this.features = features;
    }

    public RoutingMode(RoutingType type, TransportMode transportMode, Map<RouteFeature, RouteFeatureWeight> features) {
        this.type = type;
        this.transportMode = transportMode;
        this.features = features;
    }

    public RoutingMode(RoutingType type, TransportMode transportMode, TrafficMode trafficMode, Map<RouteFeature, RouteFeatureWeight> features) {
        this.type = type;
        this.transportMode = transportMode;
        this.trafficMode = trafficMode;
        this.features = features;
    }

    public RoutingType getType() {
        return type;
    }

    public void setType(RoutingType type) {
        this.type = type;
    }

    public TransportMode getTransportMode() {
        return transportMode;
    }

    public void setTransportMode(TransportMode transportMode) {
        this.transportMode = transportMode;
    }

    public TrafficMode getTrafficMode() {
        return trafficMode;
    }

    public void setTrafficMode(TrafficMode trafficMode) {
        this.trafficMode = trafficMode;
    }

    public Map<RouteFeature, RouteFeatureWeight> getFeatures() {
        return features;
    }

    public void setFeatures(Map<RouteFeature, RouteFeatureWeight> features) {
        this.features = features;
    }

    @Override
    public String toString() {
        return "RoutingMode{" +
                "type=" + type +
                ", transportMode=" + transportMode +
                ", trafficMode=" + trafficMode +
                ", features=" + features +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoutingMode that = (RoutingMode) o;

        if (type != that.type) return false;
        if (transportMode != that.transportMode) return false;
        if (trafficMode != that.trafficMode) return false;
        return features != null ? features.equals(that.features) : that.features == null;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + (transportMode != null ? transportMode.hashCode() : 0);
        result = 31 * result + (trafficMode != null ? trafficMode.hashCode() : 0);
        result = 31 * result + (features != null ? features.hashCode() : 0);
        return result;
    }

    public String toRequestString (){
        //RoutingMode = Type + [TransportModes] + [TrafficMode] + [Feature]
        String ret = "";

        //Type
        ret += type.name();

        //[TransportMode]
        if(transportMode != null){
            ret += ";" + transportMode.name();
        }

        //[TrafficMode]
        if(trafficMode != null){
            ret += ";traffic:" + trafficMode.getName();
        }

        //[Features]
        if(features != null){
            for(Map.Entry<RouteFeature, RouteFeatureWeight> feature : features.entrySet()){
                ret += ";" + feature.getKey().name() + ":" + feature.getValue().getValue();
            }
        }

        return ret;
    }

    public enum RoutingType {
        fastest,
        shortest,
    }

    public enum TrafficMode {
        enabled("enabled"),
        disabled("disabled"),
        auto("default");

        private String name;

        TrafficMode(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public enum TransportMode {
        car,
        carHOV,
        pedestrian,
        publicTransport,
        publicTransportTimeTable,
        truck,
        bicycle,
    }

    public enum RouteFeature {
        tollroad,
        motorway,
        boatFerry,
        railFerry,
        tunnel,
        dirtRoad,
        park,
    }

    public enum RouteFeatureWeight {
        strictExclude(-3),
        softExclude(-2),
        avoid(-1),
        normal(0),;

        private int value;

        RouteFeatureWeight(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

}
