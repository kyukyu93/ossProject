package worrior.api.service;

import java.util.HashMap;

public interface APIService {
	public HashMap getBoard(HashMap hashMap) throws Exception;
	public HashMap postBoard(HashMap hashMap) throws Exception;
	public HashMap deleteBoard(HashMap hashMap) throws Exception;
	public HashMap putBoard(HashMap hashMap) throws Exception;

}
