package character;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Enemy extends Character{

	public static final String SKELETON = "스켈레톤";
	public static final String SNAKE = "뱀";
	public static final String MOUSE = "쥐";
	
	public static ArrayList<String> floor1EnemyList = new ArrayList<>();
	public static ArrayList<String> floor2EnemyList = new ArrayList<>();
	public static ArrayList<String> floor3EnemyList = new ArrayList<>();
	public static ArrayList<ArrayList<String>> allEnemyList = new ArrayList<ArrayList<String>>();
	
	static {
		allEnemyList.addAll(Arrays.asList(
				floor1EnemyList, 
				floor2EnemyList, 
				floor3EnemyList));
		floor1EnemyList.addAll(Arrays.asList(
				SKELETON,
				SNAKE,
				MOUSE));
		floor2EnemyList.addAll(Arrays.asList(
				));
		floor3EnemyList.addAll(Arrays.asList(
				));
	}
	
	public Enemy(String name) {
		this.name = name;
		
		switch(name) {
		case SKELETON:
			HP = 20;
			MHP = HP;
			SP = 0;
			MSP = SP;
			AP = 0;
			MAP = 100;
			HPG = 0;
			SPG = 0;
			ATK = 10;
			DEF = 10;
			SPD = 10;
			EFC = 0;
			break;
		case SNAKE:
			HP = 15;
			MHP = HP;
			SP = 0;
			MSP = SP;
			AP = 0;
			MAP = 100;
			HPG = 0;
			SPG = 0;
			ATK = 15;
			DEF = 0;
			SPD = 8;
			EFC = 0;
			break;
		case MOUSE:
			HP = 15;
			MHP = HP;
			SP = 0;
			MSP = SP;
			AP = 0;
			MAP = 100;
			HPG = 0;
			SPG = 0;
			ATK = 8;
			DEF = 0;
			SPD = 12;
			EFC = 20;
			break;
		}
	}
	
}
