package worrior.home.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import worrior.common.util.commonUtils.SessionUtils;

@Controller
public class HomeController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}

	@RequestMapping(value = {"/home.do", "/mobile/home.do"})
	public ModelAndView getMainView(HttpServletRequest req, HttpServletResponse res, Model model, ModelAndView modelAndView) throws Exception {
		
		if(req.getServletPath().equals("/home.do")) {
			log.info("/home");
	    }else if(req.getServletPath().equals("/mobile/home.do")) {
	    	log.info("/mobile/home");
	    }
	    else {
	    	log.info("Exception url (home)");
	    }
		return modelAndView;
	}	
	
	@RequestMapping(value = "/worrior/home.do")
	public ModelAndView getworriorMainView(HttpServletRequest req, HttpServletResponse res, Model model, ModelAndView modelAndView) throws Exception {
		return modelAndView;
	}	

	
	@RequestMapping(value = "/getProcessMonitoring.ajax")
    public String getProcessMonitoring(HttpServletRequest req, HttpServletResponse res, Model model) throws Exception {
		SessionUtils session = new SessionUtils();
		try {
			if("".equals(session.getUserId()) || session.getUserId() == null) {
				model.addAttribute("result", "none");
				model.addAttribute("code", "600");
				model.addAttribute("msg", "권한이 없습니다.");
			}
			else {
				
			}
			
		}
		catch (Exception e) {
			model.addAttribute("result", "fail");
			model.addAttribute("code", "500");
			model.addAttribute("msg", "서버 통신 중 오류가 발생했습니다.");
		}
		return "jsonView";
	}	
}
