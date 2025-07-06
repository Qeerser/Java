package component;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import pane.RootPane;

public class CreatePageButton extends StackPane {
	public CreatePageButton() {
		Circle c = new Circle(20);
		c.setFill(Color.LIGHTGRAY);
		Text t = new Text("+");
		t.setFont(new Font(20));
		this.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event arg0) {
			RootPane.getNavigationPane().addPage();
			}
		});
		this.getChildren().addAll(c,t);
	}
}
