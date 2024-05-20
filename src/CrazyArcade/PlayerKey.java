package CrazyArcade;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerKey implements Runnable {
	MainFrame mContext;

	private Player player1;
	private Player player2;
	int playerNum;

	public PlayerKey(MainFrame mContext, int playerNum) {
		this.mContext = mContext;
		this.player1 = mContext.player1;
		this.player2 = mContext.player2;
		this.playerNum = playerNum;
	}

	@Override
	public void run() {
		mContext.panelCenter.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (playerNum == 2) {
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
				} else {
					switch (e.getKeyCode()) {

					case KeyEvent.VK_LEFT:

						if (!player2.isLeft() && !player2.isLeftWallCrash()) {
							player2.setUp(false);
							player2.setDown(false);
							player2.setRight(false);
							player2.left();
						}
						break;

					case KeyEvent.VK_RIGHT:
						if (!player2.isRight() && !player2.isRightWallCrash()) {
							player2.setUp(false);
							player2.setDown(false);
							player2.setLeft(false);
							player2.right();
						}
						break;

					case KeyEvent.VK_UP:

						if (!player2.isUp() && !player2.isUpWallCrash()) {
							player2.setRight(false);
							player2.setDown(false);
							player2.setLeft(false);
							player2.up();
						}
						break;

					case KeyEvent.VK_DOWN:

						if (!player2.isDown() && !player2.isDownWallCrash()) {
							player2.setUp(false);
							player2.setRight(false);
							player2.setLeft(false);
							player2.down();
						}
						break;

					case KeyEvent.VK_SPACE:
						player2.attack();
						break;
					default:
						break;
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (playerNum == 1) {
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
				} else {
					switch (e.getKeyCode()) {

					case KeyEvent.VK_LEFT:
						player2.setLeft(false);
						break;

					case KeyEvent.VK_RIGHT:
						player2.setRight(false);
						break;

					case KeyEvent.VK_UP:
						player2.setUp(false);
						break;

					case KeyEvent.VK_DOWN:
						player2.setDown(false);
						break;

					default:
						break;
					}
				}

			}
		});
	}
}