package CrazyArcade;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundPlayerBlueService implements Runnable {

	private BufferedImage image;
	private PlayerBlue playerBlue;
	private final int RED = -65536;
	private final int BLUE = -16776961;

	public BackgroundPlayerBlueService(PlayerBlue playerBlue) {
		this.playerBlue = playerBlue;
		image = this.playerBlue.mContext.newBI;
	}

	public void setNewImage() {
		image = this.playerBlue.mContext.newBI;
	}

	@Override
	public void run() {
		while (true) {

			int rightFirstPositionColor = image.getRGB(playerBlue.getX() + 80, playerBlue.getY() + 70);
			int rightSecondPositionColor = image.getRGB(playerBlue.getX() + 80, playerBlue.getY() + 90);
			int leftFirstPositionColor = image.getRGB(playerBlue.getX() + 20, playerBlue.getY() + 70);
			int leftSecondPositionColor = image.getRGB(playerBlue.getX() + 20, playerBlue.getY() + 90);
			int upFirstPositionColor = image.getRGB(playerBlue.getX() + 40, playerBlue.getY() + 60);
			int upSecondPositionColor = image.getRGB(playerBlue.getX() + 60, playerBlue.getY() + 60);
			int downFirstPositionColor = image.getRGB(playerBlue.getX() + 40, playerBlue.getY() + 100);
			int downSecondPositionColor = image.getRGB(playerBlue.getX() + 60, playerBlue.getY() + 100);

			if ((playerBlue.playerWay == playerBlue.playerWay.LEFT
					&& (leftFirstPositionColor == RED || leftFirstPositionColor == BLUE))
					|| (playerBlue.playerWay == playerBlue.playerWay.LEFT
							&& (leftSecondPositionColor == RED || leftSecondPositionColor == BLUE))) {
				//System.out.println("왼쪽막힘");
				playerBlue.setLeftWallCrash(true);
				playerBlue.setLeft(false);
			} else if ((playerBlue.playerWay == playerBlue.playerWay.RIGHT
					&& (rightFirstPositionColor == RED || rightFirstPositionColor == BLUE))
					|| (playerBlue.playerWay == playerBlue.playerWay.RIGHT
							&& (rightSecondPositionColor == RED || rightSecondPositionColor == BLUE))) {
				//System.out.println("오른쪽막힘");
				playerBlue.setRightWallCrash(true);
				playerBlue.setRight(false);
			} else if ((playerBlue.playerWay == playerBlue.playerWay.UP
					&& (upFirstPositionColor == RED || upFirstPositionColor == BLUE))
					|| (playerBlue.playerWay == playerBlue.playerWay.UP
							&& (upSecondPositionColor == RED || upSecondPositionColor == BLUE))) {
				//System.out.println("위쪽막힘");
				playerBlue.setUpWallCrash(true);
				playerBlue.setUp(false);
			} else if ((playerBlue.playerWay == playerBlue.playerWay.DOWN
					&& (downFirstPositionColor == RED || downFirstPositionColor == BLUE))
					|| (playerBlue.playerWay == playerBlue.playerWay.DOWN
							&& (downSecondPositionColor == RED || downSecondPositionColor == BLUE))) {
				//System.out.println("아래쪽막힘");
				playerBlue.setDownWallCrash(true);
				playerBlue.setDown(false);
			} else {
				playerBlue.setLeftWallCrash(false);
				playerBlue.setRightWallCrash(false);
				playerBlue.setUpWallCrash(false);
				playerBlue.setDownWallCrash(false);
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}