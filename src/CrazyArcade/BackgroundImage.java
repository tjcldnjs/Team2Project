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
		unbreakBox = new ImageIcon("img/box_unbreak.png");
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
		if (i == 0) {
			setIcon(floor);
			imageStatus = 0;
		} else if (i == 1) {
			setIcon(unbreakBox);
			imageStatus = 1;
		} else if (i == 2) {
			setIcon(breakBox);
			imageStatus = 2;
		}
	}

	public void bubbled(String bombImage, int y, int x) {
		new Thread(new Runnable() {

			@Override
			public void run() {

				if (imageStatus == 1 || imageStatus == 0) {

				} else if (imageStatus == 2) {
					setIcon(floor);
					mContext.reviseBufferImage(x, y);
				}
				if (bombImage.equals("bomb")) {
					setIcon(bomb);					
					mContext.reviseBufferImage(x, y);

				} else if (bombImage.equals("bombUp")) {
					setIcon(bombUp);
					mContext.reviseBufferImage(x, y);
				} else if (bombImage.equals("bombDown")) {
					setIcon(bombDown);
					mContext.reviseBufferImage(x, y);
				} else if (bombImage.equals("bombLeft")) {
					setIcon(bombLeft);
					mContext.reviseBufferImage(x, y);
				} else if (bombImage.equals("bombRight")) {
					setIcon(bombRight);
					mContext.reviseBufferImage(x, y);
				}
				clearbubble();
			}
		}).start();
	}

	public void clearbubble() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		setIcon(floor);
		flag = false;
	}

}
