package main;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InventoryGame extends Application {

    // sample inventory data
    private String[] inventoryItems = {"Sword", "Shield", "Potion", "Key"};
    private int[] inventoryQuantities = {1, 1, 3, 2};
    
    // sample player data
    private String playerName = "Player 1";
    private int playerHealth = 100;
    private int playerLevel = 1;
    
    @Override
    public void start(Stage stage) {
        // create a VBox to hold the player information
        VBox playerBox = new VBox();
        playerBox.setSpacing(10);
        
        // add the player information as Labels to the VBox
        Label nameLabel = new Label("Name: " + playerName);
        Label healthLabel = new Label("Health: " + playerHealth);
        Label levelLabel = new Label("Level: " + playerLevel);
        playerBox.getChildren().addAll(nameLabel, healthLabel, levelLabel);
        
        // create a TableView to hold the inventory information
        TableView<InventoryItem> inventoryTable = new TableView<>();
        inventoryTable.setItems(FXCollections.observableArrayList(
                new InventoryItem("Sword", 1),
                new InventoryItem("Shield", 1),
                new InventoryItem("Potion", 3),
                new InventoryItem("Sword", 1),
                new InventoryItem("Sword", 1),
                new InventoryItem("Sword", 1),
                new InventoryItem("Sword", 1),
                new InventoryItem("Sword", 1),
                new InventoryItem("Sword", 1),
                new InventoryItem("Sword", 1),
                new InventoryItem("Sword", 1),
                new InventoryItem("Sword", 1),
                new InventoryItem("Sword", 1),
                new InventoryItem("Key", 2)
                
        ));
        
        // create columns for the inventory table
        TableColumn<InventoryItem, String> itemColumn = new TableColumn<>("Item");
        itemColumn.setCellValueFactory(new PropertyValueFactory<>("item"));
        
        TableColumn<InventoryItem, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        
        inventoryTable.getColumns().addAll(itemColumn, quantityColumn);
        
        // create a SplitPane to display the player information and inventory table side by side
        SplitPane splitPane = new SplitPane();
        splitPane.setOrientation(Orientation.HORIZONTAL);
        splitPane.getItems().addAll(playerBox, inventoryTable);
        
        // create a Scene with the SplitPane as its root node
        Scene scene = new Scene(splitPane, 600, 400);
        
        // set the Scene on the Stage and show it
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static class InventoryItem {
        private final String item;
        private final int quantity;

        public InventoryItem(String item, int quantity) {
            this.item = item;
            this.quantity = quantity;
        }

        public String getItem() {
            return item;
        }

        public int getQuantity() {
            return quantity;
        }
    }
}