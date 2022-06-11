import javafx.scene.Group;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class RollerShadeView extends Group {
    public RollerShadeView(double maxLength, double width, double length, double radius, Color color, String videoSrc) {

        Media media = new Media(getClass().getResource(videoSrc).toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.setFitHeight(mediaView.getFitWidth());
        mediaView.setFitWidth(width-5);
        mediaView.setX(5);
        mediaView.setY(5);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
        mediaPlayer.setVolume(0);


        Rectangle roll = new Rectangle(0d, 0d, width, radius*2);
        roll.setFill(color);
        roll.setArcHeight(radius*2);
        roll.setArcWidth(radius);

        getChildren().add(mediaView);
        getChildren().add(roll);


        cloth = new Rectangle (0d, 0d, width, 0d);
        cloth.setFill(color);
        cloth.setStrokeWidth(0.5d);
        cloth.setStroke(Color.BLACK);
        getChildren().add(cloth);

        // Rolled up shade cloth
        Ellipse rightSide = new Ellipse(width, radius,radius/2,radius);
        rightSide.setFill(color);
        rightSide.setStrokeWidth(0.5d);
        rightSide.setStroke(Color.BLACK);
        getChildren().add(rightSide);
    }
    public void setLength(double length) {
        cloth.setHeight(length);
    }
    private Rectangle cloth;
}
