package java76.pms.service;

import java.util.HashMap;
import java.util.List;

import java76.pms.domain.Court;

public interface CourtService {
	int insert_court(HashMap<String, Object> paramMap);
	List<Court> courtList(int sch_no);
	int removeAllCourt(String code);
}







