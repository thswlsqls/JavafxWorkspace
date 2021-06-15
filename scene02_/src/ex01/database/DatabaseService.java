package ex01.database;

import java.util.HashMap;

import ex01.memberdto.MemberDTO;

public interface DatabaseService {
	public int saveMember( MemberDTO dto );
	public String loginCheck(String userId);
	public HashMap<String, String> printUserInfo(String userId);
}
