package main;

import entity.NPC_LostVillager;
import entity.NPC_Merchant;
import entity.NPC_OldMan;
import entity.NPC_Villager;
import entity.NPC_Wizard;
import entity.NPC_WoodsMan;
import monster.MON_GreenSlime;
import monster.MON_Spider;
import monster.MON_Statue;
import monster.MON_UndeadSoldier;
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
		gp.monster[0].worldX = gp.tileSize * 42;
		gp.monster[0].worldY = gp.tileSize * 19;
		
		gp.monster[1] = new MON_Wolves(gp);
		gp.monster[1].worldX = gp.tileSize * 42;
		gp.monster[1].worldY = gp.tileSize * 20;
		
		gp.monster[2] = new MON_UndeadSoldier(gp);
		gp.monster[2].worldX = gp.tileSize * 38;
		gp.monster[2].worldY = gp.tileSize * 6;
		
		gp.monster[3] = new MON_UndeadSoldier(gp);
		gp.monster[3].worldX = gp.tileSize * 31;
		gp.monster[3].worldY = gp.tileSize * 6;
		
		gp.monster[4] = new MON_Spider(gp);
		gp.monster[4].worldX = gp.tileSize * 6;
		gp.monster[4].worldY = gp.tileSize * 30;
		
		gp.monster[5] = new MON_Spider(gp);
		gp.monster[5].worldX = gp.tileSize * 7;
		gp.monster[5].worldY = gp.tileSize * 30;
		
		gp.monster[6] = new MON_Spider(gp);
		gp.monster[6].worldX = gp.tileSize * 10;
		gp.monster[6].worldY = gp.tileSize * 33;
		
		gp.monster[7] = new MON_Spider(gp);
		gp.monster[7].worldX = gp.tileSize * 10;
		gp.monster[7].worldY = gp.tileSize * 34;
		
		gp.monster[7] = new MON_Statue(gp);
		gp.monster[7].worldX = gp.tileSize * 33;
		gp.monster[7].worldY = gp.tileSize * 37;
		
		gp.monster[8] = new MON_Statue(gp);
		gp.monster[8].worldX = gp.tileSize * 35;
		gp.monster[8].worldY = gp.tileSize * 37;
		
		gp.monster[9] = new MON_Statue(gp);
		gp.monster[9].worldX = gp.tileSize * 34;
		gp.monster[9].worldY = gp.tileSize * 39;
		
		gp.monster[10] = new MON_Statue(gp);
		gp.monster[10].worldX = gp.tileSize * 33;
		gp.monster[10].worldY = gp.tileSize * 40;
		
		gp.monster[11] = new MON_UndeadSoldier(gp);
		gp.monster[11].worldX = gp.tileSize * 36;
		gp.monster[11].worldY = gp.tileSize * 30;
		
		gp.monster[12] = new MON_UndeadSoldier(gp);
		gp.monster[12].worldX = gp.tileSize * 29;
		gp.monster[12].worldY = gp.tileSize * 33;
		
		gp.monster[13] = new MON_UndeadSoldier(gp);
		gp.monster[13].worldX = gp.tileSize * 32;
		gp.monster[13].worldY = gp.tileSize * 31;
		
		gp.monster[14] = new MON_UndeadSoldier(gp);
		gp.monster[14].worldX = gp.tileSize * 34;
		gp.monster[14].worldY = gp.tileSize * 33;
		
		gp.monster[15] = new MON_UndeadSoldier(gp);
		gp.monster[15].worldX = gp.tileSize * 34;
		gp.monster[15].worldY = gp.tileSize * 32;
		
		gp.monster[16] = new MON_Wolves(gp);
		gp.monster[16].worldX = gp.tileSize * 40;
		gp.monster[16].worldY = gp.tileSize * 20;
		
		gp.monster[17] = new MON_Wolves(gp);
		gp.monster[17].worldX = gp.tileSize * 44;
		gp.monster[17].worldY = gp.tileSize * 20;
		
		gp.monster[18] = new MON_Wolves(gp);
		gp.monster[18].worldX = gp.tileSize * 43;
		gp.monster[18].worldY = gp.tileSize * 21;
		
		gp.monster[19] = new MON_Wolves(gp);
		gp.monster[19].worldX = gp.tileSize * 46;
		gp.monster[19].worldY = gp.tileSize * 23;
		
		gp.monster[20] = new MON_Wolves(gp);
		gp.monster[20].worldX = gp.tileSize * 44;
		gp.monster[20].worldY = gp.tileSize * 24;
		
		gp.monster[21] = new MON_UndeadSoldier(gp);
		gp.monster[21].worldX = gp.tileSize * 41;
		gp.monster[21].worldY = gp.tileSize * 13;
		
		gp.monster[22] = new MON_UndeadSoldier(gp);
		gp.monster[22].worldX = gp.tileSize * 44;
		gp.monster[22].worldY = gp.tileSize * 15;
		
		gp.monster[23] = new MON_UndeadSoldier(gp);
		gp.monster[23].worldX = gp.tileSize * 41;
		gp.monster[23].worldY = gp.tileSize * 8;
		
		gp.monster[24] = new MON_UndeadSoldier(gp);
		gp.monster[24].worldX = gp.tileSize * 41;
		gp.monster[24].worldY = gp.tileSize * 5;
		
		gp.monster[25] = new MON_UndeadSoldier(gp);
		gp.monster[25].worldX = gp.tileSize * 38;
		gp.monster[25].worldY = gp.tileSize * 6;
	
		gp.monster[26] = new MON_UndeadSoldier(gp);
		gp.monster[26].worldX = gp.tileSize * 36;
		gp.monster[26].worldY = gp.tileSize * 5;
		
		gp.monster[27] = new MON_UndeadSoldier(gp);
		gp.monster[27].worldX = gp.tileSize * 33;
		gp.monster[27].worldY = gp.tileSize * 8;
		
		gp.monster[28] = new MON_UndeadSoldier(gp);
		gp.monster[28].worldX = gp.tileSize * 25;
		gp.monster[28].worldY = gp.tileSize * 5;
		
		gp.monster[29] = new MON_UndeadSoldier(gp);
		gp.monster[29].worldX = gp.tileSize * 24;
		gp.monster[29].worldY = gp.tileSize * 7;
		
		gp.monster[30] = new MON_UndeadSoldier(gp);
		gp.monster[30].worldX = gp.tileSize * 7;
		gp.monster[30].worldY = gp.tileSize * 5;
		
		gp.monster[30] = new MON_UndeadSoldier(gp);
		gp.monster[30].worldX = gp.tileSize * 10;
		gp.monster[30].worldY = gp.tileSize * 6;
		
		gp.monster[31] = new MON_UndeadSoldier(gp);
		gp.monster[31].worldX = gp.tileSize * 13;
		gp.monster[31].worldY = gp.tileSize * 5;
		
		gp.monster[32] = new MON_UndeadSoldier(gp);
		gp.monster[32].worldX = gp.tileSize * 13;
		gp.monster[32].worldY = gp.tileSize * 13;
		
		gp.monster[33] = new MON_UndeadSoldier(gp);
		gp.monster[33].worldX = gp.tileSize * 13;
		gp.monster[33].worldY = gp.tileSize * 15;
		
		gp.monster[34] = new MON_UndeadSoldier(gp);
		gp.monster[34].worldX = gp.tileSize * 7;
		gp.monster[34].worldY = gp.tileSize * 14;
		
		gp.monster[35] = new MON_UndeadSoldier(gp);
		gp.monster[35].worldX = gp.tileSize * 5;
		gp.monster[35].worldY = gp.tileSize * 9;
		
		gp.monster[36] = new MON_UndeadSoldier(gp);
		gp.monster[36].worldX = gp.tileSize * 6;
		gp.monster[36].worldY = gp.tileSize * 11;
		
		gp.monster[37] = new MON_Spider(gp);
		gp.monster[37].worldX = gp.tileSize * 10;
		gp.monster[37].worldY = gp.tileSize * 22;
		
		gp.monster[38] = new MON_Spider(gp);
		gp.monster[38].worldX = gp.tileSize * 7;
		gp.monster[38].worldY = gp.tileSize * 19;
		
		gp.monster[39] = new MON_Spider(gp);
		gp.monster[39].worldX = gp.tileSize * 6;
		gp.monster[39].worldY = gp.tileSize * 36;
		
		gp.monster[40] = new MON_Spider(gp);
		gp.monster[40].worldX = gp.tileSize * 12;
		gp.monster[40].worldY = gp.tileSize * 38;
		
		gp.monster[41] = new MON_Spider(gp);
		gp.monster[41].worldX = gp.tileSize * 9;
		gp.monster[41].worldY = gp.tileSize * 41;
		
		gp.monster[42] = new MON_UndeadSoldier(gp);
		gp.monster[42].worldX = gp.tileSize * 13;
		gp.monster[42].worldY = gp.tileSize * 44;
		
		gp.monster[43] = new MON_UndeadSoldier(gp);
		gp.monster[43].worldX = gp.tileSize * 15;
		gp.monster[43].worldY = gp.tileSize * 46;
		
		gp.monster[44] = new MON_UndeadSoldier(gp);
		gp.monster[44].worldX = gp.tileSize * 12;
		gp.monster[44].worldY = gp.tileSize * 48;
		
		
	}
}
