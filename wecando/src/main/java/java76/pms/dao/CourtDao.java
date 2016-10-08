package java76.pms.dao;

import java.util.List;

import java76.pms.domain.Court;

public interface CourtDao {
  int insertCourt(Court court);
  List<Court> courtList(int sch_no);
  int removeAllCourt(String code);
  Court setCourt(String code);
  int updateCourt(Court court);
  int removeCourt(String court_code);
  List<String> courtcodeList();
}







