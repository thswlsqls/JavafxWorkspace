package ex02.mediaService;

import javafx.scene.Parent;

public interface MediaServer {
	public void myStart();
	public void myPause();
	public void myStop();
	public void setMedia(Parent root, String mediaName);
	public void volumeControll();
}
