import java.util.ArrayList;

/**
 * Java interface használatának bemutatása
 * 
 * @todo Tanfolyam osztály a main metódusben példányosítja a tanarokat
 * a Tanar interface-re hivatkozva.
 * 
 * @author furedij
 */

public class Tanfolyam {
	public static void main(String[] args) {
		System.out.println("Tanfolyamra beosztott tanárok névsora");
		ArrayList<Tanar> tanarok = new ArrayList<Tanar>();
		feltolt(tanarok);

		System.out.printf("%-16s %-16s %-16s\n","Munkahely","Tanár","Szak");
		
		for(Tanar tan:tanarok){
			System.out.printf("%-16s %-16s %-16s\n",Tanar.munkahely,tan.nev(),tan.szak());
		}
	}
	
	// A példányosításnál már az Oktato implementációt használjuk!!!
	private static void feltolt(ArrayList<Tanar> tan){
		tan.add(new Oktato("Remek Elek","Matematika"));
		tan.add(new Oktato("Meg Győző","Kommunikáció"));
		tan.add(new Oktato("Prog Ramoz","Informatika"));
	}
}
/**
* Hasznos linkek:
* [1] https://inf.nyme.hu/~nemes/Software/Polymorph/poli_def.htm
*
*/