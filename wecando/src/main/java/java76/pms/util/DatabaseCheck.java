package java76.pms.util;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import java76.pms.controller.ajax.MemberController;

public class DatabaseCheck{

  @PostConstruct
  public void DatabaseCheck1()
  {
    System.out.println("DBCheck");
    ScheduledJob job = new ScheduledJob();

    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    
    scheduler.scheduleAtFixedRate(new MemberController(), 0, 1, TimeUnit.DAYS);

    /*
        Timer jobScheduler = new Timer();
        jobScheduler.scheduleAtFixedRate(job, 1000, 3000);
        try {
          Thread.sleep(2000000000);
        } catch(InterruptedException ex) {

        }
        jobScheduler.cancel();
        
        */
  }
}

class ScheduledJob extends TimerTask {

  public void run() {
    System.out.println("run");
  }
}