package CrazyArcade;

import java.awt.Color;

public class MapData {
	MainFrame mContext;

	public MapData(MainFrame mContext) {
		this.mContext = mContext;

	}

	public void setMap(int mapNum) {
		if (mapNum == 1) {
			mContext.panelArray[1][2].setBackground(Color.blue);
			mContext.panelArray[2][2].setBackground(Color.blue);
			mContext.panelArray[2][1].setBackground(Color.blue);
			mContext.panelArray[2][0].setBackground(Color.blue);
			mContext.panelArray[7][9].setBackground(Color.blue);
			mContext.panelArray[7][8].setBackground(Color.blue);
			mContext.panelArray[7][7].setBackground(Color.blue);
			mContext.panelArray[8][7].setBackground(Color.blue);

			mContext.panelArray[4][4].setBackground(Color.red);
			mContext.panelArray[4][5].setBackground(Color.red);
			mContext.panelArray[5][4].setBackground(Color.red);
			mContext.panelArray[5][5].setBackground(Color.red);
		} else if (mapNum == 2) {

			for (int i = 0; i < mContext.PANELARRAY_SIZE; i++) {
				for (int j = 0; j < mContext.PANELARRAY_SIZE; j++) {
					mContext.panelArray[i][j].setBackground(Color.white);

				}
			}
			// 1행
			mContext.panelArray[0][2].setBackground(Color.blue);
			mContext.panelArray[0][4].setBackground(Color.blue);
			mContext.panelArray[0][5].setBackground(Color.red);
			mContext.panelArray[0][7].setBackground(Color.red);
			mContext.panelArray[0][9].setBackground(Color.red);

			// 2행
			mContext.panelArray[1][2].setBackground(Color.blue);
			mContext.panelArray[1][4].setBackground(Color.blue);
			mContext.panelArray[1][5].setBackground(Color.blue);
			mContext.panelArray[1][8].setBackground(Color.blue);

			// 3행
			mContext.panelArray[2][0].setBackground(Color.blue);
			mContext.panelArray[2][1].setBackground(Color.blue);
			mContext.panelArray[2][2].setBackground(Color.blue);
			mContext.panelArray[2][4].setBackground(Color.red);
			mContext.panelArray[2][5].setBackground(Color.blue);
			mContext.panelArray[2][6].setBackground(Color.red);
			mContext.panelArray[2][7].setBackground(Color.blue);
			mContext.panelArray[2][9].setBackground(Color.red);

			// 4행
			mContext.panelArray[3][4].setBackground(Color.blue);
			mContext.panelArray[3][5].setBackground(Color.blue);
			mContext.panelArray[3][6].setBackground(Color.blue);
			mContext.panelArray[3][7].setBackground(Color.red);

			// 5행
			mContext.panelArray[4][0].setBackground(Color.blue);
			mContext.panelArray[4][1].setBackground(Color.red);
			mContext.panelArray[4][2].setBackground(Color.blue);
			mContext.panelArray[4][3].setBackground(Color.red);
			mContext.panelArray[4][4].setBackground(Color.red);
			mContext.panelArray[4][5].setBackground(Color.red);
			mContext.panelArray[4][6].setBackground(Color.blue);
			mContext.panelArray[4][7].setBackground(Color.blue);
			mContext.panelArray[4][8].setBackground(Color.blue);
			mContext.panelArray[4][9].setBackground(Color.red);

			// 6행
			mContext.panelArray[5][0].setBackground(Color.blue);
			mContext.panelArray[5][1].setBackground(Color.blue);
			mContext.panelArray[5][2].setBackground(Color.blue);
			mContext.panelArray[5][3].setBackground(Color.blue);
			mContext.panelArray[5][4].setBackground(Color.red);
			mContext.panelArray[5][5].setBackground(Color.red);
			mContext.panelArray[5][6].setBackground(Color.blue);
			mContext.panelArray[5][7].setBackground(Color.red);
			mContext.panelArray[5][8].setBackground(Color.blue);
			mContext.panelArray[5][9].setBackground(Color.blue);

			// 7행
			mContext.panelArray[6][2].setBackground(Color.red);
			mContext.panelArray[6][3].setBackground(Color.blue);
			mContext.panelArray[6][4].setBackground(Color.blue);
			mContext.panelArray[6][5].setBackground(Color.blue);

			// 8행
			mContext.panelArray[7][0].setBackground(Color.red);
			mContext.panelArray[7][2].setBackground(Color.blue);
			mContext.panelArray[7][3].setBackground(Color.red);
			mContext.panelArray[7][4].setBackground(Color.blue);
			mContext.panelArray[7][5].setBackground(Color.blue);
			mContext.panelArray[7][7].setBackground(Color.blue);
			mContext.panelArray[7][8].setBackground(Color.blue);
			mContext.panelArray[7][9].setBackground(Color.blue);

			// 9행
			mContext.panelArray[8][1].setBackground(Color.blue);
			mContext.panelArray[8][4].setBackground(Color.blue);
			mContext.panelArray[8][5].setBackground(Color.red);
			mContext.panelArray[8][7].setBackground(Color.blue);

			// 10행
			mContext.panelArray[9][0].setBackground(Color.red);
			mContext.panelArray[9][2].setBackground(Color.red);
			mContext.panelArray[9][4].setBackground(Color.blue);
			mContext.panelArray[9][5].setBackground(Color.blue);
			mContext.panelArray[9][7].setBackground(Color.blue);

		} else if (mapNum == 3) {
			// 1행
			mContext.panelArray[0][2].setBackground(Color.red);
			mContext.panelArray[0][4].setBackground(Color.blue);
			mContext.panelArray[0][5].setBackground(Color.blue);

			// 2행
			mContext.panelArray[1][2].setBackground(Color.blue);
			mContext.panelArray[1][4].setBackground(Color.blue);
			mContext.panelArray[1][5].setBackground(Color.blue);
			mContext.panelArray[1][7].setBackground(Color.red);

			// 3행
			mContext.panelArray[2][2].setBackground(Color.red);
			mContext.panelArray[2][4].setBackground(Color.blue);
			mContext.panelArray[2][5].setBackground(Color.blue);

			// 4행
			mContext.panelArray[3][2].setBackground(Color.blue);
			mContext.panelArray[3][4].setBackground(Color.blue);
			mContext.panelArray[3][5].setBackground(Color.blue);
			mContext.panelArray[3][7].setBackground(Color.red);

			// 5행
			mContext.panelArray[4][0].setBackground(Color.red);
			mContext.panelArray[4][1].setBackground(Color.blue);
			mContext.panelArray[4][2].setBackground(Color.red);
			mContext.panelArray[4][4].setBackground(Color.blue);
			mContext.panelArray[4][5].setBackground(Color.blue);

			// 6행
			mContext.panelArray[5][4].setBackground(Color.blue);
			mContext.panelArray[5][5].setBackground(Color.blue);
			mContext.panelArray[5][7].setBackground(Color.red);
			mContext.panelArray[5][8].setBackground(Color.blue);
			mContext.panelArray[5][9].setBackground(Color.red);

			// 7행
			mContext.panelArray[6][2].setBackground(Color.red);
			mContext.panelArray[6][4].setBackground(Color.blue);
			mContext.panelArray[6][5].setBackground(Color.blue);
			mContext.panelArray[6][7].setBackground(Color.blue);

			// 8행
			mContext.panelArray[7][4].setBackground(Color.blue);
			mContext.panelArray[7][5].setBackground(Color.blue);
			mContext.panelArray[7][7].setBackground(Color.red);

			// 9행
			mContext.panelArray[8][2].setBackground(Color.red);
			mContext.panelArray[8][4].setBackground(Color.blue);
			mContext.panelArray[8][5].setBackground(Color.blue);
			mContext.panelArray[8][7].setBackground(Color.blue);

			// 10행
			mContext.panelArray[9][4].setBackground(Color.blue);
			mContext.panelArray[9][5].setBackground(Color.blue);
			mContext.panelArray[9][7].setBackground(Color.red);
		} else if (mapNum == 4) {
			mContext.panelArray[0][1].setBackground(Color.blue);
			mContext.panelArray[1][0].setBackground(Color.blue);
			mContext.panelArray[1][2].setBackground(Color.blue);
			mContext.panelArray[2][2].setBackground(Color.blue);
			mContext.panelArray[3][1].setBackground(Color.blue);
			mContext.panelArray[4][0].setBackground(Color.blue);
			mContext.panelArray[5][8].setBackground(Color.blue);
			mContext.panelArray[6][7].setBackground(Color.blue);
			mContext.panelArray[6][9].setBackground(Color.blue);
			mContext.panelArray[7][7].setBackground(Color.blue);
			mContext.panelArray[8][8].setBackground(Color.blue);
			mContext.panelArray[9][9].setBackground(Color.blue);

		} else if (mapNum == 0) {

		}
	}
}
