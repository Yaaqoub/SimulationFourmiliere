/**
 * Management of 'FinNourriture'
 * @author YAAQOUB
 *
 */
public class FinNourriture extends Evenement{

	public FinNourriture(Fourmi expediteur, Fourmiliere f) {
		
		super(expediteur.getNomFourmi() + " dit que la nourriture est vide.", expediteur); //call the constructor of the class abstract
		
	}
	@Override
	public void action(Fourmiliere f){
		
	}
}
