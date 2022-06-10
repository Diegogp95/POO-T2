import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class LampControlView extends VBox {
    public LampControlView(LampControl lampControl) {
        Image img = new Image("rsc/powerIcon.png");
        ImageView view = new ImageView(img);
        view.setFitHeight(0d);
        view.setScaleX(0.5d);
        view.setScaleY(0.5d);
        view.setOnMousePressed(e-> lampControl.pressPower());


        Slider sliderR = new Slider(0, 255, 0);
        sliderR.setMajorTickUnit(0.25f);
        sliderR.setBlockIncrement(0.1f);
        Label redCaption = new Label("R:");
        Label redValue = new Label("");


        sliderR.valueProperty().addListener(
                (observable, oldValue, newValue) -> {
                    redValue.setText(DecimalFormat.getNumberInstance().format(newValue));
                    lampControl.changeR((double)newValue);
                });

        HBox controlR = new HBox();
        controlR.getChildren().addAll(redCaption, sliderR, redValue);




        Slider sliderG = new Slider(0, 255, 0);
        sliderG.setMajorTickUnit(0.25f);
        sliderG.setBlockIncrement(0.1f);
        Label greenCaption = new Label("G:");
        Label greenValue = new Label("");


        sliderG.valueProperty().addListener(
                (observable, oldValue, newValue) -> {
                    greenValue.setText(DecimalFormat.getNumberInstance().format(newValue));
                    lampControl.changeG((double)newValue);
                });

        HBox controlG = new HBox();
        controlG.getChildren().addAll(greenCaption, sliderG, greenValue);




        Slider sliderB = new Slider(0, 255, 0);
        sliderB.setMajorTickUnit(0.25f);
        sliderB.setBlockIncrement(0.1f);
        Label blueCaption = new Label("B:");
        Label blueValue = new Label("");


        sliderB.valueProperty().addListener(
                (observable, oldValue, newValue) -> {
                    blueValue.setText(DecimalFormat.getNumberInstance().format(newValue));
                    lampControl.changeB((double)newValue);
                });

        HBox controlB = new HBox();
        controlB.getChildren().addAll(blueCaption, sliderB, blueValue);






        setBackground(new Background(new BackgroundFill(Color.NAVY, new CornerRadii(10), new Insets(0)),
                new BackgroundFill(Color.LIGHTCORAL, new CornerRadii(8), new Insets(1))));
        setAlignment(Pos.CENTER);
        setPadding(new Insets(5));
        getChildren().addAll(view,controlR,controlG,controlB);

    }
}
