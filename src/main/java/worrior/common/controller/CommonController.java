package worrior.common.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
private Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/error404")
    public String Error404(HttpServletResponse res, Model model) {
		log.info("error 404");
        model.addAttribute("code", "ERROR_404");
        return "error/error404";
    }
    
    @GetMapping("/error500")
    public String Error500(HttpServletResponse res, Model model) {
    	log.info("error 500");
        model.addAttribute("code", "ERROR_500");
        return "error/error500";
    }
    
    
}
