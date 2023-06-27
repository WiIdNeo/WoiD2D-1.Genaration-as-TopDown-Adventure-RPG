package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
			
	public boolean upPressed, downPressed, leftPressed, rightPressed; 
	
	@Override
	public void keyTyped(KeyEvent e) {
		int code = e.getKeyCode();

		if(code == KeyEvent.VK_W || code == KeyEvent.VK_KP_UP) { 

			upPressed = true;
		}
		if(code == KeyEvent.VK_S || code == KeyEvent.VK_KP_DOWN) { 
			downPressed = true;
		}
		
		if(code == KeyEvent.VK_A || code == KeyEvent.VK_KP_LEFT) { 
			leftPressed = true;
		}
		
		if(code == KeyEvent.VK_D || code == KeyEvent.VK_KP_RIGHT) { 
			rightPressed = true;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();

		if(code == KeyEvent.VK_W || code == KeyEvent.VK_KP_UP)  { 

			upPressed = true;
		}
		if(code == KeyEvent.VK_S || code == KeyEvent.VK_KP_DOWN) { 
			downPressed = true;
		}
		
		if(code == KeyEvent.VK_A || code == KeyEvent.VK_KP_LEFT) { 
			leftPressed = true;
		}
		
		if(code == KeyEvent.VK_D || code == KeyEvent.VK_KP_RIGHT) { 
			rightPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_W || code == KeyEvent.VK_KP_UP) { 
			upPressed = false;
		}
		
		if(code == KeyEvent.VK_S || code == KeyEvent.VK_KP_UP) { 
			downPressed = false;
		}
		
		if(code == KeyEvent.VK_A || code == KeyEvent.VK_KP_UP) { 
			leftPressed = false;
		}
		
		if(code == KeyEvent.VK_D || code == KeyEvent.VK_KP_UP) { 
			rightPressed = false;
		}
	}
}

