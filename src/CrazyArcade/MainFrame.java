package CrazyArcade;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{

	private JButton startButton;
	private JPanel panelCenter;
	private JPanel panelSouth;

	private final int PANELARRAY_SIZE = 10;
	private final int PANEL_SIZE_XY =100;

	public CreatePanel[][] panelArray = new CreatePanel[PANELARRAY_SIZE][PANELARRAY_SIZE];

	public MainFrame() {
		initData();
		setInitLayout();
		addEventListner(); 
	}

	private void initData() {
		setSize(1000, 1100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panelCenter = new JPanel();
		panelSouth = new JPanel();
		startButton = new JButton();

		panelCenter.setSize(1000, 1000);
		panelSouth.setSize(1000, 100);
	}

	private void setInitLayout() {
		panelCenter.setLayout(null); // 좌표
		add(panelCenter, BorderLayout.CENTER);
		// panelCenter.setBackground(Color.BLUE);
		add(panelSouth, BorderLayout.SOUTH);
		panelSouth.add(startButton, BorderLayout.EAST);
		// panelSouth.setLayout(new FlowLayout(FlowLayout.RIGHT));
		addPanel();
		setVisible(true);

	}

	public void addPanel() {

		for (int i = 0; i < PANELARRAY_SIZE; i++) {
			for (int j = 0; j < PANELARRAY_SIZE; j++) {
				panelArray[i][j] = new CreatePanel(); // 패널생성자 call
				panelArray[i][j].setSize(PANEL_SIZE_XY, PANEL_SIZE_XY); // 생성된 panel의 size 지정
				panelArray[i][j].setLocation(j * 100, i * 100); // 생성된 panel의 position 지정(JFrame?? JPanel??)
				panelCenter.add(panelArray[i][j]); // Center JPanel에 생성된 JPanel attach.
			}
		}

	}

	private void addEventListner() {
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if (e.getSource().equals(startButton)) {
					for (int i = 0; i < PANELARRAY_SIZE; i++) {
						for (int j = 0; j < PANELARRAY_SIZE; j++) {
							// 100개의 panel 전체 visible set false;
							panelArray[i][j].setVisible(false);

						}
					}
					createNewBufferdImage();
				}
			}
			
		});
	}

	// 100개의 panel.getColor 후 panelcenter에 그린후 -> panelcneter ->bufferedImage로 변환
	// 시키기;
	public BufferedImage createNewBufferdImage() {

		Graphics centerG = panelCenter.getGraphics();

		for (int i = 0; i < PANELARRAY_SIZE; i++) {
			for (int j = 0; j < PANELARRAY_SIZE; j++) {
				centerG.setColor(panelArray[i][j].getBackground());
				centerG.fillRect(j * 100, i * 100, PANEL_SIZE_XY, PANEL_SIZE_XY);
			}
		}

		centerG.dispose();

		int w = panelCenter.getWidth();
		int h = panelCenter.getHeight();
		
		BufferedImage newBI = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = newBI.createGraphics();
		panelCenter.paint(g);
		g.dispose();
		return newBI;
	}

	public static void main(String[] args) {
		new MainFrame();
	}

}
