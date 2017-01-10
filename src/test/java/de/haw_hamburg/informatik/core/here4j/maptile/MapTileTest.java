package de.haw_hamburg.informatik.core.here4j.maptile;

import de.haw_hamburg.informatik.core.here4j.weather.Weather;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

/**
 * Created by skrec on 10.01.2017.
 */
public class MapTileTest {

    MapTile mapTile;

    @Before
    public void setUp() throws Exception {
        mapTile = new MapTile();

    }

    @After
    public void tearDown() throws Exception {


    }

    @Test
    public void requestMapTile() throws Exception {
        boolean success = false;
        try {
            BufferedImage response = mapTile.requestMapTile(ResourceTileType.maptile,13,4400,2686);
            success = true;
        }catch (Exception e){
            e.printStackTrace();
        }

        assertTrue("No MapTileAPI access granted.", success);
    }

}