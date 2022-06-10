import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class ShadeControlView extends BorderPane {
    public ShadeControlView (ShadeControl sc){
        ShadeControl shadeControl = sc;
        Button channelButton = new Button(""+sc.getChannel());
        setPadding(new Insets(2));
        Polygon upButton = new Polygon();
        Polygon downButton = new Polygon();
        Polygon leftButton = new Polygon();
        Polygon rightButton = new Polygon();
        upButton.getPoints().addAll(new Double[]{
                10d, 0d,
                20d, 10d,
                0d, 10d});
        downButton.getPoints().addAll(new Double[]{
                0d, 0d,
                20d, 0d,
                10d, 10d});
        leftButton.getPoints().addAll(new Double[]{
                10d, 0d,
                10d, 20d,
                0d, 10d});
        rightButton.getPoints().addAll(new Double[]{
                0d, 0d,
                10d, 10d,
                0d, 20d});
        upButton.setFill(Color.SALMON);
        downButton.setFill(Color.SALMON);
        leftButton.setFill(Color.SALMON);
        rightButton.setFill(Color.SALMON);
        setTop(upButton);
        setBottom(downButton);
        setLeft(leftButton);
        setRight(rightButton);
        setCenter(channelButton);
        setAlignment(upButton, Pos.CENTER);
        setAlignment(downButton, Pos.CENTER);
        setAlignment(leftButton, Pos.CENTER);
        setAlignment(rightButton, Pos.CENTER);
        setBackground(new Background(new BackgroundFill(Color.NAVY, new CornerRadii(10), new Insets(0)),
                new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(8), new Insets(1))));



        channelButton.setOnAction( e-> {sc.stop();});
        upButton.setOnMouseClicked( e-> {sc.startUp();} );
        downButton.setOnMouseClicked( e -> {sc.startDown();});
        leftButton.setOnMouseClicked( e -> {
            int ch = shadeControl.getChannel();
            if (ch > 1){ch -= 1;}
            shadeControl.setChannel(ch);
            channelButton.setText(""+ch);
        });
        rightButton.setOnMouseClicked( e -> {
            int ch = shadeControl.getChannel();
            if (ch < 10){ch += 1;}
            shadeControl.setChannel(ch);
            channelButton.setText(""+ch);
        });
    }
}
