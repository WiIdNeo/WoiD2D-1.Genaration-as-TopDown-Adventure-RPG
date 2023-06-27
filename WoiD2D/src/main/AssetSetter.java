package main;

import object.OBJ_Boots;
import object.OBJ_Key;
import object.OBJ_Wooden_Chest;
import object.OBJ_Wooden_Door;

public class AssetSetter {
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}

	
	public void setObject() {
		
		gp.obj[0] = new OBJ_Key(gp);
		gp.obj[0].worldX = 7 * gp.tileSize;
		gp.obj[0].worldY = 7 * gp.tileSize;
		
		gp.obj[1] = new OBJ_Key(gp);
		gp.obj[1].worldX = 42 * gp.tileSize;
		gp.obj[1].worldY = 88 * gp.tileSize;
		
		gp.obj[2] = new OBJ_Wooden_Door(gp);
		gp.obj[2].worldX = 92 * gp.tileSize;
		gp.obj[2].worldY = 23 * gp.tileSize;
		
		gp.obj[3] = new OBJ_Wooden_Door(gp);
		gp.obj[3].worldX = 15 * gp.tileSize;
		gp.obj[3].worldY = 5 * gp.tileSize;
		
		gp.obj[4] = new OBJ_Wooden_Chest(gp);
		gp.obj[4].worldX = 15 * gp.tileSize;
		gp.obj[4].worldY = 2 * gp.tileSize;
		
		gp.obj[5] = new OBJ_Boots(gp);
		gp.obj[5].worldX = 5 * gp.tileSize;
		gp.obj[5].worldY = 73 * gp.tileSize;
		
		
	}
}
