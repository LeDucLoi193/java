package interfacePkg;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HighScore {
	private int totalScore;
	private int totalShot; 
		
	private ArrayList<HighScore> scoreSave = new ArrayList<HighScore>(20);
	
	public HighScore(){
		this.totalScore = 0;
		this.totalShot = 0;
	}
	
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	
	public int getTotalScore() {
		return this.totalScore;
	}
	
	public void setTotalShot(int totalShot) {
		this.totalShot = totalShot;
	}
	
	public int getTotalShot() {
		return this.totalShot;
	}
	
	public ArrayList<HighScore> getScoreSave() {
		return scoreSave;
	}

	public void setScoreSave(ArrayList<HighScore> scoreSave) {
		this.scoreSave = scoreSave;
	}
	
	public void writeToFile() throws IOException {		
		try {
			File f = new File("C:\\Users\\ASUS\\Downloads\\BattleShip\\Source\\BattleShip\\src\\interfacePkg\\highscore.txt");
//			Scanner scan = new Scanner(f);
			PrintWriter fw = new PrintWriter(f);
		    
		    for (int i = 0; i < getScoreSave().size(); ++i) {
		    	fw.print(++i);
		    	--i;
		    	fw.print("\t");
		    	fw.print(getScoreSave().get(i).totalScore);
		    	fw.print("\t");
		    	fw.println(getScoreSave().get(i).totalShot);
		    }
		    
		    fw.close();	
		    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readFromFile() {		
		try {
		     File f = new File("C:\\Users\\ASUS\\Downloads\\BattleShip\\Source\\BattleShip\\src\\interfacePkg\\highscore.txt");
		     Scanner scan = new Scanner(f);
		     
		     while (scan.hasNext()) {
		    	 HighScore hs = new HighScore();
		    	 scan.nextInt();
		    	 hs.totalScore = scan.nextInt();
		    	 hs.totalShot = scan.nextInt();
		    	 this.getScoreSave().add(hs);
		     }
		     
		    scan.close();
		    } catch (Exception ex) {
		      System.out.println("Loi doc file: " + ex);
		  }
	}
	
	public static void main(String args[]) {
		HighScore hs = new HighScore();
		hs.readFromFile();
		for (int i = 0; i < hs.getScoreSave().size(); ++i) {
			System.out.println(hs.getScoreSave().get(i).totalScore);
			System.out.println(hs.getScoreSave().get(i).totalShot);
		}
	}
}
