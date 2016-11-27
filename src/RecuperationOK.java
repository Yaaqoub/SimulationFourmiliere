/**
 * Management of 'Recuperation' of the ants
 * @author YAAQOUB
 *
 */
public class RecuperationOK extends Evenement{
	private int index;
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public RecuperationOK(Fourmi expediteur , int index) {
		
		super("La fourmie (" + expediteur.getNomFourmi() + ") a mettre le fourmi a la fourmiliere", expediteur); //call the constructor of the class abstract
		this.index = index;
	}
	
	@Override
	public void action(Fourmiliere f){	
		f.getNbrFourmi().remove(this.getExpediteur().getChoix()); // if we recover any Ant we remove it from the Hashtable
		((Soigneur) f.getNbrFourmi().get(this.getIndex())).setActive(false); // we set the Active of the soigneur to false .. so she is no longer in the service 
		this.getExpediteur().setChoix(0);  // we reset the Choix
	}
}
