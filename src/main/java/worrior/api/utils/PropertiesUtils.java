package worrior.api.utils;

import java.io.Reader;
import java.util.HashMap;
import java.util.Properties;
import org.apache.ibatis.io.Resources;

public class PropertiesUtils {

	public String getStatusMessage(String name) throws Exception{
		String strReturn = "오류가 발생했습니다";
		String resource = "resources/APIRes.properties";
        Properties properties = new Properties();
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            properties.load(reader);
            strReturn = properties.getProperty(name + ".msg");
        } catch (Exception e) {
//            e.printStackTrace();
        }
		return strReturn;
	}
	
	public String getStatusCode(String name) {
		String strReturn = "오류가 발생했습니다";
		String resource = "resources/APIRes.properties";
        Properties properties = new Properties();
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            properties.load(reader);
            strReturn = properties.getProperty(name + ".code");
        } catch (Exception e) {
//            e.printStackTrace();
        }
		return strReturn;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public HashMap getMessage(String name) {
		HashMap hashMap = new HashMap();
		hashMap.put("msg", "에러가 발생했습니다");
		hashMap.put("code", "500");
		String resource = "";
        Properties properties = new Properties();
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            properties.load(reader);
            hashMap.put("msg",properties.getProperty(name + ".msg"));
            System.out.println(hashMap.get("msg"));
            hashMap.put("code",properties.getProperty(name + ".code"));
            System.out.println(hashMap.get("code"));
        } catch (Exception e) {
//        	e.printStackTrace();
        }
		return hashMap;
	}
}
