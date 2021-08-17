package worrior.common.util.utils;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UtilsUser {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	public String getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null) {
            ip = request.getRemoteAddr();
        }
        return ip;
 
    }
	
	private boolean chkPageWhiteList(String strUrl) {
		String[] whiteListArr = {
				"/healthier/manage/notice.do"
		};
		for(int i = 0; i < whiteListArr.length; i++){
			if(whiteListArr[i].equals(strUrl)){
				return true;
			}
		}
		return false;
    }
	
	private boolean chkIpBlackList(String strIp) {
		String[] blackListArr = {
				"000.000.000.000"
		};
		for(int i = 0; i < blackListArr.length; i++){
			if(blackListArr[i].equals(strIp)){
				return true;
			}
		}
		return false;
    }
	
	@SuppressWarnings("unused")
	private int acceptExceptionUtils(Exception e) {
		try {
			StringBuffer sb = new StringBuffer();
			Date time = new Date();
			
			sb.append(time.toString() +"\n");
			sb.append(e.toString() +"\n");
			
			for(StackTraceElement stackTraceElement : e.getStackTrace()) {
				
				String className = stackTraceElement.getClassName();
				String methodName = stackTraceElement.getMethodName();
				String fileName = stackTraceElement.getFileName();
				int lineNumber = stackTraceElement.getLineNumber();
				sb.append(className + "." + methodName + "(" + fileName + "):" + lineNumber);
			}
		}
		catch (Exception ex) {
			// TODO: handle exception
			return 0;
		}
		
		return 1;
	}
}
