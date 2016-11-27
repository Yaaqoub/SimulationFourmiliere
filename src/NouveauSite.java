/**
 * Management of 'NouveauSite'
 * @author YAAQOUB
 *
 */
public class NouveauSite extends Evenement{
	
	private int index;
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public NouveauSite(Fourmi expediteur , int index) {
		
		super("La fourmie (" + expediteur.getNomFourmi() + ") a trouver un noveau Site de Nourriture", expediteur); //call the constructor of the class abstract
		this.index = index;
	}
	
	@Override
	public void action(Fourmiliere f){
		
	}
}
