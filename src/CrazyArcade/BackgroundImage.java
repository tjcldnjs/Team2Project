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
		} else if (i == 1) {
			setIcon(unbreakBox);
		} else if (i == 2) {
			setIcon(breakBox);
		}
	}

}
