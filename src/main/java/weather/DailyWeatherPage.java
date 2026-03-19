package weather;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class DailyWeatherPage {
    public Scene createScene(Stage stage) {
        VBox vbox = new VBox();
        vbox.setStyle("-fx-background-color: #E8E2DB");
        vbox.setSpacing(20);

        Font cityFont = Font.loadFont(getClass().getResourceAsStream("/fonts/Poppins-SemiBold.ttf"),25);

        Label cityName = new Label("Chicago, Illinois");
        cityName.setFont(cityFont);
        cityName.setStyle("-fx-text-fill: black");

        ArrayList<Period> forecast = WeatherAPI.getForecast("LOT", 77, 70);
        int current = forecast.get(0).temperature;

        String tempText = current + "°";
        Label temperature = new Label(tempText);

        Font tempFont = Font.loadFont(getClass().getResourceAsStream("/fonts/Poppins-SemiBold.ttf"),22);

        temperature.setFont(tempFont);
        temperature.setStyle("-fx-text-fill: black");

        vbox.getChildren().addAll(cityName,temperature);
        vbox.setAlignment(Pos.TOP_CENTER);

        return new Scene(vbox, 320, 640);
    }


}
