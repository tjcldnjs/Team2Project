package CrazyArcade;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

// Player 

// PlayerBlue
// 키보드 이벤트 오버라이드 처리 ( 직접 이벤트 구현)

//PlayerRed
//키보드 이벤트 오버라이드 처리 (직접 이벤트 구현) 

// MainF
// Player p1 = new PlayerBlue();
//Player  p2 = new PlayerRed();

// Player  n1 = new Player();
// Player n2 = new Player();

public class PlayerRed extends JLabel implements Moveable {

	MainFrame mContext;
	// 나의 겉모습 이미지

	private int x;
	private int y;
	private int imageIconIndex;
	int bubbleCountRed = 0; // get set

	private ImageIcon[] BazziUpImageArray;
	private ImageIcon[] BazziDownImageArray;
	private ImageIcon[] BazziRightImageArray;
	private ImageIcon[] BazziLeftImageArray;
	private ImageIcon[] BazziDieArray;

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

		BazziDieArray = new ImageIcon[5];
		BazziDieArray[0] = new ImageIcon("img/reddie1.png");
		BazziDieArray[1] = new ImageIcon("img/reddie2.png");
		BazziDieArray[2] = new ImageIcon("img/reddie3.png");
		BazziDieArray[3] = new ImageIcon("img/reddie4.png");
		BazziDieArray[4] = new ImageIcon("img/reddie5.png");

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
	public void redDie() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < BazziDieArray.length; i++) {

					setIcon(BazziDieArray[i]);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				mContext.playerRed.setVisible(false);
			}
		}).start();

	}

	public void attack() {

		int playerPosX = x + 50;
		int playerPosY = y + 80;
		System.out.println(bubbleCountRed);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i * 100 < playerPosX && playerPosX <= (i + 1) * 100 && j * 100 <= playerPosY
						&& playerPosY <= (j + 1) * 100) {
					if (mContext.backgroundImage[j][i].flag == false) {
						mContext.backgroundImage[j][i].flag = true;
						Bubble bubble = new Bubble(mContext, this, j, i);
						new Thread(bubble).start();

					} else {
						System.out.println("이미 버블이 있음");
					}

				}

			}
		}

	}

}
