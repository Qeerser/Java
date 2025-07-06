package pane;

import component.TodoItem;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class InputPane extends HBox {
	public InputPane() {
		this.setPrefHeight(70);
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
		this.setSpacing(20);
		this.setAlignment(Pos.CENTER);
		
		final TextField textField = new TextField();
		textField.setPrefWidth(300);

		Button smButton = new Button("Submit");
		smButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (!textField.getText().isEmpty()) {
					TodoItem todoitem = new TodoItem(textField.getText());
					RootPane.getDisplayPane().addTodoItem(todoitem);
					textField.setText("");
				}
			}
		});

		this.getChildren().addAll(textField, smButton);
	}
}
