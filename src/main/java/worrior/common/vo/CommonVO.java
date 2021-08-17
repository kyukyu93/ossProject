package worrior.common.vo;

@SuppressWarnings("serial")
public class CommonVO extends worrior.common.util.commonVO.CommonVO{
	private String userChk;
	private String currentMenuPath;

	private String menuNm;
	private String menuPath;
	private String menuUpperCd;
	private String menuCd;
	
	public String getUserChk() {
		return userChk;
	}

	public void setUserChk(String userChk) {
		this.userChk = userChk;
	}

	public String getMenuPath() {
		return menuPath;
	}

	public void setMenuPath(String menuPath) {
		this.menuPath = menuPath;
	}

	public String getCurrentMenuPath() {
		return currentMenuPath;
	}

	public void setCurrentMenuPath(String currentMenuPath) {
		this.currentMenuPath = currentMenuPath;
	}

	public String getMenuNm() {
		return menuNm;
	}

	public void setMenuNm(String menuNm) {
		this.menuNm = menuNm;
	}

	public String getMenuUpperCd() {
		return menuUpperCd;
	}

	public void setMenuUpperCd(String menuUpperCd) {
		this.menuUpperCd = menuUpperCd;
	}

	public String getMenuCd() {
		return menuCd;
	}

	public void setMenuCd(String menuCd) {
		this.menuCd = menuCd;
	}
	
	
}
