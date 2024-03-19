package engeller;

import java.util.Random;

import entities.Pozisyon;

public class Engel2 extends Engel {
	
	Random random;
	
	public Engel2(int row, int col) {
		rows = 2;
		cols = 2;

		poz = new Pozisyon(row, col);
		
		random = new Random();
		
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
		/*
		{1, 
		 1,}
		
		{1,1}
		*/
		int dikey = random.nextInt(2);
		
		if(dikey == 1) {
			int sag = random.nextInt(2);
		
			if(sag == 1) {
				engelSekli[0][1] = 1;
				engelSekli[1][1] = 1;
			}
			else {
				engelSekli[0][0] = 1;
				engelSekli[1][0] = 1;
			}
			
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < cols; j++) {
					int engelMi = random.nextInt(4);
					if(engelMi == 1) {
						engelSekli[i][j] = 1;
					}
				}
			}
		}
		else {
			int alt = random.nextInt(2);
			
			if(alt == 1) {
				engelSekli[0][1] = 1;
				engelSekli[1][1] = 1;
			}
			else {
				engelSekli[0][0] = 1;
				engelSekli[0][1] = 1;
			}
			
			
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < cols; j++) {
					int engelMi = random.nextInt(4);
					if(engelMi == 1) {
						engelSekli[i][j] = 1;
					}
				}
			}
		}	
	}
}
