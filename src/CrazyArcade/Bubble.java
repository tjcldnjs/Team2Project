package CrazyArcade;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bubble extends JLabel {
    MainFrame mContext;
    PlayerBlue playerBlue;
    PlayerRed playerRed;

    private boolean shift;

    int bubblePosX;
    int bubblePosY;
    private ImageIcon bubble;
    private ImageIcon bomb;
    private ImageIcon bombdown;
    private ImageIcon bombleft;
    private ImageIcon bombright;
    private ImageIcon bombup;

    public Bubble(MainFrame mContext, PlayerRed playerRed) {
        this.mContext = mContext;
        this.playerRed = playerRed;
        bubblePosX = playerRed.getX();
        bubblePosY = playerRed.getY();
        initData();
        mContext.panelCenter.add(this);
        System.out.println("123123");
    }

    public Bubble(MainFrame mContext, PlayerBlue playerBlue) {
        this.mContext = mContext;
        this.playerBlue = playerBlue;
        bubblePosX = playerBlue.getX();
        bubblePosY = playerBlue.getY();
        initData();
        mContext.panelCenter.add(this);
    }

    public void initData() {
        bubble = new ImageIcon("img/bomb_2.png");
        bubble = new ImageIcon("img/bomb.png");
        bubble = new ImageIcon("img/bombdown.png");
        bubble = new ImageIcon("img/bombleft.png");
        bubble = new ImageIcon("img/bombright.png");
        bubble = new ImageIcon("img/bombup.png");
        setIcon(bubble);
        setSize(100, 100);
        setLocation(bubblePosX, bubblePosY);
        setVisible(true);

    }

    public void setInitData() {
    }

    
    
}