package java76.pms.service;

import java.util.List;
import java.util.Map;

import java76.pms.domain.School;

public interface SchoolService {
  List<School> getSchoolList(
      int pageNo, int pageSize, 
      String keyword, String align);
  int sch_register(Map<String,Object> schoolMap);
  int sch_change(Map<String,Object> schoolMap);
  int get_sch(String sch_location);
  School sch_Manager(int m_no);
  int sch_manage_update(Map<String, Object> schoolMap);
}







