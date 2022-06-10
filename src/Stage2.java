import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Stage2 extends Application {
    public void start(Stage primaryStage) {
        int lampChannel1=2;
        int lampChannel2=3;

        Cloud cloud = new Cloud();
        Lamp lamp1 = new Lamp(lampChannel1);
        Lamp lamp2 = new Lamp(lampChannel2);
        cloud.addLamp(lamp1);
        cloud.addLamp(lamp2);
        LampControl lampControl = new LampControl(lampChannel1, cloud);

        HBox hBox = new HBox(20);
        hBox.setPadding(new Insets(20));
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(lamp1.getView(),lamp2.getView(), lampControl.getView());
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(20));
        pane.setBottom(hBox);

        int shadeChannel=2;
        RollerShade rs = new RollerShade(shadeChannel, 10, 150, 100);
        cloud.addRollerShade(rs);
        pane.setCenter(rs.getView());
        ShadeControl shadeControl = new ShadeControl(shadeChannel,cloud);
        BorderPane rsControlView = shadeControl.getView();
        rsControlView.setPrefSize(60,60);
        rsControlView.setMaxHeight(60);
        rsControlView.setMaxWidth(60);
        hBox.getChildren().add(0,rsControlView);
        Scene scene = new Scene(pane, 600, 500);
        primaryStage.setTitle("Domotic Devices Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
