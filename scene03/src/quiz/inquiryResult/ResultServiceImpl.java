package quiz.inquiryResult;
import java.util.ArrayList;

import quiz.Inquiry;
import javafx.scene.Parent;
import javafx.scene.control.RadioButton;

public class ResultServiceImpl implements ResultService{
	public Inquiry result(Parent root) {
		Inquiry into = new Inquiry();
		ArrayList<RadioButton> radioTravel = new ArrayList<>();
		for(int i=0;i < 3;i++) {
			radioTravel.add((RadioButton)root.lookup("#radioTr"+i));
			if(radioTravel.get(i).isSelected())
				// 0:해외여행, 1:국내여행,2:없다
				into.setTravel(i);
		}
		ArrayList<RadioButton> radioAge = new ArrayList<>();
		for(int i=0;i<4;i++) {
			radioAge.add((RadioButton)root.lookup("#radioAge"+i));
			if(radioAge.get(i).isSelected())
				into.setAge(i);
		}
		RadioButton man = (RadioButton)root.lookup("#radioGender1");
		if(man.isSelected())
			into.setGender(1);
		else
			into.setGender(0);
		return into;
	}
}
