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
	private MapData mapData;

	private JButton startButton;
	JPanel panelCenter;
	private JPanel panelSouth;

	BufferedImage newBI;
	// -----------------------------------
	PlayerRed playerRed;//get set
	PlayerBlue playerBlue;//get set

	BackgroundPlayerBlueService blueService;
	BackgroundPlayerRedService redService;

	final int PANELARRAY_SIZE = 10;
	final int PANEL_SIZE_XY = 100;

	private boolean isButtonPressed;
	BackgroundImage[][] backgroundImage = new BackgroundImage[PANELARRAY_SIZE][PANELARRAY_SIZE];

	CreatePanel[][] panelArray = new CreatePanel[PANELARRAY_SIZE][PANELARRAY_SIZE];

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

		blueService = new BackgroundPlayerBlueService(playerBlue);
		redService = new BackgroundPlayerRedService(playerRed);
		
		new Thread(new PlayerRedKey(mContext, playerRed)).start();
		new Thread(new PlayerBlueKey(mContext, playerBlue)).start();

		new Thread(blueService).start();
		new Thread(redService).start();
		// -----------------------------------

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

		boolean flag = true;
		mapData = new MapData(mContext);
		while (flag) {
			Scanner sc = new Scanner(System.in);
			int mapNum = sc.nextInt();
			if (mapNum < 0 || mapNum > 4) {
				System.out.println("1번 또는 2번 또는 3번 또는 4번을 선택해주세요.");

			} else {
				mapData.setMap(mapNum);
				flag = false;
			}
		}
		createNewBufferdImage();
		drawMapElements();
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

	public void reviseBufferImage(int x, int y) {
		Graphics2D graphic2D = newBI.createGraphics();
		graphic2D.setColor(Color.white);
		graphic2D.fillRect(x * 100, y * 100, PANEL_SIZE_XY, PANEL_SIZE_XY);
		blueService.setNewImage();
		redService.setNewImage();
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

	public void nullBubble(Bubble bubble) {
		Bubble bubble2 = bubble;
		bubble2.setVisible(false);
		bubble2 = null;
	}

	public static void main(String[] args) {
		new MainFrame();
	}

}
