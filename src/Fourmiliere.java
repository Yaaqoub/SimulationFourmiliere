/**
 * Management of the anthill 'Fourmiliere'
 * @author YAAQOUB
 *
 */
import java.util.Hashtable;

public class Fourmiliere {
	private Sites sites; 
	private int nourritureQuantite; // Amount of the food in the Fourmiliere	
	private Hashtable<Integer, Fourmi> nbrFourmi; // // we put ant in that hashtable
	private int indexFourmi; // every formi in here have unique index
	
	public Hashtable<Integer, Fourmi> getNbrFourmi() {
		return nbrFourmi;
	}

	public void setNbrFourmi(Hashtable<Integer, Fourmi> nbrFourmi) {
		this.nbrFourmi = nbrFourmi;
	}

	public int getIndexFourmi() {
		return indexFourmi;
	}

	public void setIndexFourmi(int indexFourmi) {
		this.indexFourmi = indexFourmi;
	}

	public Sites getSites() {
		return sites;
	}

	public void setSites(Sites sites) {
		this.sites = sites;
	}

	public int getNourritureQuantite() {
		return nourritureQuantite;
	}

	public void setNourritureQuantite(int nourritureQuantite) {
		this.nourritureQuantite = nourritureQuantite;
	}

	public Fourmiliere() {
		
		this.indexFourmi = 0; // we set index Fourmi to 0
		this.sites = null; 
		this.nbrFourmi = new Hashtable<>(); //creat a new hashtable
		nbrFourmi.put(this.indexFourmi, new Reine(this)); // we creat a new rein here because we have just one
		this.nourritureQuantite = 0;
	}
}
