package component;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import pane.RootPane;

public class TodoItem extends HBox {

	public TodoItem(String value) {
		this.setSpacing(10);
		Text t = new Text(value);
		t.setFont(new Font(20));
		Button b = new Button("Delete");
		TodoItem todo = this;
		b.setOnMouseClicked(new EventHandler<Event>() {

			public void handle(Event arg0) {
				RootPane.getDisplayPane().removeTodoItem(todo);
				
		
			}
		});
		this.getChildren().addAll(t,b)
		;
	}
		
		
}
