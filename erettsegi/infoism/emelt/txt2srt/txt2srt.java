/**
 * Érettségi Informatika ismeretek emelt szint 2017. május 17.
 * 
 * A videókhoz a legtöbb lejátszóprogram meg tud jeleníteni feliratokat.
 * A feliratokat egy külön srt kiterjesztés feliratfájlban szokták megadni,
 * amely tartalmazza a feliratok sorszámát, az id zítéseket és a feliratokat.
 * Ebben a feladatban egy videóhoz SRT formátumú, angol nyelv feliratfájlt
 * kell készítenie. A feliratok és azok időzítése rendelkezésre állnak a
 * feliratok.txt állományban, de a formátumuk nem megfelelő.
 * 
 * Feladat: https://www.oktatas.hu/bin/content/dload/erettsegi/feladatok_2017tavasz_emelt/e_infoism_17maj_fl.pdf
 * Forrás:  https://www.oktatas.hu/bin/content/dload/erettsegi/feladatok_2017tavasz_emelt/e_infoismfor_17maj_fl.zip
 */
 
// package txt2srt;

import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * @author  John
 * @version 1.0
 * @since   2017-06-22
 */

// 2. feladat - Sajat osztaly letrehozasa
class IdozitettFelirat {
	private String idozites;
	private String felirat;
	
	// 3. feladat - Az osztaly konstruktora
	IdozitettFelirat ( String s1, String s2){
		this.idozites = s1;
		this.felirat = s2;
	}
	
	public String getIdozites(){
		return this.idozites;
	}
	
	public String getFelirat(){
		return this.felirat;
	}
	
	// 6. feladat - SzavakSzama metodus
	public int SzavakSzama(){
		String[] szavak = this.felirat.split(" ");
		return szavak.length;
	}
	
	// 8. feladat - SrtIdozites metodus
	public String SrtIdozites(){
		String[] idok = this.idozites.split(" ");
		return msToSrt(idok[0])+" --> "+msToSrt(idok[2]);
	}
	
	private String msToSrt(String s1){
		String[] st = s1.split(":");
		int mm = Integer.parseInt(st[0]);
		return String.format("%02d:%02d:", mm/60, mm%60)+st[1];
	}
}

class txt2srt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList<IdozitettFelirat> idofel = new LinkedList<IdozitettFelirat>();
		
		System.out.println("4. feladat - Olvassa be a feliratok.txt állomány sorait");
		beolvas(Paths.get("feliratok.txt"),idofel);
		
		System.out.println("5. feladat - Feliratok száma: "+idofel.size());

		System.out.println("7. feladat - Legtöbb szóból álló felirat: ");
		System.out.println(maxSzoSzam(idofel));
		
		System.out.println("9. feladat - A felirat.srt állomány készétése");
		srtFileWrite(Paths.get("felirat.srt"),idofel);
	}
	
	public static void beolvas(Path f, LinkedList<IdozitettFelirat> idofelir ){
		try {
			List<String> lines = Files.readAllLines(f);
			
			String linePrev = null;
		    for(String line:lines) {
		    	if (linePrev == null){
		    		linePrev = line;
		    	}
		    	else{
		    		idofelir.add(new IdozitettFelirat(linePrev,line));
		    		linePrev = null;
		    	}
		    }
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public static String maxSzoSzam(LinkedList<IdozitettFelirat> idofelir){
		IdozitettFelirat max = idofelir.getFirst();
		for(IdozitettFelirat x: idofelir){
			if(max.SzavakSzama()<x.SzavakSzama()){
				max=x;
			}
		}
		return max.getFelirat();
	}

	public static void srtFileWrite(Path f, LinkedList<IdozitettFelirat> idofelir){
		try {
			BufferedWriter bw = Files.newBufferedWriter(f);
			int i=1;
			for(IdozitettFelirat x: idofelir){
				bw.write((i>1?"\r\n\r\n":"")+i+"\r\n"+x.SrtIdozites()+"\r\n"+x.getFelirat());
				i++;
			}
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}
}
