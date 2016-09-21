package java76.pms.service;

import java.util.HashMap;
import java.util.List;

import java76.pms.domain.School;

public interface SchoolService {
  List<School> getSchoolList(
      int pageNo, int pageSize, 
      String keyword, String align);
  int sch_register(HashMap<String,Object> schoolMap);
  int sch_change(HashMap<String,Object> schoolMap);
  int get_sch(String sch_location);
  School sch_Manager(int m_no);
  int sch_manage_update(HashMap<String, Object> schoolMap);
}







