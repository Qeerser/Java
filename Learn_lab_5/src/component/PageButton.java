package component;


import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import pane.RootPane;

public class PageButton extends StackPane {
	private Circle circle;
	public PageButton(int pageNumber) {
		this.circle = new Circle(25);
		circle.setFill(Color.LIGHTGRAY);
		Text t = new Text(""+pageNumber);
		t.setFont(new Font(25));
		this.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event arg0) {
			RootPane.getNavigationPane().setCurrentPage(pageNumber);
			}
		});
		this.getChildren().addAll(circle,t);
	}

	public void setActive(boolean value) {
		if(value)circle.setFill(Color.WHITE);
		else circle.setFill(Color.LIGHTGRAY);
	}
}
