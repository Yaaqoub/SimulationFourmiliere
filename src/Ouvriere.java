import java.util.Enumeration;
import java.util.Random;

/**
 * Class Ouvriere is for instantiate 'Fourmi' of the type 'Ouvriere'
 * @author YAAQOUB
 *
 */
public class Ouvriere extends Fourmi{
	private int nourrTrans; // Food amount the ant take
	public static int ouvrieresNbr = 1;		// that's for the 'Ouvrieres' name
	// Ouvriere constructor
	public Ouvriere(Fourmiliere f){
		super("Ouvriere " + ouvrieresNbr, 100, 3, f);	// We call Constructor of the class abstart:
														// Ouvriere : Name + ouvrieresNbr : this int is to give the Anst's number the first one will call Ouvriere 1
														// 100 : Life point
														// 3 : speed of the Ouvriere
		
		this.nourrTrans = 0;							// Food amount the ant take .. we set it to 0
		ouvrieresNbr ++;
	}
	
	public int getNourrTrans(){
		return nourrTrans;
	}
	
	public void setNourrTrans(int nourrTrans){
		this.nourrTrans = nourrTrans;
	}
	
	@Override
	public void nouveauCycle(Fourmiliere f){
		
		if(this.isFoActive()){ // if the Ant 'Fourmi' is not supported launch a new cycle
			
			if(this.isQuitterFourm()){ // if the Ant 'fourmi' is leaving the 'fourmiliere'
				
				if(this.getPosition() == 0){ // if 'Fourmi' is in 'Fourmiliere'
					
					Random choix = new Random();
					
					this.setChoix(choix.nextInt(f.getSites().getSites().length));
					
					this.setPosition(this.getPosition() + this.getVitesse());
					this.setNbCycle(this.getNbCycle() - 1);
					
					System.out.println("La fourmi (" + this.getNomFourmi() + ") avance vers le (" + f.getSites().getSites()[this.getChoix()].getNom() + ").");
				}
				else if (this.getPosition() > 0 && this.getPosition() < f.getSites().getSites()[this.getChoix()].getDistance()) {
					
					this.setPosition(this.getPosition() + this.getVitesse());
					this.setNbCycle(this.getNbCycle() - 1);
					
					System.out.println("La fourmi (" + this.getNomFourmi() + ") avance vers le (" + f.getSites().getSites()[this.getChoix()].getNom() + ").");
				}
				else { 
					
					this.setQuitterForm(false);
					this.setNourrTrans(2);
					f.getSites().getSites()[this.getChoix()].setQuantite(f.getSites().getSites()[this.getChoix()].getQuantite() - 2);		
					
					this.setPosition(f.getSites().getSites()[this.getChoix()].getDistance());
					this.setNbCycle(this.getNbCycle() - 1);
					
					System.out.println("La fourmi (" + this.getNomFourmi() + ") prend de la nourriture dans le (" + f.getSites().getSites()[this.getChoix()].getNom() + ").");
				}
			}
			else {
				
				if (this.getPosition() <= f.getSites().getSites()[this.getChoix()].getDistance() && this.getPosition() > 0) {	
					
					this.setPosition(this.getPosition() - this.getVitesse());	
					this.setNbCycle(this.getNbCycle() - 1);
					
					System.out.println("La fourmi (" + this.getNomFourmi() + ") avance vers la fourmiliere.");
					
				} else {
					
					this.setQuitterForm(true); 
					this.setPosition(0);	
					this.setNbCycle(this.getNbCycle() - 1); 
					
					this.setNourrTrans(0);
					
					if (f.getNourritureQuantite() > 0) { // if there is food in the fourmiliere
						
						f.setNourritureQuantite(f.getNourritureQuantite() - 1); // decrease the amount of the food by 1
						
					} else { // if there is no food in fourmiliere
						
						this.setNbCycle(this.getNbCycle() - 2); // loss life point
						
					}				
				}				
			}
			
			if (this.getNbCycle() <= 0) { 
				
				this.setIsFoActive(false);		
			}
		}
		else {
			
			if (!this.isPriseEnCharge()) {
				int index = -1;
				
				Enumeration<Integer> eNbFo = f.getNbrFourmi().keys();
				
				while (eNbFo.hasMoreElements()) {
					
					int key = eNbFo.nextElement();
					
					if (f.getNbrFourmi().get(key) == this) {
						
						index = key;
						break;
						
					}
					
				}
				 
				BoiteEvenement.getInstance().ajout(new Blessee(this ,index)); // start the event
			}
		}
	}
}
