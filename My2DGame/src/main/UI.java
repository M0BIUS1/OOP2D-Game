package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.io.File;

import object.OBJ_Key;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font arial_40, arial_80B;
    Font pixelFont;
    public int commandNum = 0;
    public int titleScreenState = 0; // 0: the first screen, 1: the 2nd screen
    
 //   BufferedImage keyImage;
    
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    
//    double playTime;
//    DecimalFormat dFormat = new DecimalFormat("#0.00");
    
    public String currentDialogue = "";

    public UI(GamePanel gp) {
        this.gp = gp;
        
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);
        
        try {
        	pixelFont = Font.createFont(Font.TRUETYPE_FONT, new File("res/font/PixelFont.ttf"));
            pixelFont = pixelFont.deriveFont(55F);
        	
        } catch (Exception e) {
        	e.printStackTrace();
            pixelFont = new Font("Monospaced", Font.BOLD, 55);
        }
        
 //       OBJ_Key key = new OBJ_Key(gp);
 //       keyImage = key.image;
        
    }
    public void showMessage(String text){
    	
    	message = text;
    	messageOn = true;
    }
    
    public void draw(Graphics2D g2) {
    	/* g2.setFont(arial_40);


    	g2.setColor(Color.white);

    	if (gameFinished == true) {
    		
    		String text;
    		int textLength;
    		int x;
    		int y;
    		
    		text = "YOU FOUND THE TREASURE!";
    		textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
    		x =gp.screenWidth/2 - textLength/2;
    		y =gp.screenHeight/2 - (gp.tileSize*3);
    		g2.drawString(text, x, y);
    		
    		text = "Your Time is :" + dFormat.format(playTime) + "!";
    		textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
    		x =gp.screenWidth/2 - textLength/2;
    		y =gp.screenHeight/2 + (gp.tileSize*4);
    		g2.drawString(text, x, y);
    		
    		
    		
    		g2.setFont(arial_80B);
    		g2.setColor(Color.yellow);
    		text = "Congratulations!";
    		textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
    		x =gp.screenWidth/2 - textLength/2;
    		y =gp.screenHeight/2 + (gp.tileSize*2);
    		g2.drawString(text, x, y);
    		
    		 gp.gameThread = null;
    	}

    	else {
    		g2.setFont(arial_40);
    		g2.setColor(Color.white);
    		g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
    		g2.drawString("x "+ gp.player.hasKey, 74, 65);

    		//TIMER
    		playTime +=(double)1/60;
    		g2.drawString("Time:"+dFormat.format(playTime), gp.tileSize*11, 65);
    		
    		//Message
    		if(messageOn == true) {
    			g2.setFont(g2.getFont().deriveFont(30F));
    			g2.drawString(message, gp.tileSize/2, gp.tileSize*5);
    			
    			messageCounter++;
    			
    			if(messageCounter > 120) {
    				messageCounter = 0;
    				messageOn = false;
    			}
    		}
    	} */
    	
    	
    	this.g2 = g2;
    	
    	//TITLE STATE
    	if(gp.gameState == gp.titleState) {
    		drawTitleScreen();
    	}
    	
    	g2.setFont(arial_40);
    	g2.setColor(Color.white);
    	
    	//PLAY STATE
    	if (gp.gameState == gp.playState) {
    		//later
    	}
    	// PAUSE STATE
    	if(gp.gameState == gp.pauseState) {
    		drawPauseScreen();
    	}
    	
    	//DIALOGUE STATE
    	if (gp.gameState == gp.dialogueState) {
    		drawDialogueScreen();
    	}

    }
    
    public void drawTitleScreen() {
    	
    	if(titleScreenState == 0) {
    		g2.setColor(new Color(29, 20, 17));
        	g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        	
        	g2.setFont(pixelFont.deriveFont(55F)); 
        	String text = "Little Knight";
        	int x = getXforCenteredText(text);
        	int y = gp.tileSize*3;
        	
        	//Shadow Text
        	g2.setColor(Color.darkGray);
            g2.drawString(text, x + 5, y + 5);
        	
            //Main Text
        	g2.setColor(Color.white);
        	g2.drawString(text, x, y);
        	
        	//Character Image
        	x = gp.screenWidth / 2 - (gp.tileSize * 2) / 2;
        	y += gp.tileSize * 2;
        	g2.drawImage(gp.player.down1, x, y, gp.tileSize * 2, gp.tileSize * 2, null);
        	
        	//Menu
        	g2.setFont(pixelFont.deriveFont(30F));
        	
        	text = "NEW GAME";
        	x = getXforCenteredText(text);
        	y += gp.tileSize * 3.5;
        	g2.drawString(text, x, y);
        	if(commandNum == 0) {
        		g2.drawString(">", x-gp.tileSize, y);
        	}
        	
        	text = "LOAD GAME";
        	x = getXforCenteredText(text);
        	y += gp.tileSize;
        	g2.drawString(text, x, y);
        	if(commandNum == 1) {
        		g2.drawString(">", x-gp.tileSize, y);
        	}
        	
        	text = "EXIT";
        	x = getXforCenteredText(text);
        	y += gp.tileSize;
        	g2.drawString(text, x, y);
        	if(commandNum == 2) {
        		g2.drawString(">", x-gp.tileSize, y);
        	}
    	} 
    	
    	// Class Selection
    	
    	else if (titleScreenState == 1) {
    		g2.setColor(Color.white);
    		g2.setFont(pixelFont.deriveFont(30F));
    		
    		String text = "Select your class!";
    		int x = getXforCenteredText(text);
    		int y = gp.tileSize * 3;
    		g2.drawString(text, x, y);
    		
    		text = "Fighter";
    		x = getXforCenteredText(text);
    		y += gp.tileSize * 3;
    		g2.drawString(text, x, y);
    		if(commandNum == 0) {
    			g2.drawString(">", x-gp.tileSize, y);
    		}
    		
    		text = "Thief";
    		x = getXforCenteredText(text);
    		y += gp.tileSize;
    		g2.drawString(text, x, y);
    		if(commandNum == 1) {
    			g2.drawString(">", x-gp.tileSize, y);
    		}
    		
    		text = "Sorcerer";
    		x = getXforCenteredText(text);
    		y += gp.tileSize;
    		g2.drawString(text, x, y);
    		if(commandNum == 2) {
    			g2.drawString(">", x-gp.tileSize, y);
    		}
    		
    		text = "Back";
    		x = getXforCenteredText(text);
    		y += gp.tileSize * 2;
    		g2.drawString(text, x, y);
    		if(commandNum == 3) {
    			g2.drawString(">", x-gp.tileSize, y);
    		}
    	}
    }
    
    public void drawPauseScreen() {
    	g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
    	String text = "PAUSED";
    	int x = getXforCenteredText(text);
    	
    	int y = gp.screenHeight/2;
    	
    	g2.drawString(text, x, y);
    } 
    public void drawDialogueScreen() {
    	
    	//WINDOW
    	int x = gp.tileSize*2;
    	int y = gp.tileSize/2;
    	int width = gp.screenWidth - (gp.tileSize*4);
    	int height = gp.tileSize*4;
    	
    	drawSubWindow(x, y, width, height);
    	
    	g2.setFont(g2.getFont().deriveFont(Font.PLAIN,28F));
    	x += gp.tileSize;
    	y += gp.tileSize;
    	
    	for (String line  : currentDialogue.split("/n")) {
        	g2.drawString(line, x, y);
        	 y += 40;
        	 
    	}
    }
    public void drawSubWindow(int x, int y, int width, int height) {
    	Color c = new Color(0, 0, 0, 190);
    	g2.setColor(c);
    	g2.fillRoundRect(x, y, width, height, 35, 35);
    	
    	c = new Color(255, 255, 255);
    	g2.setColor(c);
    	g2.setStroke(new BasicStroke(5));
    	g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
    	
    }
    public int getXforCenteredText(String text) {
    	int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
    	int x = gp.screenWidth/2 - length/2;
    	return x;
    }
}

