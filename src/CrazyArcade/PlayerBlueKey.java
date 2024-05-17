package CrazyArcade;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerBlueKey implements Runnable {

	private MainFrame mContext;
	private Player player1;

	public PlayerBlueKey(MainFrame mContext, Player player1) {
		this.mContext = mContext;
		this.player1 = player1;
	}

	@Override
	public void run() {

		mContext.panelCenter.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				switch (e.getKeyCode()) {

				case KeyEvent.VK_A:
					if (!player1.isLeft() && !player1.isLeftWallCrash()) {
						player1.setUp(false);
						player1.setDown(false);
						player1.setRight(false);
						player1.left();
					}
					break;

				case KeyEvent.VK_D:
					if (!player1.isRight() && !player1.isRightWallCrash()) {
						player1.setUp(false);
						player1.setDown(false);
						player1.setLeft(false);
						player1.right();
					}
					break;

				case KeyEvent.VK_W:
					if (!player1.isUp() && !player1.isUpWallCrash()) {
						player1.setRight(false);
						player1.setDown(false);
						player1.setLeft(false);
						player1.up();
					}
					break;

				case KeyEvent.VK_S:
					if (!player1.isDown() && !player1.isDownWallCrash()) {
						player1.setUp(false);
						player1.setRight(false);
						player1.setLeft(false);
						player1.down();
					}
					break;

//				case KeyEvent.VK_O:
//					player1.attack();
//					break;

				default:
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {

				switch (e.getKeyCode()) {

				case KeyEvent.VK_A:
					player1.setLeft(false);
					break;

				case KeyEvent.VK_D:
					player1.setRight(false);
					break;

				case KeyEvent.VK_W:
					player1.setUp(false);
					break;

				case KeyEvent.VK_S:
					player1.setDown(false);
					break;
				case KeyEvent.VK_SHIFT:
					player1.attack();
				default:
					break;
				}
			}
		});
	}
}
