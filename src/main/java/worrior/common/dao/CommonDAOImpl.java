package worrior.common.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import worrior.common.vo.CommonVO;

@Repository
public class CommonDAOImpl implements CommonDAO{
	
	@Inject
	private SqlSession sqlSession;
	public int chkMenuAuth(CommonVO commonVO) throws Exception {
		return sqlSession.selectOne("commonDAO.menuAuthChk", commonVO);
	}
	public List<CommonVO> getSideMenu(CommonVO commonVO) throws Exception {
		return sqlSession.selectList("commonDAO.getSideMenu", commonVO);
	}
	
	public String getCurrentMenu(CommonVO commonVO) throws Exception {
		return sqlSession.selectOne("commonDAO.getCurrentMenu", commonVO);
	}
	
	public List<CommonVO> getNavMenu(CommonVO commonVO) throws Exception {
		return sqlSession.selectList("commonDAO.getNavMenu", commonVO);
	}
	
	public int writeProcessLog(HashMap hashMap) throws Exception {
		return sqlSession.insert("commonDAO.insertProcessLog", hashMap);
	}
}
