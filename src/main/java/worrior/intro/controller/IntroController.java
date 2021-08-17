package worrior.intro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/worrior/intro")
public class IntroController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/service.do")
	public ModelAndView getServiceView(HttpServletRequest req, HttpServletResponse res, Model model, ModelAndView modelAndView) throws Exception {
		return modelAndView;
	}	
	@RequestMapping(value = "/worrior.do")
	public ModelAndView getworriorView(HttpServletRequest req, HttpServletResponse res, Model model, ModelAndView modelAndView) throws Exception {
		return modelAndView;
	}	
	@RequestMapping(value = "/partner.do")
	public ModelAndView getPartnerView(HttpServletRequest req, HttpServletResponse res, Model model, ModelAndView modelAndView) throws Exception {
		return modelAndView;
	}	
	@RequestMapping(value = "/developer.do")
	public ModelAndView getDeveloperView(HttpServletRequest req, HttpServletResponse res, Model model, ModelAndView modelAndView) throws Exception {
		return modelAndView;
	}	
}
