package de.haw_hamburg.informatik.core.here4j.routing.routing_data_types;


import java.util.Map;

/**
 * Created by TimoHäckel on 21.02.2017.
 *
 * The RoutingMode specifies how the route is calculated. Parameter representation:
 *      RoutingMode = Type + [TransportModes] + [TrafficModeType] + [Feature]
 */
public class RoutingModeType {

    /**
     * RoutingTypeType relevant to calculation.
     */
    private RoutingTypeType type = null;

    /**
     * Specify which mode of transport to calculate the route for.
     */
    private TransportModeType transportModes = null;

    /**
     * Specify whether to optimize a route for traffic.
     */
    private TrafficModeType trafficMode = null;

    /**
     * Route feature weightings to be applied when calculating the route. As many as required.
     */
    private Map<RouteFeature, RouteFeatureWeight> features = null;

    public RoutingModeType(RoutingTypeType type) {
        this.type = type;
    }

    public RoutingModeType(RoutingTypeType type, TransportModeType transportModes) {
        this.type = type;
        this.transportModes = transportModes;
    }

    public RoutingModeType(RoutingTypeType type, TrafficModeType trafficMode) {
        this.type = type;
        this.trafficMode = trafficMode;
    }

    public RoutingModeType(RoutingTypeType type, Map<RouteFeature, RouteFeatureWeight> features) {
        this.type = type;
        this.features = features;
    }

    public RoutingModeType(RoutingTypeType type, TransportModeType transportModes, TrafficModeType trafficMode) {
        this.type = type;
        this.transportModes = transportModes;
        this.trafficMode = trafficMode;
    }

    public RoutingModeType(RoutingTypeType type, TrafficModeType trafficMode, Map<RouteFeature, RouteFeatureWeight> features) {
        this.type = type;
        this.trafficMode = trafficMode;
        this.features = features;
    }

    public RoutingModeType(RoutingTypeType type, TransportModeType transportModes, Map<RouteFeature, RouteFeatureWeight> features) {
        this.type = type;
        this.transportModes = transportModes;
        this.features = features;
    }

    public RoutingModeType(RoutingTypeType type, TransportModeType transportModes, TrafficModeType trafficMode, Map<RouteFeature, RouteFeatureWeight> features) {
        this.type = type;
        this.transportModes = transportModes;
        this.trafficMode = trafficMode;
        this.features = features;
    }

    public RoutingTypeType getType() {
        return type;
    }

    public void setType(RoutingTypeType type) {
        this.type = type;
    }

    public TransportModeType getTransportModes() {
        return transportModes;
    }

    public void setTransportModes(TransportModeType transportModes) {
        this.transportModes = transportModes;
    }

    public TrafficModeType getTrafficMode() {
        return trafficMode;
    }

    public void setTrafficMode(TrafficModeType trafficMode) {
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
        return "RoutingModeType{" +
                "type=" + type +
                ", transportModes=" + transportModes +
                ", trafficMode=" + trafficMode +
                ", features=" + features +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoutingModeType that = (RoutingModeType) o;

        if (type != that.type) return false;
        if (transportModes != that.transportModes) return false;
        if (trafficMode != that.trafficMode) return false;
        return features != null ? features.equals(that.features) : that.features == null;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + (transportModes != null ? transportModes.hashCode() : 0);
        result = 31 * result + (trafficMode != null ? trafficMode.hashCode() : 0);
        result = 31 * result + (features != null ? features.hashCode() : 0);
        return result;
    }

    public String toRequestString (){
        //RoutingModeType = Type + [TransportModes] + [TrafficModeType] + [Feature]
        String ret = "";

        //Type
        ret += type.name();

        //[TransportModeType]
        if(transportModes != null){
            ret += ";" + transportModes.name();
        }

        //[TrafficModeType]
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

}
