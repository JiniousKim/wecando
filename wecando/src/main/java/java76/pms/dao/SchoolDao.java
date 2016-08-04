package java76.pms.dao;

import java.util.List;
import java.util.Map;

import java76.pms.domain.School;

public interface SchoolDao {
  List<School> selectList(Map<String,Object> paramMap);
  
  int sch_insert(Map<String,Object> schoolMap);
  
  int sch_delete(Map<String,Object> paramMap);
  
  int sch_create(School school);   //이메일 인증하고 아이디 생성 시 사용할 쿼리
  
  int sch_update(School school);
  
  School sch_Manager(int m_no);
}







