package CrazyArcade;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundPlayerBlueService implements Runnable {

	private BufferedImage image;
	private Player player1;
	private final int RED = -65536;
	private final int BLUE = -16776961;

	public BackgroundPlayerBlueService(Player player1) {
		this.player1 = player1;
		image = this.player1.mContext.newBI;
	}

	public void setNewImage() {
		image = this.player1.mContext.newBI;
	}

	@Override
	public void run() {
		while (true) {

			int rightFirstPositionColor = image.getRGB(player1.getX() + 80, player1.getY() + 70);
			int rightSecondPositionColor = image.getRGB(player1.getX() + 80, player1.getY() + 90);
			int leftFirstPositionColor = image.getRGB(player1.getX() + 20, player1.getY() + 70);
			int leftSecondPositionColor = image.getRGB(player1.getX() + 20, player1.getY() + 90);
			int upFirstPositionColor = image.getRGB(player1.getX() + 40, player1.getY() + 60);
			int upSecondPositionColor = image.getRGB(player1.getX() + 60, player1.getY() + 60);
			int downFirstPositionColor = image.getRGB(player1.getX() + 40, player1.getY() + 100);
			int downSecondPositionColor = image.getRGB(player1.getX() + 60, player1.getY() + 100);

			if ((player1.playerWay == player1.playerWay.LEFT
					&& (leftFirstPositionColor == RED || leftFirstPositionColor == BLUE))
					|| (player1.playerWay == player1.playerWay.LEFT
							&& (leftSecondPositionColor == RED || leftSecondPositionColor == BLUE))) {
				//System.out.println("왼쪽막힘");
				player1.setLeftWallCrash(true);
				player1.setLeft(false);
			} else if ((player1.playerWay == player1.playerWay.RIGHT
					&& (rightFirstPositionColor == RED || rightFirstPositionColor == BLUE))
					|| (player1.playerWay == player1.playerWay.RIGHT
							&& (rightSecondPositionColor == RED || rightSecondPositionColor == BLUE))) {
				//System.out.println("오른쪽막힘");
				player1.setRightWallCrash(true);
				player1.setRight(false);
			} else if ((player1.playerWay == player1.playerWay.UP
					&& (upFirstPositionColor == RED || upFirstPositionColor == BLUE))
					|| (player1.playerWay == player1.playerWay.UP
							&& (upSecondPositionColor == RED || upSecondPositionColor == BLUE))) {
				//System.out.println("위쪽막힘");
				player1.setUpWallCrash(true);
				player1.setUp(false);
			} else if ((player1.playerWay == player1.playerWay.DOWN
					&& (downFirstPositionColor == RED || downFirstPositionColor == BLUE))
					|| (player1.playerWay == player1.playerWay.DOWN
							&& (downSecondPositionColor == RED || downSecondPositionColor == BLUE))) {
				//System.out.println("아래쪽막힘");
				player1.setDownWallCrash(true);
				player1.setDown(false);
			} else {
				player1.setLeftWallCrash(false);
				player1.setRightWallCrash(false);
				player1.setUpWallCrash(false);
				player1.setDownWallCrash(false);
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
