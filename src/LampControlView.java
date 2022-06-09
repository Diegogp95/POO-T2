import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class LampControlView extends VBox {
    public LampControlView(LampControl lampControl) {
        Image img = new Image("rsc/powerIcon.png");
        ImageView view = new ImageView(img);
        view.setFitHeight(0d);
        view.setScaleX(0.5d);
        view.setScaleY(0.5d);
        this.setBackground(new Background(new BackgroundFill(Color.NAVY, new CornerRadii(10), new Insets(0)),
                new BackgroundFill(Color.LIGHTCORAL, new CornerRadii(8), new Insets(1))));
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(5));
        this.getChildren().addAll(view);
    }

}
