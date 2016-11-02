package java76.pms.dao;

import java.util.HashMap;
import java.util.List;

import java76.pms.domain.Reserve;

public interface ReserveDao {
	int doReserve(HashMap<String, Object> paramMap);
	List<Reserve> reserveInfoList(int m_no);
}







