package engeller;

import entities.Pozisyon;

public class Engel1 extends Engel {

	
	public Engel1(int row, int col) {
		rows = 1;
		cols = 1;

		poz = new Pozisyon(row, col);
		
		engelSekli = new int[rows][cols];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				engelSekli[i][j] = 0;
			}
		}
		
		engelOlustur();
	}
	
	
	@Override
	public void engelOlustur() {
		// TODO Auto-generated method stub
		engelSekli[0][0] = 1;
	}
	
}
