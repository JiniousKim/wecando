package java76.pms.service.support;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java76.pms.dao.MemberDao;
import java76.pms.domain.Event;
import java76.pms.domain.Member;
import java76.pms.service.MemberService;

@Service
public class DefaultMemberService implements MemberService {
  @Autowired MemberDao memberDao;

  public List<Member> getMemberList(int pageNo, int pageSize, 
      String keyword, String align) {
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
    paramMap.put("keyword", keyword);
    paramMap.put("align", align);

    return memberDao.selectList(paramMap);
  }

  public int register(Member member) {
    return memberDao.insert(member);
  }

  public int remove(int no, String password) {
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("no", no);
    paramMap.put("password", password);

    return memberDao.delete(paramMap);
  }

  public int change(Member member) {
    return memberDao.update(member);
  }

  public Member retrieve(int m_no) {
    return memberDao.selectOne(m_no);
  }

  public Member retrieve(String m_email, String m_password) {
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("m_email", m_email);
    paramMap.put("m_password", m_password);

    return memberDao.selectOneByEmailPassword(paramMap);
  }

  public int create(Member member) {
    return memberDao.create(member);
  }

  public void removeExpirationMember() {
    System.out.println("remove");
    //memberDao.deleteExpirationMember();
  }
  
  public String auth(Map<String, String> paramMap) {
    return memberDao.auth(paramMap);
  }
  
  public int monitor_email(String m_email) {
  		return memberDao.monitor_email(m_email);
  }
  
  public int check_nick(String m_nick) {
		return memberDao.check_nick(m_nick);
  }
  
  public String check_ava(Map<String, String> paramMap) {
		return memberDao.auth(paramMap);
  }
  
  public int insert_event(Event event) {
  		return memberDao.insert_event(event);
  }
}







