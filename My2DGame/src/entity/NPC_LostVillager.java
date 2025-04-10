package entity;

import main.GamePanel;

public class NPC_LostVillager extends Entity {

    public NPC_LostVillager(GamePanel gp) {
        super(gp);
        
        direction = "down";
        speed = 0; 
        
        getImage();
        setDialogue();
    }
    
    public void getImage() {
        down1 = setup("/npc/NPC_lostVillager_Down1", gp.tileSize, gp.tileSize); 
        down2 = setup("/npc/NPC_lostVillager_Down2", gp.tileSize, gp.tileSize); 
    }
    
    public void setDialogue() {
        dialogues[0] = "Is someone there?";
        dialogues[1] = "Thank the Gods!";
        dialogues[2] = "How did you find me here?";
        dialogues[3] = "My Brother?";
        dialogues[4] = "He must must be worried Sick";
        dialogues[5] = "I need to go back";
        dialogues[6] = "Thank you Sir Knight";
    }
    
    public void setAction() {
        
    }
    
    public void speak() {
        super.speak();
    }
}
