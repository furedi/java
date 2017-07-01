/**
 * Java interface
 * 
 * @todo A Tanar interface az a kapcsoló felület, amelyre a Tanfolyam osztály hivatkozik.
 * 
 * Itt csak a metódusok szignatúráját adjuk meg,
 * ezek implementációja például az Oktato osztályban valósítható meg.
 * 
 * Az Oktató osztály csak egy a lehetséges implementációk közül.
 * Egy másik programban lecserélhető anélkül, hogy a Tanfolyam osztályon,
 * vagy a Tanar interface-n változtatni kellene.
 * 
 */
public interface Tanar {
	static String munkahely="Dream Study";
	public String nev();
	public String szak();
}
