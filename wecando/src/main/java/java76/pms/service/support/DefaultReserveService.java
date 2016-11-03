package java76.pms.service.support;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java76.pms.dao.ReserveDao;
import java76.pms.domain.Reserve;
import java76.pms.service.ReserveService;

@Service
public class DefaultReserveService implements ReserveService {
  @Autowired ReserveDao reserveDao;
  
  public int doReserve(HashMap<String, Object> paramMap) {
  		return reserveDao.doReserve(paramMap);
  }
  
  public int cancleReserve(HashMap<String, Object> paramMap) {
  	  return reserveDao.cancleReserve(paramMap);
  }
  
  public List<Reserve> reserveInfoList(int m_no) {
  	  return reserveDao.reserveInfoList(m_no);
  }
  
  public List<Reserve> reserveLastList(int m_no) {
  	  return reserveDao.reserveLastList(m_no);
  }
  
  public List<Reserve> ClientReserveList(int m_no) {
	  return reserveDao.ClientReserveList(m_no);
  }
  
  public Reserve getReserve(int res_no) {
  	  return reserveDao.getReserve(res_no);
  }
}







