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
	int jlabelPosX;
	int jlabelPosY;

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
					bubblePosX = i * 100;
					bubblePosY = j * 100;
					jlabelPosX = j;
					jlabelPosY = i;
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
		setLocation(bubblePosX, bubblePosY);

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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// mContext.backgroundImage[playerPosY / 100][playerPosX / 100].setIcon(null);
//		mContext.backgroundImage[jlabelPosX + 1][jlabelPosY].setIcon(null);
//		mContext.backgroundImage[jlabelPosX - 1][jlabelPosY].setIcon(null);
//		mContext.backgroundImage[jlabelPosX][jlabelPosY + 1].setIcon(null);
//		mContext.backgroundImage[jlabelPosX][jlabelPosY - 1].setIcon(null);

		if (jlabelPosY == 9 && jlabelPosX == 0) {
			mContext.backgroundImage[jlabelPosX][jlabelPosY - 1].bubbled();
			mContext.backgroundImage[jlabelPosX + 1][jlabelPosY].bubbled();
		} else if (jlabelPosX == 9 && jlabelPosY == 9) {
			mContext.backgroundImage[jlabelPosX][jlabelPosY - 1].bubbled();
			mContext.backgroundImage[jlabelPosX - 1][jlabelPosY].bubbled();

		} else if (jlabelPosX == 9 && jlabelPosY == 0) {
			mContext.backgroundImage[jlabelPosX - 1][jlabelPosY].bubbled();
			mContext.backgroundImage[jlabelPosX][jlabelPosY + 1].bubbled();

		} else if (jlabelPosX == 0 && jlabelPosY == 0) {
			mContext.backgroundImage[jlabelPosX][jlabelPosY + 1].bubbled();
			mContext.backgroundImage[jlabelPosX + 1][jlabelPosY].bubbled();

		} else if (jlabelPosX == 0) {
			mContext.backgroundImage[jlabelPosX][jlabelPosY + 1].bubbled();
			mContext.backgroundImage[jlabelPosX][jlabelPosY - 1].bubbled();
			mContext.backgroundImage[jlabelPosX + 1][jlabelPosY].bubbled();

		} else if (jlabelPosY == 0) {
			mContext.backgroundImage[jlabelPosX + 1][jlabelPosY].bubbled();
			mContext.backgroundImage[jlabelPosX - 1][jlabelPosY].bubbled();
			mContext.backgroundImage[jlabelPosX][jlabelPosY + 1].bubbled();

		} else if (jlabelPosY == 9) {
			mContext.backgroundImage[jlabelPosX + 1][jlabelPosY].bubbled();
			mContext.backgroundImage[jlabelPosX - 1][jlabelPosY].bubbled();
			mContext.backgroundImage[jlabelPosX][jlabelPosY - 1].bubbled();
		} else if (jlabelPosX == 9) {
			mContext.backgroundImage[jlabelPosX - 1][jlabelPosY].bubbled();
			mContext.backgroundImage[jlabelPosX][jlabelPosY - 1].bubbled();
			mContext.backgroundImage[jlabelPosX][jlabelPosY + 1].bubbled();

		} else {
			mContext.backgroundImage[jlabelPosX][jlabelPosY + 1].bubbled();
			mContext.backgroundImage[jlabelPosX][jlabelPosY - 1].bubbled();
			mContext.backgroundImage[jlabelPosX + 1][jlabelPosY].bubbled();
			mContext.backgroundImage[jlabelPosX - 1][jlabelPosY].bubbled();

		}

	}

}