import javafx.scene.Node;

public class Lamp extends DomoticDevice{
    public Lamp(int channel){
        super(channel);
        r=g= 255;
        b = 50;
        state = LampState.OFF;
        view = new LampView();
        view.setColor((short)0,(short)0, (short)0);
    }
    public int getChannel(){
        return channel;
    }
    public void changePowerState(){
        state = state==LampState.ON ? LampState.OFF : LampState.ON;
        if (state==LampState.OFF) view.setColor((short)0,(short)0, (short)0);
        else view.setColor(r,g,b);
    }
    public Node getView() {
        return view;
    }
    public enum LampState {
        ON,
        OFF
    }

    private int channel;
    private short r,g,b;
    private LampState state;
    private LampView view;
}
