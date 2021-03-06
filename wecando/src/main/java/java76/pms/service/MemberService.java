package java76.pms.service;

import java.util.List;
import java.util.Map;

import java76.pms.domain.Event;
import java76.pms.domain.Member;

public interface MemberService {
  List<Member> getMemberList(
      int pageNo, int pageSize, 
      String keyword, String align);
  int register(Member member);
  int remove(int m_no, String m_password);
  int change(Member member);
  int create(Member member);
  int monitor_email(String m_email);
  int check_nick(String m_nick);
  String check_ava(Map<String, String> paramMap);
  String auth(Map<String,String>paramMap);
  Member retrieve(int m_no);
  Member retrieve(String m_email, String m_password);
  void removeExpirationMember();
  int update_manage(int mng_no, int m_no);
  
  int event_insert(Event event);
}







