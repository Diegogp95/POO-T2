import javafx.scene.layout.Pane;

public class LampControl extends DomoticDeviceControl{
    public LampControl(int channel, Cloud cloud){
        super(channel, cloud);
        view = new LampControlView(this);
    }
    public Pane getView() { return view;}
    public void pressPower(){
        cloud.changeLampPowerState(channel);
    }
    public void changeR(double R){
        cloud.changeRED(channel,R);
    }

    public void changeG(double G){
        cloud.changeGREEN(channel,G);
    }

    public void changeB(double B){
        cloud.changeBLUE(channel, B);
    }





    private int channel;
    private Pane view;
}
