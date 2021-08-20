package worrior.manage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/worrior/manage")
public class ManageController {
private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/home.do")
	public ModelAndView getHomeView(HttpServletRequest req, HttpServletResponse res, Model model, ModelAndView modelAndView) throws Exception {
		return modelAndView;
	}	
	@RequestMapping(value = "/notice.do")
	public ModelAndView getNoticeView(HttpServletRequest req, HttpServletResponse res, Model model, ModelAndView modelAndView) throws Exception {
		return modelAndView;
	}	
}
