import java.util.ArrayList;

public class Cloud {
    public Cloud() {
        lamps = new ArrayList<Lamp>();
    }
    public void addLamp(Lamp l){
        lamps.add(l);
    }
    public Lamp getLampAtChannel( int channel){
        for (Lamp l: lamps)
            if (l.getChannel() ==channel)
                return l;
        return null;
    }
    public void addRollerShade(RollerShade rs){
        rollerShades.add(rs);
    }
    public void changeLampPowerState(int channel){
        Lamp l=getLampAtChannel(channel);
        if (l != null) l.changePowerState();
    }
    private ArrayList<Lamp> lamps;
    private ArrayList<RollerShade> rollerShades;
}
