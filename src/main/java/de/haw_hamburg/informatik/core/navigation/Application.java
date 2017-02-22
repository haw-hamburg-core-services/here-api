package de.haw_hamburg.informatik.core.navigation;

import de.haw_hamburg.informatik.core.calendar.CalendarEvent;
import de.haw_hamburg.informatik.core.calendar.CalendarEventCollection;
import de.haw_hamburg.informatik.core.here4j.base_data_types.GeoCoordinateType;
import de.haw_hamburg.informatik.core.here4j.base_data_types.LanguageCodeType;
import de.haw_hamburg.informatik.core.here4j.geocoder.resources.Geocoding;
import de.haw_hamburg.informatik.core.here4j.geocoder.response_data_types.GeocodingResponse;
import de.haw_hamburg.informatik.core.here4j.geocoder.response_data_types.SearchResultType;
import de.haw_hamburg.informatik.core.here4j.geocoder.response_data_types.SearchResultsViewType;
import de.haw_hamburg.informatik.core.here4j.routing.parameters.Waypoint;
import de.haw_hamburg.informatik.core.here4j.routing.resources.CalculateRoute;
import de.haw_hamburg.informatik.core.here4j.routing.response_data_types.CalculateRouteResponse;
import de.haw_hamburg.informatik.core.here4j.routing.routing_data_types.*;
import org.springframework.web.client.RestTemplate;
import sun.util.resources.cldr.agq.CalendarData_agq_CM;

import javax.swing.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TimoHäckel on 22.02.2017.
 */
public class Application {

    public static void main (String ... args){
        new Application().start();
    }

    private void start() {
        //request upcoming events
        CalendarEventCollection events = requestEvents();

        //get upcoming events with location
        CalendarEventCollection filteredEvents = filterEvents(events);

        //ask user which route to calculate
        CalendarEvent event = userFeedBack(filteredEvents);

        if(event==null){
            System.out.println("möp");
            return;
        } else {
            System.out.println(event);
        }

        //get geocoding for address
        GeocodingResponse destination = null;
        try {
            destination = new Geocoding(event.getLocation()).request();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }

        //from HAW HAMBURG weil is so!^^
        GeocodingResponse start = null;
        try {
            start = new Geocoding("Berliner Tor 5, 20099 Hamburg").request();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("Start:" + start);
        System.out.println("Destination:" + destination);

        //calculate route
        CalculateRouteResponse route = null;
        try {
             route = calculateRoute(start, destination);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        System.out.println(route);

        //print instructions.
        printInstructions(route);

    }

    private void printInstructions(CalculateRouteResponse route) {
        RouteType[] routeTypes = route.getResponse().getRoute();
        System.out.println("alternative routes:");
        for (int i = 0; i < routeTypes.length; i++){
            System.out.println((i+1) + ":");
            RouteType routeType = routeTypes[i];
            RouteLegType[] legs = routeType.getLeg();

            for (int j = 0; j < legs.length; j++){
                RouteLegType leg = legs[j];
                ManeuverType[] maneuvers = leg.getManeuver();
                System.out.println("\t" + (j+1) + ":");

                for (int k = 0; k < maneuvers.length; k++){
                    ManeuverType maneuver = maneuvers[k];
                    System.out.println("\t \t" + (k+1) + ": " + maneuver.getInstruction());
                }
            }
        }

    }

    private CalculateRouteResponse calculateRoute(GeocodingResponse start, GeocodingResponse destination) throws Exception {
        Waypoint[] waypoints = new Waypoint [2];
        waypoints[0] = new Waypoint(start.getPosition().getLatitude(), start.getPosition().getLongitude());
        waypoints[1] = new Waypoint(destination.getPosition().getLatitude(), destination.getPosition().getLongitude());
        TransportModeType[] transportModeTypes = new TransportModeType [1];
        transportModeTypes[0] = TransportModeType.car;
        CalculateRoute calculateRoute = new CalculateRoute(waypoints, new RoutingModeType(RoutingTypeType.fastest, transportModeTypes),"label",null,null, 2, new LanguageCodeType("de-de"));

        return calculateRoute.request();
    }

    private CalendarEvent userFeedBack(CalendarEventCollection filteredEvents) {
        if(filteredEvents == null) return null;
        if(filteredEvents.getEvents() == null) return null;
        System.out.println("Choose one option");
        int counter = 0;
        for(CalendarEvent event : filteredEvents.getEvents()){
            System.out.println("\t" + (++counter) + ": " + event.getTitle() + " in " + event.getLocation());
        }

        int choice = Integer.parseInt(JOptionPane.showInputDialog("Choose!"));

        return filteredEvents.getEvents().get(choice-1);
    }

    private CalendarEventCollection filterEvents(CalendarEventCollection events) {
        List<CalendarEvent> ret = new ArrayList<>();
        for (CalendarEvent event : events.getEvents()){
            if(event.getLocation() != null){
                ret.add(event);
            }
        }

        return new CalendarEventCollection(ret);
    }

    public CalendarEventCollection requestEvents() {
        RestTemplate restTemplate = new RestTemplate();
        CalendarEventCollection events = restTemplate.getForObject("http://localhost:9000/calendar/events", CalendarEventCollection.class);
        return events;
    }
}
