package CrazyArcade;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PlayerRed extends JLabel implements Moveable {

	MainFrame mContext;

	private int x;
	private int y;
	private int walkCount;

	private ImageIcon bazziUp1;
	private ImageIcon bazziUp2;
	private ImageIcon bazziUp3;
	private ImageIcon bazziUp4;
	private ImageIcon bazziUp5;

	private ImageIcon bazziDown1;
	private ImageIcon bazziDown2;
	private ImageIcon bazziDown3;
	private ImageIcon bazziDown4;
	private ImageIcon bazziDown5;

	private ImageIcon bazziR1;
	private ImageIcon bazziR2;
	private ImageIcon bazziR3;
	private ImageIcon bazziR4;

	private ImageIcon bazziL1;
	private ImageIcon bazziL2;
	private ImageIcon bazziL3;
	private ImageIcon bazziL4;

	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;

	private boolean leftWallCrash;
	private boolean rightWallCrash;
	private boolean upWallCrash;
	private boolean downWallCrash;

	private final int SPEED = 2;

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
		bazziL1 = new ImageIcon("img/bazzi_Left1.png");
		bazziL2 = new ImageIcon("img/bazzi_Left2.png");
		bazziL3 = new ImageIcon("img/bazzi_Left3.png");
		bazziL4 = new ImageIcon("img/bazzi_Left4.png");

		bazziR1 = new ImageIcon("img/bazzi_Right1.png");
		bazziR2 = new ImageIcon("img/bazzi_Right2.png");
		bazziR3 = new ImageIcon("img/bazzi_Right3.png");
		bazziR4 = new ImageIcon("img/bazzi_Right4.png");

		bazziUp1 = new ImageIcon("img/bazzi_Up1.png");
		bazziUp2 = new ImageIcon("img/bazzi_Up2.png");
		bazziUp3 = new ImageIcon("img/bazzi_Up3.png");
		bazziUp4 = new ImageIcon("img/bazzi_Up4.png");
		bazziUp5 = new ImageIcon("img/bazzi_Up5.png");

		bazziDown1 = new ImageIcon("img/bazzi_Down1.png");
		bazziDown2 = new ImageIcon("img/bazzi_Down2.png");
		bazziDown3 = new ImageIcon("img/bazzi_Down3.png");
		bazziDown4 = new ImageIcon("img/bazzi_Down4.png");
		bazziDown5 = new ImageIcon("img/bazzi_Down5.png");

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
		setIcon(bazziDown1);
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
					System.out.println(walkCount);
					if (walkCount == 0) {
						setIcon(bazziL4);
						walkCount = 1;
					} else if (walkCount == 1) {
						setIcon(bazziL3);
						walkCount = 2;
					} else if (walkCount == 2) {
						setIcon(bazziL2);
						walkCount = 3;
					} else if (walkCount == 3) {
						setIcon(bazziL1);
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
					System.out.println(walkCount);
					if (walkCount == 0) {
						setIcon(bazziR1);
						walkCount = 1;
					} else if (walkCount == 1) {
						setIcon(bazziR2);
						walkCount = 2;
					} else if (walkCount == 2) {
						setIcon(bazziR3);
						walkCount = 3;
					} else if (walkCount == 3) {
						setIcon(bazziR4);
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

	@Override
	public void up() {
		playerWay = playerWay.UP;
		up = true;
		walkCount = 0;
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (up) {
					if (walkCount == 0) {
						setIcon(bazziUp1);
						walkCount = 1;
					} else if (walkCount == 1) {
						setIcon(bazziUp2);
						walkCount = 2;
					} else if (walkCount == 2) {
						setIcon(bazziUp3);
						walkCount = 3;
					} else if (walkCount == 3) {
						setIcon(bazziUp4);
						walkCount = 4;
					} else if (walkCount == 4) {
						setIcon(bazziUp5);
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

	@Override
	public void down() {
		playerWay = playerWay.DOWN;
		down = true;
		walkCount = 0;
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (down) {
					if (walkCount == 0) {
						setIcon(bazziDown1);
						walkCount = 1;
					} else if (walkCount == 1) {
						setIcon(bazziDown2);
						walkCount = 2;
					} else if (walkCount == 2) {
						setIcon(bazziDown3);
						walkCount = 3;
					} else if (walkCount == 3) {
						setIcon(bazziDown4);
						walkCount = 4;
					} else if (walkCount == 4) {
						setIcon(bazziDown5);
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
//			new Bubble(mContext, this);

		}).start();

	}

}
