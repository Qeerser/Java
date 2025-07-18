package application;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class Utility {
	public static GameCoreWrapper setUpGameCore(GameCoreWrapper gameCoreWrapper, BeatMap beatMap, NoteTiles noteTiles) {
		if (gameCoreWrapper != null) {
			gameCoreWrapper.interrupt();
		}
		gameCoreWrapper = new GameCoreWrapper(beatMap, noteTiles);
		gameCoreWrapper.start();
		return gameCoreWrapper;
	}

	public static ScoreProcessorWrapper setUpScoreProcessor(ScoreProcessorWrapper scoreProcessorWrapper,
			BeatMap beatMap, KeyPressTiles keyPressTiles, Label hitScoreLabel, Label missScoreLabel) {
		if (scoreProcessorWrapper != null) {
			scoreProcessorWrapper.interrupt();
		}
		scoreProcessorWrapper = new ScoreProcessorWrapper(beatMap, keyPressTiles, hitScoreLabel, missScoreLabel);
		scoreProcessorWrapper.start();
		return scoreProcessorWrapper;
	}

	public static void updateLabel(Label label, String newText) {
		Thread thread = new Thread(() -> {
			try {
				Thread.sleep(10);
				Platform.runLater(new Runnable() {
					public void run() {	
						label.setText(newText);
					}
					});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		thread.start();
		}

	public static void cleanUp(Menu menu) {
		menu.getGameCoreWrapper().interrupt();
		menu.getScoreProcessorWrapper().interrupt();
	}
}
