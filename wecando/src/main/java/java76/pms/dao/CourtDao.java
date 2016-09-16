package java76.pms.dao;

import java.util.HashMap;
import java.util.List;

import java76.pms.domain.Court;

public interface CourtDao {
  int insertCourt(HashMap<String, Object> paramMap);
  List<Court> courtList(int sch_no);
  int removeAllCourt(String code);
}







