package worrior.api.service;

import java.util.HashMap;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import worrior.api.dao.APIDAO;

@Service
public class APIService {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Inject
	private APIDAO apiDAO;
	
	public void postTracking(HashMap hashMap) throws Exception {
		apiDAO.postTracking(hashMap);
	}
	
	public void updateDeviceId(HashMap hashMap) throws Exception {
		apiDAO.updateDeviceId(hashMap);
	}
}
