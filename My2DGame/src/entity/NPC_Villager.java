package entity;

import main.GamePanel;

public class NPC_Villager extends Entity {

    public NPC_Villager(GamePanel gp) {
        super(gp);
        
        direction = "down";
        speed = 0; 
        
        getImage();
        setDialogue();
    }
    
    public void getImage() {
        down1 = setup("/npc/NPC_Villager_Down1", gp.tileSize, gp.tileSize); 
        down2 = setup("/npc/NPC_Villager_Down2", gp.tileSize, gp.tileSize); 
    }
    
    public void setDialogue() {
        dialogues[0] = "A Hero At last!!";
        dialogues[1] = "Can you help find my Brother?";
        dialogues[2] = "He is lost in the forest";
        dialogues[3] = "Please you need to help him quick";
    }
    
    public void setAction() {
        
    }
    
    public void speak() {
        super.speak();
    }
}
