package java76.pms.service.support;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java76.pms.dao.SchoolDao;
import java76.pms.domain.School;
import java76.pms.service.SchoolService;

@Service
public class DefaultSchoolService implements SchoolService {
  @Autowired SchoolDao schoolDao;

  public List<School> getSchoolList(int pageNo, int pageSize, 
      String keyword, String align) {
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
    paramMap.put("keyword", keyword);
    paramMap.put("align", align);

    return schoolDao.selectList(paramMap);
  }

  public int sch_register(HashMap<String,Object> schoolMap) {
    return schoolDao.sch_insert(schoolMap);
  }

  public int sch_change(HashMap<String,Object> schoolMap) {
    return schoolDao.sch_update(schoolMap);
  }

  public int get_sch(String sch_location) {
  		return schoolDao.get_sch(sch_location);
  }
  
  public School sch_Manager(int m_no) {
  		return schoolDao.sch_Manager(m_no);
  }
  
  public int sch_manage_update(HashMap<String,Object> schoolMap) {
  	  return schoolDao.sch_manage_update(schoolMap);
  }
}







