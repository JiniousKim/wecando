package java76.pms.util;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;

import java76.pms.service.MemberService;

@SuppressWarnings("serial")
public class DatabaseCheck extends HttpServlet {

  public void init() throws ServletException
  {
    System.out.println("DBCheck");
    ScheduledJob job = new ScheduledJob();

    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    scheduler.scheduleAtFixedRate(job, 0, 1, TimeUnit.DAYS);

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
  @Autowired MemberService memberService;

  public void run() {
    System.out.println("run");
    memberService.removeExpirationMember();
  }
}