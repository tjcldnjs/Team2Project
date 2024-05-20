package CrazyArcade;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable {

	MainFrame mContext;
	// 나의 겉모습 이미지

	private int playerX;
	private int playerY;
	private int imageIconIndex;
	private int playerNum;
	int bubbleCountRed = 0; // get set

	private ImageIcon[] UpImageArray;
	private ImageIcon[] DownImageArray;
	private ImageIcon[] RightImageArray;
	private ImageIcon[] LeftImageArray;
	private ImageIcon[] DieArray;

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

	public int getX() {
		return playerX;
	}

	public int getY() {
		return playerY;
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

	public Player(int playerNum, MainFrame mContext) {
		this.playerNum = playerNum;
		this.mContext = mContext;
		initData();
		setInitLayout();
	}

	private void initData() {
		// 걷는 모션
		if (playerNum == 2) {
			LeftImageArray = new ImageIcon[5];
			LeftImageArray[0] = new ImageIcon("img/Dao_Left1.png");
			LeftImageArray[1] = new ImageIcon("img/Dao_Left2.png");
			LeftImageArray[2] = new ImageIcon("img/Dao_Left3.png");
			LeftImageArray[3] = new ImageIcon("img/Dao_Left4.png");
			LeftImageArray[4] = new ImageIcon("img/Dao_Left5.png");

			RightImageArray = new ImageIcon[5];
			RightImageArray[0] = new ImageIcon("img/Dao_Right1.png");
			RightImageArray[1] = new ImageIcon("img/Dao_Right2.png");
			RightImageArray[2] = new ImageIcon("img/Dao_Right3.png");
			RightImageArray[3] = new ImageIcon("img/Dao_Right4.png");
			RightImageArray[4] = new ImageIcon("img/Dao_Right5.png");

			UpImageArray = new ImageIcon[5];
			UpImageArray[0] = new ImageIcon("img/Dao_Up1.png");
			UpImageArray[1] = new ImageIcon("img/Dao_Up2.png");
			UpImageArray[2] = new ImageIcon("img/Dao_Up3.png");
			UpImageArray[3] = new ImageIcon("img/Dao_Up4.png");
			UpImageArray[4] = new ImageIcon("img/Dao_Up5.png");

			DownImageArray = new ImageIcon[5];
			DownImageArray[0] = new ImageIcon("img/Dao_Down1.png");
			DownImageArray[1] = new ImageIcon("img/Dao_Down2.png");
			DownImageArray[2] = new ImageIcon("img/Dao_Down3.png");
			DownImageArray[3] = new ImageIcon("img/Dao_Down4.png");
			DownImageArray[4] = new ImageIcon("img/Dao_Down5.png");

			DieArray = new ImageIcon[5];
			DieArray[0] = new ImageIcon("img/bluedie1.png");
			DieArray[1] = new ImageIcon("img/bluedie2.png");
			DieArray[2] = new ImageIcon("img/bluedie3.png");
			DieArray[3] = new ImageIcon("img/bluedie4.png");
			DieArray[4] = new ImageIcon("img/bluedie5.png");
		} else {
			LeftImageArray = new ImageIcon[4];
			LeftImageArray[0] = new ImageIcon("img/bazzi_Left1.png");
			LeftImageArray[1] = new ImageIcon("img/bazzi_Left2.png");
			LeftImageArray[2] = new ImageIcon("img/bazzi_Left3.png");
			LeftImageArray[3] = new ImageIcon("img/bazzi_Left4.png");

			RightImageArray = new ImageIcon[4];
			RightImageArray[0] = new ImageIcon("img/bazzi_Right1.png");
			RightImageArray[1] = new ImageIcon("img/bazzi_Right2.png");
			RightImageArray[2] = new ImageIcon("img/bazzi_Right3.png");
			RightImageArray[3] = new ImageIcon("img/bazzi_Right4.png");

			UpImageArray = new ImageIcon[5];
			UpImageArray[0] = new ImageIcon("img/bazzi_Up1.png");
			UpImageArray[1] = new ImageIcon("img/bazzi_Up2.png");
			UpImageArray[2] = new ImageIcon("img/bazzi_Up3.png");
			UpImageArray[3] = new ImageIcon("img/bazzi_Up4.png");
			UpImageArray[4] = new ImageIcon("img/bazzi_Up5.png");

			DownImageArray = new ImageIcon[5];
			DownImageArray[0] = new ImageIcon("img/bazzi_Down1.png");
			DownImageArray[1] = new ImageIcon("img/bazzi_Down2.png");
			DownImageArray[2] = new ImageIcon("img/bazzi_Down3.png");
			DownImageArray[3] = new ImageIcon("img/bazzi_Down4.png");
			DownImageArray[4] = new ImageIcon("img/bazzi_Down5.png");

			DieArray = new ImageIcon[5];
			DieArray[0] = new ImageIcon("img/reddie1.png");
			DieArray[1] = new ImageIcon("img/reddie2.png");
			DieArray[2] = new ImageIcon("img/reddie3.png");
			DieArray[3] = new ImageIcon("img/reddie4.png");
			DieArray[4] = new ImageIcon("img/reddie5.png");
		}

		if (playerNum == 2) {
			// 플레이어 블루 값 넣기
			playerX = 10;
			playerY = 100;
		} else {
			playerX = 890;
			playerY = 790;
		}
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
		if (playerNum == 1) {
			setIcon(DownImageArray[0]);
		} else {
			setIcon(DownImageArray[0]); // 교체

		}

		setSize(mContext.PANEL_SIZE_XY, mContext.PANEL_SIZE_XY); // 100 x 100
		setLocation(playerX, playerY);

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
					setIcon(LeftImageArray[imageIconIndex]);
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
					if (playerX == 0) {
						return;
					}
					playerX = playerX - SPEED;
					setLocation(playerX, playerY);
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
					setIcon(RightImageArray[imageIconIndex]);
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
					if (playerX == 896) {
						return;
					}
					playerX = playerX + SPEED;
					setLocation(playerX, playerY);
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
					setIcon(UpImageArray[imageIconIndex]);
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
					if (playerY == 0) {
						return;
					}
					playerY = playerY - SPEED;
					setLocation(playerX, playerY);
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
					setIcon(DownImageArray[imageIconIndex]);
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
					if (playerY == 898) {
						return;
					}
					playerY = playerY + SPEED;
					setLocation(playerX, playerY);
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	public void die(int playerNum) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < DieArray.length; i++) {

					setIcon(DieArray[i]);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (playerNum == 1) {
					mContext.player1.setVisible(false);
				} else {
					mContext.player2.setVisible(false);

				}

			}
		}).start();

	}

	public void attack() {

		int playerPosX = playerX + 50; // 버블의 X좌표를 정가운데 오게 만듬.
		int playerPosY = playerY + 80; // 버블의 Y좌표를 정가운데 오게 만듬.
		System.out.println(bubbleCountRed);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i * 100 < playerPosX && playerPosX <= (i + 1) * 100 && j * 100 <= playerPosY
						&& playerPosY <= (j + 1) * 100) {
					if (mContext.backgroundImage[j][i].flag == false) {
						mContext.backgroundImage[j][i].flag = true;
						Bubble bubble = new Bubble(mContext, playerNum, j, i);
						new Thread(bubble).start();

					} else {
						System.out.println("이미 버블이 있음");
					}

				}

			}
		}

	}

}
