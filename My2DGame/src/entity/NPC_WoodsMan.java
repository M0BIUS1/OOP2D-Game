package entity;

import main.GamePanel;

public class NPC_WoodsMan extends Entity {

    public NPC_WoodsMan(GamePanel gp) {
        super(gp);
        
        direction = "down";
        speed = 0; 
        
        getImage();
        setDialogue();
    }
    
    public void getImage() {
        down1 = setup("/npc/NPC_WoodsMan_Down1", gp.tileSize, gp.tileSize); 
        down2 = setup("/npc/NPC_WoodsMan_Down2", gp.tileSize, gp.tileSize); 
    }
    
    public void setDialogue() {
        dialogues[0] = "Oh A not so Familiar Face";
        dialogues[1] = "Well disregard that";
        dialogues[2] = "If you wanna venture through the";
        dialogues[3] = "Woods you must be cautious";
        dialogues[4] = "There are alot of those beast";
        dialogues[5] = "Be on your guard then";
    }
    
    public void setAction() {
        
    }
    
    public void speak() {
        super.speak();
    }
}
