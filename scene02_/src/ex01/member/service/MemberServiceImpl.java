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
			cmb.getItems().addAll("10��","20��","30��","30�� �̻�");
	}
	@Override
	public void memberClose() {
		Controller.cs.exit(root);
	}
	@Override
	public void memberShip() {
		boolean gender = getGender();
		System.out.println("����(true:��, false:��) : "+gender);
		int hobby = getHobby();
		//���ð�� => 1:����, 2:������, 4:��ȭ
		System.out.println("���(1.����,2.������,4.��ȭ...0���þ���) : "+hobby);
		String age = getComboBox();
		System.out.println("����� ���̴� : "+age);
		
		TextField id = (TextField)root.lookup("#fxId");
		TextField pw = (TextField)root.lookup("#fxPw");
		TextField pwChk = (TextField)root.lookup("#fxPwChk");
		TextField name = (TextField)root.lookup("#fxName");
		System.out.println("���̵� : "+id.getText());
		System.out.println("��й�ȣ : "+pw.getText());
		System.out.println("��й�ȣȮ�� : "+pwChk.getText());
		System.out.println("�̸� : "+name.getText());
		
		MemberDTO dto = new MemberDTO();
		String pw_ = pw.getText().toString();
		String pwChk_ = pwChk.getText().toString();
		
		
		if(!(pw_.equals(pwChk_))) {
			System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			Controller.cs.alert("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			pwChk.clear(); pwChk.requestFocus();
		}else {
			dto.setId(id.getText());
			dto.setPw(pw.getText());
			dto.setName(name.getText());
			dto.setHobby(hobby);
			dto.setAge(age);
			if(gender) { //true:��(1), false:��(0)
				dto.setGender(1);
			}else {
				dto.setGender(0);
			}
			DatabaseService ds = new DatabaseServiceImpl();
			
			int result = ds.saveMember(dto);
			if(result == 1) {
				Controller.cs.alert("���������� ���ԵǾ����ϴ�");
				Controller.cs.exit(root);
			}else {
				Controller.cs.alert("���Կ� �����߽��ϴ�");
			}			
		}
	}
	
	public boolean getGender() {
		RadioButton man = (RadioButton)root.lookup("#rdoMan");
		return man.isSelected();//���õǾ������� true, �ƴϸ� false
	}
	public int getHobby() {
		CheckBox music = (CheckBox)root.lookup("#chkMusic");
		CheckBox sport = (CheckBox)root.lookup("#chkSport");
		CheckBox movie = (CheckBox)root.lookup("#chkMovie");
		int hobby = 0;
		//���ð�� => 1:����, 2:������, 4:��ȭ
		if( music.isSelected() ) hobby += 1;
		if( sport.isSelected() ) hobby += 2;
		if( movie.isSelected() ) hobby += 4;
		return hobby;
	}
	public String getComboBox() {
		ComboBox<String> cmb = (ComboBox<String>)root.lookup("#cmbAge");
		String age = cmb.getValue();
		
		if(age == null) {
			Controller.cs.alert("�޺��ڽ��� �������ּ���");
		}
		return age;
	}
}









