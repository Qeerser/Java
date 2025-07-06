package Game.logic;

import java.util.ArrayList;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundControl {
	
	static Media a = new Media(ClassLoader.getSystemResource("music/GameOpen.m4a").toString());
	static Media b = new Media(ClassLoader.getSystemResource("music/break.mp3").toString());
	
	
	static ArrayList<Media> soundList = new ArrayList<>();
	
	public static void setup() {
		soundList.add(a);
		soundList.add(b);
	}
	
	public static void playSound(int index) {
		MediaPlayer play = new MediaPlayer(soundList.get(index));
		play.play();
	}
	
}
