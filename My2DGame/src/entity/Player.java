package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Entity {
    
    KeyHandler keyH;
    
    public final int screenX;
    public final int screenY;
   // public int hasKey = 0; 
    
    public Player(GamePanel gp, KeyHandler keyH) {
    	
    	super(gp); 
    	
        this.keyH = keyH;
        
        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);
        
        solidArea = new Rectangle();
        solidArea.x  = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x; 
        solidAreaDefaultY =  solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;
        
        setDefaultValues(); 
        getPlayerImage();
    }

    public void setDefaultValues() {
    	worldX = gp.tileSize * 23;
    	worldY = gp.tileSize * 21;
        //worldX = gp.tileSize * 10;
        //worldY = gp.tileSize * 13;
        speed = 4; 
        direction = "down";
        
        //PLAYER STATUS
        maxLife = 6;
        life = maxLife;
    }
    
    public void getPlayerImage() {
        
        up1 = setup("/player/down_left_walk");
        up2 = setup("/player/down_right_walk");
        down1 = setup("/player/top_left_walk");
        down2 = setup("/player/top_right_walk");
        left1 = setup("/player/left_left_walk");
        left2 = setup("/player/left_right_walk");
        right1 = setup("/player/right_left_walk");
        right2 = setup("/player/right_right_walk");
    }
    
   
    public void update() {
    	
    	if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true||
    			keyH.rightPressed == true) {
    		
    		if (keyH != null) { 
                if (keyH.upPressed) {
                	direction = "up";
                }
                if (keyH.downPressed) {
                	direction = "down";
                }
                if (keyH.leftPressed) {
                	direction = "left";
                }
                if (keyH.rightPressed) {
                	direction = "right";
                }
                
                // Check tile collision
                collisionOn = false;
                gp.cChecker.checkTile(this);
                
                //check object collision
                int objIndex = gp.cChecker.checkObject(this, true);
                pickUpObject(objIndex);
                
                //CHECK NPC COLLISION
                int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
                interactNPC(npcIndex); 
                
                //CHECK MONSTER COLLISION
                int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
                contactMonster(monsterIndex);
                
                //CHECK EVENT
                gp.eHandler.checkEvent();
                
                gp.keyH.enterPressed = false;
                
                // if collision is false a player can move
               if(collisionOn == false) {
            	   switch(direction) {
            	   case "up": worldY -= speed;
            		   break;
            	   case "down": worldY += speed;
            		   break;
            	   case "left": worldX -= speed;
            		   break;
            	   case "right": worldX += speed;
            		   break;
            	   }
               }
                
                spriteCounter++;
                if (spriteCounter > 12) {
                	if(spriteNum == 1) {
                		spriteNum = 2;
                	}
                	else if (spriteNum == 2) {
                		spriteNum = 1;
                	}
                	spriteCounter = 0;
                }
            }
    	}   
    	
    	//This need to be outside of key if statement!
    	if(invincible == true) {
    		invincibleCounter++;
    		if(invincibleCounter > 60) {
    			invincible = false;
    			invincibleCounter = 0;
    		}
    	}
    }
    
    public void pickUpObject(int i) {
    	if (i != 999) {
    		
    		/*String objectName = gp.obj[i].name;
    		
    		switch (objectName) {
    		case "Key":
    			gp.playSE(1);
    			hasKey++;
    			gp.obj[i] = null;
    			gp.ui.showMessage("You got a Key!");
    			break;
    		case "Door":
    			if (hasKey > 0) {
    				gp.playSE(3);
    				gp.obj[i] = null;
    				hasKey--;
    				gp.ui.showMessage("You opened the Door!");
    			}
    			else {
    				gp.ui.showMessage("You need a Key!");
    			}
    			break;
    		case "Boots":
    			gp.playSE(2);
    			speed += 2;
    			gp.obj[i] = null;
    			gp.ui.showMessage("Speed Up!");
    			break;
    		case "Chest":
    			gp.ui.gameFinished =true;
    			gp.stopMusic();
    			gp.playSE(4);
    			break;
    		}*/
    	}
    }
    
    public void interactNPC(int i) {
    	if (i != 999) {
    		
    		if(gp.keyH.enterPressed == true) {
    			gp.gameState = gp.dialogueState;
        		gp.npc[i].speak();
    		}
    	}  	
    }
    
    public void contactMonster(int i) {
    	if(i != 999) {
    		
    		if(invincible == false) {
    			life -= 1;
    			invincible = true;
    		}
    	}
    }

    public void draw(Graphics2D g2) {
       // g2.setColor(Color.WHITE);
       // g2.fillRect(x, y, gp.tileSize, gp.tileSize);
    	
    	BufferedImage image = null;
    	
    	switch(direction) {
    		case "up":
    			if (spriteNum == 1) {
    				image = up1;
    			}
    			if (spriteNum == 2) {
    				image = up2;
    			}
    			break;
    		case "down":
    			if (spriteNum == 1) {
    				image = down1;
    			}
    		    if (spriteNum == 2) {
    		    	image = down2;
    		    }
    			break;
    		case "left":
    			if (spriteNum == 1) {
    				image = left1;
    			}
    		    if (spriteNum == 2) {
    		    	image = left2;
    		    }
    			break;
    		case "right":
    			if (spriteNum == 1) {
    				image = right1;
    			}
    		    if (spriteNum == 2) {
    		    	image = right2;
    		    }
    			break;
    	}
    	
    	if(invincible == true) {
    		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
    	}
    	
    	g2.drawImage(image, screenX, screenY, null);
    	
    	//Reset Alpha
    	g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    	
    	//DEBUG
    	/*
    	g2.setFont(new Font("Arial", Font.PLAIN, 26));
    	g2.setColor(Color.white);
    	g2.drawString("Invincible: " + invincibleCounter, 10, 400);
    	*/
    }
}
