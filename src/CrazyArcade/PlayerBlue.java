package CrazyArcade;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PlayerBlue extends JLabel implements Moveable {

	MainFrame mContext;
//	Bubble bubble;

	private int walkCount;
	private int x;
	private int y;
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

	public MainFrame getmContext2() {
		return mContext;
	}

	public void setmContext2(MainFrame mContext2) {
		this.mContext = mContext2;
	}

//	public Bubble getBubble() {
//		return bubble;
//	}
//
//	public void setBubble(Bubble bubble) {
//		this.bubble = bubble;
//	}

	public int getWalkCount() {
		return walkCount;
	}

	public void setWalkCount(int walkCount) {
		this.walkCount = walkCount;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ImageIcon getDaoUp1() {
		return DaoUp1;
	}

	public void setDaoUp1(ImageIcon daoUp1) {
		DaoUp1 = daoUp1;
	}

	public ImageIcon getDaoUp2() {
		return DaoUp2;
	}

	public void setDaoUp2(ImageIcon daoUp2) {
		DaoUp2 = daoUp2;
	}

	public ImageIcon getDaoUp3() {
		return DaoUp3;
	}

	public void setDaoUp3(ImageIcon daoUp3) {
		DaoUp3 = daoUp3;
	}

	public ImageIcon getDaoUp4() {
		return DaoUp4;
	}

	public void setDaoUp4(ImageIcon daoUp4) {
		DaoUp4 = daoUp4;
	}

	public ImageIcon getDaoUp5() {
		return DaoUp5;
	}

	public void setDaoUp5(ImageIcon daoUp5) {
		DaoUp5 = daoUp5;
	}

	public ImageIcon getDaoDown1() {
		return DaoDown1;
	}

	public void setDaoDown1(ImageIcon daoDown1) {
		DaoDown1 = daoDown1;
	}

	public ImageIcon getDaoDown2() {
		return DaoDown2;
	}

	public void setDaoDown2(ImageIcon daoDown2) {
		DaoDown2 = daoDown2;
	}

	public ImageIcon getDaoDown3() {
		return DaoDown3;
	}

	public void setDaoDown3(ImageIcon daoDown3) {
		DaoDown3 = daoDown3;
	}

	public ImageIcon getDaoDown4() {
		return DaoDown4;
	}

	public void setDaoDown4(ImageIcon daoDown4) {
		DaoDown4 = daoDown4;
	}

	public ImageIcon getDaoDown5() {
		return DaoDown5;
	}

	public void setDaoDown5(ImageIcon daoDown5) {
		DaoDown5 = daoDown5;
	}

	public ImageIcon getDaoR1() {
		return DaoR1;
	}

	public void setDaoR1(ImageIcon daoR1) {
		DaoR1 = daoR1;
	}

	public ImageIcon getDaoR2() {
		return DaoR2;
	}

	public void setDaoR2(ImageIcon daoR2) {
		DaoR2 = daoR2;
	}

	public ImageIcon getDaoR3() {
		return DaoR3;
	}

	public void setDaoR3(ImageIcon daoR3) {
		DaoR3 = daoR3;
	}

	public ImageIcon getDaoR4() {
		return DaoR4;
	}

	public void setDaoR4(ImageIcon daoR4) {
		DaoR4 = daoR4;
	}

	public ImageIcon getDaoR5() {
		return DaoR5;
	}

	public void setDaoR5(ImageIcon daoR5) {
		DaoR5 = daoR5;
	}

	public ImageIcon getDaoL1() {
		return DaoL1;
	}

	public void setDaoL1(ImageIcon daoL1) {
		DaoL1 = daoL1;
	}

	public ImageIcon getDaoL2() {
		return DaoL2;
	}

	public void setDaoL2(ImageIcon daoL2) {
		DaoL2 = daoL2;
	}

	public ImageIcon getDaoL3() {
		return DaoL3;
	}

	public void setDaoL3(ImageIcon daoL3) {
		DaoL3 = daoL3;
	}

	public ImageIcon getDaoL4() {
		return DaoL4;
	}

	public void setDaoL4(ImageIcon daoL4) {
		DaoL4 = daoL4;
	}

	public ImageIcon getDaoL5() {
		return DaoL5;
	}

	public void setDaoL5(ImageIcon daoL5) {
		DaoL5 = daoL5;
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

	public PlayerWay getPlayerWay() {
		return playerWay;
	}

	public void setPlayerWay(PlayerWay playerWay) {
		this.playerWay = playerWay;
	}

	public int getSPEED() {
		return SPEED;
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


		x = 900;
		y = 900;
		x = 10;
		y = 10;

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
//			new Bubble(mContext, this);
		}).start();

	}

}// end of class
