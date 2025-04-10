package entity;

import main.GamePanel;

public class NPC_Wizard extends Entity {

    public NPC_Wizard(GamePanel gp) {
        super(gp);
        
        direction = "down";
        speed = 0; 
        
        getImage();
        setDialogue();
    }
    
    public void getImage() {
        down1 = setup("/npc/NPC_Wizard_Down1", gp.tileSize, gp.tileSize); 
        down2 = setup("/npc/NPC_Wizard_Down2", gp.tileSize, gp.tileSize); 
    }
    
    public void setDialogue() {
        dialogues[0] = "Are you the Little Knight?";
        dialogues[1] = "Well you are in for a Treat!";
        dialogues[2] = "Find the missing keys to open";
        dialogues[3] = "The Iron Doors";
        dialogues[4] = "Here is my tip For You!";
        dialogues[5] = "Use A,S,W,D for movement";
        dialogues[6] = "And enter to attack and speak";
        dialogues[7] = "Good luck! my Little Knight!";
    }
    
    public void setAction() {
        
    }
    
    public void speak() {
        super.speak();
    }
}
