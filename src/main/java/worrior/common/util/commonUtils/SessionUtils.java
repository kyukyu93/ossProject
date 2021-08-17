package worrior.common.util.commonUtils;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import worrior.common.vo.CommonVO;

public class SessionUtils {
	
    private HttpSession session = null;
    
    public SessionUtils(){
    	 this(false);
    }
    
    public SessionUtils(boolean isNew){
        if(isNew){
            this.session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession(true);
        }else{
            this.session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        } 
    }
    
    /**
     * 세션
     */
    public HttpSession getSession(){
    	return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
    }    
    
    /**
     * 로그인 여부
     */
    public boolean isLogin(){
        if( null == this.session.getAttribute("isLogin") ) {
            return false;
        }else if( this.session.getAttribute("isLogin").equals("false") ) {
            return false;
        }else{
            return true;
        }
    }
    public void setIsLogin(boolean isLogin){
       this.session.setAttribute("isLogin", isLogin); 
    }
    
    /**
     * 사용자 ID
     */
    public String getUserId(){
        return (String)this.session.getAttribute("userId");
    }
    public void setUserId(String userId){
        this.session.setAttribute("userId", userId);
    }
    
    /**
     * 사용자 성명
     */
    public String getUserNm() {
    	return (String)this.session.getAttribute("userNm");
	}

	public void setUserNm(String userNm) {
		 this.session.setAttribute("userNm", userNm);
	}

	/**
     * 사용자 메뉴 권한
     */
	public String getUserChk(){
        return (String)this.session.getAttribute("userChk");
    }
    public void setUserChk(String userChk){
        this.session.setAttribute("userChk", userChk);
    }
    /**
     * 사용자 전자우편 주소
     */
    public String getUserEmail(){
        return (String)this.session.getAttribute("userEmail");
    }
    public void setUserEmail(String userEmail){
        this.session.setAttribute("userEmail", userEmail);
    }
    
    /**
     * 네비 메뉴 리스트
     */
    @SuppressWarnings("unchecked")
	public List<CommonVO> getNavList(){
        return (List<CommonVO>)this.session.getAttribute("navList");
    }
    public void setNavList(List<CommonVO> navList){
        this.session.setAttribute("navList", navList);
    }
    /**
     * 네비 메뉴 리스트
     */
    @SuppressWarnings("unchecked")
	public List<CommonVO> getSideMenu(){
        return (List<CommonVO>)this.session.getAttribute("menuList");
    }
    public void setSideMenu(List<CommonVO> menuList){
        this.session.setAttribute("menuList",menuList);
    }
    
    /**
     * 세션 소멸
     * @return
     */
    public void removeSession(){
        
        this.session.invalidate();
         
    }
    
}