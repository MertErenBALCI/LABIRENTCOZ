package entities;


public class Pozisyon {
	public int row;
	public int col;

	public Pozisyon(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public boolean ayniMi(Pozisyon p) {
		return p.col == col && p.row == row;
	}
	
	public boolean ayniMi(int row, int col) {
		return this.row == row && this.col == col;
	}
	
	public Pozisyon kopya() {
		return new Pozisyon(row, col);
	}
}