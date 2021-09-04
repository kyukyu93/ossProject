package worrior.fcm.controller;

import java.io.FileInputStream;

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

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.AndroidNotification;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;

@Controller
@RequestMapping("/fcm")
public class FcmController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/message/{targetId}", method = RequestMethod.GET)
	public String toMessage(@PathVariable String targetId, HttpServletRequest req, HttpServletResponse res, Model model) {
		sendMessage(targetId, "테스트", "내용");
		log.info("/message/targetId/" + targetId);
//		model.addAttribute("result", "success");
//		model.addAttribute("msg", "안전하게 로그아웃되었습니다.");
		
	return "jsonView";
	}
	
	@RequestMapping(value = "/message.do", method = RequestMethod.GET)
    public ModelAndView messageView(HttpServletRequest req, HttpServletResponse res, Model model, ModelAndView modelAndView) throws Exception {
		return modelAndView;
	}	
	
	private void sendMessage (String tokenId, String title, String content) { 
		try {
			// 본인의 json 파일 경로 입력
			FileInputStream refreshToken = new FileInputStream("fcm//ossproj.json");

			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(refreshToken)).setDatabaseUrl("firebase-adminsdk-xm9co@ossproj-bed2d.iam.gserviceaccount.com")
					.build();

			// Firebase 처음 호출시에만 initializing 처리
			if (FirebaseApp.getApps().isEmpty()) {
				FirebaseApp.initializeApp(options);
			}

			// String registrationToken = 안드로이드 토큰 입력;
			String registrationToken = tokenId;

			// message 작성
			Message msg = Message.builder().setAndroidConfig(AndroidConfig.builder().setTtl(3600 * 1000) // 1 hour in // milliseconds
					.setPriority(AndroidConfig.Priority.NORMAL)
					.setNotification(AndroidNotification.builder().setTitle(title).setBody(content)
							.setIcon("stock_ticker_update").setColor("#f45342").build())
					.build()).setToken(registrationToken).build();

			// 메세지를 FirebaseMessaging 에 보내기
			String response = FirebaseMessaging.getInstance().send(msg);
			// 결과 출력
			log.info("Successfully sent message: " + response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
