package pane;

import component.TodoItem;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class DisplayPane extends VBox {
    private final ArrayList<ArrayList<TodoItem>> todoLists = new ArrayList<>();
    public DisplayPane() {
    	this.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        this.setPadding(new Insets(20, 20, 20, 20));
        this.setSpacing(10);
    }

    public void addTodoList() {
    	this.todoLists.add(new ArrayList<>());
    }

    public void setActiveTodoList(int index) {
    	 if(0 <= index && index < todoLists.size()) {
    		this.getChildren().clear();
    		this.todoLists.get(index).forEach(TodoItem -> this.getChildren().add(TodoItem));			  		  		
    	 }
    }

    public void addTodoItem(TodoItem todoItem) {
        int currentPage = RootPane.getNavigationPane().getCurrentPage();
        this.todoLists.get(currentPage).add(todoItem);
        this.getChildren().add(todoItem);
    }

    public void removeTodoItem(TodoItem todoItem) {
        int currentPage = RootPane.getNavigationPane().getCurrentPage();
        this.todoLists.get(currentPage).remove(todoItem);
        this.getChildren().remove(todoItem);
    }
}
