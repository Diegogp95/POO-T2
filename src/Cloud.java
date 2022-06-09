import java.util.ArrayList;

public class Cloud {
    public Cloud() {
        lamps = new ArrayList<Lamp>();
        rollerShades = new ArrayList<RollerShade>();
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
    public void changeLampPowerState(int channel){
        Lamp l=getLampAtChannel(channel);
        if (l != null) l.changePowerState();
    }

    public void addRollerShade(RollerShade rs){
        rollerShades.add(rs);
    }
    public void startShadeUp(int channel){
        for (RollerShade rs: rollerShades){
            if (rs.getChannel() == channel){
                rs.startUp();
            }
        }
    }
    public void startShadeDown(int channel){
        for (RollerShade rs: rollerShades){
            if (rs.getChannel() == channel){
                rs.startDown();
            }
        }
    }
    public void stopShade(int channel){
        for (RollerShade rs: rollerShades){
            if (rs.getChannel() == channel){
                rs.stop();
            }
        }
    }


    private ArrayList<Lamp> lamps;
    private ArrayList<RollerShade> rollerShades;
}
