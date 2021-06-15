package ex01.member.service;

import ex01.Controller;
import ex01.database.DatabaseService;
import ex01.database.DatabaseServiceImp1;
import ex01.memberdto.memberDTO;
import javafx.scene.Parent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class MemberServiceImpl implements MemberService{

	Parent root0;
	
	TextField id = (TextField)root0.lookup("#fxId");
	TextField pw = (TextField)root0.lookup("#fxPw");
	TextField name = (TextField)root0.lookup("#fxName");
	
	memberDTO dto = new memberDTO();
	
//	dto.setId(id.getText());
//	dto.setPw(pw.getText());
//	dto.setName(name.getText());
////	dto.setHobby(hobby);
//	dto.setAge(age);
	
//	if(gender) {
//		dte.setGender(1);
//	}else {
//		dto.setGender(0);
//	}
	
//	DatabaseService ds = new DatabaseServiceImp1();
//	ds.saveMember(dto);
	
	DatabaseService ds = new DatabaseServiceImp1();
	
//	int result = ds.saveMember(dto);
//			
//	if(result == 1) {
//		Controller.cs.alert("성공적으로 가입되었습니다.");
//	}else {
//		Controller.cs.alert("가입에 실패했습니다.");
//	}

		public boolean getGender() {
				
				RadioButton man = (RadioButton)root0.lookup("#rdoMan");
				return false;
		}

}
