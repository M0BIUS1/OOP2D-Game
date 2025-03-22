package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D; 

import javax.swing.JPanel;
import entity.Player;
import object.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {

    // Screen Settings 
    final int originalTileSize = 16; // 16x16 tile
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;  // 48x48 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 768 pixels 
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels
    
    // World Settings
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
 
    
    // FPS 
    int FPS = 60;
    
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler(this);
    Sound music = new Sound();
    Sound se = new Sound();
    public CollisionChecker cChecker = new CollisionChecker(this);
    public Player player = new Player(this,keyH);
    public UI ui = new UI(this);
    Thread gameThread; 
    
    //ENTITY AND OBJECTS
    public SuperObject obj[] = new SuperObject[10];
    public AssetSetter aSetter = new AssetSetter(this);
    
    //game state
    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;
    

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);

        keyH = new KeyHandler(this); // ✅ Initialize KeyHandler first
        player = new Player(this, keyH); // ✅ Now pass it to Player safely

        this.addKeyListener(keyH);
        this.setFocusable(true); 
    } 
    
    public void setupGame() {
    	
    	aSetter.setObject();
    	playMusic(0);
    	stopMusic();
    	gameState = playState;
    	
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime; 
        long timer = 0;
        int drawCount = 0;
        
        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            
            if (delta >= 1) {
                update(); 
                repaint();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    
    public void update() {
    	
    	if (gameState == playState) {
    		player.update();
    	}
        if (gameState == pauseState) {
        	//nothjng for now
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);        
        Graphics2D g2 = (Graphics2D) g;
        
        //debug
        long drawStart = 0;
        if (keyH.checkDrawTime == true) {
        	  drawStart = System.nanoTime();
        }
      
        
        
        //tile
        tileM.draw(g2);
        
        //object
        for(int i = 0; i < obj.length; i++) {
        	if (obj[i] != null) {
        			obj[i].draw(g2, this);
        	}
        }
        
        //player
        player.draw(g2);
        
        ui.draw(g2);
        
        //debug
        if (keyH.checkDrawTime == true) {
        	long drawEnd = System.nanoTime();
            long passed = drawEnd - drawStart;
            g2.setColor(Color.white);
            g2.drawString("Draw Time: " + passed, 10, 400);
            System.out.println("Draw Time:" + passed);
        }
        
        
        g2.dispose();
    }
    
    public void playMusic(int i) {
    	
    	music.setFile(i);
    	music.play();
    	music.loop();
    }
    public void stopMusic() {
    	music.stop();
    }
    
    public void playSE (int i) {
    	se.setFile(i);
    	se.play();
    }
}
