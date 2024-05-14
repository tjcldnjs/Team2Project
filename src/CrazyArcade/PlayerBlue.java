package CrazyArcade;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PlayerBlue extends JLabel implements Moveable {

	MainFrame mContext;

	private int x;
	private int y;
	private int walkCount;

	private ImageIcon DaoUp1;
	private ImageIcon DaoUp2;
	private ImageIcon DaoUp3;
	private ImageIcon DaoUp4;
	private ImageIcon DaoUp5;

	private ImageIcon DaoDown1;
	private ImageIcon DaoDown2;
	private ImageIcon DaoDown3;
	private ImageIcon DaoDown4;
	private ImageIcon DaoDown5;

	private ImageIcon DaoR1;
	private ImageIcon DaoR2;
	private ImageIcon DaoR3;
	private ImageIcon DaoR4;
	private ImageIcon DaoR5;

	private ImageIcon DaoL1;
	private ImageIcon DaoL2;
	private ImageIcon DaoL3;
	private ImageIcon DaoL4;
	private ImageIcon DaoL5;

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
		DaoUp1 = new ImageIcon("img/Dao_Up1.png");
		DaoUp2 = new ImageIcon("img/Dao_Up2.png");
		DaoUp3 = new ImageIcon("img/Dao_Up3.png");
		DaoUp4 = new ImageIcon("img/Dao_Up4.png");
		DaoUp5 = new ImageIcon("img/Dao_Up5.png");

		DaoDown1 = new ImageIcon("img/Dao_Down1.png");
		DaoDown2 = new ImageIcon("img/Dao_Down2.png");
		DaoDown3 = new ImageIcon("img/Dao_Down3.png");
		DaoDown4 = new ImageIcon("img/Dao_Down4.png");
		DaoDown5 = new ImageIcon("img/Dao_Down5.png");

		DaoL1 = new ImageIcon("img/Dao_Left1.png");
		DaoL2 = new ImageIcon("img/Dao_Left2.png");
		DaoL3 = new ImageIcon("img/Dao_Left3.png");
		DaoL4 = new ImageIcon("img/Dao_Left4.png");
		DaoL5 = new ImageIcon("img/Dao_Left5.png");

		DaoR1 = new ImageIcon("img/Dao_Right1.png");
		DaoR2 = new ImageIcon("img/Dao_Right2.png");
		DaoR3 = new ImageIcon("img/Dao_Right3.png");
		DaoR4 = new ImageIcon("img/Dao_Right4.png");
		DaoR5 = new ImageIcon("img/Dao_Right5.png");

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
		setIcon(DaoDown1);
		setSize(100, 100);
		setLocation(x, y);

		mContext.panelCenter.add(this);
		mContext.repaint();
	}

	@Override
	public void left() {
		playerWay = playerWay.LEFT;
		left = true;
		walkCount = 0;
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (left) {
					if (walkCount == 0) {
						setIcon(DaoL5);
						walkCount = 1;
					} else if (walkCount == 1) {
						setIcon(DaoL4);
						walkCount = 2;
					} else if (walkCount == 2) {
						setIcon(DaoL3);
						walkCount = 3;
					} else if (walkCount == 3) {
						setIcon(DaoL2);
						walkCount = 4;
					} else if (walkCount == 4) {
						setIcon(DaoL1);
						walkCount = 0;
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
		walkCount = 0;
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (right) {
					if (walkCount == 0) {
						setIcon(DaoR5);
						walkCount = 1;
					} else if (walkCount == 1) {
						setIcon(DaoR4);
						walkCount = 2;
					} else if (walkCount == 2) {
						setIcon(DaoR3);
						walkCount = 3;
					} else if (walkCount == 3) {
						setIcon(DaoR2);
						walkCount = 4;
					} else if (walkCount == 4) {
						setIcon(DaoR1);
						walkCount = 0;
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
		walkCount = 0;
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (up) {
					if (walkCount == 0) {
						setIcon(DaoUp5);
						walkCount = 1;
					} else if (walkCount == 1) {
						setIcon(DaoUp4);
						walkCount = 2;
					} else if (walkCount == 2) {
						setIcon(DaoUp3);
						walkCount = 3;
					} else if (walkCount == 3) {
						setIcon(DaoUp2);
						walkCount = 4;
					} else if (walkCount == 4) {
						setIcon(DaoUp1);
						walkCount = 0;
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
		walkCount = 0;
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (down) {
					if (walkCount == 0) {
						setIcon(DaoDown5);
						walkCount = 1;
					} else if (walkCount == 1) {
						setIcon(DaoDown4);
						walkCount = 2;
					} else if (walkCount == 2) {
						setIcon(DaoDown3);
						walkCount = 3;
					} else if (walkCount == 3) {
						setIcon(DaoDown2);
						walkCount = 4;
					} else if (walkCount == 4) {
						setIcon(DaoDown1);
						walkCount = 0;
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
			new Bubble(mContext, this);
		}).start();

	}

}
