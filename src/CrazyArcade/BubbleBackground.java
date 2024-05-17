package CrazyArcade;

public class BubbleBackground implements Runnable {

	Bubble bubble;
	PlayerRed playerRed;
	PlayerBlue playerBlue;
	MainFrame mContext;
	int bubblePosX;
	int bubblePosY;
	int playerRedPosX;
	int playerRedPosY;
	int playerBluePosX;
	int playerBluePosY;

	public BubbleBackground(Bubble bubble, MainFrame mContext) {
		this.bubble = bubble;

		this.bubblePosX = bubble.jLabelPosY * 100;
		this.bubblePosY = bubble.jLabelPosX * 100;
		this.mContext = mContext;
		this.playerRed = mContext.playerRed;
		this.playerBlue = mContext.playerBlue;

		playerRedPosX = mContext.playerRed.getX();
		playerRedPosY = mContext.playerRed.getY();

	}

	@Override
	public void run() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean flag = true;
		while (flag) {
			System.out.println("1");
			System.out.println(bubblePosX);
			if (playerRed.isLeft()) {
				if (bubblePosX < playerRed.getX() && (playerRed.getX() - bubblePosX <= 90)
						&& bubblePosY < playerRed.getY() + 80 && playerRed.getY() + 80 <= bubblePosY + 100) {
					playerRed.setLeft(false);
				} else {
					playerRed.setLeft(true);
				}
			} else if (playerRed.isRight()) {
				if (bubblePosX > playerRed.getX() && Math.abs(playerRed.getX() - bubblePosX) <= 90
						&& bubblePosY < playerRed.getY() + 80 && playerRed.getY() + 80 <= bubblePosY + 100) {
					playerRed.setRight(false);
				} else {
					playerRed.setRight(true);
				}
			} else if (playerRed.isUp()) {
				if (bubblePosY < playerRed.getY() && Math.abs(playerRed.getY() - bubblePosY) <= 90
						&& bubblePosX < playerRed.getX() + 50 && playerRed.getX() + 50 <= bubblePosX + 100) {
					playerRed.setUp(false);

				}

			} else if (playerRed.isDown()) {
				if (bubblePosY > playerRed.getY() && Math.abs(playerRed.getY() - bubblePosY) <= 90
						&& bubblePosX < playerRed.getX() + 50 && playerRed.getX() + 50 <= bubblePosX + 100) {
					playerRed.setDown(false);

				}

			}
			if (playerBlue.isLeft()) {
				if (bubblePosX < playerBlue.getX() && (playerBlue.getX() - bubblePosX <= 90)
						&& bubblePosY < playerBlue.getY() + 80 && playerBlue.getY() + 80 <= bubblePosY + 100) {
					playerBlue.setLeft(false);
				} else {
					playerBlue.setLeft(true);
				}
			} else if (playerBlue.isRight()) {
				if (bubblePosX > playerBlue.getX() && Math.abs(playerBlue.getX() - bubblePosX) <= 90
						&& bubblePosY < playerBlue.getY() + 80 && playerBlue.getY() + 80 <= bubblePosY + 100) {
					playerBlue.setRight(false);
				} else {
					playerBlue.setRight(true);
				}
			} else if (playerBlue.isUp()) {
				if (bubblePosY < playerBlue.getY() && Math.abs(playerBlue.getY() - bubblePosY) <= 90
						&& bubblePosX < playerBlue.getX() + 50 && playerBlue.getX() + 50 <= bubblePosX + 100) {
					playerBlue.setUp(false);

				}

			} else if (playerBlue.isDown()) {
				if (bubblePosY > playerBlue.getY() && Math.abs(playerBlue.getY() - bubblePosY) <= 90
						&& bubblePosX < playerBlue.getX() + 50 && playerBlue.getX() + 50 <= bubblePosX + 100) {
					playerBlue.setDown(false);

				}

			}

			if (bubble.status == false) {
				playerRed.setLeft(true);
				playerBlue.setLeft(true);
				flag = false;
			}
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}