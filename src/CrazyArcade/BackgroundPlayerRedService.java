package CrazyArcade;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundPlayerRedService implements Runnable {

	private BufferedImage image;
	private Player player2;
	private final int RED = -65536;
	private final int BLUE = -16776961;

	public BackgroundPlayerRedService(Player player2) {
		this.player2 = player2;
		image = this.player2.mContext.newBI;
	}

	public void setNewImage() {
		image = this.player2.mContext.newBI;
	}

	@Override
	public void run() {
		while (true) {

			int rightFirstPositionColor = image.getRGB(player2.getX() + 80, player2.getY() + 70);
			int rightSecondPositionColor = image.getRGB(player2.getX() + 80, player2.getY() + 90);
			int leftFirstPositionColor = image.getRGB(player2.getX() + 20, player2.getY() + 70);
			int leftSecondPositionColor = image.getRGB(player2.getX() + 20, player2.getY() + 90);
			int upFirstPositionColor = image.getRGB(player2.getX() + 40, player2.getY() + 60);
			int upSecondPositionColor = image.getRGB(player2.getX() + 60, player2.getY() + 60);
			int downFirstPositionColor = image.getRGB(player2.getX() + 40, player2.getY() + 100);
			int downSecondPositionColor = image.getRGB(player2.getX() + 60, player2.getY() + 100);

			if ((player2.playerWay == player2.playerWay.LEFT
					&& (leftFirstPositionColor == RED || leftFirstPositionColor == BLUE))
					|| (player2.playerWay == player2.playerWay.LEFT
							&& (leftSecondPositionColor == RED || leftSecondPositionColor == BLUE))) {
				//System.out.println("왼쪽막힘");
				player2.setLeftWallCrash(true);
				player2.setLeft(false);
			} else if ((player2.playerWay == player2.playerWay.RIGHT
					&& (rightFirstPositionColor == RED || rightFirstPositionColor == BLUE))
					|| (player2.playerWay == player2.playerWay.RIGHT
							&& (rightSecondPositionColor == RED || rightSecondPositionColor == BLUE))) {
				//System.out.println("오른쪽막힘");
				player2.setRightWallCrash(true);
				player2.setRight(false);
			} else if ((player2.playerWay == player2.playerWay.UP
					&& (upFirstPositionColor == RED || upFirstPositionColor == BLUE))
					|| (player2.playerWay == player2.playerWay.UP
							&& (upSecondPositionColor == RED || upSecondPositionColor == BLUE))) {
				//System.out.println("위쪽막힘");
				player2.setUpWallCrash(true);
				player2.setUp(false);
			} else if ((player2.playerWay == player2.playerWay.DOWN
					&& (downFirstPositionColor == RED || downFirstPositionColor == BLUE))
					|| (player2.playerWay == player2.playerWay.DOWN
							&& (downSecondPositionColor == RED || downSecondPositionColor == BLUE))) {
				//System.out.println("아래쪽막힘");
				player2.setDownWallCrash(true);
				player2.setDown(false);
			} else {
				player2.setLeftWallCrash(false);
				player2.setRightWallCrash(false);
				player2.setUpWallCrash(false);
				player2.setDownWallCrash(false);
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
