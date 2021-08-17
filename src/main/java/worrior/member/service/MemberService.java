package worrior.member.service;

import worrior.member.vo.MemberVO;

public interface MemberService {
	public MemberVO loginProcess(MemberVO loginVO) throws Exception;
	public MemberVO loginChkProcess(MemberVO loginVO) throws Exception;
	public int checkId(MemberVO loginVO) throws Exception;
	public int signUp(MemberVO loginVO) throws Exception;
}
  