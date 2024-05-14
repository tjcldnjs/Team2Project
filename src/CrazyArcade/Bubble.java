package CrazyArcade;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bubble extends JLabel implements Runnable{
    MainFrame mContext;
    PlayerBlue playerBlue;
    PlayerRed playerRed;

    private boolean shift;

    int bubblePosX;
    int bubblePosY;
    private ImageIcon bubble;
    private ImageIcon bomb;
   

    public Bubble(MainFrame mContext, PlayerRed playerRed) {
        this.mContext = mContext;
        this.playerRed = playerRed;
        bubblePosX = playerRed.getX();
        bubblePosY = playerRed.getY();
        initData();
        mContext.panelCenter.add(this,0);
        System.out.println("123123");
    }

    public Bubble(MainFrame mContext, PlayerBlue playerBlue) {
        this.mContext = mContext;
        this.playerBlue = playerBlue;
        bubblePosX = playerBlue.getX();
        bubblePosY = playerBlue.getY();
        initData();
        mContext.panelCenter.add(this,0);
    }

    public void initData() {
    
        bubble = new ImageIcon("img/bomb.png");
      
        setIcon(bubble);
        setSize(100, 100);
        setLocation(bubblePosX, bubblePosY);
        setVisible(true);

    }

    public void setInitData() {
    }

	@Override
	public void run() {

		
		
	}

    
    
}