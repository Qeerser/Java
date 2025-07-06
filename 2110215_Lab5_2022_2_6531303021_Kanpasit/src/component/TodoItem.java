package component;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import pane.RootPane;

public class TodoItem extends HBox{
	
	public TodoItem(String value) {
		this.setSpacing(10);
		
		Text text =  new Text(value);
		text.setFont(Font.font(20));
		
		Button button = new Button("Delete");
		
		final TodoItem toDo = this;
		button.setOnAction(new EventHandler<ActionEvent>() {
		      public void handle(ActionEvent event) {
		    	  RootPane.getDisplayPane().removeTodoItem(toDo);
			}
		});
		
		this.getChildren().addAll(text, button);
	}
}