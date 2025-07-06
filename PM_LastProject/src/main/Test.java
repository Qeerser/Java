package main;

import java.util.ArrayList;
import java.util.Scanner;

import Player.Weapon;
import exception.NameBlankException;
import logic.Inventory;
import logic.Item;
import logic.ItemCounter;
import logic.Slot;

public class Test {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Inventory> inventories = new ArrayList<Inventory>();

	public static void main(String[] args) throws NameBlankException {
		
		ArrayList<> items = new ArrayList<>();
		
		items.add(new Weapon("excalibor", 500, 9));
		
		
		
//		createPlayer();
//		showMainMenu();
	}
	
	public static void createPlayer() throws NameBlankException {
		String input;
		Weapon sword = new Weapon("Excalibor", 500, 9);
		System.out.println("========================================");
		System.out.println("       Create New Player");
		System.out.println("--------------------------------");
		System.out.println("	Insert Name");
		System.out.println("--------------------------------");
		System.out.println("========================================");
		input = (sc.nextLine());
		
		inventories.add(new Inventory(input));
		inventories.get(0).setMoney(5000);
		inventories.get(0).addItem(sword, 0);
	}
	public static void setUp() {
		Weapon sword = null;
		try {
			sword = new Weapon("Copper Sword", 500, 0);
		} catch (NameBlankException e) {
		}
		
		inventories.add(new Inventory("Player 1"));
		inventories.get(0).setMoney(5000);
		inventories.get(0).addItem(sword, 1);
	}

	public static void showMainMenu() {

		String input = "999";
		while (!input.equals("0")) {
			System.out.println("========================================");
			System.out.println("       Select an option");
			System.out.println("--------------------------------");
			System.out.println("1. Show market (all items).");
			System.out.println("2. Show player inventory.");
			System.out.println("--------------------------------");
			System.out.println("0. Main menu");
			System.out.println("========================================");
			input = (sc.nextLine());
			switch (input) {
			case "1":
				break;
			case "2":
				showPlayerInventory(0);
				break;
			case "0":
				System.out.println("\n	!! EXIT PROGRAM !!");
				return;
			default:
				System.out.println("UNKNOWN COMMAND");
				break;
			}
		}
	}
	
	public static void showPlayerInventory(int i) {
		String input = "999";
		while (!input.equals("0")) {
			System.out.println("========================================");
			System.out.println("     " + inventories.get(i).getPlayerName() + "'s inventory");
			System.out.println("            $" + inventories.get(i).getMoney());
			System.out.println("--------------------------------");
			System.out.println(inventories.get(i).toString());
			System.out.println("--------------------------------");
			System.out.println("Select an option");
			System.out.println("--------------------------------");
			System.out.println("0. Exit inventory.");
			System.out.println("========================================");
			input = (sc.nextLine());
			switch (input) {
			case "0":
				return;
			default:
				System.out.println("UNKNOWN COMMAND");
				break;
			}
		}
	}
}
