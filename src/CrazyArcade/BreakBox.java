package CrazyArcade;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BreakBox extends JLabel{

	private int x;
	private int y; 
	
	private ImageIcon box2;
	
	private MainFrame mContext;
	
	public BreakBox(MainFrame mContext,int i,int j) {
		
		this.mContext = mContext;
		this.x = j*100;
		this.y = i*100;
		box2 = new ImageIcon("img/box_breakable.png");
		
		initData();
		
	}

	private void initData() {
		setIcon(box2);
		setSize(100, 100);
		setLocation(x, y);
		setVisible(true);
		
	}
	
	
	
}