package java76.pms.service.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java76.pms.dao.ReserveDao;
import java76.pms.service.ReserveService;

@Service
public class DefaultReserveService implements ReserveService {
  @Autowired ReserveDao reserveDao;

}






