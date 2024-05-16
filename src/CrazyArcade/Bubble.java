package CrazyArcade;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Bubble extends JLabel implements Runnable{
    MainFrame mContext;
    PlayerBlue playerBlue;
    PlayerRed playerRed;

    static int bubbleCount;
  //  static int bubbleCountBlue;

	int bubblePosX;
	int bubblePosY;
	int playerPosX;
	int playerPosY;
	int jLabelPosX;
	int jLabelPosY;

    private ImageIcon bubble;

   

	private int imageChaneIndex;

	private ImageIcon bombomb_Action__main;
	private ImageIcon bombomb_Action_1;
	private ImageIcon bombomb_Action_2;
	private ImageIcon bombomb_Action_3;

    public Bubble(MainFrame mContext, PlayerRed playerRed) {
        this.mContext = mContext;
        this.playerRed = playerRed;
        playerPosX = playerRed.getX()+50; 
        playerPosY = playerRed.getY()+80;
        bubbleCount++;
    }

	private ImageIcon[] imageChangeArray;

    public Bubble(MainFrame mContext, PlayerBlue playerBlue) {
        this.mContext = mContext;
        this.playerBlue = playerBlue;
        playerPosX = playerBlue.getX()+50;
        playerPosY = playerBlue.getY()+80;
        bubbleCount++;

    }

	private ImageIcon bomb;
	private ImageIcon bombdown;
	private ImageIcon bombleft;
	private ImageIcon bombright;
	private ImageIcon bombup;


	
	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i * 100 < playerPosX && playerPosX <= (i + 1) * 100 && j * 100 <= playerPosY
						&& playerPosY <= (j + 1) * 100) {
					bubblePosX = i*100;
					bubblePosY = j*100;
                    jLabelPosX = j;
                    jLabelPosY = i;
				}
			}
		}

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
			mContext.backgroundImage[jLabelPosX + 1][jLabelPosY].bubbled("bombDown",jLabelPosX + 1,jLabelPosY);
			mContext.backgroundImage[jLabelPosX][jLabelPosY + 1].bubbled("bombRight",jLabelPosX,jLabelPosY + 1);
			mContext.backgroundImage[jLabelPosX][jLabelPosY].bubbled("bomb",jLabelPosX,jLabelPosY);

		} else if (jLabelPosX == 9 && jLabelPosY == 0) {
			mContext.backgroundImage[jLabelPosX - 1][jLabelPosY].bubbled("bombUp",jLabelPosX - 1,jLabelPosY);
			mContext.backgroundImage[jLabelPosX][jLabelPosY + 1].bubbled("bombRight",jLabelPosX,jLabelPosY + 1);
			mContext.backgroundImage[jLabelPosX][jLabelPosY].bubbled("bomb",jLabelPosX,jLabelPosY);

		} else if (jLabelPosX == 0 && jLabelPosY == 9) {
			mContext.backgroundImage[jLabelPosX + 1][jLabelPosY].bubbled("bombDown",jLabelPosX + 1,jLabelPosY);
			mContext.backgroundImage[jLabelPosX][jLabelPosY - 1].bubbled("bombLeft",jLabelPosX,jLabelPosY - 1);
			mContext.backgroundImage[jLabelPosX][jLabelPosY].bubbled("bomb",jLabelPosX,jLabelPosY);

		} else if (jLabelPosX == 9 && jLabelPosY == 9) {
			mContext.backgroundImage[jLabelPosX - 1][jLabelPosY].bubbled("bombUp",jLabelPosX - 1,jLabelPosY);
			mContext.backgroundImage[jLabelPosX][jLabelPosY - 1].bubbled("bombLeft",jLabelPosX,jLabelPosY - 1);
			mContext.backgroundImage[jLabelPosX][jLabelPosY].bubbled("bomb",jLabelPosX,jLabelPosY);

		} else if (jLabelPosX == 0) {
			mContext.backgroundImage[jLabelPosX + 1][jLabelPosY].bubbled("bombDown",jLabelPosX + 1,jLabelPosY);
			mContext.backgroundImage[jLabelPosX][jLabelPosY + 1].bubbled("bombRight",jLabelPosX,jLabelPosY + 1);
			mContext.backgroundImage[jLabelPosX][jLabelPosY - 1].bubbled("bombLeft",jLabelPosX,jLabelPosY - 1);
			mContext.backgroundImage[jLabelPosX][jLabelPosY].bubbled("bomb",jLabelPosX,jLabelPosY);

		} else if (jLabelPosX == 9) {
			mContext.backgroundImage[jLabelPosX - 1][jLabelPosY].bubbled("bombUp",jLabelPosX - 1,jLabelPosY);
			mContext.backgroundImage[jLabelPosX][jLabelPosY - 1].bubbled("bombLeft",jLabelPosX,jLabelPosY - 1);
			mContext.backgroundImage[jLabelPosX][jLabelPosY + 1].bubbled("bombRight",jLabelPosX,jLabelPosY + 1);
			mContext.backgroundImage[jLabelPosX][jLabelPosY].bubbled("bomb",jLabelPosX,jLabelPosY);
		} else if (jLabelPosY == 0) {
			mContext.backgroundImage[jLabelPosX + 1][jLabelPosY].bubbled("bombDown",jLabelPosX + 1,jLabelPosY);
			mContext.backgroundImage[jLabelPosX - 1][jLabelPosY].bubbled("bombUp",jLabelPosX - 1,jLabelPosY);
			mContext.backgroundImage[jLabelPosX][jLabelPosY + 1].bubbled("bombRight",jLabelPosX,jLabelPosY + 1);
			mContext.backgroundImage[jLabelPosX][jLabelPosY].bubbled("bomb",jLabelPosX,jLabelPosY);
		} else if (jLabelPosY == 9) {
			mContext.backgroundImage[jLabelPosX + 1][jLabelPosY].bubbled("bombDown",jLabelPosX + 1,jLabelPosY);
			mContext.backgroundImage[jLabelPosX - 1][jLabelPosY].bubbled("bombUp",jLabelPosX - 1,jLabelPosY);
			mContext.backgroundImage[jLabelPosX][jLabelPosY - 1].bubbled("bombLeft",jLabelPosX,jLabelPosY - 1);
			mContext.backgroundImage[jLabelPosX][jLabelPosY].bubbled("bomb",jLabelPosX,jLabelPosY);
			
		} else {
			mContext.backgroundImage[jLabelPosX + 1][jLabelPosY].bubbled("bombDown",jLabelPosX + 1,jLabelPosY);
			mContext.backgroundImage[jLabelPosX - 1][jLabelPosY].bubbled("bombUp",jLabelPosX - 1,jLabelPosY);
			mContext.backgroundImage[jLabelPosX][jLabelPosY + 1].bubbled("bombRight",jLabelPosX,jLabelPosY + 1);
			mContext.backgroundImage[jLabelPosX][jLabelPosY - 1].bubbled("bombLeft",jLabelPosX,jLabelPosY - 1);
			mContext.backgroundImage[jLabelPosX][jLabelPosY].bubbled("bomb",jLabelPosX,jLabelPosY);	
		} 
			mContext.playerRed.bubbleCountRed--; // get set
			
			mContext.playerBlue.bubbleCountBlue--; // get set
	}


}