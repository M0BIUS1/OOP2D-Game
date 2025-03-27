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
import java.text.DecimalFormat;

import object.OBJ_Key;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font maruMonica, purisaB;
    
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
    	
    	g2.setFont(maruMonica);
    	//g2.setFont(purisaB);
    	g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
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
    	
    	g2.setFont(g2.getFont().deriveFont(Font.PLAIN,32F));
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

