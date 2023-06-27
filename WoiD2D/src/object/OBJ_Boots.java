package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Boots extends SuperObject{
	
	GamePanel gp;
	
	public OBJ_Boots(GamePanel gp) {
		
		this.gp = gp;
		
		name = "BOOTS";
		try {
			
			imageObjects = ImageIO.read(getClass().getResourceAsStream("/objects/WoiD2D_Boots_of_Knight.png"));
			uTool.scaleImage(imageObjects, gp.tileSize, gp.tileSize);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
