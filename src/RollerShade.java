import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class RollerShade extends DomoticDevice {
    public RollerShade (int channel, double alpha, double width, double len, String videoSrc, Color color) {
        super(channel);
        motor = new Motor(alpha);
        MaxShadeLength = len;
        this.length = 0;  // Start with roller shade open.
        view = new RollerShadeView(MaxShadeLength, width, RADIUS, color, videoSrc);
    }
    public Group getView() { return view;}
    public void startUp(){
        motor.turnUp();
    }
    public void startDown(){
        motor.turnDown();
    }
    public void stop(){
        motor.stop();
    }
    private class Motor implements EventHandler<ActionEvent> {  //nested class, Motor is only used within RollerShade.
        public Motor (double a){
            alpha = a;
            state = MotorState.STOPPED;
            animation= new Timeline(new KeyFrame(Duration.millis(DELTA*1000), this));
            animation.setCycleCount(Timeline.INDEFINITE);
        }
        public void turnUp(){
            state = MotorState.UPWARD;
            animation.play();
        }
        public void turnDown(){
            state = MotorState.DOWNWARD;
            animation.play();
        }
        public void stop(){
            state = MotorState.STOPPED;
            animation.stop();
        }
        public void handle (ActionEvent event){
            double increment = alpha*DELTA*RADIUS;
            switch (state) {
                case STOPPED:

                    break;
                case DOWNWARD:
                    length += increment;
                    LimitSwitchSensor();
                    break;
                case UPWARD:
                    length -= increment;
                    LimitSwitchSensor();
                    break;
            }
            view.setLength(length);
        }
        private double alpha;
        private MotorState state;
        private Timeline animation;
        private static final double DELTA=0.1;
    }
    public enum MotorState {
        UPWARD,
        STOPPED,
        DOWNWARD
    }
    public void LimitSwitchSensor(){        // Sensor de fin de carrera, detiene el motor si se llega al sensor,
        // se llama en cada avance de tiempo con motor UP o DOWN
        if( length < 0){
            length = 0;
            this.stop();
            return;
        }
        else {
            if (length > MaxShadeLength){
                length = MaxShadeLength;
                this.stop();
            }
            return;
        }
    }

    private RollerShadeView view;
    private Motor motor;
    private double length;
    private final double MaxShadeLength;
    private static double RADIUS=4;  //cm
}
