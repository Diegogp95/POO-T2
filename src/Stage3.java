import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Stage3 extends Application {
    public void start(Stage primaryStage) {
        int lampChannel1=2;
        int lampChannel2=3;

        Image wall = new Image("rsc/Background.jpg");
        BackgroundImage bgImage = new BackgroundImage(wall, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(1, 1, true, true, false, true));
        Background background = new Background(bgImage);

        Cloud cloud = new Cloud();
        Lamp lamp1 = new Lamp(lampChannel1);
        Lamp lamp2 = new Lamp(lampChannel2);
        cloud.addLamp(lamp1);
        cloud.addLamp(lamp2);
        LampControl lampControl = new LampControl(lampChannel1, cloud);

        HBox hBox = new HBox(20);
        hBox.setSpacing(100);
        hBox.setPadding(new Insets(20));
        hBox.setAlignment(Pos.CENTER);

        HBox lampBox = new HBox(20);
        lampBox.setSpacing(40);
        lampBox.setPadding(new Insets(20));
        lampBox.setAlignment(Pos.CENTER);
        lampBox.getChildren().addAll(lamp1.getView(), lamp2.getView());

        lampControl.getView().setPrefSize(140,130);
        lampControl.getView().setMaxHeight(130);
        lampControl.getView().setMaxWidth(140);
        hBox.getChildren().addAll(lampBox,lampControl.getView());
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(20));
        pane.setBottom(hBox);
        pane.setMargin(hBox,new Insets(20));
        pane.setBackground(background);

        int shadeChannel1=1;
        int shadeChannel2=2;
        RollerShade rs = new RollerShade(shadeChannel1, 10, 355, 210, "rsc/video1.mp4", Color.ORANGE );
        RollerShade rs1 = new RollerShade(shadeChannel2, 10, 200, 210, "rsc/video2.mp4",Color.CHOCOLATE);
        cloud.addRollerShade(rs);
        cloud.addRollerShade(rs1);
        HBox videoBox = new HBox();
        videoBox.setSpacing(100);
        videoBox.setPadding(new Insets(30));
        videoBox.getChildren().addAll(rs.getView(),rs1.getView());
        pane.setCenter(videoBox);
        videoBox.setAlignment(Pos.CENTER);

        ShadeControl shadeControl = new ShadeControl(shadeChannel1,cloud);
        BorderPane rsControlView = shadeControl.getView();
        rsControlView.setPrefSize(80,80);
        rsControlView.setMaxHeight(80);
        rsControlView.setMaxWidth(80);

        hBox.getChildren().add(0,rsControlView);
        Scene scene = new Scene(pane, 800, 500);
        primaryStage.setTitle("Domotic Devices Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
