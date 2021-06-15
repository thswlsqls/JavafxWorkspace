package ex01.member.service;

import ex01.Controller;
import ex01.database.DataBaseService;
import ex01.database.DatabaseServiceImpl;
import ex01.memberDTO.MemberDTO;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class MemberServiceImpl implements MemberService{

	Parent root;
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}

	@Override
	public void memberShip() {
		TextField id = (TextField)root.lookup("#fxId");
		TextField pw = (TextField)root.lookup("#fxPw");
		TextField nickName = (TextField)root.lookup("#fxName");
		CheckBox chkId = (CheckBox)root.lookup("#chkId");
		CheckBox chkName = (CheckBox)root.lookup("#chkName");
		
		if(chkName.isSelected() == false) Controller.cs.alert("�г��� �ߺ�üũ ���ּ���");
		if(chkId.isSelected() == false) Controller.cs.alert("���̵� �ߺ�üũ ���ּ���");
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id.getText());
		dto.setPw(pw.getText());
		dto.setNickName(nickName.getText());
		
		if(chkName.isSelected() == true && chkId.isSelected() == true) {
			DataBaseService ds = new DatabaseServiceImpl();
			int result = ds.saveMember(dto);
			if(result == 1) {
				Controller.cs.alert("���ԵǾ����ϴ�");
				Controller.cs.exit(root);
			} else {
				Controller.cs.alert("���� �����Ͽ����ϴ�");
			}
		} 
		
		
	}

	@Override
	public void idCheck() {
		DataBaseService ds = new DatabaseServiceImpl();
		TextField id = (TextField)root.lookup("#fxId");
		if(ds.chkId(id.getText()) == true) {
			Controller.cs.alert("���̵� �ߺ�, �ٸ� ���̵� �Է��ϼ���");
		} else{
			Controller.cs.alert("���̵� �ߺ� �ƴմϴ�, ����ϼ���");
		}
	}

	@Override
	public void nameCheck() {
		DataBaseService ds = new DatabaseServiceImpl();
		TextField nickName = (TextField)root.lookup("#fxName");
		if(ds.chkName(nickName.getText()) == true) {
			Controller.cs.alert("�г��� �ߺ�, �ٸ� �г��� �Է��ϼ���");
		} else{
			Controller.cs.alert("�г��� �ߺ� �ƴմϴ�, ����ϼ���");
		}
		
	}
	
	
	

}
