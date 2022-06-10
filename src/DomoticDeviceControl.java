public class DomoticDeviceControl {
    public DomoticDeviceControl(int ch, Cloud c){
        channel = ch;
        cloud = c;
    }
    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) { this.channel = channel; }

    protected Cloud cloud;
    private int channel;
}
