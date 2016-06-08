package java76.pms.service;

import java.util.List;

import java76.pms.domain.Member;

public interface MemberService {
  List<Member> getMemberList(
      int pageNo, int pageSize, 
      String keyword, String align);
  void register(Member member);
  void remove(int m_no, String m_password);
  void change(Member member);
  void create(Member member);
  Member retieve(int m_no);
  Member retrieve(String m_email, String m_password);
}







