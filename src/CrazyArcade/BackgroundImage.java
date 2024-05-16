package CrazyArcade;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BackgroundImage extends JLabel {

	private int x;
	private int y;

	private ImageIcon unbreakBox;
	private ImageIcon breakBox;
	private ImageIcon floor;

	private MainFrame mContext;
	
	private int imageStatus;
 
	public BackgroundImage(MainFrame mContext, int i, int j) {
		this.mContext = mContext;
		this.x = j * 100;
		this.y = i * 100;
		unbreakBox = new ImageIcon("img/box_unbreak.png");
		breakBox = new ImageIcon("img/box_breakable.png");
		floor = new ImageIcon("img/main_background1.png");

		initData();
	}

	public void initData() {
		setSize(100, 100);
		setLocation(x, y);
		setVisible(true);
	}

	public void setInitLayout() {
	}

	public void setBackgroundImage(int i) {
		if (i == 0) {
			setIcon(floor);
			imageStatus = 0;
		} else if (i == 1) {
			setIcon(unbreakBox);
			imageStatus = 1;
		} else if (i == 2) {
			setIcon(breakBox);
			imageStatus =2;
		}
	}
	
	public void bubbled() {
		if (imageStatus == 1 || imageStatus == 0) {
			
		}else if (imageStatus == 2) {
			setIcon(floor);
		}
	}

}
