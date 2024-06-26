package CrazyArcade;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BackgroundImage extends JLabel {

	private int x;
	private int y;

	private ImageIcon unbreakBox;
	private ImageIcon breakBox;
	private ImageIcon floor;
	private ImageIcon bomb;
	private ImageIcon bombUp;
	private ImageIcon bombDown;
	private ImageIcon bombRight;
	private ImageIcon bombLeft;

	private MainFrame mContext;

	boolean flag = false;

	private int imageStatus;

	public BackgroundImage(MainFrame mContext, int i, int j) {
		this.mContext = mContext;
		this.x = j * 100;
		this.y = i * 100;
		unbreakBox = new ImageIcon("img/vilige_Box_M1.png");
		breakBox = new ImageIcon("img/box_breakable.png");
		floor = new ImageIcon("img/main_background1.png");

		bomb = new ImageIcon("img/bombed.png");
		bombUp = new ImageIcon("img/bombup.png");
		bombDown = new ImageIcon("img/bombdown.png");
		bombRight = new ImageIcon("img/bombright.png");
		bombLeft = new ImageIcon("img/bombleft.png");

		initData();
	}

	public void initData() {
		setSize(100, 100);
		setLocation(x, y);
		setVisible(true);
	}

	public void setInitLayout() {
	}

	public void setBackgroundImage(int i) {
		if (i == 0) { // 0(white)면 바닥
			setIcon(floor);
			imageStatus = 0;
		} else if (i == 1) { // 1(red)면 부숴지지 않는 상자 생성
			setIcon(unbreakBox);
			imageStatus = 1;
		} else if (i == 2) { // 2(blue)면 부숴지는 상자 생성
			setIcon(breakBox);
			imageStatus = 2;
		}
	}

	public boolean bubbled(String bombImage, int y, int x) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// 버블이 터진후 바닥까지 없어지던 상황을
				// reviseBufferImage로 바닥 다시 깔아줌
				if (bombImage.equals("bomb")) {
					playerDie(x, y);
					setIcon(bomb);
					clearbubble();

					mContext.reviseBufferImage(x, y);

				} else if (bombImage.equals("bombUp") && imageStatus != 1) {
					playerDie(x, y);
					setIcon(bombUp);
					clearbubble();

					mContext.reviseBufferImage(x, y);

				} else if (bombImage.equals("bombDown") && imageStatus != 1) {
					playerDie(x, y);
					setIcon(bombDown);
					clearbubble();
					mContext.reviseBufferImage(x, y);
				} else if (bombImage.equals("bombLeft") && imageStatus != 1) {
					playerDie(x, y);
					setIcon(bombLeft);
					clearbubble();
					mContext.reviseBufferImage(x, y);
				} else if (bombImage.equals("bombRight") && imageStatus != 1) {
					playerDie(x, y);
					setIcon(bombRight);
					clearbubble();
					mContext.reviseBufferImage(x, y);
				}
			}
		}).start();
		return true;
	}

	public boolean clearbubble() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		setIcon(floor);
		flag = false;
		return true;
	}

	public void playerDie(int x, int y) {
		int BlueX = mContext.player1.getX() + 50;
		int BlueY = mContext.player1.getY() + 80;
		int RedX = mContext.player2.getX() + 50;
		int RedY = mContext.player2.getY() + 80;

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i * 100 < BlueX && BlueX <= (i + 1) * 100 && j * 100 <= BlueY && BlueY <= (j + 1) * 100) {
					if (i == x && j == y) {
						mContext.player1.die(1);
					}
				}
				if (i * 100 < RedX && RedX <= (i + 1) * 100 && j * 100 <= RedY && RedY <= (j + 1) * 100) {
					if (i == x && j == y) {

						mContext.player2.die(2);
					}

				}

			}
		}
	}

}
