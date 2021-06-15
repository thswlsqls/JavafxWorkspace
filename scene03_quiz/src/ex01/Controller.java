package ex01;

import java.net.URL;
import java.util.ResourceBundle;

import ex01.common.CommonClass;
import ex01.common.CommonService;
import ex01.survey.SurveyMain;
import ex01.survey.service.SurveyService;
import ex01.survey.service.SurveyServiceImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Controller implements Initializable{

	Parent root;
	SurveyService ss;
	SurveyMain sm;
	
	public static CommonService cs;
	static { cs = new CommonClass(); }
	public void cancelProc() {
		System.out.println("취소 버튼 클릭");
		Controller.cs.exit(root);
	}
	
	public void setRoot(Parent root) { this.root = root; }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setRoot(root);
		ss = new SurveyServiceImpl();
		sm = new SurveyMain();
	}
	
	public void surveyProc() {
		System.out.println("설문 등록");
		ss.registerSurvey(root);
	}
	
	public void resultProc() throws Exception {
		System.out.println("결과 확인");
//		sm.start();
	}
	
	public void checkSight() { ss.sightSelected(root); }
	public void checkAge() { ss.ageSelected(root); }
	public void checkGender() { ss.genderSelected(root); }
	
}
