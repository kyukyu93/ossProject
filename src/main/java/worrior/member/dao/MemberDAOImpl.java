package worrior.member.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import worrior.member.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Inject
	private SqlSession sqlSession;
	
	public int checkIdLogin(MemberVO loginVO) throws Exception {
		return sqlSession.selectOne("memberDAO.idChkLogin", loginVO);
		
	}
	public void insertLoginLog(MemberVO loginVO) throws Exception {
		sqlSession.insert("memberDAO.loginLog", loginVO);
	}
	public MemberVO getUserInfo(MemberVO loginVO) throws Exception {
		return sqlSession.selectOne("memberDAO.getUserInfo", loginVO);
	}
	public int checkId(MemberVO loginVO) throws Exception {
		return sqlSession.selectOne("memberDAO.idChk", loginVO);
		
	}
	public int signUp(MemberVO loginVO) throws Exception {
		return sqlSession.insert("memberDAO.signUp", loginVO);
		
	}
}
