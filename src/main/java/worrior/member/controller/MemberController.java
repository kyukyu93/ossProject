package worrior.member.controller;

import java.io.IOException;

import javax.inject.Inject;
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
import worrior.common.util.utils.UtilsUser;
import worrior.member.service.MemberService;
import worrior.member.vo.MemberVO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.Connection;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Inject
	private MemberService loginService;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public ModelAndView loginView(HttpServletRequest req, HttpServletResponse res, Model model, ModelAndView modelAndView) throws Exception {
		SessionUtils session = new SessionUtils();
		session.removeSession();
		log.debug("login");
		return modelAndView;
	}	
	
	@RequestMapping(value = "/login.ajax", method = RequestMethod.POST)
    public String loginProcess(HttpServletRequest req, HttpServletResponse res, Model model) throws Exception {
		SessionUtils session = new SessionUtils();
		UtilsUser utilsUser = new UtilsUser();
		MemberVO loginVO = new MemberVO();
		loginVO.setUserId(req.getParameter("userId"));
		loginVO.setUserPw(req.getParameter("userPw"));
		loginVO.setUserLoc(req.getParameter("userLoc"));
		loginVO.setUserFrom(req.getParameter("userFrom"));
		loginVO.setUserLoc(utilsUser.getIp(req));
		if(loginVO.getUserLoc() == null || loginVO.getUserLoc() == "") loginVO.setUserLoc("0.0.0.0");
		if(loginVO.getUserFrom() == null || loginVO.getUserFrom() == "") loginVO.setUserFrom("1");
		
		MemberVO resultVO = loginService.loginProcess(loginVO);
		if(resultVO != null) {
			model.addAttribute("result", "success");
			model.addAttribute("msg", "�솚�쁺�빀�땲�떎");
			model.addAttribute("userInfo", resultVO);
			session.setUserId(resultVO.getUserId());
			session.setUserNm(resultVO.getUserNm());
			session.setUserEmail(resultVO.getUserEmail());
			session.setUserChk(resultVO.getUserChk());
			session.setIsLogin(true);
		}
		else {
			model.addAttribute("result", "fail");
			model.addAttribute("msg", "濡쒓렇�씤�뿉 �떎�뙣�븯���뒿�땲�떎");
		}
		return "jsonView";
	}	

	@RequestMapping(value = "/signup.do", method = RequestMethod.GET)
    public ModelAndView signUpView(HttpServletRequest req, HttpServletResponse res, Model model, ModelAndView modelAndView) throws Exception {
		log.debug("signup");
		return modelAndView;
	}	

	@RequestMapping(value = "/logout.ajax")
    public String logoutProcess(HttpServletRequest req, HttpServletResponse res, Model model) throws Exception {
		SessionUtils session = new SessionUtils();
		
		try {
			session.removeSession();
			model.addAttribute("result", "success");
			model.addAttribute("msg", "�븞�쟾�븯寃� 濡쒓렇�븘�썐�릺�뿀�뒿�땲�떎.");
		}
		catch(Exception e) {
			model.addAttribute("result", "fail");
			model.addAttribute("msg", "濡쒓렇�븘�썐 以� �삤瑜섍� 諛쒖깮�뻽�뒿�땲�떎.");
		}
		
		return "jsonView";
	}	
	
	@RequestMapping(value = "/idChk.ajax",  method= RequestMethod.POST)
    public String idCheck(HttpServletRequest req, HttpServletResponse res, Model model) throws Exception {
		try {
			MemberVO loginVO = new MemberVO();
			loginVO.setUserId(req.getParameter("userId"));
			
			int idChk = loginService.checkId(loginVO);

			if(idChk == 0) {
				model.addAttribute("result", "success");
				model.addAttribute("msg", "�궗�슜�븷 �닔 �엳�뒗 ID�엯�땲�떎");
			}
			else {
				model.addAttribute("result", "fail");
				model.addAttribute("msg", "�궗�슜�븷 �닔 �뾾�뒗 ID�엯�땲�떎");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("result", "error");
			model.addAttribute("msg", "�꽌踰꾪넻�떊 以� �삤瑜섍� 諛쒖깮�뻽�뒿�땲�떎");
		}
		return "jsonView";
	}	
	
	@RequestMapping(value = "/signup.ajax")
    public String signupProcess(HttpServletRequest req, HttpServletResponse res, Model model) throws Exception {
		MemberVO loginVO = new MemberVO();
		loginVO.setUserId(req.getParameter("userId"));
		loginVO.setUserPw(req.getParameter("userPw"));
		loginVO.setUserNm(req.getParameter("userName"));
		loginVO.setUserEmail(req.getParameter("userEmail"));
		loginVO.setUserPhone(req.getParameter("userPhone"));
		loginVO.setUserAddrs(req.getParameter("userAddress"));
		loginVO.setUserBirth(req.getParameter("userbirth"));
		
		
		int chkIn = loginService.signUp(loginVO);
		if(chkIn == 1) {
			model.addAttribute("result", "success");
			model.addAttribute("msg", "�쉶�썝媛��엯�뿉 �꽦怨듯뻽�뒿�땲�떎.\n"+loginVO.getUserNm()+"�떂 �솚�쁺�빀�땲�떎.");
		}
		else {
			model.addAttribute("result", "fail");
			model.addAttribute("msg", "�쉶�썝媛��엯�뿉 �떎�뙣�뻽�뒿�땲�떎.");
		}
		return "jsonView";
	}	
	
	@RequestMapping(value = "/jsoup.ajax")
    public void jsoupTest(HttpServletRequest req, HttpServletResponse res) {
		try {
			String URL = "https://www.gangnam.go.kr";
			
			Connection conn = Jsoup.connect(URL);
			
			Document html = conn.get();
			
			System.out.println(html);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
