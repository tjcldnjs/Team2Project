package CrazyArcade;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PlayerRed extends JLabel implements Moveable {

	MainFrame mContext;

	private int x;
	private int y;
	private int imageIconIndex;

	private ImageIcon[] BazziUpImageArray;
	private ImageIcon[] BazziDownImageArray;
	private ImageIcon[] BazziRightImageArray;
	private ImageIcon[] BazziLeftImageArray;

	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;

	private boolean leftWallCrash;
	private boolean rightWallCrash;
	private boolean upWallCrash;
	private boolean downWallCrash;

	private final int SPEED = 1;

	PlayerWay playerWay;

	public PlayerRed(MainFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isLeftWallCrash() {
		return leftWallCrash;
	}

	public void setLeftWallCrash(boolean leftWallCrash) {
		this.leftWallCrash = leftWallCrash;
	}

	public boolean isRightWallCrash() {
		return rightWallCrash;
	}

	public void setRightWallCrash(boolean rightWallCrash) {
		this.rightWallCrash = rightWallCrash;
	}

	public boolean isUpWallCrash() {
		return upWallCrash;
	}

	public void setUpWallCrash(boolean upWallCrash) {
		this.upWallCrash = upWallCrash;
	}

	public boolean isDownWallCrash() {
		return downWallCrash;
	}

	public void setDownWallCrash(boolean downWallCrash) {
		this.downWallCrash = downWallCrash;
	}

	private void initData() {
		BazziLeftImageArray = new ImageIcon[4];
		BazziLeftImageArray[0] = new ImageIcon("img/bazzi_Left1.png");
		BazziLeftImageArray[1] = new ImageIcon("img/bazzi_Left2.png");
		BazziLeftImageArray[2] = new ImageIcon("img/bazzi_Left3.png");
		BazziLeftImageArray[3] = new ImageIcon("img/bazzi_Left4.png");

		BazziRightImageArray = new ImageIcon[5];
		BazziRightImageArray[0] = new ImageIcon("img/bazzi_Right1.png");
		BazziRightImageArray[1] = new ImageIcon("img/bazzi_Right2.png");
		BazziRightImageArray[2] = new ImageIcon("img/bazzi_Right3.png");
		BazziRightImageArray[3] = new ImageIcon("img/bazzi_Right4.png");

		BazziUpImageArray = new ImageIcon[5];
		BazziUpImageArray[0] = new ImageIcon("img/bazzi_Up1.png");
		BazziUpImageArray[1] = new ImageIcon("img/bazzi_Up2.png");
		BazziUpImageArray[2] = new ImageIcon("img/bazzi_Up3.png");
		BazziUpImageArray[3] = new ImageIcon("img/bazzi_Up4.png");
		BazziUpImageArray[4] = new ImageIcon("img/bazzi_Up5.png");

		BazziDownImageArray = new ImageIcon[5];
		BazziDownImageArray[0] = new ImageIcon("img/bazzi_Down1.png");
		BazziDownImageArray[1] = new ImageIcon("img/bazzi_Down2.png");
		BazziDownImageArray[2] = new ImageIcon("img/bazzi_Down3.png");
		BazziDownImageArray[3] = new ImageIcon("img/bazzi_Down4.png");
		BazziDownImageArray[4] = new ImageIcon("img/bazzi_Down5.png");

		x = 30;
		y = 30;

		x = 890;
		y = 790;

		left = false;
		right = false;
		up = false;
		down = false;

		leftWallCrash = false;
		rightWallCrash = false;
		upWallCrash = false;
		downWallCrash = false;

		playerWay = playerWay.DOWN;
	}

	private void setInitLayout() {
		setIcon(BazziDownImageArray[0]);
		setSize(100, 100);
		setLocation(x, y);

		mContext.repaint();
	}

	@Override
	public void left() {
		playerWay = playerWay.LEFT;
		left = true;
		imageIconIndex = 0;
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (left) {
					setIcon(BazziLeftImageArray[imageIconIndex]);
					imageIconIndex++;
					if (imageIconIndex == 4) {
						imageIconIndex = 0;
					}

					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (left) {
					if (x == 0) {
						return;
					}
					x = x - SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	@Override
	public void right() {
		playerWay = playerWay.RIGHT;
		right = true;
		imageIconIndex = 0;
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (right) {
					setIcon(BazziRightImageArray[imageIconIndex]);
					imageIconIndex++;
					if (imageIconIndex == 4) {
						imageIconIndex = 0;
					}
					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (right) {
					if (x == 896) {
						return;
					}
					x = x + SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	@Override
	public void up() {
		playerWay = playerWay.UP;
		up = true;
		imageIconIndex = 0;
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (up) {
					setIcon(BazziUpImageArray[imageIconIndex]);
					imageIconIndex++;
					if (imageIconIndex == 5) {
						imageIconIndex = 0;
					}
					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (up) {
					if (y == 0) {
						return;
					}
					y = y - SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	@Override
	public void down() {
		playerWay = playerWay.DOWN;
		down = true;
		imageIconIndex = 0;
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (down) {
					setIcon(BazziDownImageArray[imageIconIndex]);
					imageIconIndex++;
					if (imageIconIndex == 5) {
						imageIconIndex = 0;
					}
					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (down) {
					if (y == 898) {
						return;
					}
					y = y + SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	public void attack() {
		new Thread(() -> {
//			new Bubble(mContext, this);

		}).start();

		new Thread(new Bubble(mContext, this)).start();
	}

}
