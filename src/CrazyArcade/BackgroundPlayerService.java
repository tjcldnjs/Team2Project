package CrazyArcade;

import java.awt.image.BufferedImage;

public class BackgroundPlayerService implements Runnable {
	MainFrame mContext;

	BufferedImage image1;
	BufferedImage image2;
	private Player player1;
	private Player player2;
	private final int RED = -65536;
	private final int BLUE = -16776961;
	int playerNum;
	
	// playerNum은 player1인지 player2인지 파라미터를 던져주는 역할
	public BackgroundPlayerService(MainFrame mCotext, int playerNum) {
		this.mContext = mCotext;
		this.player1 = mCotext.player1;
		this.player2 = mCotext.player2;
		this.playerNum = playerNum;
		image1 = this.player1.mContext.newBI;
		image2 = this.player2.mContext.newBI;
	}

	public void setNewImage() {
		image1 = this.player1.mContext.newBI;
	}

	public void setNewImage2() {
		image2 = this.player2.mContext.newBI;
	}

	@Override
	public void run() {
		while (true) {
			// 벽에 닿는 좌표 알맞게 조정
			int rightFirstPositionColor2 = image2.getRGB(player2.getX() + 80, player2.getY() + 70);
			int rightSecondPositionColor2 = image2.getRGB(player2.getX() + 80, player2.getY() + 90);
			int leftFirstPositionColor2 = image2.getRGB(player2.getX() + 20, player2.getY() + 70);
			int leftSecondPositionColor2 = image2.getRGB(player2.getX() + 20, player2.getY() + 90);
			int upFirstPositionColor2 = image2.getRGB(player2.getX() + 40, player2.getY() + 60);
			int upSecondPositionColor2 = image2.getRGB(player2.getX() + 60, player2.getY() + 60);
			int downFirstPositionColor2 = image2.getRGB(player2.getX() + 40, player2.getY() + 100);
			int downSecondPositionColor2 = image2.getRGB(player2.getX() + 60, player2.getY() + 100);

			int rightFirstPositionColor1 = image1.getRGB(player1.getX() + 80, player1.getY() + 70);
			int rightSecondPositionColor1 = image1.getRGB(player1.getX() + 80, player1.getY() + 90);
			int leftFirstPositionColor1 = image1.getRGB(player1.getX() + 20, player1.getY() + 70);
			int leftSecondPositionColor1 = image1.getRGB(player1.getX() + 20, player1.getY() + 90);
			int upFirstPositionColor1 = image1.getRGB(player1.getX() + 40, player1.getY() + 60);
			int upSecondPositionColor1 = image1.getRGB(player1.getX() + 60, player1.getY() + 60);
			int downFirstPositionColor1 = image1.getRGB(player1.getX() + 40, player1.getY() + 100);
			int downSecondPositionColor1 = image1.getRGB(player1.getX() + 60, player1.getY() + 100);

			if (playerNum == 2) {

				if ((player2.playerWay == player2.playerWay.LEFT
						&& (leftFirstPositionColor2 == RED || leftFirstPositionColor2 == BLUE))
						|| (player2.playerWay == player2.playerWay.LEFT
								&& (leftSecondPositionColor2 == RED || leftSecondPositionColor2 == BLUE))) {
					// System.out.println("왼쪽막힘");
					player2.setLeftWallCrash(true);
					player2.setLeft(false);
				} else if ((player2.playerWay == player2.playerWay.RIGHT
						&& (rightFirstPositionColor2 == RED || rightFirstPositionColor2 == BLUE))
						|| (player2.playerWay == player2.playerWay.RIGHT
								&& (rightSecondPositionColor2 == RED || rightSecondPositionColor2 == BLUE))) {
					// System.out.println("오른쪽막힘");
					player2.setRightWallCrash(true);
					player2.setRight(false);
				} else if ((player2.playerWay == player2.playerWay.UP
						&& (upFirstPositionColor2 == RED || upFirstPositionColor2 == BLUE))
						|| (player2.playerWay == player2.playerWay.UP
								&& (upSecondPositionColor2 == RED || upSecondPositionColor2 == BLUE))) {
					// System.out.println("위쪽막힘");
					player2.setUpWallCrash(true);
					player2.setUp(false);
				} else if ((player2.playerWay == player2.playerWay.DOWN
						&& (downFirstPositionColor2 == RED || downFirstPositionColor2 == BLUE))
						|| (player2.playerWay == player2.playerWay.DOWN
								&& (downSecondPositionColor2 == RED || downSecondPositionColor2 == BLUE))) {
					// System.out.println("아래쪽막힘");
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
			} else {
				if ((player1.playerWay == player1.playerWay.LEFT
						&& (leftFirstPositionColor1 == RED || leftFirstPositionColor1 == BLUE))
						|| (player1.playerWay == player1.playerWay.LEFT
								&& (leftSecondPositionColor1 == RED || leftSecondPositionColor1 == BLUE))) {
					// System.out.println("왼쪽막힘");
					player1.setLeftWallCrash(true);
					player1.setLeft(false);
				} else if ((player1.playerWay == player1.playerWay.RIGHT
						&& (rightFirstPositionColor1 == RED || rightFirstPositionColor1 == BLUE))
						|| (player1.playerWay == player1.playerWay.RIGHT
								&& (rightSecondPositionColor1 == RED || rightSecondPositionColor1 == BLUE))) {
					// System.out.println("오른쪽막힘");
					player1.setRightWallCrash(true);
					player1.setRight(false);
				} else if ((player1.playerWay == player1.playerWay.UP
						&& (upFirstPositionColor1 == RED || upFirstPositionColor1 == BLUE))
						|| (player1.playerWay == player1.playerWay.UP
								&& (upSecondPositionColor1 == RED || upSecondPositionColor1 == BLUE))) {
					// System.out.println("위쪽막힘");
					player1.setUpWallCrash(true);
					player1.setUp(false);
				} else if ((player1.playerWay == player1.playerWay.DOWN
						&& (downFirstPositionColor1 == RED || downFirstPositionColor1 == BLUE))
						|| (player1.playerWay == player1.playerWay.DOWN
								&& (downSecondPositionColor1 == RED || downSecondPositionColor1 == BLUE))) {
					// System.out.println("아래쪽막힘");
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
}
