package ex01.survey.service;

import javafx.scene.Parent;

public interface SurveyService {
	public void setRoot(Parent root);
	public void registerSurvey(Parent root);
	
	public void sightSelected(Parent root);
	public void ageSelected(Parent root);
	public void genderSelected(Parent root);
	
}
