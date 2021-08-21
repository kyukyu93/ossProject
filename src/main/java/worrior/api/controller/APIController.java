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
	
//	@Inject
//	private APIService apiService;
	
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
    public String insertTrackingData(HttpServletRequest req, HttpServletResponse res, Model model) throws Exception {
		HashMap hashMap = new HashMap();
		try {
			SessionUtils sessionUtils = new SessionUtils();
			System.out.println("############"+sessionUtils.getUserId());
			if("".equals(sessionUtils.getUserId()) || null == sessionUtils.getUserId()) {
				System.out.println("############222"+sessionUtils.getUserId());
				 hashMap = propertiesUtils.getMessage("api.fail.req.auth");
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("data", hashMap);
		return "jsonView";
	}
}
