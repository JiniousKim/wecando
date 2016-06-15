package java76.pms.util;

import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import java76.pms.controller.ajax.MemberController;

@SuppressWarnings("serial")
public class DatabaseCheck extends HttpServlet {

  public void init() throws ServletException
  {
    System.out.println("DBCheck");
    ScheduledJob job = new ScheduledJob();

//    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//    
//    scheduler.scheduleAtFixedRate(new MemberController(), 0, 1, TimeUnit.DAYS);

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
    System.out.println("run");
  }
}