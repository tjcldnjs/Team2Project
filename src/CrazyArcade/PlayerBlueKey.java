package CrazyArcade;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerBlueKey implements Runnable {
	MainFrame mContext;
	PlayerBlue playerBlue;
	
	public PlayerBlueKey(MainFrame mContext, PlayerBlue player2) {
		this.mContext = mContext;
		this.playerBlue = player2;
	}
	
	
	@Override
	public void run() {

		 
		mContext.panelCenter.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					switch (e.getKeyCode()) {
					
					case KeyEvent.VK_A:
						if (!playerBlue.isLeft() && !playerBlue.isLeftWallCrash()) {
							playerBlue.setUp(false);
							playerBlue.setDown(false);
							playerBlue.setRight(false);
							playerBlue.left();
						}
						break;
					
					case KeyEvent.VK_D:
						if (!playerBlue.isRight() && !playerBlue.isRightWallCrash()) {
							playerBlue.setUp(false);
							playerBlue.setDown(false);
							playerBlue.setLeft(false);
							playerBlue.right();
						}

						break;
					
					case KeyEvent.VK_W:
						if (!playerBlue.isUp() && !playerBlue.isUpWallCrash()) {
							playerBlue.setRight(false);
							playerBlue.setDown(false);
							playerBlue.setLeft(false);
							playerBlue.up();
						}

						break;
					
					case KeyEvent.VK_S:
						if (!playerBlue.isDown() && !playerBlue.isDownWallCrash()) {
							playerBlue.setUp(false);
							playerBlue.setRight(false);
							playerBlue.setLeft(false);
							playerBlue.down();
						}
						break;
					case KeyEvent.VK_O:
						playerBlue.attack();
						break;
					default:
						break;
					}
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					switch(e.getKeyCode()){
					case KeyEvent.VK_A:
						playerBlue.setLeft(false);
						break;
					case KeyEvent.VK_D:
						playerBlue.setRight(false);
						break;
					case KeyEvent.VK_W:
						playerBlue.setUp(false);
						break;
					case KeyEvent.VK_S:
						playerBlue.setDown(false);
						break;
					default:
						break;
					}
				}
			});
		}
	}

