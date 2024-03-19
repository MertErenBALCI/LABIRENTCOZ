package entities;

import java.util.Stack;

import entities.Pozisyon;

public class Cilekes {
	
	private Pozisyon poz;
	private Stack<Pozisyon> ayrim;
	private Stack<Pozisyon> iz;
	private Stack<Pozisyon> sonuYok;
	boolean bitti = false;
	long baslangic;
	long bitis;
	
	
	public Cilekes(int x, int y) {
		poz = new Pozisyon(x, y);
		ayrim = new Stack<Pozisyon>();
		iz = new Stack<Pozisyon>();
		sonuYok = new Stack<Pozisyon>();
		iz.push(poz.kopya());
		ayrim.push(poz.kopya());
		baslangic = System.currentTimeMillis();
	}
	
	public Cilekes() {
		this(1, 1);
	}
	
	public Stack<Pozisyon> izAl() {
		return iz;
	}
	public Stack<Pozisyon> sonAl() {
		return sonuYok;
	}
	
	public boolean izdeVarMi(Pozisyon p) {
		for(Pozisyon a : iz) {
			if(p.ayniMi(a)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean sonuVarMi(Pozisyon p) {
		for(Pozisyon a : sonuYok) {
			if(p.ayniMi(a)) {
				return true;
			}
		}
		return false;
	}
	
	public void pushIz() {
		iz.push(poz.kopya());
	}
	public void pushAyrim(Pozisyon p) {
		ayrim.push(p.kopya());
	}
	public void pushSonuYok(Pozisyon p) {
		sonuYok.push(p);
	}
	
	public void adimAt(int[][] labirent, Pozisyon hedef) {
		if(!bitti) {
			boolean kontrol = false;
			Pozisyon sag = new Pozisyon(poz.row, poz.col + 1);
			Pozisyon sol = new Pozisyon(poz.row, poz.col - 1);
			Pozisyon ust = new Pozisyon(poz.row - 1, poz.col);
			Pozisyon alt = new Pozisyon(poz.row + 1, poz.col);
			int duvarSay = 0;
			Pozisyon eskiPoz = poz;
			
			Pozisyon fark = new Pozisyon(hedef.row - poz.row, hedef.col - poz.col);
			
			if(fark.col > 0) {
				if(labirent[sag.row][sag.col] == 1) {
					
					if(kontrol) {
						if(!izdeVarMi(sag)) {
							pushAyrim(eskiPoz);
						}
					}
					else {
						boolean k = false;
						if(izdeVarMi(sag) || sonuVarMi(sag)) {
							k = true;
							duvarSay++;
						}
						
						if(!k) {
							poz = sag;
							pushIz();
							kontrol = true;
						}
					}
				}
				else {
					duvarSay++;
				}
				
				if(labirent[sol.row][sol.col] == 1) {
					if(kontrol){
						if(!izdeVarMi(sol)) {
							pushAyrim(eskiPoz);
						}
					}
					else {
						boolean k = false;
						if(izdeVarMi(sol) || sonuVarMi(sol)) {
							k = true;
							duvarSay++;
						}
						
						if(!k) {
							poz = sol;
							pushIz();
							kontrol = true;
						}
					}
				}
				else {
					duvarSay++;
				}
			}
			
			else {
				if(labirent[sol.row][sol.col] == 1) {
					if(kontrol){
						if(!izdeVarMi(sol)) {
							pushAyrim(eskiPoz);
						}
					}
					else {
						boolean k = false;
						if(izdeVarMi(sol) || sonuVarMi(sol)) {
							k = true;
							duvarSay++;
						}
						
						if(!k) {
							poz = sol;
							pushIz();
							kontrol = true;
						}
					}
				}
				else {
					duvarSay++;
				}
				
				if(labirent[sag.row][sag.col] == 1) {
					
					if(kontrol) {
						if(!izdeVarMi(sag)) {
							pushAyrim(eskiPoz);
						}
					}
					else {
						boolean k = false;
						if(izdeVarMi(sag) || sonuVarMi(sag)) {
							k = true;
							duvarSay++;
						}
						
						if(!k) {
							poz = sag;
							pushIz();
							kontrol = true;
						}
					}
				}
				else {
					duvarSay++;
				}
			}
			
			if(fark.row > 0) {
				if(labirent[alt.row][alt.col] == 1) {
					if(kontrol) {
						if(!izdeVarMi(alt)) {
							pushAyrim(eskiPoz);
						}
					}
					else {
						boolean k = false;
						if(izdeVarMi(alt) || sonuVarMi(alt)) {
							k = true;
							duvarSay++;
						}
						
						if(!k) {
							poz = alt;
							pushIz();
							kontrol = true;
						}
					}
					
				}
				else {
					duvarSay++;
				}
				
				if(labirent[ust.row][ust.col] == 1) {
					if(kontrol) {
						if(!izdeVarMi(ust)) {
							pushAyrim(eskiPoz);
						}
					}
					else {
						boolean k = false;
						if(izdeVarMi(ust) || sonuVarMi(ust)) {
							k = true;
							duvarSay++;
						}
						
						if(!k) {
							poz = ust;
							pushIz();
							kontrol = true;
						}
					}
				}
				else {
					duvarSay++;
				}
			}
			
			else {
				if(labirent[ust.row][ust.col] == 1) {
					if(kontrol) {
						if(!izdeVarMi(ust)) {
							pushAyrim(eskiPoz);
						}
					}
					else {
						boolean k = false;
						if(izdeVarMi(ust) || sonuVarMi(ust)) {
							k = true;
							duvarSay++;
						}
						
						if(!k) {
							poz = ust;
							pushIz();
							kontrol = true;
						}
					}
				}
				else {
					duvarSay++;
				}
				
				if(labirent[alt.row][alt.col] == 1) {
					if(kontrol) {
						if(!izdeVarMi(alt)) {
							pushAyrim(eskiPoz);
						}
					}
					else {
						boolean k = false;
						if(izdeVarMi(alt) || sonuVarMi(alt)) {
							k = true;
							duvarSay++;
						}
						
						if(!k) {
							poz = alt;
							pushIz();
							kontrol = true;
						}
					}
					
				}
				else {
					duvarSay++;
				}
			}
			
			
			
			if(duvarSay == 4) {
				sonPozisyonaGel(labirent);
			}
			
			if(poz.ayniMi(hedef)) {
				bitti = true;
				bitis = System.currentTimeMillis() - baslangic;
				System.out.println("Bitti: " + bitis + " ms");
			}

		}
		
		
	}
	
	public void sonPozisyonaGel(int[][] labirent) {
		Pozisyon tmp = iz.pop();
		
		if(iz.size() == 0) {
			bitti = true;
			System.out.println("Finished");
			return;
		}
		
		Pozisyon pretmp = tmp.kopya();
		Pozisyon sonDogru = ayrim.peek();
		while(!sonDogru.ayniMi(tmp)) {
			pretmp = tmp.kopya();
			tmp = iz.pop();
			sonuYok.push(tmp);
		}
		iz.push(tmp);
		sonuYok.push(pretmp);
		poz = sonDogru;
		
		int gezilmisSay = 0;
		for(Pozisyon p : sonuYok) {
			if(p.ayniMi(sonDogru.row, sonDogru.col + 1) || labirent[sonDogru.row][sonDogru.col + 1] == 0) {
				gezilmisSay++;
			}
			if(p.ayniMi(sonDogru.row, sonDogru.col - 1) || labirent[sonDogru.row][sonDogru.col - 1] == 0) {
				gezilmisSay++;
			}
			if(p.ayniMi(sonDogru.row + 1, sonDogru.col) || labirent[sonDogru.row + 1][sonDogru.col] == 0) {
				gezilmisSay++;
			}
			if(p.ayniMi(sonDogru.row - 1, sonDogru.col) || labirent[sonDogru.row - 1][sonDogru.col] == 0) {
				gezilmisSay++;
			}
			
			if(izdeVarMi(p)) {
				gezilmisSay++;
			}
		}
		if(gezilmisSay >= 4) {
			ayrim.pop();
		}
	}
	
}