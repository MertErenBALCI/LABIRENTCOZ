package engeller;

import entities.Pozisyon;

public abstract class Engel {
	Pozisyon poz;
	int rows;
	int cols;
	int[][] engelSekli;
	
	public abstract void engelOlustur();
	
	public void labirenteEkle(int[][] labirent) {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				labirent[i + poz.row][j + poz.col] = engelSekli[i][j];
			}
		}
	}
	
}
