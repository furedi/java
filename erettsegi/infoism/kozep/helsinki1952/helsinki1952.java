/*
 * 2017maj informatika ismeretek középszintû gyakorlati érettségi vizsga
 * Helsinki 1952 programozás feladat
 * 
 * Eclipse IDE for Java Developers Version: Neon.3 Release (4.6.3)
 * 
 * Futtatás parancssorból a helsinki1952 mappában lévõ futtat.bat file-ból:
 * javac -encoding utf8 helsinki1952.java
 * if %errorlevel%==0 java helsinki1952
 * @pause Enter a key to continue!
 * 
 */

import java.io.*;
import java.util.*;

// === Data structure
class Adat {
	int hely;
	int fo;
	String ag, verseny;
	Adat(int hely,int fo,String ag, String verseny){
		this.hely = hely;
		this.fo = fo;
		this.ag = ag;
		this.verseny = verseny;
	}
}

// === Main
class helsinki1952 {
	public static void main(String[] args) throws IOException {

		System.out.println("helsinki1952 feladat megoldása");
		
		System.out.println("2.feladat:\nA helsinki.txt állományban lévő adatok tárolása");
		ArrayList<Adat> adatok = new ArrayList<>();		
		feltolt(".\\helsinki.txt",adatok);

		// for (Adat adat : adatok) {System.out.println(adat.hely+" "+adat.fo+" "+adat.ag+" "+adat.verseny);}

		System.out.println("3.feladat:\nPontszerző helyezések szama: "+adatok.size());
		
		System.out.println("4.feladat: Éremstatisztika\n"+statisztika(adatok));
		
		System.out.println("5.feladat:\nOlimpiai pontok száma: "+pontok(adatok));

		System.out.println("6.feladat:\n"+torusz(adatok));
		
		System.out.println("7.feladat:\nA helsinki2.txt állomány készítése");
		tarol(".\\helsinki2.txt",adatok);
		
		System.out.println("8.feladat: Melyik pontszerző helyezéshez fűződik a legtöbb sportoló?\n"+ltsportolo(adatok));
	}
	
	// --- Upload text file to ArrayList
	public static void feltolt(String f, ArrayList<Adat> a) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		String s;
		while((s = br.readLine()) !=null){
			String[] parts = s.split(" ");
			a.add(new Adat(Integer.valueOf(parts[0]),Integer.valueOf(parts[1]),parts[2],parts[3]));
		}
		
		br.close();
	}

	// --- Éremstatisztika
	public static String statisztika(ArrayList<Adat> a){
		int[] db ={0,0,0};
		for (Adat ad : a) {
			switch (ad.hely) {
			case 1:
				db[0]++;
				break;
			case 2:
				db[1]++;
				break;
			case 3:
				db[2]++;
				break;				
			default:
				break;
			}
		}
		return "Arany: "+db[0]+"\nEzüst: "+db[1]+"\nBronz: "+db[2]+"\nÖsszesen: "+(db[0]+db[1]+db[2]);
	}
	
	// --- Olimpiai pontok száma
	public static int op(int helyezes){
		int[] p = {7,5,4,3,2,1};
		return p[helyezes-1];
	}
	
	public static int pontok(ArrayList<Adat> a){
		int opsz=0;
		for (Adat ad : a) {
			opsz+=op(ad.hely);
		}
		return opsz;
	}
	
	// --- Torna/uszas érmek száma
	public static String torusz(ArrayList<Adat> a){
		int[] db ={0,0};
		for(Adat ad: a){
			if (ad.ag.equals("torna")&&ad.hely<4){
				db[0]++;
			}
			else if (ad.ag.equals("uszas")&&ad.hely<4){
				db[1]++;
			}
		}
		
		String s;
		if (db[0]>db[1]){
			s="Torna sportágban szereztek több érmet";
		}
		else if(db[0]<db[1]){
			s="Úszás sportágban szereztek több érmet";
		}
		else{
			s="Egyenlő volt az érmek száma";
		}
		
		return s;
	}
	
	// --- helsinki2.txt írása
	public static void tarol(String f, ArrayList<Adat> a) throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		for (Adat ad: a){
			bw.write(ad.hely+" "+ad.fo+" "+op(ad.hely)+" "+(ad.ag.equals("kajakkenu")?"kajak-kenu":ad.ag)+" "+ad.verseny+"\r\n");
		}
		
		bw.close();
	}
	
	// --- Melyik pontszerző helyezéshez fűződik a legtöbb sportoló?
	public static String ltsportolo(ArrayList<Adat> a){
		Adat max = a.get(0);
		for(Adat ad:a){
			if(ad.hely<7&&ad.fo>max.fo){
				max = ad;
			}
		}
		return "Helyezés: "+max.hely+"\nSportág: "+max.ag+"\nVersenyszám: "+max.verseny+"\nSportolok száma: "+max.fo;
	}
}
