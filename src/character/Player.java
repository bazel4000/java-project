package character;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player extends Character{

	public ArrayList<String> allSkillList;
	public ArrayList<String> allItemList;
	public ArrayList<String> statList;
	public ArrayList<String> skillList;
	public ArrayList<String> itemList;
	
	public Player() {
		name = "나";
		HP = 30;
		MHP = HP;
		SP = 15;
		MSP = SP;
		AP = 0;
		MAP = 100;
		HPG = 0;
		SPG = 0;
		ATK = 10;
		DEF = 10;
		SPD = 10;
		EFC = 0;

		allSkillList = new ArrayList<>();
		allSkillList.addAll(Arrays.asList(
				Skill.DEFAULT_ATTACK,
				Skill.CHARGE_ATTACK,
				Skill.FAST_ATTACK));
		allItemList = new ArrayList<>();
		allItemList.addAll(Arrays.asList(
				Item.POTION,
				Item.HIGH_POTION,
				Item.MEGA_POTION));
		
		statList = new ArrayList<>();
		statList.addAll(Arrays.asList("HP", "SP", "HPG", "SPG", "ATK", "DEF", "SPD", "EFC"));
		
		skillList = new ArrayList<>();
		skillList.add(Skill.DEFAULT_ATTACK);
		skillList.add(Skill.HEALING);
		
		itemList = new ArrayList<>();
		itemList.add(Item.POTION);
		itemList.add(Item.SPEAR);
	}
	
	public static class Stat{
		
		public String name;
		public String point;
		public String description;
		
		public Stat(String name, Player player) {
			this.name = name;
			
			switch(name) {
			case "HP":
				point = player.HP + "/" + player.MHP;
				description = "현재/최대 체력 수치입니다. 0이 되면 사망합니다.";
				break;
			case "SP":
				point = player.SP + "/" + player.MSP;
				description = "현재/최대 자원 수치입니다. 소모량보다 적으면 해당 스킬은 사용불가합니다.";
				break;
			case "HPG":
				point = String.valueOf(player.HPG);
				description = "체력 재생 수치입니다. 매 턴마다 수치만큼 HP를 회복합니다.";
				break;
			case "SPG":
				point = String.valueOf(player.SPG);
				description = "자원 재생 수치입니다. 매 턴마다 수치만큼 SP를 회복합니다.";
				break;
			case "ATK":
				point = String.valueOf(player.ATK);
				description = "공격력 수치입니다. 높을수록 주는 피해량이 증가합니다.";
				break;
			case "DEF":
				point = String.valueOf(player.DEF);
				description = "방어력 수치입니다. 높을수록 받는 피해량이 감소합니다.";
				break;
			case "SPD":
				point = String.valueOf(player.SPD);
				description = "속도 수치입니다. 높을수록 AP 회복량이 증가합니다.";
				break;
			case "EFC":
				point = String.valueOf(player.EFC);
				description = "효율 수치입니다. 높을수록 AP 최대치가 감소합니다.";
				break;
			}
		}
		
	}
	
	public static class Skill{
		
		public static final String DEFAULT_ATTACK = "기본 공격";
		public static final String CHARGE_ATTACK = "강공격";
		public static final String FAST_ATTACK = "속공";
		public static final String HEALING = "치유술";
		final String PLAYER = "player";
		final String ENEMY = "enemy";

		public String name;
		public int cost;
		public String target;
		public ArrayList<Integer> points = new ArrayList<>();
		public String description;
		
		public Skill(String name, Player player) {
			this.name = name;
			
			switch(name) {
			case DEFAULT_ATTACK:
				cost = 0;
				target = ENEMY;
				points.add(player.ATK);
				description = "적에게 피해를 " + points.get(0) + " 줍니다.";
				break;
			case CHARGE_ATTACK:
				cost = 10;
				target = ENEMY;
				points.add((int)(player.ATK * 1.2), (int)(player.ATK * 1.2));
				description = "적에게 피해를 " + points.get(0) + " 주고 AP를 " + points.get(1) + " 감소시킵니다.";
				break;
			case FAST_ATTACK:
				cost = 5;
				target = ENEMY;
				points.add(player.ATK, player.SPD * 3);
				description = "적에게 피해를 " + points.get(0) + " 주고 플레이어의 AP를 " + points.get(1) + " 회복합니다.";
				break;
			case HEALING:
				cost = 5;
				target = PLAYER;
				points.add((int)(player.MHP * 0.3));
				description = "플레이어의 HP를 " + points.get(0) + " 회복합니다.";
				break;
			}
		}
		
	}
	
	public static class Item{
		
		public static final String POTION = "포션";
		public static final String HIGH_POTION = "하이 포션";
		public static final String MEGA_POTION = "메가 포션";
		public static final String SPEAR = "투창";
		final String PLAYER = "player";
		final String ENEMY = "enemy";

		public String name;
		public String target;
		public ArrayList<Integer> points = new ArrayList<>();
		public String description;
		
		public Item(String name, Player player) {
			this.name = name;
			
			switch (name) {
			case POTION:
				target = PLAYER;
				points.add((int)(player.MHP * 0.3));
				description = "플레이어의 HP를 " + points.get(0) + " 회복합니다.";
				break;
			case HIGH_POTION:
				target = PLAYER;
				points.add((int)(player.MHP * 0.5));
				description = "플레이어의 HP를" + points.get(0) + " 회복합니다.";
				break;
			case MEGA_POTION:
				target = PLAYER;
				points.add((int)(player.MHP * 0.7));
				description = "플레이어의 HP를 " + points.get(0) + " 회복합니다.";
				break;
			case SPEAR:
				target = ENEMY;
				points.add(20);
				description = "적에게 피해를 " + points.get(0) + " 줍니다.";
				break;
			}
		}
		
	}
	
}
