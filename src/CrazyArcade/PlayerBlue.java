package CrazyArcade;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PlayerBlue extends JLabel implements Moveable {

	MainFrame mContext;

	private int x;
	private int y;
	private int imageIconIndex;

	private ImageIcon[] DaoUpImageArray;
	private ImageIcon[] DaoDownImageArray;
	private ImageIcon[] DaoRightImageArray;
	private ImageIcon[] DaoLeftImageArray;

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

	public PlayerBlue(MainFrame mContext) {
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

		DaoUpImageArray = new ImageIcon[5];

		DaoUpImageArray[0] = new ImageIcon("img/Dao_Up1.png");
		DaoUpImageArray[1] = new ImageIcon("img/Dao_Up2.png");
		DaoUpImageArray[2] = new ImageIcon("img/Dao_Up3.png");
		DaoUpImageArray[3] = new ImageIcon("img/Dao_Up4.png");
		DaoUpImageArray[4] = new ImageIcon("img/Dao_Up5.png");

		DaoDownImageArray = new ImageIcon[5];

		DaoDownImageArray[0] = new ImageIcon("img/Dao_Down1.png");
		DaoDownImageArray[1] = new ImageIcon("img/Dao_Down2.png");
		DaoDownImageArray[2] = new ImageIcon("img/Dao_Down3.png");
		DaoDownImageArray[3] = new ImageIcon("img/Dao_Down4.png");
		DaoDownImageArray[4] = new ImageIcon("img/Dao_Down5.png");

		DaoLeftImageArray = new ImageIcon[5];

		DaoLeftImageArray[0] = new ImageIcon("img/Dao_Left1.png");
		DaoLeftImageArray[1] = new ImageIcon("img/Dao_Left2.png");
		DaoLeftImageArray[2] = new ImageIcon("img/Dao_Left3.png");
		DaoLeftImageArray[3] = new ImageIcon("img/Dao_Left4.png");
		DaoLeftImageArray[4] = new ImageIcon("img/Dao_Left5.png");

		DaoRightImageArray = new ImageIcon[5];

		DaoRightImageArray[0] = new ImageIcon("img/Dao_Right1.png");
		DaoRightImageArray[1] = new ImageIcon("img/Dao_Right2.png");
		DaoRightImageArray[2] = new ImageIcon("img/Dao_Right3.png");
		DaoRightImageArray[3] = new ImageIcon("img/Dao_Right4.png");
		DaoRightImageArray[4] = new ImageIcon("img/Dao_Right5.png");

		left = false;
		right = false;
		up = false;
		down = false;

		x = 10;
		y = 100;

		leftWallCrash = false;
		rightWallCrash = false;
		upWallCrash = false;
		downWallCrash = false;

		playerWay = playerWay.DOWN;
	}

	private void setInitLayout() {
		setIcon(DaoDownImageArray[0]);
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
					setIcon(DaoLeftImageArray[imageIconIndex]);
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

					setIcon(DaoRightImageArray[imageIconIndex]);
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

	public void up() {
		playerWay = playerWay.UP;
		up = true;
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (up) {
					setIcon(DaoUpImageArray[imageIconIndex]);
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

	public void down() {
		playerWay = playerWay.DOWN;
		down = true;
		imageIconIndex = 0;
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (down) {
					setIcon(DaoDownImageArray[imageIconIndex]);
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
<<<<<<< HEAD
		new Thread(() -> {
//			new Bubble(mContext, this);
		}).start();
=======
				
		new Thread(new Bubble(mContext, this)).start();
>>>>>>> 5a9ab3fee0df0b9348029e57fea71e1d5ea0fe80

	}

}
