import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class LampView extends Group {
    public LampView () {
        Polygon base = new Polygon();
        base.getPoints().addAll(new Double[]{
                18d, 20d,
                18d, 50d,
                13d, 50d,
                10d, 53d,
                10d, 60d,
                30d, 60d,
                30d, 53d,
                27d, 50d,
                22d, 50d,
                22d, 20d});
        base.setFill(Color.STEELBLUE);
        Polygon top = new Polygon();
        top.getPoints().addAll(new Double[]{
                2d, 20d,
                38d, 20d,
                30d, 0d,
                10d, 0d});
        top.setFill(Color.LIMEGREEN);
        lampshade = top;
        getChildren().addAll(base, lampshade);
    }
    public void setColor(short r, short g, short b){
        Color color = Color.rgb(r, g, b);
        lampshade.setFill(color);
    }



    private Polygon lampshade;
}
