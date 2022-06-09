import javafx.scene.layout.Pane;

public class LampControl extends DomoticDeviceControl{
    public LampControl(int channel, Cloud cloud){
        super(channel, cloud);
        view = new LampControlView(this);
    }
    public Pane getView() { return view;}
    private int channel;
    private Cloud cloud;
    private Pane view;
}
