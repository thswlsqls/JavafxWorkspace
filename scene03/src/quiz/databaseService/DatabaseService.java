package quiz.databaseService;

import java.util.ArrayList;

import quiz.Inquiry;

public interface DatabaseService {
	public void insertSQL(Inquiry into);
	public ArrayList<Inquiry> selectSQL();
	
}
