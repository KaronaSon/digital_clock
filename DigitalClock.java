package digital_clock;

import javax.swing.*;

public class DigitalClock extends JFrame {
    public DigitalClock(){
        add(new ClockPanel());
        setSize(400,250);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setVisible(true);
    }
    public static void main(String [] args){
        new DigitalClock();
    }
}
