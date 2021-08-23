package worrior.manage.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

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
import worrior.manage.service.ManageService;

@Controller
@RequestMapping("/worrior/manage")
public class ManageController {
private Logger log = LoggerFactory.getLogger(this.getClass());
	@Inject
	private ManageService manageService;

	@RequestMapping(value = "/home.do")
	public ModelAndView getHomeView(HttpServletRequest req, HttpServletResponse res, Model model, ModelAndView modelAndView) throws Exception {
		return modelAndView;
	}	
	@RequestMapping(value = "/notice.do")
	public ModelAndView getNoticeView(HttpServletRequest req, HttpServletResponse res, Model model, ModelAndView modelAndView) throws Exception {
		return modelAndView;
	}	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/getMon.ajax", method = RequestMethod.GET)
    public String getProcMon(HttpServletRequest req, HttpServletResponse res, Model model) throws Exception {
		HashMap hashMap = new HashMap();
		hashMap.put("useType", req.getParameter("useType"));
		
		try {
			
			SessionUtils sessionUtils = new SessionUtils();
			if("".equals(sessionUtils.getUserId()) || null == sessionUtils.getUserId()) {
				 //hashMap = propertiesUtils.getMessage("api.fail.req.auth");
				hashMap.put("code", "401");
				hashMap.put("msg", "인증되지 않은 사용자");
			}
			else {
				SimpleDateFormat timeFormat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
				Calendar calendar = Calendar.getInstance();
				String reqestTime = timeFormat.format(calendar.getTime());
				
				hashMap = manageService.getProcMon(hashMap);
				
				String successCnt = hashMap.get("successCnt").toString();
				String allCnt = hashMap.get("allCnt").toString();
				String callAvg = String.format("%.2f", ((float) Integer.parseInt(successCnt) / (float) Integer.parseInt(allCnt)) * 100);
				
				hashMap.put("requestTime", reqestTime);
				hashMap.put("callAvg", callAvg);
				hashMap.put("code", "200");
				hashMap.put("msg", "정상적으로 조회되었습니다");
			}			
		}
		catch (Exception e) {
			// TODO: handle exception
			hashMap.put("code", "500");
			hashMap.put("msg", "서버가 응답하지 않습니다");
			e.printStackTrace();
		}
		model.addAttribute("data", hashMap);
		return "jsonView";
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/getMonList.ajax", method = RequestMethod.GET)
    public String getProcMonList(HttpServletRequest req, HttpServletResponse res, Model model) throws Exception {
		HashMap hashMap = new HashMap();
		hashMap.put("useType", req.getParameter("useType"));
		hashMap.put("pageStart", ("".equals(req.getParameter("pageStart")) || req.getParameter("pageStart") == null) ? 0 : (Integer.parseInt(req.getParameter("pageStart")) * 10));
		
		hashMap.put("pageEnd", ("".equals(req.getParameter("pageEnd")) || req.getParameter("pageEnd") == null) ? 0 : req.getParameter("pageEnd"));
		List<HashMap<String, String>> list = null;
		try {
			SessionUtils sessionUtils = new SessionUtils();
			if("".equals(sessionUtils.getUserId()) || null == sessionUtils.getUserId()) {
				 //hashMap = propertiesUtils.getMessage("api.fail.req.auth");
				hashMap.put("code", "401");
				hashMap.put("msg", "인증되지 않은 사용자");
			}
			else {
				list = manageService.getProcMonList(hashMap);
				int boardCount = manageService.getProcMonListCount(hashMap);
				hashMap.put("code", "200");
				hashMap.put("msg", "정상적으로 조회되었습니다");
				hashMap.put("boardList", list);
				hashMap.put("boardCount", boardCount);
			}			
		}
		catch (Exception e) {
			// TODO: handle exception
			hashMap.put("code", "500");
			hashMap.put("msg", "서버가 응답하지 않습니다");
			e.printStackTrace();
		}
		model.addAttribute("data", hashMap);
		return "jsonView";
	}
}
