package java76.pms.dao;

import java.util.HashMap;
import java.util.List;

import java76.pms.domain.SchEvent;

public interface SchEventDao {
	List<SchEvent> schEventList(HashMap<String, Object> paramMap);
	int schEventCnt();
	int createTime(HashMap<String, Object> paramMap);
	List<SchEvent> searchSchEvent(HashMap<String, Object> paramMap);
	int reserveT6_8(HashMap<String, Object> paramMap);
	int reserveT8_10(HashMap<String, Object> paramMap);
	int reserveT10_12(HashMap<String, Object> paramMap);
	int reserveT12_14(HashMap<String, Object> paramMap);
	int reserveT14_16(HashMap<String, Object> paramMap);
	int reserveT16_18(HashMap<String, Object> paramMap);
	int reserveT18_20(HashMap<String, Object> paramMap);
	int reserveT20_22(HashMap<String, Object> paramMap);
	
	int cancleT6_8(HashMap<String, Object> paramMap);
	int cancleT8_10(HashMap<String, Object> paramMap);
	int cancleT10_12(HashMap<String, Object> paramMap);
	int cancleT12_14(HashMap<String, Object> paramMap);
	int cancleT14_16(HashMap<String, Object> paramMap);
	int cancleT16_18(HashMap<String, Object> paramMap);
	int cancleT18_20(HashMap<String, Object> paramMap);
	int cancleT20_22(HashMap<String, Object> paramMap);
	
}







