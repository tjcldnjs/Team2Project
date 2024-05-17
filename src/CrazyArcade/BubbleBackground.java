package CrazyArcade;

public class BubbleBackground implements Runnable {

	Bubble bubble;
	Player player1;
	Player player2;
	MainFrame mContext;
	int bubblePosX;
	int bubblePosY;
	int player2PosX;
	int player2PosY;
	int player1PosX;
	int player1PosY;

	public BubbleBackground(Bubble bubble, MainFrame mContext) {
		this.bubble = bubble;

		this.bubblePosX = bubble.jLabelPosY * 100;
		this.bubblePosY = bubble.jLabelPosX * 100;
		this.mContext = mContext;
		this.player2 = mContext.player2;
		this.player1 = mContext.player1;

		player2PosX = mContext.player2.getX();
		player2PosY = mContext.player2.getY();

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
			//System.out.println("1");
			System.out.println(bubblePosX);
			if (player2.isLeft()) {
				if (bubblePosX < player2.getX() && (player2.getX() - bubblePosX <= 90)
						&& bubblePosY < player2.getY() + 80 && player2.getY() + 80 <= bubblePosY + 100) {
					player2.setLeft(false);
				} else {
					player2.setLeft(true);
				}
			} else if (player2.isRight()) {
				if (bubblePosX > player2.getX() && Math.abs(player2.getX() - bubblePosX) <= 90
						&& bubblePosY < player2.getY() + 80 && player2.getY() + 80 <= bubblePosY + 100) {
					player2.setRight(false);
				} else {
					player2.setRight(true);
				}
			} else if (player2.isUp()) {
				if (bubblePosY < player2.getY() && Math.abs(player2.getY() - bubblePosY) <= 90
						&& bubblePosX < player2.getX() + 50 && player2.getX() + 50 <= bubblePosX + 100) {
					player2.setUp(false);

				}

			} else if (player2.isDown()) {
				if (bubblePosY > player2.getY() && Math.abs(player2.getY() - bubblePosY) <= 90
						&& bubblePosX < player2.getX() + 50 && player2.getX() + 50 <= bubblePosX + 100) {
					player2.setDown(false);

				}

			}
			if (player1.isLeft()) {
				if (bubblePosX < player1.getX() && (player1.getX() - bubblePosX <= 90)
						&& bubblePosY < player1.getY() + 80 && player1.getY() + 80 <= bubblePosY + 100) {
					player1.setLeft(false);
				} else {
					player1.setLeft(true);
				}
			} else if (player1.isRight()) {
				if (bubblePosX > player1.getX() && Math.abs(player1.getX() - bubblePosX) <= 90
						&& bubblePosY < player1.getY() + 80 && player1.getY() + 80 <= bubblePosY + 100) {
					player1.setRight(false);
				} else {
					player1.setRight(true);
				}
			} else if (player1.isUp()) {
				if (bubblePosY < player1.getY() && Math.abs(player1.getY() - bubblePosY) <= 90
						&& bubblePosX < player1.getX() + 50 && player1.getX() + 50 <= bubblePosX + 100) {
					player1.setUp(false);

				}

			} else if (player1.isDown()) {
				if (bubblePosY > player1.getY() && Math.abs(player1.getY() - bubblePosY) <= 90
						&& bubblePosX < player1.getX() + 50 && player1.getX() + 50 <= bubblePosX + 100) {
					player1.setDown(false);

				}

			}

			if (bubble.status == false) {
				player2.setLeft(true);
				player1.setLeft(true);
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