package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Wooden_Chest extends SuperObject{
	
	GamePanel gp;
	
public OBJ_Wooden_Chest(GamePanel gp) {
	
		this.gp = gp;
		
		name = "WOODEN_CHEST";
		try {
			
			imageObjects = ImageIO.read(getClass().getResourceAsStream("/objects/WoiD2D_Wooden_Chest.png"));
			uTool.scaleImage(imageObjects, gp.tileSize, gp.tileSize);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
