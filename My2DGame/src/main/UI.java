package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;

import object.OBJ_Heart;
import entity.Entity;


public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font maruMonica, purisaB;
    Font arial_40, arial_80B;
    Font pixelFont;
    BufferedImage heart_full, heart_half, heart_blank;
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
        
        try {
        	InputStream is = getClass().getResourceAsStream("/font/x12y16pxMaruMonica.ttf");
			maruMonica = Font.createFont(Font.TRUETYPE_FONT, is);
			is = getClass().getResourceAsStream("/font/Purisa Bold.ttf");
			purisaB = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        try {
        	pixelFont = Font.createFont(Font.TRUETYPE_FONT, new File("res/font/PixelFont.ttf"));
            pixelFont = pixelFont.deriveFont(55F);
        	
        } catch (Exception e) {
        	e.printStackTrace();
            pixelFont = new Font("Monospaced", Font.BOLD, 55);
        }
        
 //       OBJ_Key key = new OBJ_Key(gp);
 //       keyImage = key.image;
        
        //CREATE HUD OBJECT
        Entity heart = new OBJ_Heart(gp);
        heart_full = heart.image;
        heart_half = heart.image2;
        heart_blank = heart.image3;
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
    	
    	g2.setFont(maruMonica);
    	//g2.setFont(purisaB);
    	g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

    	//TITLE STATE
    	if(gp.gameState == gp.titleState) {
    		drawTitleScreen();
    	}
    	
    	g2.setFont(arial_40);
    	g2.setColor(Color.white);
    	
    	//PLAY STATE
    	if (gp.gameState == gp.playState) {
    		drawPlayerLife();
    	}
    	// PAUSE STATE
    	if(gp.gameState == gp.pauseState) {
    		drawPlayerLife();
    		drawPauseScreen();
    	}
    	
    	//DIALOGUE STATE
    	if (gp.gameState == gp.dialogueState) {
    		drawPlayerLife();
    		drawDialogueScreen();
    	}

    }
    
    public void drawPlayerLife() {
    	int x = gp.tileSize / 2;
    	int y = gp.tileSize / 2;
    	
    	int i = 0;
    	
    	//DRAW MAX LIFE
    	while(i < gp.player.maxLife / 2) {
    		g2.drawImage(heart_blank, x, y, null);
    		i++;
    		x += gp.tileSize;
    	}
    	
    	//RESET
    	x = gp.tileSize / 2;
    	y = gp.tileSize / 2;
    	i = 0;
    	
    	//DRAW CURRENT LIFE
    	while(i < gp.player.life) {
    		g2.drawImage(heart_half, x, y, null);
    		i++;
    		if(i < gp.player.life) {
    			g2.drawImage(heart_full, x, y, null);
    		}
    		
    		i++;
    		x += gp.tileSize;
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
    	g2.setFont(pixelFont.deriveFont(80F));
    	//g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
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
    	
    	g2.setFont(g2.getFont().deriveFont(Font.PLAIN,32F));
    	//g2.setFont(pixelFont.deriveFont(17F));
    	g2.setFont(new Font("Monospaced", Font.BOLD,25));
    	x += gp.tileSize;
    	y += gp.tileSize;
    	
    	for (String line  : currentDialogue.split("\n")) {
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

