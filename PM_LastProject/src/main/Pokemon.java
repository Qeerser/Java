package main;

import java.util.ArrayList;

public class Pokemon {
    private String name;
    private Type type;
    private ArrayList<Move> moves;
    private int health;
    private int maxHealth;
    private int Defense;
    
    public Pokemon(String name, Type type, int health) {
        this.name = name;
        this.type = type;
        this.health = health;
        this.maxHealth = health;
        this.Defense = 1;
    }


	public String getName() {
        return name;
    }
    
    public Type getType() {
        return type;
    }
    
    public ArrayList<Move> getMoves() {
        return moves;
    }
    
    public Move getMove(int index) {
        return this.moves.get(index-1);
    }
    
    public int getHealth() {
        return health;
    }
    
    public int getMaxHealth() {
        return maxHealth;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }
    
    public void reduceHealth(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }
    
    public boolean isFainted() {
        return health <= 0;
    }

	public void setMove(ArrayList<Move> moves) {
		this.moves = moves;
	}

	public void addMove(Move move) {
		this.moves.add(move);
	}


	public int getCurrentHealth() {
		return this.health;
	}


	public int getDefense() {
		// TODO Auto-generated method stub
		return this.Defense;
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


	public void takeDamage(int damage) {
		this.health = Math.max(this.health-damage,0);
		
	}
}

