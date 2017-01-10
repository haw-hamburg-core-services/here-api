package de.haw_hamburg.informatik.core.here4j;

import de.haw_hamburg.informatik.core.here4j.maptile.MapTile;
import de.haw_hamburg.informatik.core.here4j.maptile.MapTileTypes;
import de.haw_hamburg.informatik.core.here4j.maptile.ResourceTileType;
import de.haw_hamburg.informatik.core.here4j.weather.WeatherProduct;
import de.haw_hamburg.informatik.core.here4j.weather.Weather;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static java.lang.System.exit;

/**
 * Created by skrec on 03.01.2017.
 */
public class Application {
    public static void main (String ... args ) throws IOException {
        MapTile mapTile = new MapTile();

        //Server request
        mapTile.setMapTileType(MapTileTypes.traffic);
        BufferedImage img = mapTile.requestMapTile(ResourceTileType.traffictile,15,53.5511,9.9937);

        //display
        ImageIcon icon = new ImageIcon(img.getScaledInstance(1000,1000,Image.SCALE_SMOOTH));

        JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(1000,1000);
        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
