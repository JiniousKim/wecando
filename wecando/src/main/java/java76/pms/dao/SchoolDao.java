package java76.pms.dao;

import java.util.List;
import java.util.Map;

import java76.pms.domain.School;

public interface SchoolDao {
  List<School> selectList(Map<String,Object> paramMap);
  
  int sch_insert(Map<String,Object> schoolMap);
  
  int sch_delete(Map<String,Object> paramMap);
  
  int sch_update(Map<String,Object> schoolMap);
  
  School sch_Manager(int m_no);
  
  int get_sch(String sch_location);
  
  int get_sch_num(String sch_name);
  
  int sch_manage_update(Map<String, Object> schoolMap);
  
  List<String> AllschoolList();
}







