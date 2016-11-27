import java.util.Enumeration;
import java.util.Random;

/**
 * Class Soldats is for instantiate 'Fourmi' of the type 'Soldats'
 * @author YAAQOUB
 *
 */
public class Soldat extends Fourmi{
	
	public static int soldatsNbr = 1; 		// that's for the 'Soldats' name
	// Soldats constructor
	public Soldat (Fourmiliere f){
		super ("Soldat " + soldatsNbr, 100, 2, f); 	// We call Constructor of the class abstart:
													// Soldat : Name + soldatsNbr : this int is to give the Anst's number the first one will call Soldat 1
													// 100 : Life point
													// 2 : speed of the Soldat
		soldatsNbr++;
	}
	
	@Override
	public void nouveauCycle(Fourmiliere f){
		
		if (this.isFoActive()){ // if the Ant 'Fourmi' is not supported launch a new cycle
			
			if (this.isQuitterFourm()){ // if the Ant 'fourmi' is leaving the 'fourmiliere'
				
				if (this.getPosition() == 0){ // if 'Fourmi' is in 'Fourmiliere'
					
					Random choix = new Random();
					this.setChoix(choix.nextInt(f.getSites().getSites().length)); // Select a 'Site Nourriture' randomly
					this.setPosition(this.getPosition() + this.getVitesse());
					this.setNbCycle(this.getNbCycle() - 1);
					
					System.out.println("La fourmi (" + this.getNomFourmi() + ") avance vers le (" + f.getSites().getSites()[this.getChoix()].getNom() + ").");
				}
				// if the 'Fourmi' is not in the 'Fourmilier' and not yet arrive to the 'Site Nourriture'
				else if (this.getPosition() > 0 && this.getPosition() < f.getSites().getSites()[this.getChoix()].getDistance()) { 
					
					this.setPosition(this.getPosition() + this.getVitesse());
					this.setNbCycle(this.getNbCycle() - 1);
					
					System.out.println("La fourmi (" + this.getNomFourmi() + ") avance vers le (" + f.getSites().getSites()[this.getChoix()].getNom() + ").");
				}
				else{ // if 'Fourmi' is in 'Site Nourriture'
					
					this.setPosition(f.getSites().getSites()[this.getChoix()].getDistance()); // la kandifiniw la position 3la 7ssab site 
					this.setNbCycle(this.getNbCycle() - 1); // loss a life point
					this.setQuitterForm(false);
				}
			}
			else{ // if the Ant 'fourmi' is returning to the 'fourmiliere'
				
				if (this.getPosition() <= f.getSites().getSites()[this.getChoix()].getDistance() && this.getPosition() > 0) { // if the 'Fourmi' between 'Fourmiliere' and 'Site'
					
					this.setPosition(this.getPosition() - this.getVitesse());
					this.setNbCycle(this.getNbCycle() - 1);
					
					System.out.println("La fourmi (" + this.getNomFourmi() + ") avance vers la fourmiliere.");
					
				} else { // 'Fourmi' is in 'Fourmiliere'
					
					this.setPosition(0); // hnaya kandifiniw position 3la 7ssab dyal fourmiliere
					this.setNbCycle(this.getNbCycle() - 1); // Loss a life point
					this.setQuitterForm(true);
					
					if (f.getNourritureQuantite() > 0){ // if there is food in the fourmiliere
						f.setNourritureQuantite(f.getNourritureQuantite() - 1); // decrease the amount of the food by 1
					}
					else{ // if there is no food in fourmiliere
						this.setNbCycle(this.getNbCycle() - 2); // loss life point
					}
				}
			}
			
			if (this.getNbCycle() <= 0){ // if the Ant 'Fourmi' is out of the life point set the IsFoActive to false
				this.setIsFoActive(false);
			}
		}
		else if (!this.isPriseEnCharge()){ // if the Ant is supported
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
