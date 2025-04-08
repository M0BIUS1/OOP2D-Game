package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.*;

import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
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
    
    //SYSTEM
    TileManager tileM = new TileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    Sound music = new Sound();
    Sound se = new Sound();
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    public EventHandler eHandler = new EventHandler(this);
    Thread gameThread; 
    
    //ENTITY AND OBJECTS
    public Player player = new Player(this, keyH);
    public Entity obj[] = new Entity[10];
    public Entity npc[] = new Entity[10];
    public Entity monster[] = new Entity[20];
    ArrayList<Entity> entityList  = new ArrayList<>();
    
    //game state
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int characterState = 4;
    public final int gameOverState = 6;

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
    	aSetter.setNPC();
    	aSetter.setMonster();
    	playMusic(0);
    	stopMusic();
    	gameState = titleState;
    	
    }
    
    public void retry() {
    	player.setDefaultPositions();
    	player.restoreLifeAndMana();
    	aSetter.setNPC();
    	aSetter.setMonster();
    	
    }
    
    public void restart() {
    	player.setDefaultValues();
    	player.setDefaultPositions();
    	player.restoreLifeAndMana();
    	player.setItems();
    	aSetter.setObject();
    	aSetter.setNPC();
    	aSetter.setMonster();
    	//aSetter.setInteractiveTile();
    	
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
    		
    		//player
    		player.update();
    		
    		//npc
    		for (int i = 0; i < npc.length; i++) {
    			if (npc [i] != null) {
    				npc[i].update();
    			}
    		}
    		
    		for(int i = 0; i < monster.length; i++) {
    			if(monster[i] != null) {
    				if(monster[i].alive == true && monster[i].dying == false) {
    					monster[i].update();
    				}
    				
    				if(monster[i].alive == false) {
    					monster[i] = null;
    				}
    			}
    		}
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
      
        //TITLE SCREEN
        if(gameState == titleState) {
        	ui.draw(g2);
        }
        
        //Other
        else {
        	
        	//tile
            tileM.draw(g2);
            
            //ADD ENTITIES TO THE LIST
            entityList.add(player);
            
            for(int i = 0; i < npc.length; i++) {
            	if(npc[i] != null) {
            		entityList.add(npc[i]);
            	}
            }
            
            for (int i = 0; i < obj.length; i++) {
                if (obj[i] != null) {
                    entityList.add(obj[i]);
                }
            }
            
            for (int i = 0; i < monster.length; i++) {
                if (monster[i] != null) {
                    entityList.add(monster[i]);
                }
            }
            
            //Sort
            Collections.sort(entityList, new Comparator<Entity>() {
            	
            	@Override
            	public int compare(Entity e1, Entity e2) {
            		int result = Integer.compare(e1.worldY, e2.worldY);
            		return result;
            	}
            });
            
            //Draw Entities
            for(int i = 0; i < entityList.size(); i++) {
            	entityList.get(i).draw(g2);
            }
            
            //Empty List
            entityList.clear();
            
            //UI
            ui.draw(g2);
        }
        
        
        //debug
        if (keyH.checkDrawTime == true) {
        	long drawEnd = System.nanoTime();
            long passed = drawEnd - drawStart;
            
            //g2.setFont(new Font("Arial",Font.PLAIN,20));
            g2.setColor(Color.white);
            //int x = 10;
            //int y = 400;
            //int lineHeight = 20;
            
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