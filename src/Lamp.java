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

    public void setR(short R){
        if (state == LampState.ON){
            this.r = R ;
            view.setColor(r,g,b);
        }
    }

    public void setG(short G){
        if (state == LampState.ON){
            this.g = G ;
            view.setColor(r,g,b);
        }
    }


    public void setB(short B){
        if (state == LampState.ON){
            this.b = B ;
            view.setColor(r,g,b);
        }
    }

    private int channel;
    private short r,g,b;
    private LampState state;
    private LampView view;
}
