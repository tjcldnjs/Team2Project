package CrazyArcade;

public class BubbleBackground implements Runnable{
	
	Bubble bubble;
	PlayerRed playerRed;
	int bubblePosX;
	int bubblePosY;
	int playerRedPosX;
	int playerRedPosY;
	
	public BubbleBackground(Bubble bubble, PlayerRed playerRed) {
		this.bubble = bubble;
		this.playerRed = playerRed;
		this.bubblePosX = bubble.jLabelPosY *100;
		this.bubblePosY = bubble.jLabelPosX * 100;
		playerRedPosX = playerRed.getX();
		playerRedPosY = playerRed.getY();
		
	}
	public BubbleBackground(Bubble bubble, PlayerBlue playerBlue) {
		this.bubble = bubble;
		this.bubblePosX = bubble.jLabelPosX *100;
		this.bubblePosY = bubble.jLabelPosY * 100;
	
	}
	@Override
	public void run() {
		
		boolean flag = true;
		while(flag){
			System.out.println("1");
			System.out.println(bubblePosX);
			if (bubblePosX < playerRed.getX() && (playerRed.getX()-bubblePosX) <=100) {
				System.out.println("2");
				playerRed.setLeft(false);
			}
			if (bubble.status == false) {
				playerRed.setLeft(true);
				flag = false;
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
