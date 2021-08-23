package worrior.manage.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ManageDAO {
	@Inject
	private SqlSession sqlSession;
	
	public HashMap<String, Object> getProcMon(HashMap<String, Object> hashMap) throws Exception {
		return sqlSession.selectOne("manageDAO.getProcMon", hashMap);
	}
	
	public List<HashMap<String, String>> getProcMonList(HashMap<String, Object> hashMap) throws Exception {
		return sqlSession.selectList("manageDAO.getProcMonList", hashMap);
	}
	
	public int getProcMonListCount(HashMap<String, Object> hashMap) throws Exception {
		return sqlSession.selectOne("manageDAO.getProcMonListCount", hashMap);
	}
}
