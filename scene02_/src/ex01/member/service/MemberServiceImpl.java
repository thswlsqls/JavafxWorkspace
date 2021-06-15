package ex01.member.service;

import ex01.Controller;
import ex01.database.DatabaseService;
import ex01.database.DatabaseServiceImpl;
import ex01.memberdto.MemberDTO;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class MemberServiceImpl implements MemberService{
	Parent root;
	@Override
	public void setRoot(Parent root) {
		this.root = root;
		addComboBox();
	}
	private void addComboBox() {
		ComboBox<String> cmb = (ComboBox<String>)root.lookup("#cmbAge");
		if(cmb != null)
			cmb.getItems().addAll("10대","20대","30대","30대 이상");
	}
	@Override
	public void memberClose() {
		Controller.cs.exit(root);
	}
	@Override
	public void memberShip() {
		boolean gender = getGender();
		System.out.println("성별(true:남, false:여) : "+gender);
		int hobby = getHobby();
		//선택결과 => 1:음악, 2:스포츠, 4:영화
		System.out.println("취미(1.음악,2.스포츠,4.영화...0선택없음) : "+hobby);
		String age = getComboBox();
		System.out.println("당신의 나이는 : "+age);
		
		TextField id = (TextField)root.lookup("#fxId");
		TextField pw = (TextField)root.lookup("#fxPw");
		TextField pwChk = (TextField)root.lookup("#fxPwChk");
		TextField name = (TextField)root.lookup("#fxName");
		System.out.println("아이디 : "+id.getText());
		System.out.println("비밀번호 : "+pw.getText());
		System.out.println("비밀번호확인 : "+pwChk.getText());
		System.out.println("이름 : "+name.getText());
		
		MemberDTO dto = new MemberDTO();
		String pw_ = pw.getText().toString();
		String pwChk_ = pwChk.getText().toString();
		
		
		if(!(pw_.equals(pwChk_))) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			Controller.cs.alert("비밀번호가 일치하지 않습니다.");
			pwChk.clear(); pwChk.requestFocus();
		}else {
			dto.setId(id.getText());
			dto.setPw(pw.getText());
			dto.setName(name.getText());
			dto.setHobby(hobby);
			dto.setAge(age);
			if(gender) { //true:남(1), false:여(0)
				dto.setGender(1);
			}else {
				dto.setGender(0);
			}
			DatabaseService ds = new DatabaseServiceImpl();
			
			int result = ds.saveMember(dto);
			if(result == 1) {
				Controller.cs.alert("성공적으로 가입되었습니다");
				Controller.cs.exit(root);
			}else {
				Controller.cs.alert("가입에 실패했습니다");
			}			
		}
	}
	
	public boolean getGender() {
		RadioButton man = (RadioButton)root.lookup("#rdoMan");
		return man.isSelected();//선택되어있으면 true, 아니면 false
	}
	public int getHobby() {
		CheckBox music = (CheckBox)root.lookup("#chkMusic");
		CheckBox sport = (CheckBox)root.lookup("#chkSport");
		CheckBox movie = (CheckBox)root.lookup("#chkMovie");
		int hobby = 0;
		//선택결과 => 1:음악, 2:스포츠, 4:영화
		if( music.isSelected() ) hobby += 1;
		if( sport.isSelected() ) hobby += 2;
		if( movie.isSelected() ) hobby += 4;
		return hobby;
	}
	public String getComboBox() {
		ComboBox<String> cmb = (ComboBox<String>)root.lookup("#cmbAge");
		String age = cmb.getValue();
		
		if(age == null) {
			Controller.cs.alert("콤보박스를 선택해주세요");
		}
		return age;
	}
}









