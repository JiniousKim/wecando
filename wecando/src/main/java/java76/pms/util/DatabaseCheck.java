package java76.pms.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import java76.pms.controller.ajax.MemberController;

public class DatabaseCheck{

  public void DatabaseCheck1()
  {
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    
    scheduler.scheduleAtFixedRate(new MemberController(), 0, 1, TimeUnit.DAYS);
  }
}
