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
		return sqlSession.selectOne("loginDAO.idChkLogin", loginVO);
		
	}
	public void insertLoginLog(MemberVO loginVO) throws Exception {
		sqlSession.insert("loginDAO.loginLog", loginVO);
	}
	public MemberVO getUserInfo(MemberVO loginVO) throws Exception {
		return sqlSession.selectOne("loginDAO.getUserInfo", loginVO);
	}
	public int checkId(MemberVO loginVO) throws Exception {
		return sqlSession.selectOne("loginDAO.idChk", loginVO);
		
	}
	public int signUp(MemberVO loginVO) throws Exception {
		return sqlSession.insert("loginDAO.signUp", loginVO);
		
	}
}
