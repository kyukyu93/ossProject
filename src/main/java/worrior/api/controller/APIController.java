package worrior.api.controller;

import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import worrior.api.service.APIService;
import worrior.api.utils.PropertiesUtils;
import worrior.common.util.commonUtils.SessionUtils;

@Controller
@RequestMapping("/api")
public class APIController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Inject
	private APIService apiService;
	
	PropertiesUtils propertiesUtils;

	@RequestMapping(value = "/board/{code}", method = RequestMethod.GET)
	public String selectBoard(@PathVariable String code, HttpServletRequest req, HttpServletResponse res, Model model) {
		
		log.info("/API/board/" + code);
//		model.addAttribute("result", "success");
//		model.addAttribute("msg", "안전하게 로그아웃되었습니다.");
		
	return "jsonView";
	}
	
	@RequestMapping(value = "/test.do", method = RequestMethod.GET)
    public ModelAndView testView(HttpServletRequest req, HttpServletResponse res, Model model, ModelAndView modelAndView) throws Exception {
		log.debug("testView");
		log.debug("testView22");
		return modelAndView;
	}	

	
	/**
	 * 위치정보 API
	 * 2021.08.21
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/tracking", method = RequestMethod.POST)
    public String postTrackingData(HttpServletRequest req, HttpServletResponse res, Model model) throws Exception {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		String strAccuracy = req.getParameter("accuracy");
		String strTime = req.getParameter("time");
		String strLatitude = req.getParameter("latitude");
		String strLongitude = req.getParameter("longitude");
		
		log.info(req.getParameter("accuracy"));
		log.info(req.getParameter("time"));
		log.info(req.getParameter("latitude"));
		log.info(req.getParameter("longitude"));
		
		try {
			SessionUtils sessionUtils = new SessionUtils();
			if("".equals(sessionUtils.getUserId()) || null == sessionUtils.getUserId()) {
				 //hashMap = propertiesUtils.getMessage("api.fail.req.auth");
				
				
			}
			else {
//				hashMap.put("code", "200");
//				hashMap.put("msg", "조회 테스트, "+sessionUtils.getUserId()+"로그인 성공");
			}
			hashMap.put("code", "200");
			hashMap.put("msg", "정상적으로 처리되었습니다");
			hashMap.put("userid", "public");
			hashMap.put("accuracy", strAccuracy);
			hashMap.put("trackTime", strTime);
			hashMap.put("latitude", strLatitude);
			hashMap.put("LONGITUDE", strLongitude);
			
			
			apiService.postTracking(hashMap);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			hashMap.put("code", "400");
			hashMap.put("msg", "처리 중 오류가 발생했습니다");
		}
		model.addAttribute("data", hashMap);
		return "jsonView";
	}
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/tracking", method = RequestMethod.GET)
    public String getTrackingData(HttpServletRequest req, HttpServletResponse res, Model model) throws Exception {
		HashMap hashMap = new HashMap();
		String strAccuracy = req.getParameter("accuracy");
		String strTime = req.getParameter("time");
		String strLatitude = req.getParameter("latitude");
		String strLongitude = req.getParameter("longitude");
		try {
			SessionUtils sessionUtils = new SessionUtils();
			if("".equals(sessionUtils.getUserId()) || null == sessionUtils.getUserId()) {
				 //hashMap = propertiesUtils.getMessage("api.fail.req.auth");
				hashMap.put("code", "401");
				hashMap.put("msg", "인증되지 않은 사용자");
				hashMap.put("acc", strAccuracy);
				hashMap.put("tim", strTime);
				hashMap.put("lat", strLatitude);
				hashMap.put("lon", strLongitude);
			}
			else {
				hashMap.put("code", "200");
				hashMap.put("msg", "조회 테스트, "+sessionUtils.getUserId()+"로그인 성공");
			}			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("data", hashMap);
		return "jsonView";
	}
}
