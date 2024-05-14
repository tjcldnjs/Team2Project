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

	public void setNewImage() {
		image = this.playerRed.mContext.newBI;
	}

	@Override
	public void run() {
		while (true) {
			PlayerWay playerWay = null;

			int rightColor = image.getRGB(playerRed.getX() + 80, playerRed.getY() + 70);
			int right2Color = image.getRGB(playerRed.getX() + 80, playerRed.getY() + 90);
			int leftColor = image.getRGB(playerRed.getX() + 20, playerRed.getY() + 70);
			int left2Color = image.getRGB(playerRed.getX() + 20, playerRed.getY() + 90);
			int upColor = image.getRGB(playerRed.getX() + 40, playerRed.getY() + 60);
			int up2Color = image.getRGB(playerRed.getX() + 60, playerRed.getY() + 60);
			int downColor = image.getRGB(playerRed.getX() + 40, playerRed.getY() + 100);
			int down2Color = image.getRGB(playerRed.getX() + 60, playerRed.getY() + 100);

			if (playerRed.playerWay == playerRed.playerWay.LEFT && (leftColor == RED || leftColor == BLUE)) {
				System.out.println("왼쪽막힘");
				playerRed.setLeftWallCrash(true);
				playerRed.setLeft(false);
			} else if (playerRed.playerWay == playerRed.playerWay.LEFT && (left2Color == RED || left2Color == BLUE)) {
				System.out.println("왼쪽막힘");
				playerRed.setLeftWallCrash(true);
				playerRed.setLeft(false);
			} else if (playerRed.playerWay == playerRed.playerWay.RIGHT && (rightColor == RED || rightColor == BLUE)) {
				System.out.println("오른쪽막힘");
				playerRed.setRightWallCrash(true);
				playerRed.setRight(false);
			} else if (playerRed.playerWay == playerRed.playerWay.RIGHT
					&& (right2Color == RED || right2Color == BLUE)) {
				System.out.println("오른쪽막힘");
				playerRed.setRightWallCrash(true);
				playerRed.setRight(false);
			} else if (playerRed.playerWay == playerRed.playerWay.UP && (upColor == RED || upColor == BLUE)) {
				System.out.println("위쪽막힘");
				playerRed.setUpWallCrash(true);
				playerRed.setUp(false);
			} else if (playerRed.playerWay == playerRed.playerWay.UP && (up2Color == RED || up2Color == BLUE)) {
				System.out.println("위쪽막힘");
				playerRed.setUpWallCrash(true);
				playerRed.setUp(false);
			} else if (playerRed.playerWay == playerRed.playerWay.DOWN && (downColor == RED || downColor == BLUE)) {
				System.out.println("아래쪽막힘");
				playerRed.setDownWallCrash(true);
				playerRed.setDown(false);
			} else if (playerRed.playerWay == playerRed.playerWay.DOWN && (down2Color == RED || down2Color == BLUE)) {
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
