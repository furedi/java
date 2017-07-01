/**
 * Java interface implementáció
 * 
 * @todo Az Oktato osztály a Tanar interface egy lehetséges implementációja,
 * amelyben az Tanar interface metódusai kerültek kidolgozásra.
 * 
 * Figyeljük meg, hogy a Tanfolyam osztály csak a Tanár interface-re 
 * hivatkozik és azon keresztül éri el az Oktato osztályban
 * megvalósított metódusukat.
 *
 */
public class Oktato implements Tanar{
	private String nevem;
	private String szakom;
	private String tantargyam;
	
	Oktato(String s1,String s2){
		this.nevem=s1;
		this.szakom=s2;
	}
	
	public String nev(){
		return nevem.toUpperCase();
	}
	public String szak(){
		return szakom;
	}
	public String tantargy(){
		return tantargyam;
	}
	public void setTantargy(String s1){
		this.tantargyam=s1;
	}
}

/**
 * Egy másik programban lececserélhetjük az Oktato implementációt
 * anélkül, hogy a Tanfolyam osztályban bármit is módosítanunk kellene
 * vagy az Oktato is implementációban más metódust használhatunk.
 * 
 * Például nem nagy betűvel adjuk vissza a nevet:
 * 
 * return nevem;
 */
