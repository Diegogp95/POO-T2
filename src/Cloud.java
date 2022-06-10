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
    public void changeRED(int channel, double R){
        for (Lamp lamp: lamps){
            if (lamp.getChannel() == channel){
                short r = (short)R;
                lamp.setR(r);
            }
        }
    }

    public void changeBLUE(int channel, double B){
        for (Lamp lamp: lamps){
            if (lamp.getChannel() == channel){
                short b = (short)B;
                lamp.setB(b);
            }
        }
    }

    public void changeGREEN(int channel, double G){
        for (Lamp lamp: lamps){
            if (lamp.getChannel() == channel){
                short g = (short)G;
                lamp.setG(g);
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

    public short showG(int channel){    //BORRAR
        return lamps.get(0).getG();
    }

    private ArrayList<Lamp> lamps;
    private ArrayList<RollerShade> rollerShades;
}
