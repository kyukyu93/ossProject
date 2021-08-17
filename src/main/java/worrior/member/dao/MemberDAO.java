package worrior.member.dao;

import worrior.member.vo.MemberVO;

public interface MemberDAO {

	public int checkIdLogin(MemberVO loginVO) throws Exception;
	public void insertLoginLog(MemberVO loginVO) throws Exception;
	public MemberVO getUserInfo(MemberVO loginVO) throws Exception;
	public int checkId(MemberVO loginVO) throws Exception;
	public int signUp(MemberVO loginVO) throws Exception;
}
