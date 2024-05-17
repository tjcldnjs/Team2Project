package CrazyArcade;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerRedKey implements Runnable {

	private MainFrame mContext;
	 Player player2;

	public PlayerRedKey(MainFrame mContext, Player player2) {
		this.mContext = mContext;
		this.player2 = player2;
	}

	@Override
	public void run() {
		mContext.panelCenter.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

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

			@Override
			public void keyReleased(KeyEvent e) {

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
		});

	}
}
