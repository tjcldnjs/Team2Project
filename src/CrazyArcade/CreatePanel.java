package CrazyArcade;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class CreatePanel extends JPanel implements Runnable {

	int positionX;
	int positionY;
	int count;

	public CreatePanel() {
		count = 1;
		setInitLayout();

		new Thread(this).start();

	}

	@Override
	public void run() {
		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				// 마우스 클릭에 따라 색 변함.
				if (count % 3 == 1) {
					setBackground(Color.red);
				} else if (count % 3 == 2) {
					setBackground(Color.blue);
				} else if (count % 3 == 0) {
					setBackground(Color.white);
				}
				count++;
			}
		});
	}

	public void setInitLayout() {
		setBackground(Color.white);

	}
}
