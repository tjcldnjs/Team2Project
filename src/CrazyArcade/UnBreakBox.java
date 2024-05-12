package CrazyArcade;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class UnBreakBox extends JLabel{

	private int x;
	private int y;
	
	private ImageIcon box1;
	
	private MainFrame mContext;
	
	public UnBreakBox(MainFrame mContext,int i,int j) {
		
		this.mContext = mContext;
		this.x = j*100;
		this.y = i*100;
		box1 = new ImageIcon("img/box_unbreak.png");
		
		initData();
		
	}

	private void initData() {
		setIcon(box1);
		setSize(100, 100);
		setLocation(x, y);
		setVisible(true);
		
	}
	
	
	
}
