package CrazyArcade;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 현재 메인 쓰레드는 너무 바쁨 백그라운드에서 계속 Player 에 움직임을 관찰할 예정
 */
public class BackgroundPlayerRedService implements Runnable {

	private BufferedImage image;
	private PlayerRed playerRed;

	public BackgroundPlayerRedService(PlayerRed player) {
		this.playerRed = player;

//		try {
//			image = ImageIO.read(new File("imgca/background.png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		image = playerRed.mContext.newBI;
	}

	@Override
	public void run() {
		while (true) {
			Color leftColor = new Color(image.getRGB(playerRed.getX()+10, playerRed.getY() + 50));
			Color rightColor = new Color(image.getRGB(playerRed.getX() + 100, playerRed.getY() + 50));
			Color upColor = new Color(image.getRGB(playerRed.getX() + 50, playerRed.getY()));
			Color downColor = new Color(image.getRGB(playerRed.getX() + 50, playerRed.getY() + 100));

//			if(bottomColorLeft + bottomColorRight != -2) {
//				player.setDown(false);
//			} else {
//				if(!player.isUp() && !player.isDown()) {
//					player.down(); 
//				}
//			}

			if (leftColor.getRed() == 230 && leftColor.getGreen() == 0 && leftColor.getBlue() == 18) {
				System.out.println("빨간벽 충돌");
				playerRed.setLeftWallCrash(true);
				playerRed.setLeft(false);

			} else if (rightColor.getRed() == 230 && rightColor.getGreen() == 0 && rightColor.getBlue() == 18) {
				System.out.println("빨간벽 충돌");
				playerRed.setRightWallCrash(true);
				playerRed.setRight(false);

			} else if (upColor.getRed() == 230 && upColor.getGreen() == 0 && upColor.getBlue() == 18) {
				System.out.println("빨간벽 충돌");
				playerRed.setUpWallCrash(true);
				playerRed.setUp(false);

			} else if (downColor.getRed() == 230 && downColor.getGreen() == 0 && downColor.getBlue() == 18) {
				System.out.println("빨간벽 충돌");
				playerRed.setDownWallCrash(true);
				playerRed.setDown(false);

			} else {
				playerRed.setLeftWallCrash(false);
				playerRed.setRightWallCrash(false);
				playerRed.setUpWallCrash(false);
				playerRed.setDownWallCrash(false);
			}
			// 위 두 조건이 아니면 player 마음대로 움직일 수 있다.
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
