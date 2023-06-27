package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Key extends SuperObject{
	
	GamePanel gp;
	
	public OBJ_Key(GamePanel gp) {
		
		this.gp = gp;
		
		name = "KEY";
		try {
			
			imageObjects = ImageIO.read(getClass().getResourceAsStream("/objects/WoiD2D_Key_Yellow.png"));
			uTool.scaleImage(imageObjects, gp.tileSize, gp.tileSize);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
