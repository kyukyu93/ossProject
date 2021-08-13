package pros.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ProsApiInterceptor extends HandlerInterceptorAdapter {
	private Logger log = LoggerFactory.getLogger(this.getClass());

//	@Inject
//	private CommonDAO commonDAO;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//		SessionUtils session = new SessionUtils();
//		HashMap hashMap = new HashMap();
//		String userUrl = request.getRequestURI();
//		String userIp = getIp(request);
//		String userId = "";
//		
//		try {
//			
//			
//			hashMap.put(userIp, userId);
//			
//			userId = ("".equals(session.getUserId()) || session.getUserId() == null) ? "public" : session.getUserId();
//			
//			hashMap.put("userId", userId);
//			hashMap.put("userIp", userIp);
//			hashMap.put("userUrl", userUrl);
//			hashMap.put("userSuccess", "Y");
//			
//			
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//			hashMap.put("userSuccess", "N");
//			// TODO: handle exception
//		}
//		finally {
//			commonDAO.writeProcessLog(hashMap);
//		}
		
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