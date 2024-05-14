package CrazyArcade;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundPlayerRedService implements Runnable {

	private BufferedImage image;
	private PlayerRed playerRed;
	private final int RED = -65536;
	private final int BLUE = -16776961;

	public BackgroundPlayerRedService(PlayerRed playerRed) {
		this.playerRed = playerRed;
		image = this.playerRed.mContext.newBI;
	}

	@Override
	public void run() {
		while (true) {

			int rightFirstPositionColor = image.getRGB(playerRed.getX() + 80, playerRed.getY() + 70);
			int rightSecondPositionColor = image.getRGB(playerRed.getX() + 80, playerRed.getY() + 90);
			int leftFirstPositionColor = image.getRGB(playerRed.getX() + 20, playerRed.getY() + 70);
			int leftSecondPositionColor = image.getRGB(playerRed.getX() + 20, playerRed.getY() + 90);
			int upFirstPositionColor = image.getRGB(playerRed.getX() + 40, playerRed.getY() + 60);
			int upSecondPositionColor = image.getRGB(playerRed.getX() + 60, playerRed.getY() + 60);
			int downFirstPositionColor = image.getRGB(playerRed.getX() + 40, playerRed.getY() + 100);
			int downSecondPositionColor = image.getRGB(playerRed.getX() + 60, playerRed.getY() + 100);

			if ((playerRed.playerWay == playerRed.playerWay.LEFT
					&& (leftFirstPositionColor == RED || leftFirstPositionColor == BLUE))
					|| (playerRed.playerWay == playerRed.playerWay.LEFT
							&& (leftSecondPositionColor == RED || leftSecondPositionColor == BLUE))) {
				System.out.println("왼쪽막힘");
				playerRed.setLeftWallCrash(true);
				playerRed.setLeft(false);
			} else if ((playerRed.playerWay == playerRed.playerWay.RIGHT
					&& (rightFirstPositionColor == RED || rightFirstPositionColor == BLUE))
					|| (playerRed.playerWay == playerRed.playerWay.RIGHT
							&& (rightSecondPositionColor == RED || rightSecondPositionColor == BLUE))) {
				System.out.println("오른쪽막힘");
				playerRed.setRightWallCrash(true);
				playerRed.setRight(false);
			} else if ((playerRed.playerWay == playerRed.playerWay.UP
					&& (upFirstPositionColor == RED || upFirstPositionColor == BLUE))
					|| (playerRed.playerWay == playerRed.playerWay.UP
							&& (upSecondPositionColor == RED || upSecondPositionColor == BLUE))) {
				System.out.println("위쪽막힘");
				playerRed.setUpWallCrash(true);
				playerRed.setUp(false);
			} else if ((playerRed.playerWay == playerRed.playerWay.DOWN
					&& (downFirstPositionColor == RED || downFirstPositionColor == BLUE))
					|| (playerRed.playerWay == playerRed.playerWay.DOWN
							&& (downSecondPositionColor == RED || downSecondPositionColor == BLUE))) {
				System.out.println("아래쪽막힘");
				playerRed.setDownWallCrash(true);
				playerRed.setDown(false);
			} else {
				playerRed.setLeftWallCrash(false);
				playerRed.setRightWallCrash(false);
				playerRed.setUpWallCrash(false);
				playerRed.setDownWallCrash(false);
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
