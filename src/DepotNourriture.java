/**
 * Management of 'DepotNourriture'
 * @author YAAQOUB
 *
 */
public class DepotNourriture extends Evenement{
	
	private int quantite; // amount of the nourriture 
	
	int getQuantite() {
		return quantite;
	}

	void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public DepotNourriture(Fourmi expediteur , int quantite) {
				
		super("Nourriture a ete deposee par " +  expediteur.getNomFourmi() , expediteur); // call the constructor of the class abstract 
		this.quantite = quantite;
	}	
	
	@Override
	public void action(Fourmiliere f){
		f.setNourritureQuantite(f.getNourritureQuantite() + this.quantite); // add the amount of the food to the amount off the food in fourmiliere
	}
}
