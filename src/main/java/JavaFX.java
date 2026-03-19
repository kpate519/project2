import javafx.application.Application;

import javafx.scene.Scene;

import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import weather.DailyWeatherPage;
import weather.Period;
import weather.WeatherAPI;
import weather.WelcomePage;

import java.util.ArrayList;

public class JavaFX extends Application {
	TextField temperature,weather;

	public static void main(String[] args) {
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Weather App"); //we can change the title later if we want to

		WelcomePage welcomePage = new WelcomePage();
		Scene scene = welcomePage.createScene(primaryStage);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
