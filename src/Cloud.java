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

    /* Métodos para cambio de color de lámparas */
    public void changeRED(int channel, short R){
        for (Lamp lamp: lamps){
            if (lamp.getChannel() == channel){
                lamp.setR(R);
            }
        }
    }
    public void changeBLUE(int channel, short B){
        for (Lamp lamp: lamps){
            if (lamp.getChannel() == channel){
                lamp.setB(B);
            }
        }
    }
    public void changeGREEN(int channel, short G){
        for (Lamp lamp: lamps){
            if (lamp.getChannel() == channel){
                lamp.setG(G);
            }
        }
    }


    public void addRollerShade(RollerShade rs){
        rollerShades.add(rs);
    }

    /* Métodos para acción de cortina */
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
