package CrazyArcade;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{

	MainFrame mContext = this;
	
	private JButton startButton;
	JPanel panelCenter;
	private JPanel panelSouth;
	
	private UnBreakBox unBreakBox;
	private BreakBox breakBox;

	BufferedImage newBI;
	
	private PlayerRed playerRed;
	private PlayerBlue playerBlue;
	
	private final int PANELARRAY_SIZE = 10;
	private final int PANEL_SIZE_XY =100;
	
	private boolean isButtonPressed;

	public CreatePanel[][] panelArray = new CreatePanel[PANELARRAY_SIZE][PANELARRAY_SIZE];

	public MainFrame() {
		
		initData();
		panelCenter.setFocusable(true);
	    panelCenter.requestFocusInWindow();
		setInitLayout();
		//addEventListner(); 
		//drawMapElements();
		testEventListener();
		repaint();
		
		//panelCenter.add(playerRed);
	   
		//isButtonPressed = true;
		new Thread(new PlayerRedKey(mContext, playerRed)).start();
		new Thread(new BackgroundPlayerRedService(playerRed)).start();
		new Thread(new PlayerBlueKey(mContext, playerBlue)).start();
		new Thread(new BackgroundPlayerBlueService(playerBlue)).start();
	}

	private void initData() {
		setSize(1000, 1100);//메인 화면 1000,1000과 버튼 공간 1000,100
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panelCenter = new JPanel();
		panelSouth = new JPanel();
		startButton = new JButton();
		
		playerRed = new PlayerRed(mContext);
		playerBlue = new PlayerBlue(mContext);
		
		panelCenter.setSize(1000, 1000);
		panelSouth.setSize(1000, 100);
		
		isButtonPressed = true;
	}

	private void setInitLayout() {
		panelCenter.setLayout(null); // 좌표
		add(panelCenter, BorderLayout.CENTER);
		 //panelCenter.setBackground(Color.BLUE); 추후 수정 필요 이미지 아이콘으
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
	
	private void testEventListener() {
		Scanner sc = new Scanner(System.in);
		if (sc.next() != null) {
			
				for (int i = 0; i < PANELARRAY_SIZE; i++) {
					for (int j = 0; j < PANELARRAY_SIZE; j++) {
						// 100개의 panel 전체 visible set false;
						//panelArray[i][j].setVisible(false);

					}
				}
				createNewBufferdImage();
				drawMapElements();
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
						

						}
					}
					createNewBufferdImage();
					drawMapElements();
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
		
		newBI = new BufferedImage(panelCenter.getWidth(), panelCenter.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g = newBI.createGraphics();
		panelCenter.paint(g);
		g.dispose();
		
		return newBI;
	}
	
	public void drawMapElements() {
		for (int i = 0; i < PANELARRAY_SIZE; i++) {
			for (int j = 0; j < PANELARRAY_SIZE; j++) {
		panelArray[i][j].setVisible(false);
				if(panelArray[i][j].getBackground() == Color.red) {
					unBreakBox = new UnBreakBox(mContext, i, j);
					panelArray[i][j].setUnBreakBox(unBreakBox);
					panelCenter.add(unBreakBox);
					
				}else if(panelArray[i][j].getBackground() == Color.blue) {
					breakBox = new BreakBox(mContext, i, j);
					panelArray[i][j].setBreakBox(breakBox);
					panelCenter.add(breakBox);
				}
				
			
			}
		}
		
	}

	public static void main(String[] args) {
		new MainFrame();
	}

}
