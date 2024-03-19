package engeller;

import java.util.Random;

import entities.Pozisyon;

public class Engel3 extends Engel {
	
	Random random;
	
	public Engel3(int row, int col) {
		rows = 3;
		cols = 3;

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
		{0,0,0}
		{0,0,0}
		{0,0,0}
		 
		{1,1}
		{1,0}
		
		{1,1,1}
		
		{1,
		 1,
		 1,}
		
		{0,1}
		{1,1}
		*/
		
		int sekil = random.nextInt(4);
		

		switch(sekil) {
		case 0:
			Pozisyon[] olasiYerler = {new Pozisyon(0, 0), new Pozisyon(0, 1), new Pozisyon(1, 0), new Pozisyon(1, 1)};
			
			Pozisyon poz = olasiYerler[random.nextInt(olasiYerler.length)];
			
			engelSekli[poz.row][poz.col] = 1;
			engelSekli[poz.row + 1][poz.col] = 1;
			engelSekli[poz.row][poz.col + 1] = 1;
			
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < cols; j++) {
					int engelMi = random.nextInt(9);
					
					if(engelMi == 1) {
						engelSekli[i][j] = 1;
					}
				}
			}
			
			break;
			
		case 1:
			Pozisyon[] olasiYerler2 = {new Pozisyon(2, 2), new Pozisyon(2, 1), new Pozisyon(1, 2), new Pozisyon(1, 1)};
			
			Pozisyon poz2 = olasiYerler2[random.nextInt(olasiYerler2.length)];
			
			engelSekli[poz2.row][poz2.col] = 1;
			engelSekli[poz2.row - 1][poz2.col] = 1;
			engelSekli[poz2.row][poz2.col - 1] = 1;
			
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < cols; j++) {
					int engelMi = random.nextInt(9);
					
					if(engelMi == 0) {
						engelSekli[i][j] = 1;
					}
				}
			}
			break;
			
		case 2:
			
			int olasiYer3 = random.nextInt(3);
			
			for(int i = 0; i < 3; i++) {
				engelSekli[olasiYer3][i] = 1;
			}
			
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < cols; j++) {
					int engelMi = random.nextInt(9);
					
					if(engelMi == 0) {
						engelSekli[i][j] = 1;
					}
				}
			}
			
			break;
			
		case 3:
			
			int olasiYer4 = random.nextInt(3);
			
			for(int i = 0; i < 3; i++) {
				engelSekli[i][olasiYer4] = 1;
			}
			
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < cols; j++) {
					int engelMi = random.nextInt(9);
					
					if(engelMi == 0) {
						engelSekli[i][j] = 1;
					}
				}
			}
			
			break;
		}
		
		
	}
}
