package digital_clock;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class ClockPanel extends JPanel implements Runnable{
    public ClockPanel(){
        Thread thread = new Thread(this);
        thread.start();

    }

    String getTimeString(){
        Calendar calendar = Calendar.getInstance();
        String time = "";
        int hour = calendar.get(Calendar.HOUR);
        time+=hour+":";
        int minute = calendar.get(Calendar.MINUTE);
        if(minute<10)time+="0";
        time+=minute+":";
        int second = calendar.get(Calendar.SECOND);
        if(second<10)time+="0";
        time+=second;
        int am_pm=calendar.get(calendar.AM_PM);
        time+=sAmPm[am_pm];
        return time;
    }
    String getDateSring(){
        Calendar calendar = Calendar.getInstance();
        String date = "";
        int week=calendar.get(calendar.DAY_OF_WEEK);
        date+=" "+days[week-1];
        int day_of_month=calendar.get(calendar.DAY_OF_MONTH);
        date+=" "+day_of_month;
        int month = calendar.get(calendar.MONTH);
        date+=" "+months[month];
        int year=calendar.get(calendar.YEAR);
        date+=", "+year;
        return date;
    }
    String sAmPm[] ={"AM","PM"};
    String days[]={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    String months[]={"Jan","Feb","Mar","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};

    public void paint(Graphics g){
        int w=getWidth(), h=getHeight();
        int timeSize=(w+h)*6/100;
        Font font =new Font("Arial", Font.ITALIC+Font.BOLD,timeSize);
        Font fontdate =new Font("Arial", Font.ITALIC+Font.BOLD,timeSize*47/100);
        g.clearRect(0,0,w,h);


        String time = getTimeString();
        String date = getDateSring();

        FontMetrics fmtime = g.getFontMetrics(font);
        FontMetrics fmDate=g.getFontMetrics(fontdate);
        int timeWidth = fmtime.stringWidth(time);
        int x1 = (w-timeWidth)/2;
        int y1=h/2-fmtime.getHeight()+5;
        int w1=timeWidth;
        int h1=fmtime.getHeight();
        g.setColor(Color.BLACK);
        g.fillRect(x1, y1, w1, h1);

        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString(time,(w-timeWidth)/2,h/2);

        g.setFont(fontdate);
        g.setColor(Color.BLACK);
        g.drawString(date, (w - timeWidth) / 2, (h / 2+fmDate.getHeight()*3/2) );
//        g.drawString(time,20,h/2);
        //// do your things
    }
    @Override
    public void run() {
        while (true){
            repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}



