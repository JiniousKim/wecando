package java76.pms.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DatabaseCheck implements ServletContextListener {
  private  ExecutorService executor;

  public void contextInitialized(ServletContextEvent arg0) {
      ServletContext context = arg0.getServletContext();
      int nr_executors = 1;
      ThreadFactory daemonFactory = new DaemonThreadFactory();
      try {
          nr_executors = Integer.parseInt(context.getInitParameter("nr-executors"));
      } catch (NumberFormatException ignore ) {}

      if(nr_executors <= 1) {
      executor = Executors.newSingleThreadExecutor(daemonFactory);
      } else {
      executor = Executors.newFixedThreadPool(nr_executors,daemonFactory);
     }
        context.setAttribute("MY_EXECUTOR", executor);
    }

  public void contextDestroyed(ServletContextEvent arg0) {
      ServletContext context = arg0.getServletContext();
      executor.shutdownNow(); // or process/wait until all pending jobs are done
  }

}

/*
public class DatabaseCheck{

  public void DatabaseCheck1()
  {
    System.out.println("DBCheck");
    ScheduledJob job = new ScheduledJob();

    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    
    scheduler.scheduleAtFixedRate(new MemberController(), 0, 1, TimeUnit.DAYS);

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
 */