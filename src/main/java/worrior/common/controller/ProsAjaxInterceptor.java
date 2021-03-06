package worrior.common.controller;

import java.util.Enumeration;
import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import worrior.common.dao.CommonDAO;
import worrior.common.util.commonUtils.SessionUtils;
import worrior.common.util.utils.UtilsUser;

public class ProsAjaxInterceptor extends HandlerInterceptorAdapter {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Inject
	private CommonDAO commonDAO;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		return super.preHandle(request, response, handler);
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		String httpMethod = request.getMethod();
		SessionUtils session = new SessionUtils();
		HashMap hashMap = new HashMap();
		String userUrl = request.getRequestURI();
		UtilsUser utils = new UtilsUser(); 
		String userIp = utils.getIp(request);
		
		
		hashMap.put("userIp", userIp);
		hashMap.put("useMethod", httpMethod);
		hashMap.put("userUrl", userUrl);
		hashMap.put("useType", "1");
		hashMap.put("userSuccess", "Y");
		hashMap.put("useParam", "");
		String userId = "";
		try {
			hashMap.put(userIp, userId);
			userId = ("".equals(session.getUserId()) || session.getUserId() == null) ? "public" : session.getUserId();
			hashMap.put("userId", userId);
			hashMap.put("userIp", userIp);
			hashMap.put("userUrl", userUrl);
			hashMap.put("useType", "1");
			hashMap.put("userSuccess", "Y");
			
			String useParam = "";
			Enumeration params = request.getParameterNames();
			while (params.hasMoreElements()){
			    String name = (String)params.nextElement();
			    useParam += name + ":" +request.getParameter(name)+", ";
			    
			}
			hashMap.put("useParam", useParam);
		}
		catch (Exception e) {
			e.printStackTrace();
			hashMap.put("userId", "public");
			hashMap.put("userSuccess", "N");
			// TODO: handle exception
		}
		finally {
			commonDAO.writeProcessLog(hashMap);
		}
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		// TODO Auto-generated method stub
//		log.error("error : " + handler);
//		log.error("error : " + ex.getClass());
		super.afterCompletion(request, response, handler, ex);
	}
	

}