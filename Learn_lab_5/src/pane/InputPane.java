package pane;

import component.TodoItem;
import javafx.event.Event;
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
        
        TextField t = new TextField();
        t.setPrefWidth(300);
        Button b = new Button();
        b.setText("Submit");
        b.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event arg0) {
				if (!t.getText().isBlank()) {
					RootPane.getDisplayPane().addTodoItem(new TodoItem(t.getText()));
					t.setText("");
				}
			}
		});
        this.getChildren().addAll(t,b);
    }
}
