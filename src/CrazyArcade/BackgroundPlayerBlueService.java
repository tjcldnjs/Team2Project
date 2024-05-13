package CrazyArcade;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundPlayerBlueService implements Runnable {

	private BufferedImage image; 
	PlayerBlue playerBlue;
	
	// 생성자 의존 주입 DI 
	public BackgroundPlayerBlueService(PlayerBlue playerBlue) {
		this.playerBlue = playerBlue;
		
		image = this.playerBlue.mContext.newBI;
	}
	
	@Override
	public void run() {
		while (true) {

//			Color upColor = new Color(image.getRGB(player.getX() + 50, player.getY() + 70));
//			Color leftColor = new Color(image.getRGB(player.getX(), player.getY() + 85));
//			Color rightColor = new Color(image.getRGB(player.getX() + 100, player.getY() + 85));
//			Color downColor = new Color(image.getRGB(player.getX() + 50, player.getY() + 99));

			Color leftupColor = new Color(image.getRGB(playerBlue.getX() + 15, playerBlue.getY() + 75));
			Color rightupColor = new Color(image.getRGB(playerBlue.getX() + 85, playerBlue.getY() + 75));
			Color leftdownColor = new Color(image.getRGB(playerBlue.getX() + 15, playerBlue.getY() + 95));
			Color rightdownColor = new Color(image.getRGB(playerBlue.getX() + 85, playerBlue.getY() + 95));

//			System.out.println("X"+player.getX());
//			System.out.println("Y"+player.getY());

//			if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
//				System.out.println("왼쪽 빨간벽 충돌");
//				player.setLeftWallCrash(true);
//				player.setLeft(false);
//
//			} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
//				System.out.println("오른쪽 빨간벽 충돌");
//				player.setRightWallCrash(true);
//				player.setRight(false);
//
//			} else if (upColor.getRed() == 255 && upColor.getGreen() == 0 && upColor.getBlue() == 0) {
//				System.out.println("위쪽 빨간벽 충돌");
//				player.setUpWallCrash(true);
//				player.setUp(false);
//
//			} else if (downColor.getRed() == 255 && downColor.getGreen() == 0 && downColor.getBlue() == 0) {
//				System.out.println("아래쪽 빨간벽 충돌");
//				player.setDownWallCrash(true);
//				player.setDown(false);
//
//			} else 
			

			PlayerWay playerWay = null;

//			System.out.println(leftdownColor.getRed());
//			System.out.println(player.playerWay);
			if (playerBlue.playerWay == playerBlue.playerWay.LEFT
					&& (leftupColor.getRed() == 255 && leftdownColor.getRed() == 255)
					&& (leftupColor.getGreen() == 0 && leftdownColor.getGreen() == 0)
					&& (leftupColor.getBlue() == 0 && leftdownColor.getBlue() == 0)) {
//				System.out.println("빨간색 왼쪽벽 막힘");
				playerBlue.setLeftWallCrash(true);
				playerBlue.setLeft(false);

			} else if (playerBlue.playerWay == playerBlue.playerWay.RIGHT
					&& (rightdownColor.getRed() == 255 && rightupColor.getRed() == 255)
					&& (rightdownColor.getGreen() == 0 && rightupColor.getGreen() == 0)
					&& (rightdownColor.getBlue() == 0 && rightupColor.getBlue() == 0)) {
//				System.out.println("빨간색 오른쪽벽 막힘");
				playerBlue.setRightWallCrash(true);
				playerBlue.setRight(false);

			} else if (playerBlue.playerWay == playerBlue.playerWay.DOWN
					&& (leftdownColor.getRed() == 255 && rightdownColor.getRed() == 255)
					&& (leftdownColor.getGreen() == 0 && rightdownColor.getGreen() == 0)
					&& (leftdownColor.getBlue() == 0 && rightdownColor.getBlue() == 0)) {
//				System.out.println("빨간색 아래벽 막힘");
				playerBlue.setDownWallCrash(true);
				playerBlue.setDown(false);

			} else if (playerBlue.playerWay == playerBlue.playerWay.UP
					&& (leftupColor.getRed() == 255 && rightupColor.getRed() == 255)
					&& (leftupColor.getGreen() == 0 && rightupColor.getGreen() == 0)
					&& (leftupColor.getBlue() == 0 && rightupColor.getBlue() == 0)) {
//				System.out.println("빨간색 위쪽벽 막힘");
				playerBlue.setUpWallCrash(true);
				playerBlue.setUp(false);
			} else if (playerBlue.playerWay == playerBlue.playerWay.LEFT
					&& (leftupColor.getRed() == 0 && leftdownColor.getRed() == 0)
					&& (leftupColor.getGreen() == 0 && leftdownColor.getGreen() == 0)
					&& (leftupColor.getBlue() == 255 && leftdownColor.getBlue() == 255)) {
//				System.out.println("파란색 왼쪽벽 막힘");
				playerBlue.setLeftWallCrash(true);
				playerBlue.setLeft(false);

			} else if (playerBlue.playerWay == playerBlue.playerWay.RIGHT
					&& (rightdownColor.getRed() == 0 && rightupColor.getRed() == 0)
					&& (rightdownColor.getGreen() == 0 && rightupColor.getGreen() == 0)
					&& (rightdownColor.getBlue() == 255 && rightupColor.getBlue() == 255)) {
//				System.out.println("파란색 오른쪽벽 막힘");
				playerBlue.setRightWallCrash(true);
				playerBlue.setRight(false);

			} else if (playerBlue.playerWay == playerBlue.playerWay.DOWN
					&& (leftdownColor.getRed() == 0 && rightdownColor.getRed() == 0)
					&& (leftdownColor.getGreen() == 0 && rightdownColor.getGreen() == 0)
					&& (leftdownColor.getBlue() == 255 && rightdownColor.getBlue() == 255)) {

//				System.out.println("파란색 아래벽 막힘");
				playerBlue.setDownWallCrash(true);
				playerBlue.setDown(false);

			} else if (playerBlue.playerWay == playerBlue.playerWay.UP
					&& (leftupColor.getRed() == 0 && rightupColor.getRed() == 0)
					&& (leftupColor.getGreen() == 0 && rightupColor.getGreen() == 0)
					&& (leftupColor.getBlue() == 255 && rightupColor.getBlue() == 255)) {
//				System.out.println("파란색 위쪽벽 막힘");
				playerBlue.setUpWallCrash(true);
				playerBlue.setUp(false);

			} else if (playerBlue.playerWay == playerBlue.playerWay.LEFT
					&& ((leftupColor.getRed() == 255 && leftdownColor.getBlue() == 255)
							|| (leftupColor.getBlue() == 255 && leftdownColor.getRed() == 255))
					&& (leftupColor.getGreen() == 0 && leftdownColor.getGreen() == 0)) {
//				System.out.println("빨간색 파란색 왼쪽벽 막힘");
				playerBlue.setLeftWallCrash(true);
				playerBlue.setLeft(false);

			} else if (playerBlue.playerWay == playerBlue.playerWay.RIGHT
					&& ((rightdownColor.getRed() == 255 && rightupColor.getBlue() == 255)
							|| (rightdownColor.getBlue() == 255 && rightupColor.getRed() == 255))
					&& (rightdownColor.getGreen() == 0 && rightupColor.getGreen() == 0)) {
//				System.out.println("빨간색 파란색 오른쪽벽 막힘");
				playerBlue.setRightWallCrash(true);
				playerBlue.setRight(false);

			} else if (playerBlue.playerWay == playerBlue.playerWay.DOWN
					&& ((leftdownColor.getRed() == 255 && rightdownColor.getBlue() == 255)
							|| (leftdownColor.getBlue() == 255 && rightdownColor.getRed() == 255))
					&& (leftdownColor.getGreen() == 0 && rightdownColor.getGreen() == 0)) {

//				System.out.println("빨간색 파란색 아래벽 막힘");
				playerBlue.setDownWallCrash(true);
				playerBlue.setDown(false);

			} else if (playerBlue.playerWay == playerBlue.playerWay.UP
					&& ((leftupColor.getRed() == 255 && rightupColor.getBlue() == 255)
							|| (leftupColor.getBlue() == 255 && rightupColor.getRed() == 255))
					&& (leftupColor.getGreen() == 0 && rightupColor.getGreen() == 0)) {
//				System.out.println("빨간색 파란색 위쪽벽 막힘");
				playerBlue.setUpWallCrash(true);
				playerBlue.setUp(false);

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
