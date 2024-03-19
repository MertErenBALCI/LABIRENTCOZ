package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

import engeller.*;
import entities.Cilekes;

public class Labirent {
	
	
	
	private int x = 100;
	private int y = 100;
	private int rows;
	private int cols;
	private Cilekes c;
	private int[][] labirent;
	Pozisyon hedef;
	
	
	
	public Labirent(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		labirent = new int[rows][cols];
		c = new Cilekes();
		Random a = new Random();
		labirentOlustur();
		/*
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				int c = a.nextInt(100);
				if(c > 29) {
					labirent[i][j] = 0;
				}
				else {
					labirent[i][j] = 0;
				}
			}
		}
		
		for(int i = 0; i < rows; i++) {
			labirent[i][0] = 0;
			labirent[i][cols - 1] = 0;
		}
		for(int j = 0; j < cols; j++) {
			labirent[0][j] = 0;
			labirent[rows - 1][j] = 0;
		}
		labirent[rows - 2][cols - 2] = 1;
		
		labirent[1][1] = 1;
		labirent[1][2] = 1;
		labirent[1][3] = 1;
		labirent[1][4] = 1;
		labirent[2][4] = 1;
		labirent[3][4] = 1;
		labirent[3][4] = 1;
		labirent[3][5] = 1;
		labirent[3][6] = 1;
		labirent[4][4] = 1;
		labirent[5][4] = 1;
		labirent[6][4] = 1;
		labirent[6][5] = 1;
		labirent[6][6] = 1;
		labirent[6][7] = 1;
		labirent[6][8] = 1;
		labirent[8][8] = 1;
		labirent[5][6] = 1;
		labirent[3][7] = 1;
		labirent[3][8] = 1;
		labirent[4][8] = 1;
		labirent[2][2] = 1;
		labirent[3][2] = 1;
		labirent[4][2] = 1;
		labirent[5][2] = 1;
		labirent[6][2] = 1;
		labirent[7][2] = 1;
		labirent[8][2] = 1;
		labirent[8][3] = 1;
		labirent[8][4] = 1;
		labirent[8][5] = 1;
		labirent[8][6] = 1;
		labirent[8][7] = 1;
		labirent[8][8] = 1;
		*/
		hedef = new Pozisyon(rows - 2, cols - 2);
	}
	
	public Labirent() {
		this(10, 10);
	}
	
