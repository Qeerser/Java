package pane;

import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;

public class RootPane extends BorderPane {
    private static NavigationPane navigationPane;
    private static DisplayPane displayPane;
    private static InputPane inputPane;

    public RootPane() {
        // TODO: FILL CODE
    	RootPane.navigationPane = new NavigationPane();
    	RootPane.displayPane = new DisplayPane();
    	RootPane.inputPane = new InputPane();
    	
    	RootPane.navigationPane.addPage();
    	
    	this.setLeft(navigationPane);
    	this.setCenter(displayPane);
    	this.setBottom(inputPane);
    	
    	
    }

    public static NavigationPane getNavigationPane() {
        return navigationPane;
    }

    public static DisplayPane getDisplayPane() {
        return displayPane;
    }

    public static InputPane getInputPane() {
        return inputPane;
    }
}
