package component;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import pane.RootPane;
import javafx.scene.text.Font;


public class PageButton extends StackPane{
	
	private Circle circle;
	
	public PageButton(final int pageNumber) {
		circle = new Circle(25 , Color.LIGHTGRAY);
		
		Text text =  new Text(String.valueOf(pageNumber));
		text.setFont(Font.font(25));
		
		setCursor(Cursor.HAND);
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				RootPane.getNavigationPane().setCurrentPage(pageNumber);
			}
		});
		
		this.getChildren().addAll(circle,text);
	}
	
	public void setActive(boolean value) {
		if(value) circle.setFill(Color.WHITE);
		else circle.setFill(Color.LIGHTGRAY);
	}
}
