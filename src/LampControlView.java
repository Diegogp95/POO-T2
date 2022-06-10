import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class LampControlView extends VBox {
    public LampControlView(LampControl lampControl) {

        /*  Configuracion del panel */
        setBackground(new Background(new BackgroundFill(Color.NAVY, new CornerRadii(10), new Insets(0)),
                new BackgroundFill(Color.LIGHTCORAL, new CornerRadii(8), new Insets(1))));
        setAlignment(Pos.CENTER);
        setPadding(new Insets(5));

        /*  Boton de encendido/apagado  */
        Image img = new Image("rsc/powerIcon.png");
        ImageView view = new ImageView(img);
        view.setFitHeight(0d);
        view.setScaleX(0.5d);
        view.setScaleY(0.5d);
        view.setOnMousePressed(e-> lampControl.pressPower());

        /*  Spinner de seleccion de canal   */
        SpinnerValueFactory.IntegerSpinnerValueFactory spinnerValueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, lampControl.getChannel());
        Spinner<Integer> spinner = new Spinner<Integer>(spinnerValueFactory);
        spinner.editorProperty().get().setAlignment(Pos.CENTER);
        spinner.valueProperty().addListener((obs, oldValue, newValue) ->
                lampControl.setChannel(spinner.getValue()));
        spinner.setMaxWidth(90);

        /*  Sliders de seleccion de color RGB   */
        /*  Slider R  */
        Slider sliderR = new Slider(0, 255, 255);
        sliderR.setMajorTickUnit(0.25f);
        sliderR.setBlockIncrement(0.1f);
        sliderR.setMaxWidth(100);
        Label redCaption = new Label("R:");
        Label redValue = new Label("255");
        sliderR.valueProperty().addListener(
                (observable, oldValue, newValue) -> {
                    redValue.setText(""+newValue.intValue());
                    lampControl.changeR(newValue.shortValue());
                });
        HBox controlR = new HBox();
        controlR.getChildren().addAll(redCaption, sliderR, redValue);

        /*  Slider G  */
        Slider sliderG = new Slider(0, 255, 255);
        sliderG.setMajorTickUnit(0.25f);
        sliderG.setBlockIncrement(0.1f);
        sliderG.setMaxWidth(100);
        Label greenCaption = new Label("G:");
        Label greenValue = new Label("255");
        sliderG.valueProperty().addListener(
                (observable, oldValue, newValue) -> {
                    greenValue.setText(""+newValue.intValue());
                    lampControl.changeG(newValue.shortValue());
                });
        HBox controlG = new HBox();
        controlG.getChildren().addAll(greenCaption, sliderG, greenValue);

        /*  Slider B  */
        Slider sliderB = new Slider(0, 255, 50);
        sliderB.setMajorTickUnit(0.25f);
        sliderB.setBlockIncrement(0.1f);
        sliderB.setMaxWidth(100);
        Label blueCaption = new Label("B:");
        Label blueValue = new Label("50");
        sliderB.valueProperty().addListener(
                (observable, oldValue, newValue) -> {
                    blueValue.setText(""+newValue.intValue());
                    lampControl.changeB(newValue.shortValue());
                });
        HBox controlB = new HBox();
        controlB.getChildren().addAll(blueCaption, sliderB, blueValue);

        getChildren().addAll(view,spinner,controlR,controlG,controlB);
    }
}
