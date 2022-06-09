import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class RollerShadeView extends Group {
    public RollerShadeView(double maxLength, double width, double length, double radius, Color color) {
        Rectangle background = new Rectangle(5,5, width-10,maxLength-5);
        background.setFill(Color.BLUE);  // I chose Blue
        getChildren().add(background);

        Rectangle roll = new Rectangle(0d, 0d, width, radius*2);
        roll.setFill(color);
        roll.setArcHeight(radius*2);
        roll.setArcWidth(radius);
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
