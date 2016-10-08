package java76.pms.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTable {
  public TimeTable() {}
  
  public String getTime() {
  	  Long time = System.currentTimeMillis();
  	  SimpleDateFormat dayTime = new SimpleDateFormat("yyyy/MM/dd"); 
  	  String day = dayTime.format(new Date(time));
  	  System.out.println(day);
  	  return day;
  }
}
