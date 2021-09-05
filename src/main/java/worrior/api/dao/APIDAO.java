package worrior.api.dao;

import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class APIDAO {
	@Inject
	private SqlSession sqlSession;
	
	public void postTracking(HashMap<String, Object> hashMap) throws Exception {
		sqlSession.insert("apiDAO.postTracking", hashMap);
	}
	
	public void updateDeviceId(HashMap<String, Object> hashMap) throws Exception {
		sqlSession.update("apiDAO.updateDeviceId", hashMap);
	}
		
}
