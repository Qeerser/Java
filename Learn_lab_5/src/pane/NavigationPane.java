package pane;

import component.CreatePageButton;
import component.PageButton;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class NavigationPane extends VBox {
    private final ArrayList<PageButton> pageButtons = new ArrayList<>();
    private int currentPage;

    public NavigationPane() {
        this.setPrefWidth(80);
        this.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
        this.setSpacing(15);
        this.setPadding(new Insets(15));

        CreatePageButton createPageButton = new CreatePageButton();
        this.getChildren().add(createPageButton);
    }

    public void addPage() {
        // TODO: FILL CODE HERE
    	PageButton newButton = new PageButton(pageButtons.size());
    	pageButtons.add(newButton);
    	this.getChildren().add(this.getChildren().size()-1, newButton);
    	RootPane.getDisplayPane().addTodoList();
    	this.setCurrentPage(pageButtons.size()-1);
    	
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(int pageNumber) {
        if(0 <= pageNumber && pageNumber < pageButtons.size()) {
        	System.out.println(this.currentPage);
        	pageButtons.get(this.currentPage).setActive(false);
        	this.currentPage = pageNumber;
        	pageButtons.get(this.currentPage).setActive(true);
        	RootPane.getDisplayPane().setActiveTodoList(pageNumber);
        }
    }
}
