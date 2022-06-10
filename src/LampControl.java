import javafx.scene.layout.Pane;

public class LampControl extends DomoticDeviceControl{
    public LampControl(int channel, Cloud cloud){
        super(channel, cloud);
        view = new LampControlView(this);
    }
    public Pane getView() { return view;}
    public void pressPower(){
        cloud.changeLampPowerState(getChannel());
    }
    public void changeR(double R){
        cloud.changeRED(getChannel(), R);
    }

    public void changeG(double G){
        cloud.changeGREEN(getChannel(),G);
    }

    public void changeB(double B){
        cloud.changeBLUE(getChannel(), B);
    }


    private Pane view;
}
