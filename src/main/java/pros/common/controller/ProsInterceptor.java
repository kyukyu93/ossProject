package pros.common.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ProsInterceptor extends HandlerInterceptorAdapter {
	private Logger log = LoggerFactory.getLogger(this.getClass());

//	@Inject
//	private CommonDAO commonDAO;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
//		SessionUtils session = new SessionUtils();
//		
//		if("".equals(session.getUserChk()) || session.getUserChk() == null || "".equals(session.getUserId()) || session.getUserId() == null) {
//			session.setUserChk("0");
//		}
//		CommonVO commonVO = new CommonVO();
//		commonVO.setUserChk(session.getUserChk());
//		commonVO.setCurrentMenuPath(request.getRequestURI());
//		
//		log.info(commonVO.getMenuPath());
//		log.info(commonVO.getUserChk());
//		
//		//권한체크
//		if (commonDAO.chkMenuAuth(commonVO) == 0) modelAndView.setViewName("login/login");
//		else {
//			
//		}
//		
//		//NAVIGATION MENU 
//		if(session.getNavList() == null) {
//			List<CommonVO> navList   = null;   
//			navList   = (List<CommonVO>) commonDAO.getNavMenu(commonVO);
//			session.setNavList(navList);
//			
//			modelAndView.addObject("navList", navList);
//			modelAndView.addObject("navList2", navList);
//			String currentNm = "";
//			String menuUpperCd = "";
//			
//			List<CommonVO> menuList   = new ArrayList();
//			
//			for(CommonVO vo : session.getNavList()) {
//				if(vo.getMenuPath().equals(request.getRequestURI())) {
//					currentNm = vo.getMenuNm();
//					menuUpperCd = vo.getMenuUpperCd();
//				}
//			}
//			
//			for(CommonVO vo : session.getNavList()) {
//				if(vo.getMenuUpperCd().equals(menuUpperCd)) {
//					menuList.add(vo);
//				}
//			}
//			
//			modelAndView.addObject("resultList", menuList);
//			modelAndView.addObject("currentMenu", currentNm);
//			modelAndView.addObject("menuUpperCd", menuUpperCd);
//			log.info("input session navigation list");
//		}
//		else {
//			modelAndView.addObject("navList", session.getNavList());
//			modelAndView.addObject("navList2", session.getNavList());
//			String currentNm = "";
//			String menuUpperCd = "";
//			
//			List<CommonVO> menuList   = new ArrayList();
//			
//			for(CommonVO vo : session.getNavList()) {
//				if(vo.getMenuPath().equals(request.getRequestURI())) {
//					currentNm = vo.getMenuNm();
//					menuUpperCd = vo.getMenuUpperCd();
//				}
//			}
//			
//			for(CommonVO vo : session.getNavList()) {
//				if(vo.getMenuUpperCd().equals(menuUpperCd)) {
//					menuList.add(vo);
//				}
//			}
//			modelAndView.addObject("resultList", menuList);
//			modelAndView.addObject("currentMenu", currentNm);
//			modelAndView.addObject("menuUpperCd", menuUpperCd);
//			log.info("output session navigation list");
//		}
//		
//		//SIDE MENU 
//		
//		if(session.getSideMenu() == null) {
//			List<CommonVO> menuList   = null;   
//			menuList   = (List<CommonVO>) commonDAO.getSideMenu(commonVO);
//			session.setSideMenu(menuList);
//			
//			modelAndView.addObject("resultList", menuList);
//			log.info("input session menu list");
//		}
//		else {
//			modelAndView.addObject("resultList", session.getSideMenu());
//			log.info("output session menu list");
//		}
//		
////		String currentMenuNm =  commonDAO.getCurrentMenu(commonVO); 
////		log.info(currentMenuNm);
//		
//		//블랙리스트
////		if(getIp(request).equals("127.0.0.1")) {
////			log.info("blacklist");
////			modelAndView.setViewName("login/login");
////		}
//		
////		modelAndView.addObject("currentMenu", currentMenuNm);
//		
//		//USER SESSION
//		if(session.isLogin()) {
//			log.info("isLogin");
//			modelAndView.addObject("userChk", session.getUserChk());
//			modelAndView.addObject("userName", session.getUserNm());
//		}
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
//		log.error("error : " + handler);
//		log.error("error : " + ex.getClass());
		super.afterCompletion(request, response, handler, ex);
	}

	private String getIp(HttpServletRequest request) {
		 
        String ip = request.getHeader("X-Forwarded-For");
 
        log.info(">>>> X-FORWARDED-FOR : " + ip);
 
        if (ip == null) {
            ip = request.getHeader("Proxy-Client-IP");
            log.info(">>>> Proxy-Client-IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("WL-Proxy-Client-IP"); // 웹로직
            log.info(">>>> WL-Proxy-Client-IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_CLIENT_IP");
            log.info(">>>> HTTP_CLIENT_IP : " + ip);
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            log.info(">>>> HTTP_X_FORWARDED_FOR : " + ip);
        }
        if (ip == null) {
            ip = request.getRemoteAddr();
        }
        
        log.info(">>>> Result : IP Address : "+ip);
 
        return ip;
 
    }
	
	private boolean chkPageWhiteList(String strUrl) {
		String[] whiteListArr = {
				""
		};
		for(int i = 0; i < whiteListArr.length; i++){
			if(whiteListArr[i].equals(strUrl)){
				return true;
			}
		}
		return false;
    }
	
	private boolean chkIpBlackList(String strIp) {
		String[] blackListArr = {
				"000.000.000.000"
		};
		for(int i = 0; i < blackListArr.length; i++){
			if(blackListArr[i].equals(strIp)){
				return true;
			}
		}
		return false;
    }
	
	@SuppressWarnings("unused")
	private int acceptExceptionUtils(Exception e) {
		try {
			StringBuffer sb = new StringBuffer();
			
//			e.printStackTrace();
			Date time = new Date();
			
			sb.append(time.toString() +"\n");
			sb.append(e.toString() +"\n");
			
			for(StackTraceElement stackTraceElement : e.getStackTrace()) {
				
				String className = stackTraceElement.getClassName();
				String methodName = stackTraceElement.getMethodName();
				String fileName = stackTraceElement.getFileName();
				int lineNumber = stackTraceElement.getLineNumber();
				sb.append(className + "." + methodName + "(" + fileName + "):" + lineNumber);
				
//				if(className.contains("ForkUsInterceptor")) {
//					log.info(className + "." + methodName + "(" + fileName + "):" + lineNumber);
//					break;
//				}
				
			}
		}
		catch (Exception ex) {
			// TODO: handle exception
			return 0;
		}
		
		return 1;
	}
	
}