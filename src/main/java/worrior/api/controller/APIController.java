package worrior.api.controller;

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

@Controller
@RequestMapping("/api")
public class APIController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
//	@Inject
//	private APIService apiService;
	

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

}
