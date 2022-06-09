import java.util.ArrayList;

public class Cloud {
    public Cloud() {
        lamps = new ArrayList<Lamp>();
        rollerShades = new ArrayList<RollerShade>();
    }
    public void addLamp(Lamp l){
        lamps.add(l);
    }

    public void changeLampPowerState(int channel){
        for (Lamp lamp: lamps){
            if (lamp.getChannel() == channel){
                lamp.changePowerState();
            }
        }
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
