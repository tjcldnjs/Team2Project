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

	@Override
	public void run() {
		while (true) {
			PlayerWay playerWay = null;

			int rightColor = image.getRGB(playerBlue.getX() + 80, playerBlue.getY() + 70);
			int right2Color = image.getRGB(playerBlue.getX() + 80, playerBlue.getY() + 90);
			int leftColor = image.getRGB(playerBlue.getX() + 20, playerBlue.getY() + 70);
			int left2Color = image.getRGB(playerBlue.getX() + 20, playerBlue.getY() + 90);
			int upColor = image.getRGB(playerBlue.getX() + 40, playerBlue.getY() + 60);
			int up2Color = image.getRGB(playerBlue.getX() + 60, playerBlue.getY() + 60);
			int downColor = image.getRGB(playerBlue.getX() + 40, playerBlue.getY() + 100);
			int down2Color = image.getRGB(playerBlue.getX() + 60, playerBlue.getY() + 100);

			if (playerBlue.playerWay == playerBlue.playerWay.LEFT && (leftColor == RED || leftColor == BLUE)) {
				System.out.println("왼쪽막힘");
				playerBlue.setLeftWallCrash(true);
				playerBlue.setLeft(false);
			} else if (playerBlue.playerWay == playerBlue.playerWay.LEFT && (left2Color == RED || left2Color == BLUE)) {
				System.out.println("왼쪽막힘");
				playerBlue.setLeftWallCrash(true);
				playerBlue.setLeft(false);
			} else if (playerBlue.playerWay == playerBlue.playerWay.RIGHT
					&& (rightColor == RED || rightColor == BLUE)) {
				System.out.println("오른쪽막힘");
				playerBlue.setRightWallCrash(true);
				playerBlue.setRight(false);
			} else if (playerBlue.playerWay == playerBlue.playerWay.RIGHT
					&& (right2Color == RED || right2Color == BLUE)) {
				System.out.println("오른쪽막힘");
				playerBlue.setRightWallCrash(true);
				playerBlue.setRight(false);
			} else if (playerBlue.playerWay == playerBlue.playerWay.UP && (upColor == RED || upColor == BLUE)) {
				System.out.println("위쪽막힘");
				playerBlue.setUpWallCrash(true);
				playerBlue.setUp(false);
			} else if (playerBlue.playerWay == playerBlue.playerWay.UP && (up2Color == RED || up2Color == BLUE)) {
				System.out.println("위쪽막힘");
				playerBlue.setUpWallCrash(true);
				playerBlue.setUp(false);
			} else if (playerBlue.playerWay == playerBlue.playerWay.DOWN && (downColor == RED || downColor == BLUE)) {
				System.out.println("아래쪽막힘");
				playerBlue.setDownWallCrash(true);
				playerBlue.setDown(false);
			} else if (playerBlue.playerWay == playerBlue.playerWay.DOWN && (down2Color == RED || down2Color == BLUE)) {
				System.out.println("아래쪽막힘");
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
