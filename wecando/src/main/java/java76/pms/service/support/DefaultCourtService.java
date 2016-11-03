package java76.pms.service.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java76.pms.dao.CourtDao;
import java76.pms.domain.Court;
import java76.pms.service.CourtService;

@Service
public class DefaultCourtService implements CourtService {
	@Autowired CourtDao courtDao;
	
	public int insert_court(Court court) {
		return courtDao.insertCourt(court);
	}
	
	public List<Court> courtList(int sch_no) {
		return courtDao.courtList(sch_no);
	}
	
	public int removeAllCourt(String code) {
		return courtDao.removeAllCourt(code);
	}
	
	public Court setCourt(String code) {
		return courtDao.setCourt(code);
	}
	
	public int updateCourt(Court court) {
		return courtDao.updateCourt(court);
	}
	
	public int removeCourt(String court_code) {
		return courtDao.removeCourt(court_code);
	}
	
	public List<Court> courtcodeList() {
		return courtDao.courtcodeList();
	}
}







