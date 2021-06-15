package ex01.database;

import ex01.memberdto.memberDTO;

public interface DatabaseService  {
	public int saveMember(memberDTO dto);
	public String loginCheck(String userId);
	
	
}
