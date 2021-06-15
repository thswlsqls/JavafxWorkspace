package ex01.survey.service;

import ex01.Controller;
import ex01.database.DatabaseService;
import ex01.database.DatabaseServiceImpl;
import ex01.surveydto.SurveyDTO;
import javafx.scene.Parent;
import javafx.scene.control.RadioButton;

public class SurveyServiceImpl implements SurveyService{

	Parent root;
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	@Override
	public void registerSurvey(Parent root) {
		setRoot(root);
		
		String sight = getSight();
		String age = getAge();
		String gender = getGender();
				
		SurveyDTO dto = new SurveyDTO();
		dto.setSight(sight); dto.setAge(age); dto.setGender(gender);
		
		DatabaseService ds = new DatabaseServiceImpl();
		int result = ds.saveSurvey(dto);
		if(result==1) {
			System.out.println("선호여행지: "+sight+" "+"나이: "+age+" "+"성별: "+gender);
//			System.out.println("설문의 응답이 성공적으로 저장되었습니다.");
//			Controller.cs.alert("설문의 응답이 성공적으로 저장되었습니다.");
//			Controller.cs.exit(root);
		}else {
			Controller.cs.alert("설문의 응답을 저장하는 데 실패하였습니다.");
		}
	}
	
	public String getSight() {
		setRoot(root);
		RadioButton foreign = (RadioButton)root.lookup("#rdoForeign");
		RadioButton domestic = (RadioButton)root.lookup("#rdoDomestic");
		RadioButton none = (RadioButton)root.lookup("#rdoNone");
		
		if(foreign.isSelected()) {
			return "해외여행";
		}else if(domestic.isSelected()) {
			return "국내여행";
		}else {
			return "없음";
		}
		
	}
	
	public String getAge() {
		setRoot(root);
		RadioButton teen = (RadioButton)root.lookup("#rdo10");
		RadioButton twenties = (RadioButton)root.lookup("#rdo20");
		RadioButton thirties = (RadioButton)root.lookup("#rdo30");
		RadioButton forties = (RadioButton)root.lookup("#rdo40");
		
		if(teen.isSelected()) {
			return "10대";
		}else if(twenties.isSelected()) {
			return "20대";
		}else if(thirties.isSelected()) {
			return "30대";
		}else {
			return "40대";
		}
	}
	
	public String getGender() {
		setRoot(root);
		RadioButton man = (RadioButton)root.lookup("#rdoMan");
		RadioButton woman = (RadioButton)root.lookup("#rdoWoman");
		
		if(man.isSelected()) {
			return "남성";
		}else {
			return "여성";
		}
		
	}

	@Override
	public void sightSelected(Parent root) {
		setRoot(root);
		
		RadioButton Foreign = (RadioButton)root.lookup("#rdoForeign");
		RadioButton Domestic = (RadioButton)root.lookup("#rdoDomestic");
		RadioButton None = (RadioButton)root.lookup("#rdoNone");
		
		if(Foreign.isSelected()) {
			Domestic.setSelected(false); None.setSelected(false);
		}else if(Domestic.isSelected()) {
			Foreign.setSelected(false); None.setSelected(false);
		}else {
			Foreign.setSelected(false); Domestic.setSelected(false);
		}
	}

	@Override
	public void ageSelected(Parent root) {
		setRoot(root);
		
		RadioButton teen = (RadioButton)root.lookup("#rdo10");
		RadioButton tewnties = (RadioButton)root.lookup("#rdo20");
		RadioButton thirties = (RadioButton)root.lookup("#rdo30");
		RadioButton forties = (RadioButton)root.lookup("#rdo40");
		
		if(teen.isSelected()) {
			tewnties.setSelected(false); thirties.setSelected(false); forties.setSelected(false);
		}else if(tewnties.isSelected()) {
			teen.setSelected(false); thirties.setSelected(false); forties.setSelected(false);
		}else if(thirties.isSelected()){
			teen.setSelected(false); tewnties.setSelected(false); forties.setSelected(false);
		}else {
			teen.setSelected(false); tewnties.setSelected(false); thirties.setSelected(false);
		}
		
	}

	@Override
	public void genderSelected(Parent root) {
		setRoot(root);
		
		RadioButton man = (RadioButton)root.lookup("#rdoMan");
		RadioButton woman = (RadioButton)root.lookup("#rdoWoman");
		
		if(man.isSelected()) {
			woman.setSelected(false); 
		}else{
			man.setSelected(false); 
		}
	}

	
	
}
