package java76.pms.service.support;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java76.pms.dao.MemberDao;
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

	public void register(Member member) {
		memberDao.insert(member);
	}

	public void remove(int no, String password) {
		HashMap<String,Object> paramMap = new HashMap<>();
		paramMap.put("no", no);
		paramMap.put("password", password);

		memberDao.delete(paramMap);
	}

	public void change(Member member) {
		memberDao.update(member);
	}

	public Member retieve(int no) {
		return memberDao.selectOne(no);
	}
	
	public Member retrieve(String m_email, String m_password) {
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("email", m_email);
    paramMap.put("password", m_password);
    
    return memberDao.selectOneByEmailPassword(paramMap);
  }
	
	public void create(Member member) {
		memberDao.create(member);
	}
}