	public Labirent(File dosya) throws IOException {
		c = new Cilekes();
		Engel engel;
		Scanner okuma = new Scanner(dosya);

		LinkedList<String> matrix = new LinkedList<String>();
		
		while(okuma.hasNextLine()) {
			matrix.add(okuma.nextLine());
		}
		
		this.cols = matrix.get(0).length() + 2;
		this.rows = this.cols;
		
		labirent = new int[rows][cols];
		
		int rw = 1;
		int cl = 1;
		
		for(int i = 0; i < matrix.size(); i++) {
			String s = matrix.get(i);
			cl = 1;
			for(int j = 0; j < this.cols - 2; j++) {
				char ch = s.charAt(j);
				
				labirent[rw][cl] = ch - 48;
				
				cl++;
			}
			rw++;
		}
		
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				int a = labirent[i][j];
				
				if(a == 1) {
					engel = new Engel1(i, j);
					engel.labirenteEkle(labirent);
					engel = null;
				}
				else if(a == 2) {
					if(labirent[i - 1][j] != 2 && labirent[i][j - 1] != 2) {
						engel = new Engel2(i, j);
						engel.labirenteEkle(labirent);
						engel = null;
					}
				}
				else if(a == 3) {
					if(labirent[i - 1][j] != 3 || labirent[i][j - 1] != 3) {
						engel = new Engel3(i, j);
						engel.labirenteEkle(labirent);
						engel = null;
					}
				}
			}
		}
		
		for(int i = 1; i < rows - 1; i++) {
			for(int j = 1; j < cols - 1; j++) {
				if(labirent[i][j] == 0) {
					labirent[i][j] = 1;
				}
				else {
					labirent[i][j] = 0;
				}
			}
		}
		 
		hedef = new Pozisyon(new Random().nextInt(1, rows - 1), new Random().nextInt(1, cols - 1));
		
		while(labirent[hedef.row][hedef.col] == 0) {
			hedef.row = new Random().nextInt(1, rows - 1);
			hedef.col = new Random().nextInt(1, cols - 1);
		}
		
	}
	
	public void labirentOlustur() {
		Random rand = new Random();
		
		for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                labirent[row][col] = 0;
            }
        }
        // Random starting point
        int x = 1;
        int y = 1;
        labirent[y][x] = 0;
        // Use depth-first search to create maze
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int cx = current[0];
            int cy = current[1];
            int[][] directions = {{0, -2}, {0, 2}, {-2, 0}, {2, 0}};
            shuffleArray(directions);
            for (int[] direction : directions) {
                int nx = cx + direction[0];
                int ny = cy + direction[1];
                if (nx >= 1 && ny >= 1 && nx < rows - 1 && ny < cols - 1 && labirent[ny][nx] == 0) {
                	labirent[cy + direction[1] / 2][cx + direction[0] / 2] = 1;
                	labirent[ny][nx] = 1;
                    stack.push(new int[]{nx, ny});
                }
            }
        }
	}
	
	private void shuffleArray(int[][] array) {
		
        // Shuffle the array using the Fisher-Yates shuffle algorithm
        for (int i = array.length - 1; i > 0; i--) {
            int index = new Random().nextInt(i + 1);
            int[] temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
	
	public void update() {
		c.adimAt(labirent, hedef);
	}
	
	public void draw(Graphics2D g) {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				g.setColor(Color.GRAY);
				
				/*
				if(labirent[i][j] == 1) {
					g.setColor(Color.WHITE);
				}
				else {
					g.setColor(Color.BLACK);
				}
				*/
				
				
				
				
				
				for(Pozisyon p : c.sonAl()) {
					if(p.row == i && p.col == j) {
						//g.setColor(Color.RED);
					}
					
					Pozisyon alt = new Pozisyon(p.row + 1, p.col);
					Pozisyon sagAlt = new Pozisyon(p.row + 1, p.col + 1);
					Pozisyon solAlt = new Pozisyon(p.row + 1, p.col - 1);
					Pozisyon ust = new Pozisyon(p.row - 1, p.col);
					Pozisyon sagUst = new Pozisyon(p.row - 1, p.col + 1);
					Pozisyon solUst = new Pozisyon(p.row - 1, p.col - 1);
					Pozisyon sag = new Pozisyon(p.row, p.col + 1);
					Pozisyon sol = new Pozisyon(p.row, p.col - 1);
					Pozisyon ak = new Pozisyon(i, j);
					
					if(ak.ayniMi(sol) || ak.ayniMi(sag) || ak.ayniMi(ust) || ak.ayniMi(alt) || ak.ayniMi(sagAlt) || ak.ayniMi(solAlt)
							|| ak.ayniMi(sagUst) || ak.ayniMi(solUst)) {

						if(labirent[i][j] == 1) {
							g.setColor(Color.WHITE);
						}
						else {
							g.setColor(Color.BLACK);
						}
					}
				}
				
				for(Pozisyon p : c.izAl()) {
					if(p.row == i && p.col == j) {
						g.setColor(new Color(20, 96, 12));
						break;
					}
					
					Pozisyon alt = new Pozisyon(p.row + 1, p.col);
					Pozisyon sagAlt = new Pozisyon(p.row + 1, p.col + 1);
					Pozisyon solAlt = new Pozisyon(p.row + 1, p.col - 1);
					Pozisyon ust = new Pozisyon(p.row - 1, p.col);
					Pozisyon sagUst = new Pozisyon(p.row - 1, p.col + 1);
					Pozisyon solUst = new Pozisyon(p.row - 1, p.col - 1);
					Pozisyon sag = new Pozisyon(p.row, p.col + 1);
					Pozisyon sol = new Pozisyon(p.row, p.col - 1);
					Pozisyon ak = new Pozisyon(i, j);
					
					if(ak.ayniMi(sol) || ak.ayniMi(sag) || ak.ayniMi(ust) || ak.ayniMi(alt) || ak.ayniMi(sagAlt) || ak.ayniMi(solAlt)
							|| ak.ayniMi(sagUst) || ak.ayniMi(solUst)) {

						if(labirent[i][j] == 1) {
							g.setColor(Color.WHITE);
						}
						else {
							g.setColor(Color.BLACK);
						}
					}
					
					
				}
				
				if(c.izAl().peek().row == i && c.izAl().peek().col == j) {
					g.setColor(new Color(170, 60, 80));
				}
				
				g.fillRect(x + 20 * j, y + 20 * i, 19, 19);
			}
		}
	}
	
}
