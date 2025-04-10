package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;

public class MON_Spider extends Entity{
	GamePanel gp;

	public MON_Spider(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = 2;
		name = "Dark Spider";
		speed = 1;
		maxLife = 10;
		life = maxLife;

		solidArea.x = 4;
		solidArea.y = 4;
		solidArea.width = 40;
		solidArea.height = 44;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
	}

	public void getImage() {
		up1 = setup("/monster/spider_down1", gp.tileSize, gp.tileSize);
		up2 = setup("/monster/spider_down2", gp.tileSize, gp.tileSize);
		down1 = setup("/monster/spider_down1", gp.tileSize, gp.tileSize);
		down2 = setup("/monster/spider_down2", gp.tileSize, gp.tileSize);
		left1 = setup("/monster/spider_down1", gp.tileSize, gp.tileSize);
		left2 = setup("/monster/spider_down2", gp.tileSize, gp.tileSize);
		right1 = setup("/monster/spider_down1", gp.tileSize, gp.tileSize);
		right2 = setup("/monster/spider_down2", gp.tileSize, gp.tileSize);
	}
	
	
	public void setAction() {
		actionLockCounter ++;
    	
    	if (actionLockCounter == 120) {
    		Random random = new Random();
	    	int i = random.nextInt(100) + 1; //pick up a dumber 1 - 100
	    	
	    	if (i <= 25 ) {
	    		direction = "up";
	    	}
	    	if (i > 25 && i <= 50) {
	    		direction = "down";
	    	}
	    	if (i > 50 && i <= 75) {
	    		direction = "left";
	    	}
	    	if (i > 75 && i <= 100) {
	    		direction = "right";
	    	}
	    	
	    	actionLockCounter = 0;
    	}	
	}
	
	public void damageReaction() {
		actionLockCounter = 0;
		direction = gp.player.direction;
	}
}
