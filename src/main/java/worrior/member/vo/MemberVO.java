package worrior.member.vo;

import worrior.common.util.commonVO.CommonVO;

@SuppressWarnings("serial")
public class MemberVO extends CommonVO{
	private String userId;
	private String userPw;
	private String userLoc;
	private String userFrom;
	private String userNm;
	private String userEmail;
	private String userAddrs;
	private String userBirth;
	private String userChk;
	private String userPhone;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserLoc() {
		return userLoc;
	}
	public void setUserLoc(String userLoc) {
		this.userLoc = userLoc;
	}
	public String getUserFrom() {
		return userFrom;
	}
	public void setUserFrom(String userFrom) {
		this.userFrom = userFrom;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserAddrs() {
		return userAddrs;
	}
	public void setUserAddrs(String userAddrs) {
		this.userAddrs = userAddrs;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserChk() {
		return userChk;
	}
	public void setUserChk(String userChk) {
		this.userChk = userChk;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
}
