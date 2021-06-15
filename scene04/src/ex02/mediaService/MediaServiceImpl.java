package ex02.mediaService;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class MediaServiceImpl implements MediaServer{
	MediaPlayer mediaPlayer;
	MediaView mediaView;
	Button btnPlay, btnPause, btnStop;
	
	Label labelTime;
	ProgressBar progressBar;
	ProgressIndicator progressIndicator;
	Slider slider;
	
	@Override
	public void volumeControll() {
//		System.out.println(slider.getValue()/100.0);
		mediaPlayer.setVolume(slider.getValue()/100.0);
	}
	
	@Override
	public void myStart() {
		mediaPlayer.setVolume(0.1);
		slider.setValue(10.0);
		
		mediaPlayer.play();
	}

	@Override
	public void myPause() {
		mediaPlayer.pause();
	}

	@Override
	public void myStop() {
		mediaPlayer.stop();
	}
	private void setController(Parent root) {
		mediaView = (MediaView)root.lookup("#fxMediaView");
		btnPlay = (Button)root.lookup("#btnPlay");
		btnPause = (Button)root.lookup("#btnPause");
		btnStop = (Button)root.lookup("#btnStop");
		
		labelTime = (Label)root.lookup("#labelTime");
		progressBar = (ProgressBar)root.lookup("#progressBar");
		progressIndicator =(ProgressIndicator)root.lookup("#progressIndicator");
		slider = (Slider)root.lookup("#slider");
	}
	@Override
	public void setMedia(Parent root, String mediaName) {
		setController(root);
		Media media = new Media(getClass().getResource(mediaName).toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		
//		실행 전
		mediaPlayer.setOnReady(() -> {
			btnPlay.setDisable(false);
			btnPause.setDisable(true);
			btnStop.setDisable(true);
			mediaPlayer.currentTimeProperty().addListener((obj, oldValue, newValue)->{
				double progress = 
						mediaPlayer.getCurrentTime().toSeconds() /
						mediaPlayer.getTotalDuration().toSeconds();
				progressBar.setProgress(progress);
				progressIndicator.setProgress(progress);
				labelTime.setText((int)mediaPlayer.getCurrentTime().toSeconds()+" / "
													+ (int)mediaPlayer.getTotalDuration().toSeconds()+" sec");
			});
		});
//		실행 도중
		mediaPlayer.setOnPlaying(()->{
			btnPlay.setDisable(true);
			btnPause.setDisable(false);
			btnStop.setDisable(false);
		});
//		일시 정지시
		mediaPlayer.setOnPaused(()->{
			btnPlay.setDisable(false);
			btnPause.setDisable(true);
			btnStop.setDisable(false);
		});
//		종료시
		mediaPlayer.setOnEndOfMedia(()->{
			btnPlay.setDisable(false);
			btnPause.setDisable(true);
			btnStop.setDisable(true);
			
			mediaPlayer.stop();
//			mediaPlayer.seek(mediaPlayer.getStartTime());
		});
//		정지시
		mediaPlayer.setOnStopped(()->{
			btnPlay.setDisable(false);
			btnPause.setDisable(true);
			btnStop.setDisable(true);
		});
	}
}
