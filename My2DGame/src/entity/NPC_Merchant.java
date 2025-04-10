package entity;

import main.GamePanel;

public class NPC_Merchant extends Entity {

    public NPC_Merchant(GamePanel gp) {
        super(gp);
        
        direction = "down";
        speed = 0; 
        
        getImage();
        setDialogue();
    }
    
    public void getImage() {
        down1 = setup("/npc/NPC_Merchant_Down1", gp.tileSize, gp.tileSize); 
        down2 = setup("/npc/NPC_Merchant_Down2", gp.tileSize, gp.tileSize); 
    }
    
    public void setDialogue() {
        dialogues[0] = "Another victim to a false promise";
        dialogues[1] = "They told you about the treasure eh?";
        dialogues[2] = "But they did not tell you the truth";
        dialogues[3] = "There's no treasure that can";
        dialogues[4] = "This FORSAKEN KINGDOM ONLY RUIN!!";
        dialogues[5] = "RUIN!!!!!";
        dialogues[5] = "RUIN!!!!!";	
        
    }
    
    public void setAction() {
        
    }
    
    public void speak() {
        super.speak();
    }
}
