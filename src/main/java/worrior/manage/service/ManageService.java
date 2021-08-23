package worrior.manage.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import worrior.manage.dao.ManageDAO;

@Service
public class ManageService {
private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Inject
	private ManageDAO manageDAO;
	
	public HashMap getProcMon(HashMap hashMap) throws Exception {
		return manageDAO.getProcMon(hashMap);
	}
	
	public List<HashMap<String, String>> getProcMonList(HashMap hashMap) throws Exception {
		return manageDAO.getProcMonList(hashMap);
	}
	
	public int getProcMonListCount(HashMap hashMap) throws Exception {
		return manageDAO.getProcMonListCount(hashMap);
	}
}
