package worrior.common.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import worrior.common.dao.CommonDAO;
import worrior.common.util.commonUtils.SessionUtils;
import worrior.common.vo.CommonVO;

public class WorriorInterceptor extends HandlerInterceptorAdapter {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Inject
	private CommonDAO commonDAO;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		return super.preHandle(request, response, handler);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		SessionUtils session = new SessionUtils();
		String strPath = request.getRequestURI();
		String userAgent = request.getHeader("User-Agent").toUpperCase();
		log.info("1111111111 " + strPath);
		if (userAgent.indexOf("MOBILE") > -1) {
			log.info("!!!!!!!");
			if (userAgent.indexOf("PHONE") == -1) {
				//return IS_MOBILE;
				
				strPath = strPath.replace("worrior/","mobile/");
				log.info("##########" + strPath);
				modelAndView.setViewName(strPath);
			}
			else {}
		} else {
			
		}
		
		if("".equals(session.getUserChk()) || session.getUserChk() == null || "".equals(session.getUserId()) || session.getUserId() == null) {
			session.setUserChk("0");
		}
		CommonVO commonVO = new CommonVO();
		commonVO.setUserChk(session.getUserChk());
		commonVO.setCurrentMenuPath(request.getRequestURI());
		
		log.info(commonVO.getMenuPath());
		log.info(commonVO.getUserChk());
		
		//권한체크
		if (commonDAO.chkMenuAuth(commonVO) == 0) modelAndView.setViewName("member/login");
		else {
			
		}
		
		//NAVIGATION MENU 
		if(session.getNavList() == null) {
			List<CommonVO> navList   = null;   
			navList   = (List<CommonVO>) commonDAO.getNavMenu(commonVO);
			session.setNavList(navList);
			
			modelAndView.addObject("navList", navList);
			modelAndView.addObject("navList2", navList);
			String currentNm = "";
			String menuUpperCd = "";
			
			List<CommonVO> menuList = new ArrayList();
			
			for(CommonVO vo : session.getNavList()) {
				if(vo.getMenuPath().equals(request.getRequestURI())) {
					currentNm = vo.getMenuNm();
					menuUpperCd = vo.getMenuUpperCd();
				}
			}
			
			for(CommonVO vo : session.getNavList()) {
				if(vo.getMenuUpperCd().equals(menuUpperCd)) {
					menuList.add(vo);
				}
			}
			
			modelAndView.addObject("resultList", menuList);
			modelAndView.addObject("currentMenu", currentNm);
			modelAndView.addObject("menuUpperCd", menuUpperCd);
			log.info("input session navigation list");
		}
		else {
			modelAndView.addObject("navList", session.getNavList());
			modelAndView.addObject("navList2", session.getNavList());
			String currentNm = "";
			String menuUpperCd = "";
			
			List<CommonVO> menuList   = new ArrayList();
			
			for(CommonVO vo : session.getNavList()) {
				if(vo.getMenuPath().equals(request.getRequestURI())) {
					currentNm = vo.getMenuNm();
					menuUpperCd = vo.getMenuUpperCd();
				}
			}
			
			for(CommonVO vo : session.getNavList()) {
				if(vo.getMenuUpperCd().equals(menuUpperCd)) {
					menuList.add(vo);
				}
			}
			modelAndView.addObject("resultList", menuList);
			modelAndView.addObject("currentMenu", currentNm);
			modelAndView.addObject("menuUpperCd", menuUpperCd);
			log.info("output session navigation list");
		}
		
		//SIDE MENU 
		/**
		 * 2021-08-18
		 * SIDE MENU
		 * session에 담길 때 url 틀어짐 확인 중 
		 */
		
		if(session.getSideMenu() == null) {
			List<CommonVO> menuList   = null;   
			menuList   = (List<CommonVO>) commonDAO.getSideMenu(commonVO);
			session.setSideMenu(menuList);
			
			modelAndView.addObject("resultList", menuList);
			log.info("input session menu list");
		}
		else {
			List<CommonVO> menuList   = null;   
			menuList   = (List<CommonVO>) commonDAO.getSideMenu(commonVO);
			session.setSideMenu(menuList);
			
			modelAndView.addObject("resultList", menuList);
			log.info("input session menu list");
//			
//			modelAndView.addObject("resultList", session.getSideMenu());
//			log.info("output session menu list");
		}
		
		String currentMenuNm =  commonDAO.getCurrentMenu(commonVO); 
//		log.info(currentMenuNm);
		
		modelAndView.addObject("currentMenu", currentMenuNm);
		
		//USER SESSION
		if(session.isLogin()) {
//			log.info("isLogin");
			modelAndView.addObject("userChk", session.getUserChk());
			modelAndView.addObject("userName", session.getUserNm());
		}
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

}