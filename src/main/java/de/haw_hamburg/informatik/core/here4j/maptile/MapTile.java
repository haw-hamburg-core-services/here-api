package de.haw_hamburg.informatik.core.here4j.maptile;

import de.haw_hamburg.informatik.core.here4j.PropertyReader;
import de.haw_hamburg.informatik.core.here4j.weather.Properties;
import de.haw_hamburg.informatik.core.here4j.weather.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by skrec on 03.01.2017.
 */
public class MapTile {

    private static final Logger log = LoggerFactory.getLogger(Weather.class);

    private static final String PROTOCOL = "https://";

    private MapTileTypes mapTileType = MapTileTypes.base;
    private final static String BASE_URL = "maps.api.here.com";
    private final static String PATH = "/maptile/2.1/";
    private final static String MAPID = "newest";

    /**
     * normal.day – for a normal map view in daylight mode
     * normal.day.grey – for a color-reduced map view in daylight mode (especially used for background maps)
     * normal.day.transit – for a color-reduced map view with a public transport scheme in daylight mode
     * normal.night.transit – for a color-reduced map view with a public transport scheme in night mode
     * normal.traffic.day – for a color-reduced map view designed for displaying traffic in daylight mode
     * normal.traffic.night – for a color-reduced map view designed for displaying traffic in night mode
     * normal.day.custom – for a normal map view in daylight mode
     * normal.night – for a normal map view in night mode
     * normal.night.grey – for a color-reduced map view in night mode (especially used for background maps)
     * pedestrian.day – pedestrian map view in daylight mode
     * pedestrian.day.mobile – pedestrian map view in daylight mode for mobile usage
     * pedestrian.night – pedestrian map view in night mode
     * pedestrian.night.mobile – pedestrian map view in night mode for mobile usage
     * carnav.day.grey – for a normal map view in daylight mode for car navigation
     * normal.day.mobile – mobile version of the scheme
     * normal.day.grey.mobile – mobile version of the scheme
     * normal.day.transit.mobile – mobile version of the scheme
     * normal.night.transit.mobile – mobile version of the scheme
     * normal.night.mobile – mobile version of the scheme
     * normal.night.grey.mobile – mobile version of the scheme
     * reduced.day – for a reduced map view in daylight mode with few colors
     * reduced.night – for a reduced map view in night mode with few colors
     * terrain.day – for a terrain map view in daylight mode
     * satellite.day – for a satellite map view in daylight mode
     * hybrid.day – for a satellite map view with streets in daylight mode
     * hybrid.day.transit – for a satellite map view with public transport scheme in daylight mode
     * hybrid.grey.day – for a satellite map view with streets in daylight mode with few colors
     * hybrid.traffic.day – for a satellite map view with streets designed for traffic
     * terrain.day.mobile – mobile version of the scheme
     * hybrid.day.mobile – mobile version of the scheme
     **/
    private final static String SCHEME = "normal.day";

    /**
     * Returned image size. The following sizes ([width, height]) are supported:
     * 256 = [256, 256]
     * 512 = [512, 512]
     * The following sizes ([width, height]) are deprecated, although usage is still accepted:
     * 128 = [128, 128]
     * Note: Raster coverage tiles (rctile, rconlytile and rcdistonlytile) only support 256 sizes.
     */
    private final static int SIZE = 256;

    /**
     * Returned image format. The following image formats are supported:
     * png – PNG format, 24 bit, RGB
     * png8 – PNG format, 8 bit, indexed color
     * jpg – JPG format at 90% quality
     * Please note that JPG is recommended for satellite and hybrid schemes only.
     */
    private final static String FORMAT = "png8";

    private Properties properties;

    public MapTile() {

        Properties properties = PropertyReader.readProperties();
        if(properties != null) {
            this.properties = properties;
        } else {
            log.error("No properties could be found.");
        }

    }

    public void setMapTileType(MapTileTypes mapTileType) {
        this.mapTileType = mapTileType;
    }

    /**
     *
     * @param resourceTileType  on of the defined types.
     * @param zoomlevel         number between 0 and 20
     * @param column            can be everything between 0 and number of colums - 1 (number of colums = 2^zoomlevel)
     * @param row               can be any number between 0 and number of rows - 1 (number of rows = 2^zoom)
     * @return
     */
    public String requestMapTile(ResourceTileType resourceTileType, int zoomlevel, int column, int row){
        if(zoomlevel > 20 || zoomlevel < 0){
            //ERROR
            return null;
        }
        int numberOfColsRows = (int) Math.pow(2,zoomlevel);
        if(column > (numberOfColsRows-1) ||column < 0) {
            //ERROR
            return null;
        }
        if(row > (numberOfColsRows-1) ||row < 0) {
            //ERROR
            return null;
        }

        int serverNumber = (int) (Math.random() * 4 ) + 1;

        String httpCall = PROTOCOL + serverNumber + "." + mapTileType.name() + "." + BASE_URL + PATH
                + resourceTileType.name() + "/" + MAPID + "/" + SCHEME + "/"
                + zoomlevel + "/" + column + "/" + row + "/" + SIZE + "/" + FORMAT
                + "?app_id=" + properties.appID + "&app_code=" + properties.appCode;
        String response = null;
        try {
            URI uri = new URI(httpCall);
            RestTemplate restTemplate = new RestTemplate();
            response = restTemplate.getForObject(uri, String.class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return response;
    }

}
