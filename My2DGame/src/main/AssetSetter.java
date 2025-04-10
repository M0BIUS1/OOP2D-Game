package main;

import entity.NPC_LostVillager;
import entity.NPC_Merchant;
import entity.NPC_OldMan;
import entity.NPC_Villager;
import entity.NPC_Wizard;
import entity.NPC_WoodsMan;
import monster.MON_GreenSlime;
import monster.MON_Wolves;
import object.OBJ_Boots;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;

public class AssetSetter {

	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp =gp;
	}
	public void setObject() {

		gp.obj[0] = new OBJ_Key(gp);
		gp.obj[0] .worldX = 46 * gp.tileSize;
		gp.obj[0] .worldY = 25 * gp.tileSize;
		
		gp.obj[1] = new OBJ_Key(gp);
		gp.obj[1] .worldX = 43 * gp.tileSize;
		gp.obj[1] .worldY = 10 * gp.tileSize;
		
		gp.obj[2] = new OBJ_Key(gp);
		gp.obj[2] .worldX = 8 * gp.tileSize;
		gp.obj[2] .worldY = 9 * gp.tileSize;
		
		gp.obj[3] = new OBJ_Key(gp);
		gp.obj[3] .worldX = 11 * gp.tileSize;
		gp.obj[3] .worldY = 18 * gp.tileSize;
		
		gp.obj[4] = new OBJ_Key(gp);
		gp.obj[4] .worldX = 8 * gp.tileSize;
		gp.obj[4] .worldY = 9 * gp.tileSize;
		
		
		gp.obj[4] = new OBJ_Door(gp);
		gp.obj[4] .worldX = 12* gp.tileSize;
		gp.obj[4] .worldY = 25* gp.tileSize;
		
		gp.obj[5] = new OBJ_Door(gp);
		gp.obj[5] .worldX = 25* gp.tileSize;
		gp.obj[5] .worldY = 10* gp.tileSize;
		
		gp.obj[6] = new OBJ_Door(gp);
		gp.obj[6] .worldX = 25* gp.tileSize;
		gp.obj[6] .worldY = 34* gp.tileSize;
		
		gp.obj[7] = new OBJ_Door(gp);
		gp.obj[7] .worldX = 30* gp.tileSize;
		gp.obj[7] .worldY = 43* gp.tileSize;
		
		gp.obj[8] = new OBJ_Door(gp);
		gp.obj[8] .worldX = 37 * gp.tileSize;
		gp.obj[8] .worldY = 39 * gp.tileSize;
		
		gp.obj[9] = new OBJ_Chest(gp);
		gp.obj[9] .worldX = 41 * gp.tileSize;
		gp.obj[9] .worldY = 39 * gp.tileSize;
		
		gp.obj[10] = new OBJ_Boots(gp);
		gp.obj[10] .worldX = 13 * gp.tileSize;
		gp.obj[10] .worldY = 36 * gp.tileSize;
		
		gp.obj[11] = new OBJ_Key(gp);
		gp.obj[11] .worldX = 36 * gp.tileSize;
		gp.obj[11] .worldY = 30 * gp.tileSize;
		
		
		
		
	}
	
	public void setNPC() {

		gp.npc[0] = new NPC_OldMan(gp);
		gp.npc[0].worldX = gp.tileSize*25;
		gp.npc[0].worldY = gp.tileSize*23;
		
		gp.npc[1] = new NPC_Villager(gp);
		gp.npc[1].worldX = gp.tileSize*22;
		gp.npc[1].worldY = gp.tileSize*8;
		
		gp.npc[2] = new NPC_LostVillager(gp);
		gp.npc[2].worldX = gp.tileSize*5;
		gp.npc[2].worldY = gp.tileSize*7;
		
		gp.npc[3] = new NPC_Wizard(gp);
		gp.npc[3].worldX = gp.tileSize*38;
		gp.npc[3].worldY = gp.tileSize*23;
		
		gp.npc[4] = new NPC_WoodsMan(gp);
		gp.npc[4].worldX = gp.tileSize*10;
		gp.npc[4].worldY = gp.tileSize*24;
		
		gp.npc[5] = new NPC_Merchant(gp);
		gp.npc[5].worldX = gp.tileSize*21;
		gp.npc[5].worldY = gp.tileSize*32;




		/*
		gp.npc[0] = new NPC_OldMan(gp);
		gp.npc[0].worldX = gp.tileSize*9;
		gp.npc[0].worldY = gp.tileSize*10;
		*/
	}
	
	public void setMonster() {
		
		gp.monster[0] = new MON_Wolves(gp);
		gp.monster[0].worldX = gp.tileSize * 23;
		gp.monster[0].worldY = gp.tileSize * 36;
		
		gp.monster[1] = new MON_Wolves(gp);
		gp.monster[1].worldX = gp.tileSize * 23;
		gp.monster[1].worldY = gp.tileSize * 37;
		
		
		/*
		gp.monster[0] = new MON_GreenSlime(gp);
		gp.monster[0].worldX = gp.tileSize * 11;
		gp.monster[0].worldY = gp.tileSize * 10;
		
		gp.monster[1] = new MON_GreenSlime(gp);
		gp.monster[1].worldX = gp.tileSize * 11;
		gp.monster[1].worldY = gp.tileSize * 11;
		*/
	}
}
