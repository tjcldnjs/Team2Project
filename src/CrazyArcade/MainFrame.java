package CrazyArcade;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener {

	private JButton startButton;
	private JPanel panelCenter;
	private JPanel panelSouth;

	private final int PANEL_SIZE = 10;

	public CreatePanel[][] panelArray = new CreatePanel[10][10];

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
		panelCenter.setBackground(Color.BLUE);
		add(panelSouth, BorderLayout.SOUTH);
		panelSouth.add(startButton, BorderLayout.EAST);
		// panelSouth.setLayout(new FlowLayout(FlowLayout.RIGHT));
		addPanel();
		setVisible(true);

	}

	public void addPanel() {

		for (int i = 0; i < PANEL_SIZE; i++) {
			for (int j = 0; j < PANEL_SIZE; j++) {
				panelArray[i][j] = new CreatePanel(); // 패널생성자 call
				panelArray[i][j].setSize(100, 100); // 생성된 panel의 size 지정
				panelArray[i][j].setLocation(i * 100, j * 100); // 생성된 panel의 position 지정(JFrame?? JPanel??)
				panelCenter.add(panelArray[i][j]); // Center JPanel에 생성된 JPanel attach.
			}
		}

	}

	
	
	
	private void addEventListner() {
		startButton.addActionListener(this);
	}

	//
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(startButton)) {
			for (int i = 0; i < PANEL_SIZE; i++) {
				for (int j = 0; j < PANEL_SIZE; j++) {
					panelCenter.setVisible(false);
				}
			}
		}
	}

	public static void main(String[] args) {
		new MainFrame();
	}

}
