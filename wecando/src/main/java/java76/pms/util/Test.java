package java76.pms.util;

import java.util.Timer;
import java.util.TimerTask;

public class Test {
  public static void main(String[] args) {
    ScheduledJob job = new ScheduledJob();
    Timer jobScheduler = new Timer();
    jobScheduler.scheduleAtFixedRate(job, 1000, 3000);
    try {
      Thread.sleep(2000000000);
    } catch(InterruptedException ex) {

    }
    jobScheduler.cancel();
  }
}

class ScheduledJob extends TimerTask {
  public void run() {
    
  }
}