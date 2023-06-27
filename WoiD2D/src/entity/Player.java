package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;

public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;
	public int hasKey = 0;

	public Player(GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		screenY = gp.screenHeight/2 - (gp.tileSize);
		screenX = gp.screenWidth/2 - (gp.tileSize);
		
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.height = 32;
		solidArea.width = 32;

		setDefaultValues();
		getPlayerImage();
	}

	public void setDefaultValues() {
		
		worldX = gp.tileSize * 19;
		worldY = gp.tileSize * 20;
		speed = 4;
		direction = "down";
	}
	public void getPlayerImage() {
		
		
		up1 = setup("NecroUp1");
		up2 = setup("NecroUp2");
		down1 = setup("NecroDown1");
		down2 = setup("NecroDown2");
		left1 = setup("NecroLeft1");
		left2 = setup("NecroLeft2");
		right1 = setup("NecroRight1");
		right2 = setup("NecroRight2");
	}
	
	public BufferedImage setup(String imageName) {
		
		UtilityTool uTool = new UtilityTool();
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/player/" + imageName + ".png"));
			image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
			
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		return image;
	}
	public void update() {

		if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
			
			if(keyH.upPressed == true) {
				
				direction = "up";
				
				
				
			}	
			
			if(keyH.downPressed == true) {
				
				direction = "down";
				
				
			}
			
			if(keyH.leftPressed == true) {
				direction = "left";
				
				
			}
			
			if(keyH.rightPressed == true) {
				direction = "right";
				
				
			}
			
			collisionOn = false;
			gp.cChecker.checkTile(this);
			
			int objIndex = gp.cChecker.checkObject(this, true);
			pickUpObject(objIndex);
			
			if (collisionOn == false) {
				switch(direction) {
				
				case "up":
					worldY -= speed;
					break;
					
				case "down":
					worldY += speed;
					break;
					
				case "left":
					worldX -= speed;
					break;
					
				case "right":
					worldX += speed;
					break;
				}
			}

			spriteCounter++;
			if(spriteCounter > 12) {
				if(spriteNum ==1) {
					spriteNum = 2;
					
				}

				else if (spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}	
	}
	public void pickUpObject(int i) {
		
		if (i != 999) {
			String objectName = gp.obj[i].name;
			
			switch(objectName) {
			case "KEY":
				gp.playSE(1);
				hasKey++;
				gp.obj[i] = null;
				System.out.println("Key:" + hasKey);
				gp.ui.showMassage("+ Key");
				break;
			case "WOODEN_DOOR":
				gp.playSE(3);
				if(hasKey > 0) {
					gp.obj[i] = null;
					hasKey--;	
					gp.ui.showMassage("*opened...");
				}
				else {
					gp.ui.showMassage("You need a key!");
				}
				System.out.println("Key:" + hasKey);
				break;
			case "BOOTS":
				gp.playSE(2);
				speed += 2;
				gp.obj[i] = null;
				gp.ui.showMassage("*speed up");
				break;
			case "WOODEN_CHEST":
				gp.ui.gameFinished = true;
				gp.stopMusic();
				gp.playSE(4);
				break;
			}
		}
	}
	
	public void draw(Graphics2D g2) {


		BufferedImage image = null;
		switch(direction) {
			case "up":
				if(spriteNum == 1) {
					image = up1;
				}
				if(spriteNum == 2) {
					image = up2;
				}
				break;
				
			case "down":
				if(spriteNum == 1) {
					image = down1;
				}
				if(spriteNum == 2) {
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
			g2.drawImage(image, screenX, screenY, null);
	}
}