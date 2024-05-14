package CrazyArcade;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bubble extends JLabel implements Runnable {
	MainFrame mContext;
	PlayerBlue playerBlue;
	PlayerRed playerRed;

	int bubblePosX;
	int bubblePosY;
	int playerPosX;
	int playerPosY;
	int jLabelPosX;
	int jLabelPosY;

	private int imageChaneIndex;

	private ImageIcon bombomb_Action__main;
	private ImageIcon bombomb_Action_1;
	private ImageIcon bombomb_Action_2;
	private ImageIcon bombomb_Action_3;

	private ImageIcon[] imageChangeArray;

	private ImageIcon bomb;
	private ImageIcon bombdown;
	private ImageIcon bombleft;
	private ImageIcon bombright;
	private ImageIcon bombup;

	public Bubble(MainFrame mContext, PlayerRed playerRed) {
		this.mContext = mContext;
		this.playerRed = playerRed;
		playerPosX = playerRed.getX() + 50;
		playerPosY = playerRed.getY() + 80;

	}

	public Bubble(MainFrame mContext, PlayerBlue playerBlue) {
		this.mContext = mContext;
		this.playerBlue = playerBlue;
		playerPosX = playerBlue.getX() + 50;
		playerPosY = playerBlue.getY() + 80;
	}

	
	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i * 100 < playerPosX && playerPosX <= (i + 1) * 100 && j * 100 <= playerPosY
						&& playerPosY <= (j + 1) * 100) {
					playerPosX = i * 100;
					playerPosY = j * 100;
					jLabelPosX = j;
					jLabelPosY = i;
				}
			}
		}

		mContext.panelCenter.add(this, 0);
		imageChangeArray = new ImageIcon[4];
		imageChangeArray[0] = new ImageIcon("img/bomb_Action__main.png");
		imageChangeArray[1] = new ImageIcon("img/bomb_Action__1.png");
		imageChangeArray[2] = new ImageIcon("img/bomb_Action__2.png");
		imageChangeArray[3] = new ImageIcon("img/bomb_Action__3.png");

		setIcon(bombomb_Action__main);
		setSize(100, 100);
		setLocation(playerPosX, playerPosY);

		imageChaneIndex = 0;
		for (int i = 0; i < 15; i++) {

			setIcon(imageChangeArray[imageChaneIndex]);
			imageChaneIndex++;
			if (imageChaneIndex == 4) {
				imageChaneIndex = 0;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if (jLabelPosX == 0 && jLabelPosY == 0) {
			mContext.backgroundImage[jLabelPosX + 1][jLabelPosY].bubbled("bombRight",jLabelPosX + 1,jLabelPosY);
			mContext.backgroundImage[jLabelPosX][jLabelPosY + 1].bubbled("bombDown",jLabelPosX,jLabelPosY + 1);

		} else if (jLabelPosX == 9 && jLabelPosY == 0) {
			System.out.println("9/0 왼쪽아래");
			mContext.backgroundImage[jLabelPosX - 1][jLabelPosY].bubbled("bombUp",jLabelPosX - 1,jLabelPosY);
			mContext.backgroundImage[jLabelPosX][jLabelPosY + 1].bubbled("bombRight",jLabelPosX,jLabelPosY + 1);

//		} else if (jLabelPosX == 0 && jLabelPosY == 9) {
//			System.out.println("0/9");
//			mContext.backgroundImage[jLabelPosX + 1][jLabelPosY].bubbled(1);
//			mContext.backgroundImage[jLabelPosX][jLabelPosY - 1].bubbled(4);
//
//		} else if (jLabelPosX == 9 && jLabelPosY == 9) {
//			System.out.println("9/9");
//			mContext.backgroundImage[jLabelPosX - 1][jLabelPosY].bubbled(3);
//			mContext.backgroundImage[jLabelPosX][jLabelPosY - 1].bubbled(4);
//
//		} else if (jLabelPosX == 0) {
//			mContext.backgroundImage[jLabelPosX + 1][jLabelPosY].bubbled(1);
//			mContext.backgroundImage[jLabelPosX][jLabelPosY + 1].bubbled(2);
//			mContext.backgroundImage[jLabelPosX][jLabelPosY - 1].bubbled(4);
//
//		} else if (jLabelPosX == 9) {
//			mContext.backgroundImage[jLabelPosX - 1][jLabelPosY].bubbled(3);
//			mContext.backgroundImage[jLabelPosX][jLabelPosY - 1].bubbled(1);
//			mContext.backgroundImage[jLabelPosX][jLabelPosY + 1].bubbled(1);
//		} else if (jLabelPosY == 0) {
//			System.out.println("y0");
//			mContext.backgroundImage[jLabelPosX + 1][jLabelPosY].bubbled(1);
//			mContext.backgroundImage[jLabelPosX - 1][jLabelPosY].bubbled(3);
//			mContext.backgroundImage[jLabelPosX][jLabelPosY + 1].bubbled(1);
//		} else if (jLabelPosY == 9) {
//			System.out.println("y9");
//			mContext.backgroundImage[jLabelPosX + 1][jLabelPosY].bubbled(1);
//			mContext.backgroundImage[jLabelPosX - 1][jLabelPosY].bubbled(3);
//			mContext.backgroundImage[jLabelPosX][jLabelPosY - 1].bubbled(1);
//		} else {
//			mContext.backgroundImage[jLabelPosX][jLabelPosY].bubbled(1);
//			mContext.backgroundImage[jLabelPosX + 1][jLabelPosY].bubbled(1);
//			mContext.backgroundImage[jLabelPosX - 1][jLabelPosY].bubbled(3);
//			mContext.backgroundImage[jLabelPosX][jLabelPosY + 1].bubbled(1);
//			mContext.backgroundImage[jLabelPosX][jLabelPosY - 1].bubbled(1);
		}
	}

}