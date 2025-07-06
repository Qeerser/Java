package main;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Random;

public class PokemonBattle extends Application {
	private Pokemon playerPokemon;
	private Pokemon opponentPokemon;
	private ButtonBase move1Button;
	private ButtonBase move2Button;
	private Parent mainPane;
	private Label playerPokemonLabel;
	private Label opponentPokemonLabel;
	private Label move1Label;
	private Label move2Label;
	private Label move3Label;
	private Label move4Label;
	private Button move3Button;
	private Button move4Button;
	private Labeled playerHealthLabel;
	private Labeled opponentHealthLabel;
	private Stage primaryStage;
	private Object moveListView;
	private Labeled messageLabel;
	
	public static void main(String[] args) {
	    launch(args);
	}
	
	public void start(Stage primaryStage) {
	    // Set up the GUI
	    setupGui();
	    
	    // Create player and opponent Pokemon objects
	    playerPokemon = new Pokemon("Pikachu", Type.ELECTRIC, 100);
	    playerPokemon.addMove(new Move("Thunderbolt", Type.ELECTRIC, 90));
	    playerPokemon.addMove(new Move("Quick Attack", Type.NORMAL, 40));
	    
	    opponentPokemon = new Pokemon("Charmander", Type.FIRE, 100);
	    opponentPokemon.addMove(new Move("Ember", Type.FIRE, 40));
	    opponentPokemon.addMove(new Move("Scratch", Type.NORMAL, 30));
	    
	    // Show the game
	    showGame();
	    
	    // Set up event handlers for move buttons
	    move1Button.setOnAction(e -> {
	        playerTurn(playerPokemon.getMove(1));
	    });
	    
	    move2Button.setOnAction(e -> {
	        playerTurn(playerPokemon.getMove(2));
	    });
	    
	    // Set up the stage and show the GUI
	    Scene scene = new Scene(mainPane, 800, 600);
	    primaryStage.setTitle("Pokemon Battle");
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
	
	private void setupGui() {
	    // Create labels for player and opponent Pokemon names and health
	    playerPokemonLabel = new Label(playerPokemon.getName() + " - HP: " + playerPokemon.getHealth());
	    opponentPokemonLabel = new Label(opponentPokemon.getName() + " - HP: " + opponentPokemon.getHealth());

	    // Create labels for move names
	    move1Label = new Label(playerPokemon.getMove(1).getName());
	    move2Label = new Label(playerPokemon.getMove(2).getName());
	    move3Label = new Label(playerPokemon.getMove(3).getName());
	    move4Label = new Label(playerPokemon.getMove(4).getName());

	    // Create buttons for each move
	    move1Button = new Button("Use");
	    move2Button = new Button("Use");
	    move3Button = new Button("Use");
	    move4Button = new Button("Use");

	    // Add event listeners to each move button
	    move1Button.setOnAction(e -> playerTurn(playerPokemon.getMove(1)));
	    move2Button.setOnAction(e -> playerTurn(playerPokemon.getMove(2)));
	    move3Button.setOnAction(e -> playerTurn(playerPokemon.getMove(3)));
	    move4Button.setOnAction(e -> playerTurn(playerPokemon.getMove(4)));

	    // Create a VBox to hold the player and opponent Pokemon labels
	    VBox pokemonBox = new VBox();
	    pokemonBox.getChildren().addAll(playerPokemonLabel, opponentPokemonLabel);

	    // Create a VBox to hold the move labels and buttons
	    VBox moveBox = new VBox();
	    moveBox.getChildren().addAll(move1Label, move1Button, move2Label, move2Button, move3Label, move3Button, move4Label, move4Button);

	    // Create an HBox to hold the two VBoxes
	    HBox hbox = new HBox();
	    hbox.setSpacing(50);
	    hbox.setAlignment(Pos.CENTER);
	    hbox.getChildren().addAll(pokemonBox, moveBox);

	    // Create the scene and add the HBox to it
	    Scene scene = new Scene(hbox, 800, 600);
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
	
	private void showGame() {
	    playerHealthLabel.setText(playerPokemon.getName() + ": " + playerPokemon.getCurrentHealth() + "/" + playerPokemon.getMaxHealth());
	    opponentHealthLabel.setText(opponentPokemon.getName() + ": " + opponentPokemon.getCurrentHealth() + "/" + opponentPokemon.getMaxHealth());

	    ObservableList<String> moves = FXCollections.observableArrayList();
	    for (Move move : playerPokemon.getMoves()) {
	        moves.add(move.getName());
	    }
//	    moveListView.setItems(moves);

	    if (playerPokemon.getCurrentHealth() <= 0) {
//	        moveListView.setDisable(true);
//	        fightButton.setDisable(true);
	        messageLabel.setText("You lose!");
	    } else if (opponentPokemon.getCurrentHealth() <= 0) {
//	        moveListView.setDisable(true);
//	        fightButton.setDisable(true);
	        messageLabel.setText("You win!");
	    }
	}
	public void playerTurn(Move move) {
	    // Calculate damage
	    int damage = Pokemon.calculateDamage(move.getType(), playerPokemon.getType(), move.getPower(), playerPokemon.getDefense());

	    // Deal damage to opponent
	    opponentPokemon.takeDamage(damage);

	    // Update GUI
	    showGame();

	    // Check if opponent is defeated
	    if (opponentPokemon.getHealth() == 0) {
	        Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Victory!");
	        alert.setHeaderText("You have defeated the opponent!");
	        alert.showAndWait();

	        // End the game
	        System.exit(0);
	    }

	    // Opponent's turn
	    opponentTurn();
	}
	private void opponentTurn() {
	    // select a random move for the opponent Pokemon
	    int moveIndex = (int) (Math.random() * opponentPokemon.getMoves().size());
	    Move move = opponentPokemon.getMoves().get(moveIndex);
	    
	    // calculate damage and update playerPokemon's health
	    int damage = Pokemon.calculateDamage(move.getType(), 
	                                                opponentPokemon.getType(),
	                                                move.getPower(),
	                                                playerPokemon.getDefense());
	    playerPokemon.setHealth(playerPokemon.getCurrentHealth() - damage);

	    // update the GUI to display the results of the opponent's turn
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Opponent's Turn");
	    alert.setHeaderText(opponentPokemon.getName() + " used " + move.getName() + "!");
	    alert.setContentText(playerPokemon.getName() + " lost " + damage + " HP!");
	    alert.showAndWait();

	    // check if the player's Pokemon has fainted
	    if (playerPokemon.getCurrentHealth() <= 0) {
	        gameOver("You lose! Better luck next time.");
	    } else {
	        // update the GUI to display the player's turn
	        showGame();
	    }
	}
	private void gameOver(String string) {
		// TODO Auto-generated method stub
		
	}

	public static int calculateDamage(Type attackType, Type defenseType, int attack, int defense) {
	    double effectiveness = TypeChart.getEffectiveness(attackType, defenseType);
	    double STAB = 1.0;
	    if (attackType == Type.FIRE && attackType == Type.GRASS && attackType == Type.WATER && attackType == Type.ELECTRIC) {
	        STAB = 1.5;
	    }
	    int damage = (int) ((int) ((((((2.0 * 50) / 5) + 2) * attack * STAB / defense) / 50) + 2) * effectiveness);
	    return damage;
	}

//	private Pokemon playerPokemon = new Pokemon("Pikachu", 5, 20, 10, 5);
//	private Pokemon opponentPokemon = new Pokemon("Squirtle", 5, 20, 10, 5);
//    private Random random = new Random();
//    private boolean isPlayerTurn = true;
//    private int playerPokemonHP = 100;
//    private int opponentPokemonHP = 100;
//    private Label playerNameLabel = new Label(playerPokemonName + " (HP: " + playerPokemonHP + ")");
//    private Label opponentNameLabel = new Label(opponentPokemonName + " (HP: " + opponentPokemonHP + ")");
//    private Label messageLabel = new Label("Select a move.");
//    Button move1Button;
//    Button move2Button;
//    Button move3Button;
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) {
//        // Create player's Pokemon
//        playerPokemon = new Pokemon("Charmander", 5, 20, 10, 5);
//
//        // Create opponent's Pokemon
//        opponentPokemon = new Pokemon("Squirtle", 5, 20, 10, 5);
//
//        GridPane root = guiSetup();
//
//        Scene scene = new Scene(root, 400, 300);
//
//        primaryStage.setTitle("Pokemon Battle");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    private GridPane guiSetup() {
//        // Set up GUI
//        GridPane root = new GridPane();
//        root.setPadding(new Insets(10));
//        root.setHgap(10);
//        root.setVgap(10);
//
//        Label playerLabel = new Label("Player: " + playerPokemon.getName() + " Lv." + playerPokemon.getLevel() + " HP: " + playerPokemon.getHp() + "/" + playerPokemon.getMaxHp());
//        Label opponentLabel = new Label("Opponent: " + opponentPokemon.getName() + " Lv." + opponentPokemon.getLevel() + " HP: " + opponentPokemon.getHp() + "/" + opponentPokemon.getMaxHp());
//
//        Button move1Button = new Button("Move 1");
//        move1Button.setOnAction(e -> {
//            playerTurn(1);
//            opponentTurn();
//            showGame(root, playerLabel, opponentLabel, move1Button);
//        });
//
//        Button move2Button = new Button("Move 2");
//        move2Button.setOnAction(e -> {
//            playerTurn(2);
//            opponentTurn();
//            showGame(root, playerLabel, opponentLabel, move2Button);
//        });
//
//        Button move3Button = new Button("Move 3");
//        move3Button.setOnAction(e -> {
//            playerTurn(3);
//            opponentTurn();
//            showGame(root, playerLabel, opponentLabel, move3Button);
//        });
//
//        Button move4Button = new Button("Move 4");
//        move4Button.setOnAction(e -> {
//            playerTurn(4);
//            opponentTurn();
//            showGame(root, playerLabel, opponentLabel, move4Button);
//        });
//
//        root.add(playerLabel, 0, 0);
//        root.add(opponentLabel, 2, 0);
//        root.add(move1Button, 0, 1);
//        root.add(move2Button, 1, 1);
//        root.add(move3Button, 0, 2);
//        root.add(move4Button, 1, 2);
//
//        return root;
//    }
//    
//    private void playerTurn(int moveNum) {
//        Move move = playerPokemon.getMove(moveNum);
//
//        int damage = calculateDamage(playerPokemon, opponentPokemon, move);
//
//        opponentPokemon.takeDamage(damage);
//
//        System.out.println(playerPokemon.getName() + " used " + move.getName() + " and dealt " + damage + " damage to " + opponentPokemon.getName());
//    }
//    
//    public static int calculateDamage(Pokemon attacker, Pokemon defender, Move move) {
//        double effectiveness = TypeChart.getEffectiveness(move.getType(), defender.getType());
//        double attackStat = move.getCategory() == Category.PHYSICAL ? attacker.getAttack() : attacker.getSpecial();
//        double defenseStat = move.getCategory() == Category.PHYSICAL ? defender.getDefense() : defender.getSpecial();
//        double level = attacker.getLevel();
//        double basePower = move.getPower();
//
//        // Calculate damage using the formula from the official Pokémon games:
//        // damage = (((2 * level + 10) / 250) * (attack / defense) * basePower + 2) * modifier
//        double modifier = Math.random() * (1.0 - 0.85) + 0.85;
//        double damage = (((2 * level + 10) / 250.0) * (attackStat / defenseStat) * basePower + 2) * modifier * effectiveness;
//
//        return (int) damage;
//    }
//
//
//    
//    private void showGame(Stage primaryStage) {
//        // Create a button to open the bag
//        Button bagButton = new Button("Bag");
//        bagButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                showBag();
//            }
//        });
//
//        // Create buttons for each move
//        Button move1Button = new Button("Move 1");
//        Button move2Button = new Button("Move 2");
//        Button move3Button = new Button("Move 3");
//
//        // Set event handlers for each move button
//        move1Button.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                handleMove1();
//            }
//        });
//
//        move2Button.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                // Replace with logic for Move 2
//            }
//        });
//
//        move3Button.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                // Replace with logic for Move 3
//            }
//        });
//
//        // Create a grid pane for the moves
//        GridPane movesGridPane = new GridPane();
//        movesGridPane.setAlignment(Pos.CENTER);
//        movesGridPane.setHgap(10);
//        movesGridPane.setVgap(10);
//        movesGridPane.add(move1Button, 0, 0);
//        movesGridPane.add(move2Button, 0, 1);
//        movesGridPane.add(move3Button, 0, 2);
//
//        // Create a label for the player's name and level
//        Label playerLabel = new Label("Player (Level 5)");
//
//        // Create a label for the opponent's name and level
//        Label opponentLabel = new Label("Opponent (Level 5)");
//
//        // Create labels for the player and opponent HP
//        Label playerHpLabel = new Label("HP: " + playerPokemon.getHp());
//        Label opponentHpLabel = new Label("HP: " + opponentPokemon.getHp());
//
//        // Create a VBox for the player and opponent labels
//        VBox labelsVBox = new VBox();
//        labelsVBox.setAlignment(Pos.CENTER);
//        labelsVBox.setSpacing(10);
//        labelsVBox.getChildren().addAll(playerLabel, playerHpLabel, opponentLabel, opponentHpLabel);
//
//        // Create a BorderPane for the entire scene
//        BorderPane borderPane = new BorderPane();
//        borderPane.setPadding(new Insets(20));
//        borderPane.setCenter(movesGridPane);
//        borderPane.setLeft(labelsVBox);
//        borderPane.setBottom(bagButton);
//
//        // Create the scene and show the stage
//        Scene scene = new Scene(borderPane, 400, 300);
//        primaryStage.setTitle("Pokemon Battle");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    private void handleMove1() {
//        if (isPlayerTurn) {
//            int damage = 10;
//            opponentPokemonHP -= damage;
//            opponentNameLabel.setText(opponentPokemonName + " (HP: " + opponentPokemonHP + ")");
//            messageLabel.setText(playerPokemonName + " used Move 1!");
//            if (opponentPokemonHP <= 0) {
//                messageLabel.setText(opponentPokemonName + " fainted!");
//            }
//            isPlayerTurn = false;
//            opponentTurn();
//        }
//    }
//    
//    private void opponentTurn() {
//        // Generate a random number between 1 and 3 to select the opponent's move
//        int move = random.nextInt(3) + 1;
//
//        // Replace with logic for opponent move 1
//        if (move == 1) {
//            int damage = 10;
//            playerPokemonHP -= damage;
//            playerNameLabel.setText(playerPokemonName + " (HP: " + playerPokemonHP + ")");
//            messageLabel.setText(opponentPokemonName + " used Opponent Move 1!");
//            if (playerPokemonHP <= 0) {
//                messageLabel.setText(playerPokemonName + " fainted! Game Over.");
//                // Disable player move buttons
//                move1Button.setDisable(true);
//                move2Button.setDisable(true);
//                move3Button.setDisable(true);
//            }
//        }
//
//        // Replace with logic for opponent move 2
//        else if (move == 2) {
//            int damage = 20;
//            playerPokemonHP -= damage;
//            playerNameLabel.setText(playerPokemonName + " (HP: " + playerPokemonHP + ")");
//            messageLabel.setText(opponentPokemonName + " used Opponent Move 2!");
//            if (playerPokemonHP <= 0) {
//                messageLabel.setText(playerPokemonName + " fainted! Game Over.");
//                // Disable player move buttons
//                move1Button.setDisable(true);
//                move2Button.setDisable(true);
//                move3Button.setDisable(true);
//            }
//        }
//
//        // Replace with logic for opponent move 3
//        else if (move == 3) {
//            int damage = 30;
//            playerPokemonHP -= damage;
//            playerNameLabel.setText(playerPokemonName + " (HP: " + playerPokemonHP + ")");
//            messageLabel.setText(opponentPokemonName + " used Opponent Move 3!");
//            if (playerPokemonHP <= 0) {
//                messageLabel.setText(playerPokemonName + " fainted! Game Over.");
//                // Disable player move buttons
//                move1Button.setDisable(true);
//                move2Button.setDisable(true);
//                move3Button.setDisable(true);
//            }
//        }
//
//        isPlayerTurn = true;
//    }
//
//    private void showBag() {
//        // Create labels for each item in the bag
//        Label potionLabel = new Label("Potion x 3");
//        Label pokeballLabel = new Label("Pokeball x 5");
//        Label antidoteLabel = new Label("Antidote x 1");
//
//        // Create a button to use a potion
//        Button usePotionButton = new Button("Use Potion");
//        usePotionButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                // Replace with logic to use a potion
//            }
//        });
//
//        // Create a button to use a pokeball
//        Button usePokeballButton = new Button("Use Pokeball");
//        usePokeballButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                // Replace with logic to use a pokeball
//            }
//        });
//
//        // Create a button to use an antidote
//        Button useAntidoteButton = new Button("Use Antidote");
//        useAntidoteButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                // Replace with logic to use an antidote
//            }
//        });
//
//        // Create a grid pane for the items
//        GridPane itemsGridPane = new GridPane();
//        itemsGridPane.setAlignment(Pos.CENTER);
//        itemsGridPane.setHgap(10);
//        itemsGridPane.setVgap(10);
//        itemsGridPane.add(potionLabel, 0, 0);
//        itemsGridPane.add(usePotionButton, 1, 0);
//        itemsGridPane.add(pokeballLabel, 0, 1);
//        itemsGridPane.add(usePokeballButton, 1, 1);
//        itemsGridPane.add(antidoteLabel, 0, 2);
//        itemsGridPane.add(useAntidoteButton, 1, 2);
//
//        // Create a BorderPane for the entire scene
//        BorderPane borderPane = new BorderPane();
//        borderPane.setPadding(new Insets(20));
//        borderPane.setCenter(itemsGridPane);
//
//        // Create the scene and show the stage
//        Scene scene = new Scene(borderPane, 300, 200);
//        Stage stage = new Stage();
//        stage.setTitle("Bag");
//        stage.setScene(scene);
//        stage.show();
//    }   
}

