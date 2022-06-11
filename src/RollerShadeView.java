import javafx.scene.Group;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class RollerShadeView extends Group {
    public RollerShadeView(double maxLength, double width, double radius, Color color, String videoSrc) {
        /* Rectángulo invisible que evita el cambio de tamaño */
        Rectangle invisible = new Rectangle(0d, 0d, width, maxLength+3);
        invisible.setFill(new Color(0d, 0d, 0d, 0d));
        getChildren().add(invisible);

        /* Crea ventana (carga video) y configura */
        Media media = new Media(getClass().getResource(videoSrc).toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.setFitHeight(mediaView.getFitWidth());
        mediaView.setFitWidth(width-10);
        mediaView.setX(5);
        mediaView.setY(5);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
        mediaPlayer.setVolume(0);
        getChildren().add(mediaView);

        /* Crea rollo de cortina */
        Rectangle roll = new Rectangle(0d, 0d, width, radius*2);
        roll.setFill(color);
        roll.setArcHeight(radius*2);
        roll.setArcWidth(radius);
        getChildren().add(roll);

        /* Crea cortina a ser extendida */
        cloth = new Rectangle (0d, 0d, width, 0d);
        cloth.setFill(color);
        cloth.setStrokeWidth(0.5d);
        cloth.setStroke(Color.BLACK);
        getChildren().add(cloth);

        /* Elipse que emula esquina de rollo de cortina */
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
