package java76.pms.service.support;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java76.pms.dao.CourtDao;
import java76.pms.service.CourtService;

@Service
public class DefaultCourtService implements CourtService {
	@Autowired CourtDao courtDao;
	
	public int insert_court(HashMap<String, Object> paramMap) {
		return courtDao.insert_court(paramMap);
	}
}







