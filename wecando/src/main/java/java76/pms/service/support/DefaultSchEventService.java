package java76.pms.service.support;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java76.pms.dao.SchEventDao;
import java76.pms.domain.SchEvent;
import java76.pms.service.SchEventService;

@Service
public class DefaultSchEventService implements SchEventService {
	@Autowired SchEventDao schEventDao;
	
	public List<SchEvent> schEventList(HashMap<String, Object> paramMap) {
		return schEventDao.schEventList(paramMap);
	}
	
	public int createTime(HashMap<String, Object> paramMap) {
		return schEventDao.createTime(paramMap);
	}
	
	public int schEventCnt() {
		return schEventDao.schEventCnt();
	}
	
	public List<SchEvent> searchSchEvent(HashMap<String, Object> paramMap) {
		return schEventDao.searchSchEvent(paramMap);
	}

	public int reserveT6_8(HashMap<String, Object> paramMap) {
		return schEventDao.reserveT6_8(paramMap);
	}

	public int reserveT8_10(HashMap<String, Object> paramMap) {
		return schEventDao.reserveT8_10(paramMap);
	}

	public int reserveT10_12(HashMap<String, Object> paramMap) {
		return schEventDao.reserveT10_12(paramMap);
	}

	public int reserveT12_14(HashMap<String, Object> paramMap) {
		return schEventDao.reserveT12_14(paramMap);
	}
	
	public int reserveT14_16(HashMap<String, Object> paramMap) {
		return schEventDao.reserveT14_16(paramMap);
	}

	public int reserveT16_18(HashMap<String, Object> paramMap) {
		return schEventDao.reserveT16_18(paramMap);
	}

	public int reserveT18_20(HashMap<String, Object> paramMap) {
		return schEventDao.reserveT18_20(paramMap);
	}

	public int reserveT20_22(HashMap<String, Object> paramMap) {
		return schEventDao.reserveT20_22(paramMap);
	}

	public int cancleT6_8(HashMap<String, Object> paramMap) {
		return schEventDao.cancleT6_8(paramMap);
	}

	public int cancleT8_10(HashMap<String, Object> paramMap) {
		return schEventDao.cancleT8_10(paramMap);
	}

	public int cancleT10_12(HashMap<String, Object> paramMap) {
		return schEventDao.cancleT10_12(paramMap);
	}

	public int cancleT12_14(HashMap<String, Object> paramMap) {
		return schEventDao.cancleT12_14(paramMap);
	}

	public int cancleT14_16(HashMap<String, Object> paramMap) {
		return schEventDao.cancleT14_16(paramMap);
	}

	public int cancleT16_18(HashMap<String, Object> paramMap) {
		return schEventDao.cancleT16_18(paramMap);
	}
	
	public int cancleT18_20(HashMap<String, Object> paramMap) {
		return schEventDao.cancleT18_20(paramMap);
	}

	public int cancleT20_22(HashMap<String, Object> paramMap) {
		return schEventDao.cancleT20_22(paramMap);
	}
	
	
}







