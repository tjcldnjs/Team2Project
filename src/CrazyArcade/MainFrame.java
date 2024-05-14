package CrazyArcade;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	MainFrame mContext = this;

	private JButton startButton;
	JPanel panelCenter;
	private JPanel panelSouth;

	BufferedImage newBI;
	// -----------------------------------
	private PlayerRed playerRed;
	private PlayerBlue playerBlue;

	private final int PANELARRAY_SIZE = 10;
	private final int PANEL_SIZE_XY = 100;

	private boolean isButtonPressed;

	BackgroundImage[][] backgroundImage = new BackgroundImage[PANELARRAY_SIZE][PANELARRAY_SIZE];
	private CreatePanel[][] panelArray = new CreatePanel[PANELARRAY_SIZE][PANELARRAY_SIZE];

	public MainFrame() {

		initData();
		panelCenter.setFocusable(true);
		panelCenter.requestFocusInWindow();
		setInitLayout();
		// addEventListner();
		// drawMapElements();
		testEventListener();
		repaint();

		// panelCenter.add(playerRed);

		// isButtonPressed = true;


		new Thread(new PlayerRedKey(mContext, playerRed)).start();
		new Thread(new BackgroundPlayerRedService(playerRed)).start();
		new Thread(new PlayerBlueKey(mContext, playerBlue)).start();
		new Thread(new BackgroundPlayerBlueService(playerBlue)).start();

	}

	private void initData() {
		setSize(1000, 1100);// 메인 화면 1000,1000과 버튼 공간 1000,100
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Icon icon = new ImageIcon("img/main_background1.png");
		panelCenter = new JPanel();
		panelSouth = new JPanel();
		startButton = new JButton();

		playerRed = new PlayerRed(mContext);
		playerBlue = new PlayerBlue(mContext);

		playerRed.setVisible(false);
		playerBlue.setVisible(false);

		panelCenter.setSize(1000, 1000);
		panelSouth.setSize(1000, 100);

		isButtonPressed = true;
	}

	private void setInitLayout() {
		panelCenter.setLayout(null); // 좌표
		add(panelCenter, BorderLayout.CENTER);
		// panelCenter.setBackground(Color.BLUE); 추후 수정 필요 이미지 아이콘으
		add(panelSouth, BorderLayout.SOUTH);
		panelSouth.add(startButton, BorderLayout.EAST);
//		 panelSouth.setLayout(new FlowLayout(FlowLayout.RIGHT));
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
		int startNum = sc.nextInt();
		if (startNum == 1) {
//			panelArray[0][2].setBackground(Color.blue);
			panelArray[1][2].setBackground(Color.blue);
			panelArray[2][2].setBackground(Color.blue);
			panelArray[2][1].setBackground(Color.blue);
			panelArray[2][0].setBackground(Color.blue);
			panelArray[7][9].setBackground(Color.blue);
			panelArray[7][8].setBackground(Color.blue);
			panelArray[7][7].setBackground(Color.blue);
			panelArray[8][7].setBackground(Color.blue);
//			panelArray[9][7].setBackground(Color.blue);

			panelArray[4][4].setBackground(Color.red);
			panelArray[4][5].setBackground(Color.red);
			panelArray[5][4].setBackground(Color.red);
			panelArray[5][5].setBackground(Color.red);
			createNewBufferdImage();
			drawMapElements();
		} else if (startNum == 2) {

			for (int i = 0; i < PANELARRAY_SIZE; i++) {
				for (int j = 0; j < PANELARRAY_SIZE; j++) {
					panelArray[i][j].setBackground(Color.white);

				}
			}
			// 1

			panelArray[0][2].setBackground(Color.blue);
			panelArray[0][4].setBackground(Color.blue);
			panelArray[0][5].setBackground(Color.red);
			panelArray[0][7].setBackground(Color.red);
			panelArray[0][9].setBackground(Color.red);

			// 2행
			panelArray[1][2].setBackground(Color.blue);
			panelArray[1][4].setBackground(Color.blue);
			panelArray[1][5].setBackground(Color.blue);
			panelArray[1][8].setBackground(Color.blue);

			// 3행
			panelArray[2][0].setBackground(Color.blue);
			panelArray[2][1].setBackground(Color.blue);
			panelArray[2][2].setBackground(Color.blue);
			panelArray[2][4].setBackground(Color.red);
			panelArray[2][5].setBackground(Color.blue);
			panelArray[2][6].setBackground(Color.red);
			panelArray[2][7].setBackground(Color.blue);
			panelArray[2][9].setBackground(Color.red);

			// 4행
			panelArray[3][4].setBackground(Color.blue);
			panelArray[3][5].setBackground(Color.blue);
			panelArray[3][6].setBackground(Color.blue);
			panelArray[3][7].setBackground(Color.red);

			// 5행
			panelArray[4][0].setBackground(Color.blue);
			panelArray[4][1].setBackground(Color.red);
			panelArray[4][2].setBackground(Color.blue);
			panelArray[4][3].setBackground(Color.red);
			panelArray[4][4].setBackground(Color.red);
			panelArray[4][5].setBackground(Color.red);
			panelArray[4][6].setBackground(Color.blue);
			panelArray[4][7].setBackground(Color.blue);
			panelArray[4][8].setBackground(Color.blue);
			panelArray[4][9].setBackground(Color.red);

			// 6행
			panelArray[5][0].setBackground(Color.blue);
			panelArray[5][1].setBackground(Color.blue);
			panelArray[5][2].setBackground(Color.blue);
			panelArray[5][3].setBackground(Color.blue);
			panelArray[5][4].setBackground(Color.red);
			panelArray[5][5].setBackground(Color.red);
			panelArray[5][6].setBackground(Color.blue);
			panelArray[5][7].setBackground(Color.red);
			panelArray[5][8].setBackground(Color.blue);
			panelArray[5][9].setBackground(Color.blue);

			// 7행
			panelArray[6][2].setBackground(Color.red);
			panelArray[6][3].setBackground(Color.blue);
			panelArray[6][4].setBackground(Color.blue);
			panelArray[6][5].setBackground(Color.blue);

			// 8행
			panelArray[7][0].setBackground(Color.red);
			panelArray[7][2].setBackground(Color.blue);
			panelArray[7][3].setBackground(Color.red);
			panelArray[7][4].setBackground(Color.blue);
			panelArray[7][5].setBackground(Color.blue);
			panelArray[7][7].setBackground(Color.blue);
			panelArray[7][8].setBackground(Color.blue);
			panelArray[7][9].setBackground(Color.blue);

			// 9행
			panelArray[8][1].setBackground(Color.blue);
			panelArray[8][4].setBackground(Color.blue);
			panelArray[8][5].setBackground(Color.red);
			panelArray[8][7].setBackground(Color.blue);

			// 10행
			panelArray[9][0].setBackground(Color.red);
			panelArray[9][2].setBackground(Color.red);
			panelArray[9][4].setBackground(Color.blue);
			panelArray[9][5].setBackground(Color.blue);
			panelArray[9][7].setBackground(Color.blue);

			createNewBufferdImage();
			drawMapElements();
		} else if (startNum == 3) {
			panelArray[0][2].setBackground(Color.blue);
			panelArray[1][2].setBackground(Color.blue);
			panelArray[2][2].setBackground(Color.blue);
			panelArray[2][1].setBackground(Color.blue);
			panelArray[2][0].setBackground(Color.blue);
			panelArray[7][9].setBackground(Color.blue);
			panelArray[7][8].setBackground(Color.blue);
			panelArray[7][7].setBackground(Color.blue);
			panelArray[8][7].setBackground(Color.blue);
			panelArray[9][7].setBackground(Color.blue);
		}

	}

	// 100개의 panel.getColor 후 panelcenter에 그린후 -> panelcneter ->bufferedImage로 변환
	// 시키기;
	public BufferedImage createNewBufferdImage() {

		Graphics centerG = panelCenter.getGraphics();
		panelArray[0][0].setBackground(Color.red);
		System.out.println(panelArray[0][0].getBackground());
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
		try {
			// retrieve image
			File outputfile = new File("saved.png");
			ImageIO.write(newBI, "png", outputfile);
		} catch (IOException e) {
			// handle exception
		}
		panelCenter.add(playerBlue);
		panelCenter.add(playerRed);
		playerRed.setVisible(true);
		playerBlue.setVisible(true);
		return newBI;
	}

	public void drawMapElements() {
		
		for (int i = 0; i < PANELARRAY_SIZE; i++) {
			for (int j = 0; j < PANELARRAY_SIZE; j++) {
				panelArray[i][j].setVisible(false);
				if (panelArray[i][j].getBackground() == Color.red) {
					backgroundImage[i][j] = new BackgroundImage(mContext, i, j);
					panelCenter.add(backgroundImage[i][j]);
					backgroundImage[i][j].setBackgroundImage(1);
				} else if (panelArray[i][j].getBackground() == Color.blue) {
					backgroundImage[i][j] = new BackgroundImage(mContext, i, j);
					panelCenter.add(backgroundImage[i][j]);
					backgroundImage[i][j].setBackgroundImage(2);
				} else if (panelArray[i][j].getBackground() == Color.white) {
					backgroundImage[i][j] = new BackgroundImage(mContext, i, j);
					panelCenter.add(backgroundImage[i][j]);
					backgroundImage[i][j].setBackgroundImage(0);
					;
				}

			}
		}

	}

	public static void main(String[] args) {
		new MainFrame();
	}

}
