package worrior.member.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import worrior.member.dao.MemberDAO;
import worrior.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Inject
	private MemberDAO loginDAO;
	
	public MemberVO loginProcess(MemberVO loginVO) throws Exception {
		int chkId = loginDAO.checkIdLogin(loginVO);
		if (chkId == 1) {
			loginDAO.insertLoginLog(loginVO);
//			List<LoginVO> userInfoList;
//			userInfoList = loginDAO.getUserInfo(loginVO);
//			log.info("###########"+userInfoList.toString());
			return loginDAO.getUserInfo(loginVO);
		}
		return null;
		
	}
	
	public MemberVO loginChkProcess(MemberVO loginVO) throws Exception {
		int chkId = loginDAO.checkIdLogin(loginVO);
		if (chkId == 1) {
			loginDAO.insertLoginLog(loginVO);
//			List<LoginVO> userInfoList;
//			userInfoList = loginDAO.getUserInfo(loginVO);
//			log.info("###########"+userInfoList.toString());
			return loginDAO.getUserInfo(loginVO);
		}
		return null;
		
	}
	public int checkId(MemberVO loginVO) throws Exception{
		int chkId = loginDAO.checkId(loginVO);
		return chkId;
	}
	
	public int signUp(MemberVO loginVO) throws Exception{
		int chkIn = loginDAO.signUp(loginVO);
		return chkIn;
	}
}
