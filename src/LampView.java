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

        light = new Polygon();
        light.getPoints().addAll(new Double[]{
                2d, 20d,
                38d, 20d,
                30d, 0d,
                10d, 0d});

        /* Cortina de lámpara */
        Polygon lampShade = new Polygon();
        lampShade.getPoints().addAll(light.getPoints());
        Color shadeFill = Color.LIMEGREEN;
        lampShade.setFill(new Color(shadeFill.getRed(),shadeFill.getGreen(), shadeFill.getBlue(), 0.55));

        getChildren().addAll(base, light, lampShade);
    }
    public void setColor(short r, short g, short b){
        Color color = Color.rgb(r, g, b);
        light.setFill(color);
    }
    private Polygon light;
}
