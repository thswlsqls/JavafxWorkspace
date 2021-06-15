package ex01.database;

import ex01.surveydto.SurveyDTO;

public interface DatabaseService {
	
	public int saveSurvey(SurveyDTO dto);
	
	public int getdbCountOfSight(String sight);
	public int getdbCountOfAge(String age);
	public int getdbCountOfGender(String gender);
	
}
