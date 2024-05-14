package CrazyArcade;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerRedKey implements Runnable {

	private MainFrame mContext;
	private PlayerRed player;

	public PlayerRedKey(MainFrame mContext, PlayerRed player) {
		this.mContext = mContext;
		this.player = player;
	}

	@Override
	public void run() {
		mContext.panelCenter.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				switch (e.getKeyCode()) {

				case KeyEvent.VK_LEFT:

					if (!player.isLeft() && !player.isLeftWallCrash()) {
						player.setUp(false);
						player.setDown(false);
						player.setRight(false);
						player.left();
					}
					break;

				case KeyEvent.VK_RIGHT:
					if (!player.isRight() && !player.isRightWallCrash()) {
						player.setUp(false);
						player.setDown(false);
						player.setLeft(false);
						player.right();
					}
					break;

				case KeyEvent.VK_UP:

					if (!player.isUp() && !player.isUpWallCrash()) {
						player.setRight(false);
						player.setDown(false);
						player.setLeft(false);
						player.up();
					}
					break;

				case KeyEvent.VK_DOWN:

					if (!player.isDown() && !player.isDownWallCrash()) {
						player.setUp(false);
						player.setRight(false);
						player.setLeft(false);
						player.down();
					}
					break;

				case KeyEvent.VK_SPACE:
					player.attack();
					break;
				default:
					break;
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {

				switch (e.getKeyCode()) {

				case KeyEvent.VK_LEFT:
					player.setLeft(false);
					break;

				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break;

				case KeyEvent.VK_UP:
					player.setUp(false);
					break;

				case KeyEvent.VK_DOWN:
					player.setDown(false);
					break;

				default:
					break;
				}
			}
		});

	}
}
