package weather;

import java.time.LocalTime;
import javafx.scene.control.Label;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class WelcomePage {
    public Scene createScene(Stage stage) {
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: #E8E2DB");

        String greeting =  getGreeting();
        Label greetingLabel = new Label("");
        Font font = Font.loadFont(getClass().getResourceAsStream("/fonts/Poppins-SemiBold.ttf"),30);
        greetingLabel.setFont(font);
        greetingLabel.setStyle("-fx-text-fill: black");
        typingAnimation(greetingLabel, greeting);

        root.getChildren().add(greetingLabel);
        root.setAlignment(Pos.CENTER);

        return new Scene(root, 320, 640);

    }

    private String getGreeting() {
        int hour = LocalTime.now().getHour();

        if (hour >= 5 && hour < 12) {
            return "Good Morning";
        } else if (hour >= 12 && hour < 17) {
            return "Good Afternoon";
        } else if (hour >= 17 && hour < 21) {
            return "Good Evening";
        } else {
            return "Good Night";
        }
    }

    private void typingAnimation(Label label, String text) {
        Timeline timeline = new Timeline();

        for (int i = 0; i <= text.length(); i++) {
            int idx = i ;

            KeyFrame keyFrame = new KeyFrame(Duration.millis(120*i), e -> {
                label.setText(text.substring(0, idx));
            });

            timeline.getKeyFrames().add(keyFrame);
        }
        timeline.play();
    }

}
