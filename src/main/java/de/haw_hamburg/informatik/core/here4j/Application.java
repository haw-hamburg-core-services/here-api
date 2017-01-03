package de.haw_hamburg.informatik.core.here4j;

import de.haw_hamburg.informatik.core.here4j.maptile.MapTile;
import de.haw_hamburg.informatik.core.here4j.maptile.ResourceTileType;
import de.haw_hamburg.informatik.core.here4j.weather.WeatherProduct;
import de.haw_hamburg.informatik.core.here4j.weather.Weather;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by skrec on 03.01.2017.
 */
public class Application {
    public static void main (String ... args ){
        try {
            Weather weather = new Weather();
            String response = weather.requestReport("Hamburg", WeatherProduct.forecast_hourly);
            System.out.println(response);


        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            MapTile mapTile = new MapTile();
            String response = mapTile.requestMapTile(ResourceTileType.maptile,13,4400,2686);

            Stage stage = new Stage();
            Image image = new Image(response);
            // simple displays ImageView the image as is
            ImageView iv1 = new ImageView();
            iv1.setImage(image);

            Group root = new Group();
            Scene scene = new Scene(root,400,400);
            scene.setFill(Color.BLACK);
            HBox box = new HBox();
            box.getChildren().add(iv1);
            root.getChildren().add(box);

            stage.setTitle("ImageView");
            stage.setScene(scene);
            stage.show();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
