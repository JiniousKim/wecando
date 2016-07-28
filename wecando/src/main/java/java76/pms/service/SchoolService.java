package java76.pms.service;

import java.util.List;
import java.util.Map;

import java76.pms.domain.School;

public interface SchoolService {
  List<School> getSchoolList(
      int pageNo, int pageSize, 
      String keyword, String align);
  int sch_register(Map<String,Object> schoolMap);
  int sch_change(School school);
  int sch_create(School school);
}







