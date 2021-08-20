package worrior.tracking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TrackingController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = {"/worrior/tracking.do", "/mobile/tracking.do"})
	public ModelAndView getTrackingView(HttpServletRequest req, HttpServletResponse res, Model model, ModelAndView modelAndView) throws Exception {
		if(req.getServletPath().equals("/worrior/tracking.do")) {
			log.info("/tracking");
	    }else if(req.getServletPath().equals("/mobile/tracking.do")) {
	    	log.info("/mobile/tracking");
	    }
	    else {
	    	log.info("Exception url (tracking)");
	    }
		return modelAndView;
	}	
}
