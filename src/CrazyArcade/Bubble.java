package CrazyArcade;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bubble extends JLabel implements Runnable {
	MainFrame mContext;
	PlayerBlue playerBlue;
	PlayerRed playerRed;
	
	// static --> 공유 ---> 각자 정보 --> 멤버 변수 --> (시리얼 넘버, 사원 번호) 
	// 1000 <--- 시리얼 
	// 나의 고유 사원 번호  1000 <-- 나의 멤버 변수에 저장하고 , 시리얼 번호 증감 1 
	
	// 플리어가Red --> 5개  (Bubble, Bubble, Bubble , Bubble , Bubble - 색상 ) 
	
	// 플리어가Blue --> 5개 (Bubble, Bubble, Bubble , Bubble, ,Bubble - 색상  )
	
	

	int bubblePosX;
	int bubblePosY;
	int playerPosX;
	int playerPosY;
	int jLabelPosX;
	int jLabelPosY;

	private ImageIcon bubble;

	private int imageChaneIndex;
	
	boolean status = true;

	private ImageIcon bombomb_Action__main;
	private ImageIcon bombomb_Action_1;
	private ImageIcon bombomb_Action_2;
	private ImageIcon bombomb_Action_3;

	public Bubble(MainFrame mContext, PlayerRed playerRed, int jLabelPosx, int jLabelPosY) {
		this.mContext = mContext;
		this.playerRed = playerRed;
		playerPosX = playerRed.getX() + 50;
		playerPosY = playerRed.getY() + 80;
		this.jLabelPosX = jLabelPosx;
		this.jLabelPosY = jLabelPosY;
		BubbleBackground bubbleBackground = new BubbleBackground(this, playerRed);
		new Thread(bubbleBackground).start();

	}

	private ImageIcon[] imageChangeArray;

	public Bubble(MainFrame mContext, PlayerBlue playerBlue, int jLabelPosx, int jLabelPosY) {
		this.mContext = mContext;
		this.playerBlue = playerBlue;
		playerPosX = playerBlue.getX() + 50;
		this.jLabelPosX = jLabelPosx;
		this.jLabelPosY = jLabelPosY;
		BubbleBackground bubbleBackground = new BubbleBackground(this,playerBlue);
		new Thread(bubbleBackground).start();

	}

	private ImageIcon bomb;
	private ImageIcon bombdown;
	private ImageIcon bombleft;
	private ImageIcon bombright;
	private ImageIcon bombup;

	@Override
	public void run() {
		
		bubblePosX = jLabelPosY * 100;
		bubblePosY = jLabelPosX * 100;

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
				e.printStackTrace();
			}
		}

		if (jLabelPosX == 0 && jLabelPosY == 0) {
			if (bomb() == true && bombDown() == true && bombRight() == true) {
				mContext.nullBubble(this);
			}

		} else if (jLabelPosX == 9 && jLabelPosY == 0) {
			if (bomb() == true && bombUp() == true && bombRight() == true) {
				mContext.nullBubble(this);
			}

		} else if (jLabelPosX == 0 && jLabelPosY == 9) {
			if (bomb() == true && bombDown() == true && bombLeft() == true) {
				mContext.nullBubble(this);
			}

		} else if (jLabelPosX == 9 && jLabelPosY == 9) {
			if (bomb() == true && bombUp() == true && bombLeft() == true) {
				mContext.nullBubble(this);
			}

		} else if (jLabelPosX == 0) {
			if (bomb() == true && bombDown() == true && bombRight() == true && bombLeft() == true) {
				mContext.nullBubble(this);
			}

		} else if (jLabelPosX == 9) {
			if (bomb() == true && bombUp() == true && bombRight() == true && bombLeft() == true) {
				mContext.nullBubble(this);
			}
		} else if (jLabelPosY == 0) {
			if (bomb() == true && bombDown() == true && bombUp() == true && bombRight() == true) {
				mContext.nullBubble(this);
			}
		} else if (jLabelPosY == 9) {
			if (bomb() == true && bombDown() == true && bombUp() == true && bombLeft() == true) {
				mContext.nullBubble(this);
			}

		} else {
			if (bomb() == true && bombDown() == true && bombRight() == true && bombLeft() == true && bombUp() == true) {
				mContext.nullBubble(this);
			}
		}

		// get set
	}

	public boolean bomb() {
		return mContext.backgroundImage[jLabelPosX][jLabelPosY].bubbled("bomb", jLabelPosX, jLabelPosY);
	}

	public boolean bombUp() {
		return mContext.backgroundImage[jLabelPosX - 1][jLabelPosY].bubbled("bombUp", jLabelPosX - 1, jLabelPosY);
	}

	public boolean bombDown() {
		return mContext.backgroundImage[jLabelPosX + 1][jLabelPosY].bubbled("bombDown", jLabelPosX + 1, jLabelPosY);
	}

	public boolean bombLeft() {
		return mContext.backgroundImage[jLabelPosX][jLabelPosY - 1].bubbled("bombLeft", jLabelPosX, jLabelPosY - 1);
	}

	public boolean bombRight() {
		return mContext.backgroundImage[jLabelPosX][jLabelPosY + 1].bubbled("bombRight", jLabelPosX, jLabelPosY + 1);
	}

}