package java76.pms.dao;

import java.util.List;
import java.util.Map;

import java76.pms.domain.Member;

public interface MemberDao {
  List<Member> selectList(Map<String,Object> paramMap);
  
  int insert(Member member);
  
  int delete(Map<String,Object> paramMap);
  
  int create(Member member);   //이메일 인증하고 아이디 생성 시 사용할 쿼리
  
  String auth(Map<String,String> paramMap);     //이메일 사용 여부 확인 시 사용.
  
  int monitor_email(String m_email);
  
  int check_nick(String m_nick);
  
  int update(Member member);
  
  Member selectOne(int m_no);
  
  Member selectOneByEmailPassword(Map<String,Object> paramMap);
  
  void deleteExpirationMember();
  
  int manage(int sch_no);  // 관리하는 학교 넘버 등록 (default 0)
  
  int update_manage (Map<String, Integer> paramMap);
  
}







