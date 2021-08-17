package worrior.common.dao;

import java.util.HashMap;
import java.util.List;

import worrior.common.vo.CommonVO;

public interface CommonDAO {
	public int chkMenuAuth(CommonVO commonVO) throws Exception;
	public List<CommonVO> getSideMenu(CommonVO commonVO) throws Exception;
	public String getCurrentMenu(CommonVO commonVO) throws Exception;
	public List<CommonVO> getNavMenu(CommonVO commonVO) throws Exception;
	public int writeProcessLog(HashMap hashMap) throws Exception;
	
}
