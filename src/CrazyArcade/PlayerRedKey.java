package CrazyArcade;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerRedKey implements Runnable{

	MainFrame mContext;
	PlayerRed playerRed;
	
	
	
	public PlayerRedKey(MainFrame mContext, PlayerRed playerRed) {
		this.mContext = mContext;
		this.playerRed = playerRed;
		System.out.println("1번 ");
	}
	
	@Override
	public void run() {
		System.out.println("SADf");
		mContext.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				
				System.out.println("key code : " + e.getKeyCode());
				
				switch (e.getKeyCode()) {
				
				case KeyEvent.VK_0:
					System.out.println("SsdfdsfasdfADf");
					if (!playerRed.isLeft() && !playerRed.isLeftWallCrash()) {
						playerRed.left();
					}
					break;
				case KeyEvent.VK_LEFT:
					System.out.println("SsdfdsfasdfADf");
					if (!playerRed.isLeft() && !playerRed.isLeftWallCrash()) {
						playerRed.left();
					}
					break;
				
				case KeyEvent.VK_RIGHT:
					if (!playerRed.isRight() && !playerRed.isRightWallCrash()) {
						playerRed.right();
					}
					break;
					
				case KeyEvent.VK_UP:
					if (!playerRed.isUp() && !playerRed.isUpWallCrash()) {
						playerRed.up();
					}
					break;
					
				case KeyEvent.VK_DOWN:
					if (!playerRed.isDown() && !playerRed.isDownWallCrash()) {
						playerRed.down();
					}
					break;
				default:
					break;
				}

			} // end of KeyPressed

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {

				case KeyEvent.VK_LEFT:
					playerRed.setLeft(false);
					break;
				case KeyEvent.VK_RIGHT:
					playerRed.setRight(false);
					break;
				case KeyEvent.VK_UP:
					playerRed.setUp(false);
					break;
				
				case KeyEvent.VK_DOWN:
					playerRed.setDown(false);
					break;
				default:
					break;
				}

			} // end of KeyReleased
		});

	}
	}

