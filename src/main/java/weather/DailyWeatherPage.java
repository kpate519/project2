package weather;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;

public class DailyWeatherPage {
    public Scene createScene(Stage stage) {
        //vbox for all
        VBox vbox = new VBox();
        vbox.setStyle("-fx-background-color: #E8E2DB; -fx-padding: 60 0 0 0;");
        vbox.setSpacing(20);

        //Vbox for temp and short description
        VBox vbox2 = new VBox();
        vbox2.setAlignment(Pos.CENTER);
        vbox2.setSpacing(0);

        //vbox for picture and temp
        VBox vbox3 = new VBox();
        vbox3.setAlignment(Pos.CENTER);
        vbox3.setSpacing(5);

        //city
        Label cityName = new Label("Chicago, Illinois");
        Font cityFont = Font.loadFont(getClass().getResourceAsStream("/fonts/Poppins-SemiBold.ttf"),25);
        cityName.setFont(cityFont);
        cityName.setStyle("-fx-text-fill: black");

        ArrayList<Period> forecast = WeatherAPI.getForecast("LOT", 77, 70);
        int current = forecast.get(0).temperature;
        String weather = forecast.get(0).shortForecast;

        //temperature
        String tempText = current + "°";
        Label temperature = new Label(tempText);
        Font tempFont = Font.loadFont(getClass().getResourceAsStream("/fonts/Poppins-SemiBold.ttf"),70);
        temperature.setFont(tempFont);
        temperature.setStyle("-fx-text-fill: black");

        //image for weather
        String imagePath = getWeatherPic(weather);
        Image image = new Image(getClass().getResourceAsStream(imagePath));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(120);
        imageView.setPreserveRatio(true);

        //short description
        Label shortDescription = new Label(weather);
        Font shortDesFont = Font.loadFont(getClass().getResourceAsStream("/fonts/Poppins-SemiBold.ttf"),17);
        shortDescription.setFont(shortDesFont);
        shortDescription.setStyle("-fx-text-fill: black");

        vbox2.getChildren().addAll(temperature, shortDescription);

        vbox.getChildren().addAll(cityName,imageView, vbox2);

        vbox.setAlignment(Pos.TOP_CENTER);

        return new Scene(vbox, 320, 640);
    }

    private String getWeatherPic(String text) {
        String weather = text.toLowerCase();
        if (weather.contains("sunny") || weather.contains("clear")) {
            return "/images/sunny.png";
        } else if (weather.contains("cloudy")) {
            return "/images/sunny.png";
        } else {
            return "/images/sunny.png";
        }
    }

}
